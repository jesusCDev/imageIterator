package org.allvens.controller_ui.controller_managers;

import org.allvens.assets.Constants;
import org.allvens.assets.Constants_Prefs;
import org.allvens.controller_ui.managers.Image_Manager;
import org.allvens.controller_ui.deafult_methods.ui_feedback.Toast;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;

import java.io.File;

/**
 * Class that is responsible for managing the image viewer UI
 * Also manages image editor commands
 */
public class ImageViewer_Manager implements Constants, Constants_Prefs {

    private ImageView ivMainImage;

    private Label lbImagesLeft;
    private Label lbCurrentImage;

    private int width = 500;
    private int height = 500;

    private Image_Manager im;
    private Toast toast = new Toast();

    public ImageViewer_Manager(Label lbImagesLeft, Label lbCurrentImage, ImageView ivMainImage, VBox vbCenter, Label lbMainPath, Label lbUpArrow, Label lbDowArrow, Label lbLeftArrow, Label lbRightArrow){
        this.lbImagesLeft = lbImagesLeft;
        this.lbCurrentImage = lbCurrentImage;
        this.ivMainImage = ivMainImage;

        im = new Image_Manager();
        im.setImageSources();
        im.setImages(im.getImagesFromFolder(im.getMainPath()));

        setImageResizingProperty(ivMainImage, vbCenter);
        setImageBasics();
        setPaths(lbMainPath, lbUpArrow, lbDowArrow, lbLeftArrow, lbRightArrow);
        setCurrentImage(im.getCurrentImagePath());
    }

    /**
     * Returns Path Name
     * @param path
     * @return
     */
    private String getPathName(String path){
        if(!checkIfTextIsPath(path)){
            return new File(path).getName();
        }
        return path;
    }

    /**
     * Makes sure path is a path and not a keyword
     * @param path
     * @return
     */
    private boolean checkIfTextIsPath(String path){
        return path.equalsIgnoreCase(Constants.KEY_WORD_DelKeyword);
    }


    /********** UI Editors **********/
    /**
     * updates ui with latest changes
     */
    private void updateCardChange(){
        lbImagesLeft.setText(im.getCurrentImageIndex());
        lbCurrentImage.setText(im.getCurrentImageName());

        setCurrentImage(im.getCurrentImagePath());
    }

    /**
     * Sets values of the ui for the path
     * @param lbMainPath
     * @param lbUpArrow
     * @param lbDowArrow
     * @param lbLeftArrow
     * @param lbRightArrow
     */
    private void setPaths(Label lbMainPath, Label lbUpArrow, Label lbDowArrow, Label lbLeftArrow, Label lbRightArrow){
        lbMainPath.setText(im.getMainPath());

        lbUpArrow.setText(getPathName(im.getUpArrowPath()));
        lbDowArrow.setText(getPathName(im.getDownArrowPath()));
        lbLeftArrow.setText(getPathName(im.getLeftArrowPath()));
        lbRightArrow.setText(getPathName(im.getRightArrowPath()));
    }
    /**
     * Sets image to ImageView
     * @param imagePath
     */
    private void setCurrentImage(String imagePath){
        ivMainImage.setImage(new Image((fileExtension + imagePath)));
//        new Image(resource_loader.load(currentImagePath));
    }

    /********** UI Setters **********/
    /**
     * Sets Image View Settings
     */
    private void setImageBasics(){
        ivMainImage.setPreserveRatio(true);
        ivMainImage.setSmooth(true);
        ivMainImage.setCache(true);

        setCurrentImage(im.getCurrentImagePath());
    }

    /**
     * Sets zoom features
     * @param ivMainImage
     * @param vbCenter
     */
    private void setImageResizingProperty(ImageView ivMainImage, VBox vbCenter){
        vbCenter.setOnScroll((ScrollEvent event) -> {
            // Adjust the zoom factor as per your requirement
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            if (deltaY < 0){
                zoomFactor = 2.0 - zoomFactor;
            }
            ivMainImage.setScaleX(ivMainImage.getScaleX() * zoomFactor);
            ivMainImage.setScaleY(ivMainImage.getScaleY() * zoomFactor);
        });
    }

    /**
     * Sets keyboard binding listeners for image view.
     * @param e
     */
    public void setKeyboardBindingAndImageResizingListeners(ActionEvent e){

        toast.showMessage(TEXT_MESSAGE_HelpfulImageViewTips, TEXT_TITLE_HelpfulTips);

        ((Button)e.getSource()).setVisible(false);

        Scene imageViewScene = ((Node) e.getSource()).getScene();

        // TODO - THIS MIGHT NOT WORK ON PRODUCTION MODE
        imageViewScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case KP_UP:
                case UP:
                case W:
                    im.moveImage(im.getUpArrowPath());
                    break;
                case KP_DOWN:
                case DOWN:
                case S:
                    im.moveImage(im.getUpArrowPath());
                    break;
                case KP_LEFT:
                case LEFT:
                case A:
                    im.moveImage(im.getLeftArrowPath());
                    break;
                case KP_RIGHT:
                case RIGHT:
                case D:
                    im.moveImage(im.getRightArrowPath());
                    break;

                case Q:
                    im.undoLastAction();
                    break;

                case R:
                    im.leaveImageAlone();
                    break;
                default:
                    break;
            }
            updateCardChange();
        });

        /*
         * Handles resizing of the width
         */
        imageViewScene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            width = newSceneWidth.intValue();
            if(ivMainImage.getFitWidth() < width && ivMainImage.getFitHeight() < height){
                ivMainImage.setFitWidth(((double)newSceneWidth/2));
            }
        });

        /*
         * Handles resizing of the height
         */
        imageViewScene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            height = newSceneHeight.intValue();

            if(ivMainImage.getFitWidth() < width && ivMainImage.getFitHeight() < height){
                ivMainImage.setFitHeight(((double)newSceneHeight/2));
            }
        });
    }

    /********** Button Actions **********/
    /**
     * Skips Images
     */
    public void skipCurrentImage(){
        im.leaveImageAlone();
        updateCardChange();
    }

    /**
     * Undo Last Action
     */
    public void undoLastAction(){
        im.undoLastAction();
        updateCardChange();
    }
}
