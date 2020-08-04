package org.allvens.installer;

import org.allvens.assets.Constants;
import org.allvens.controller_ui.deafult_methods.Common_ControllerMethods;
import org.allvens.controller_ui.deafult_methods.ui_feedback.Toast;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Installer extends Common_ControllerMethods {

    @FXML
    ListView<String> lv_FilesAndDirectories;
    @FXML
    TextField tf_FileLocation;
    private Toast toast;

    /**
     * Sets up default values
     */
    public void initialize(){
        lv_FilesAndDirectories.getItems().add(OuterFiles.DIR_MainFolder);
        lv_FilesAndDirectories.getItems().addAll(OuterFiles.PROJECT_DIRECTORIES);

        toast = new Toast();
    }

    /********** Onscreen Button Actions **********/

    /**
     * Presents user wtih a file explorer they can navigate to select the prefer location to install the app
     * @param e
     */
    @FXML
    public void btn_FileSystem_DirectoryFinder(ActionEvent e){
        // Open File Explorer
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);

        // Present Results
        if (result == JFileChooser.APPROVE_OPTION) {
            tf_FileLocation.setText(chooser.getSelectedFile().getAbsolutePath());
        }
        else if (result == JFileChooser.CANCEL_OPTION) {
            toast.showMessage(Constants.TEXT_MESSAGE_FileChooserCanceled, Constants.TEXT_TITLE_Error);
        }
        else if (result == JFileChooser.ERROR_OPTION) {
            toast.showMessage(Constants.TEXT_MESSAGE_FileChooserError, Constants.TEXT_TITLE_Error);
        }
    }

    /**
     * Submits user selected path
     * Sets up default values
     * @param e
     */
    @FXML
    public void btn_submitFileDestination(ActionEvent e){
        if(!tf_FileLocation.getText().isEmpty()){
            FirstTimeSetUp fts = new FirstTimeSetUp();
            String mainFilePath = fts.fixFilePath(tf_FileLocation.getText());

            if(fts.createFolderForProject(mainFilePath)){
                fts.setMainPathValue(mainFilePath);
                fts.setFirstTimePref(true);
                changeScreen(CHANGE_SCREEN_NORMAL, Constants.FILE_FXML_Home, e, Constants.WINDOW_TITLE_Main,null, false);
            }else{
                toast.showMessage(Constants.TEXT_MESSAGE_SelectedFolderDidntWork, Constants.TEXT_TITLE_SelectedFolderDidntWork);
            }
        }
    }
}
