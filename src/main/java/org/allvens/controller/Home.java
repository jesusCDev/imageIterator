package org.allvens.controller;

import org.allvens.assets.Constants;
import org.allvens.assets.Constants_Prefs;
import org.allvens.controller_ui.deafult_methods.FileFixer;
import org.allvens.controller_ui.deafult_methods.Common_ControllerMethods;
import org.allvens.controller_ui.deafult_methods.ui_feedback.Toast;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.allvens.controller_ui.managers.Image_Manager;

/**
 * Controller class responsible for Home scene Actions
 * @author JessuCdev
 *
 */
public class Home extends Common_ControllerMethods implements Constants, Constants_Prefs {

    @FXML
    BorderPane bpAll;

	@FXML
	RadioButton rbUpArrow;
	@FXML
	RadioButton rbDownArrow;
	@FXML
	RadioButton rbRightArrow;
	@FXML
	RadioButton rbLeftArrow;
	
	@FXML
	RadioButton rbDeleteOrignialPictures;

	@FXML
	TextField tvMainPath;
	@FXML
	TextField tvUpArrowPath;
	@FXML
	TextField tvDownArrowPath;
	@FXML
	TextField tvRightArrowPath;
	@FXML
	TextField tvLeftArrowPath;
	
	@FXML
	Label lbForgotToFillIn;

	private FileFixer ff = new FileFixer();
	private Toast toast = new Toast();

	private int rbChecked = 1;
	private boolean deleteMainImages = true;

	public void initialize() {
        tvMainPath.setText("/home/jesuscdev/Pictures/Random");
        tvUpArrowPath.setText("/home/jesuscdev/Pictures/Random/One");
	}

    /****************************************
     /**** SubTitle
     ****************************************/
	@FXML
    private void setDeletePicturesFromMainPath(ActionEvent e){
        deleteMainImages = !deleteMainImages;
    }
	
	/**
	 * Handles radio button presses
	 */
	private void radioButtonSelected(){

		tvDownArrowPath.setDisable(false);
		tvRightArrowPath.setDisable(false);
		tvLeftArrowPath.setDisable(false);
		
		if(rbChecked < 4){
			tvRightArrowPath.setText(KEY_WORD_Empty);
			tvRightArrowPath.setDisable(true);
			if(rbChecked < 3){
				tvLeftArrowPath.setText(KEY_WORD_Empty);
				tvLeftArrowPath.setDisable(true);
				if(rbChecked < 2){
					tvDownArrowPath.setText(KEY_WORD_Empty);
					tvDownArrowPath.setDisable(true);
				}
			}
		}
	}

    /**
     * Checks Selected Radio Button
     */
    public void rbTgSelected(){
        if(rbUpArrow.isSelected()){
            rbChecked = 1;
            radioButtonSelected();
        }
        if(rbDownArrow.isSelected()){
            rbChecked = 2;
            radioButtonSelected();
        }
        if(rbRightArrow.isSelected()){
            rbChecked = 3;
            radioButtonSelected();
        }
        if(rbLeftArrow.isSelected()){
            rbChecked = 4;
            radioButtonSelected();
        }
    }

    @FXML
    public void btn_tellUserAboutPathShortCuts(ActionEvent event){
        toast.showMessage(TEXT_MESSAGE_HelpfulHomeTips, TEXT_TITLE_HelpfulTips);
    }

    /**
     * This method handles the action for the submit button that passes on the data to the next class by saving it onto a document.
     * @param event
     */
    @FXML
    public void btn_checkAndSubmitPaths(ActionEvent event){

        /********** Check If Folder Has Images **********/
        Image_Manager im = new Image_Manager();
        String mainPath = ff.fixBackFrontSlash(tvMainPath.getText());
        im.setImages(im.getImagesFromFolder(mainPath));

        if(im.getFullCountOfImagesInFolder() != 0) {
            /********** Check and Create Other Folders **********/
            prefs.put(PREF_String_DownArrowPath, KEY_WORD_DelKeyword);
            prefs.put(PREF_String_RightArrowPath, KEY_WORD_DelKeyword);
            prefs.put(PREF_String_LeftArrowPath, KEY_WORD_DelKeyword);

            boolean notBlank1;
            boolean notBlank2 = false;
            boolean notBlank3 = false;
            boolean notBlank4 = false;

            String upArrowPath = tvUpArrowPath.getText();
            notBlank1 = checkIfTFIsEmpty(upArrowPath);

            ff.savePaths(PREF_String_MainPath, mainPath);
            ff.savePaths(PREF_String_UpArrowPath, ff.checkAndCreatePath(ff.checkFrontOfPathForFrontBackSlash(upArrowPath), ff.fixBackFrontSlash(upArrowPath), mainPath));

            String downArrowPath = KEY_WORD_Empty;
            String leftArrowPath = KEY_WORD_Empty;
            String rightArrowPath = KEY_WORD_Empty;

            if (rbChecked > 1) {
                downArrowPath = tvDownArrowPath.getText();
                notBlank2 = checkIfTFIsEmpty(downArrowPath);
                if (rbChecked > 2) {
                    leftArrowPath = tvLeftArrowPath.getText();
                    notBlank3 = checkIfTFIsEmpty(leftArrowPath);
                    if (rbChecked > 3) {
                        rightArrowPath = tvRightArrowPath.getText();
                        notBlank4 = checkIfTFIsEmpty(rightArrowPath);
                    }
                }
            }

            if (!notBlank1 && !notBlank2 && !notBlank3 && !notBlank4) {
                if (rbChecked > 1) {
                    ff.savePaths(PREF_String_DownArrowPath, ff.checkAndCreatePath(ff.checkFrontOfPathForFrontBackSlash(downArrowPath), ff.fixBackFrontSlash(downArrowPath), mainPath));
                    if (rbChecked > 2) {
                        ff.savePaths(PREF_String_LeftArrowPath, ff.checkAndCreatePath(ff.checkFrontOfPathForFrontBackSlash(leftArrowPath), ff.fixBackFrontSlash(leftArrowPath), mainPath));
                        if (rbChecked > 3) {
                            ff.savePaths(PREF_String_RightArrowPath, ff.checkAndCreatePath(ff.checkFrontOfPathForFrontBackSlash(rightArrowPath), ff.fixBackFrontSlash(rightArrowPath), mainPath));
                        }
                    }
                }
                prefs.putBoolean(PREF_Boolean_DeleteValue, deleteMainImages);

                changeScreen(Common_ControllerMethods.CHANGE_SCREEN_DYNAMIC, FILE_FXML_ImageViewer, event, WINDOW_TITLE_ImageView, bpAll, false);
            } else {
                lbForgotToFillIn.setVisible(true);
            }
        }else{
            toast.showMessage(TEXT_MESSAGE_NoImageInFolder, TEXT_TITLE_NoImageInFolder);
        }
    }

    private boolean checkIfTFIsEmpty(String textFieldValue){
        return (textFieldValue.equals(KEY_WORD_Empty) || textFieldValue.equals(KEY_WORD_Space));
    }
}
