package org.allvens.controller_ui.deafult_methods;

import org.allvens.Main;
import org.allvens.assets.Constants;
import org.allvens.assets.Constants_Prefs;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Common_ControllerMethods implements Constants_Prefs {

    public static int CHANGE_SCREEN_NORMAL = 0;
    public static int CHANGE_SCREEN_NORMAL_ALWAYS_ON_TOP = 1;
    public static int CHANGE_SCREEN_DYNAMIC = 2;
    public static int CHANGE_SCREEN_DYNAMIC_ALWAYS_ON_TOP = 3;

    /****************************************
     /**** Screen Changing Methods
     ****************************************/
    /********** Setting Method **********/
    protected void screen_SetSize(BorderPane bodyPane){
        if(!prefs.getBoolean(PREF_SV_ScreenMax, false)){
            bodyPane.setPrefWidth(prefs.getDouble(PREF_SV_ScreenWidth, 800.0));
            bodyPane.setPrefHeight(prefs.getDouble(PREF_SV_ScreenHeight, 800.0));
        }
    }

    /********** Screen Checking **********/
    public void screen_checkAlwaysOnTop(String prefsID, MouseEvent event, String fxmlScreen, String windowTitle, BorderPane bpAll){
        if(prefs.getBoolean(prefsID, false)){
            changeScreen(Common_ControllerMethods.CHANGE_SCREEN_DYNAMIC_ALWAYS_ON_TOP, fxmlScreen, event, windowTitle, bpAll, true);
        }else{
            changeScreen(Common_ControllerMethods.CHANGE_SCREEN_DYNAMIC_ALWAYS_ON_TOP, fxmlScreen, event, windowTitle, bpAll, false);
        }
    }

    public void screen_checkAlwaysOnTop(String prefsID, ActionEvent event, String fxmlScreen, String windowTitle, BorderPane bpAll){
        if(prefs.getBoolean(prefsID, false)){
            changeScreen(Common_ControllerMethods.CHANGE_SCREEN_DYNAMIC_ALWAYS_ON_TOP, fxmlScreen, event, windowTitle, bpAll, true);
        }else{
            changeScreen(Common_ControllerMethods.CHANGE_SCREEN_DYNAMIC_ALWAYS_ON_TOP, fxmlScreen, event, windowTitle, bpAll, false);
        }
    }

    /**
     * Saves screen demotions
     * @param bpAll
     */
    private void changeDynamic_SaveWidth(BorderPane bpAll) {
        prefs.putDouble(PREF_SV_ScreenWidth, bpAll.getWidth());
        prefs.putDouble(PREF_SV_ScreenHeight, bpAll.getHeight());
    }

    /********** Screen Changing **********/
    /**
     * Changes Stage to new scene using Action Events
     * @param changeScreenSettings - Type of Screen Changing
     * @param fxmlScreen - Screen Changing
     * @param e - Event
     * @param bpAll - Top Window
     * @param alwaysOnTop - Always On Top Value
     */
    public void changeScreen(int changeScreenSettings, String fxmlScreen, ActionEvent e, String windowTitle, BorderPane bpAll, boolean alwaysOnTop){

        if(changeScreenSettings > 1){
            changeDynamic_SaveWidth(bpAll);
        }

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle(windowTitle);

        Parent loader = null;
        try {
            loader = FXMLLoader.load(Main.class.getResource(fxmlScreen));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Scene scene = new Scene(loader);
        scene.getStylesheets().add(Main.class.getResource(Constants.FILE_CSS_DefaultStyles).toExternalForm());

        if(changeScreenSettings == 1 || changeScreenSettings == 3){
            stage.setAlwaysOnTop(alwaysOnTop);
        }

        if (stage.isFullScreen()) {
            stage.setMaximized(true);
            prefs.putBoolean(PREF_SV_ScreenMax, true);
        }else{
            prefs.putBoolean(PREF_SV_ScreenMax, false);
        }

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes Stage to new scene using Mouse Events
     * @param changeScreenSettings - Type of Screen Changing
     * @param fxmlScreen - Screen Changing
     * @param e - Event
     * @param bpAll - Top Window
     * @param alwaysOnTop - Always On Top Value
     */
    public void changeScreen(int changeScreenSettings, String fxmlScreen, MouseEvent e, String windowTitle, BorderPane bpAll, boolean alwaysOnTop){

        if(changeScreenSettings > 1){
            changeDynamic_SaveWidth(bpAll);
        }

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle(windowTitle);

        Parent loader = null;
        try {
            loader = FXMLLoader.load(Main.class.getResource(fxmlScreen));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Scene scene = new Scene(loader);
        scene.getStylesheets().add(Main.class.getResource(Constants.FILE_CSS_DefaultStyles).toExternalForm());

        if(changeScreenSettings == 1 || changeScreenSettings == 3){
            stage.setAlwaysOnTop(alwaysOnTop);
        }

        if (stage.isFullScreen()) {
            stage.setMaximized(true);
            prefs.putBoolean(PREF_SV_ScreenMax, true);
        }else{
            prefs.putBoolean(PREF_SV_ScreenMax, false);
        }

        stage.setScene(scene);
        stage.show();
    }
}
