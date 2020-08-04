 package org.allvens.controller;

import java.io.BufferedReader;

import org.allvens.assets.Constants;
import org.allvens.assets.Constants_Prefs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.allvens.controller_ui.controller_managers.ImageViewer_Manager;

 /**
 * Controller Class Responsible for Image_Viewer Scene Actions
 * @author JesusCdev
 *
 */
public class Image_Viewer implements Constants, Constants_Prefs {

	@FXML
	BorderPane bp;
	@FXML
	ImageView ivMainImage;
	@FXML
	Label lbMainFolder;

	@FXML
    VBox vbCenter;

	@FXML
	Label lbImagesLeft;
	@FXML
	Label lbCurrentImage;
	
	@FXML
	Label lbUpArrowPath;	
	@FXML
	Label lbDownArrowPath;	
	@FXML
	Label lbRightArrowPath;	
	@FXML
	Label lbLeftArrowPath;

	@FXML
	Image image;

	private ImageViewer_Manager ivm;

     /**
	 * This class is the first class to run when the pane is loaded
	 */
	public void initialize() {
        ivm = new ImageViewer_Manager(lbImagesLeft, lbCurrentImage, ivMainImage, vbCenter, lbMainFolder, lbUpArrowPath, lbDownArrowPath, lbLeftArrowPath, lbRightArrowPath);
	}

     /****************************************
      /**** Button Actions
      ****************************************/
    /**
     * Skips current image without affecting current image
     */
    public void btn_leaveImageAlone(){
        ivm.skipCurrentImage();
    }

    /**
     * Jumps to last image and undoes previous actions
     */
    public void btn_UnDoImage(){
        ivm.undoLastAction();
    }

    /**
     * Starts Keyboard and Resizing Listeners
     * @param e
     */
    public void btn_StartImageIterator(ActionEvent e){
        ivm.setKeyboardBindingAndImageResizingListeners(e);
    }
}
