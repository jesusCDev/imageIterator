package org.allvens;
	
import org.allvens.assets.Constants;
import org.allvens.controller_ui.deafult_methods.Common_DefaultMethods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.allvens.controller_ui.managers.Image_Manager;

import static org.allvens.assets.Constants_Prefs.PREF_Boolean_FirstTimeUsingApp;
import static org.allvens.assets.Constants_Prefs.prefs;


/**
 * This program will allow users to iterate through images and organize them faster.
 * @author JessuCdev
 *
 */
public class Main extends Application implements Constants {
	
	/**
	 *Launching Main App
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
		    String nextStage = FILE_FXML_Home;
		    primaryStage.setTitle(WINDOW_TITLE_Main);

		    if(!prefs.getBoolean(PREF_Boolean_FirstTimeUsingApp, false)){
                nextStage = FILE_FXML_Installer;
		        primaryStage.setTitle(WINDOW_TITLE_Installer);
                primaryStage.setWidth(DEFAULT_WINDOW_INSTALLER_WIDTH);
                primaryStage.setHeight(DEFAULT_WINDOW_INSTALLER_HEIGHT);
            }

			Parent root = FXMLLoader.load(Main.class.getResource(nextStage));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource(FILE_CSS_DefaultStyles).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will run when the program is closed
	 */
	@Override
	public void stop(){
        Image_Manager im = new Image_Manager();
        im.emptyTempFolder();

        new Common_DefaultMethods().resetValues();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
