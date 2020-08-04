package org.allvens.controller_ui.deafult_methods.ui_feedback;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Creates Toast to inform user they have done some action
 */
public class SnackBar {

    private StackPane sp;
    private Timeline timeline;
    public static double SHORT = 3000.0;
    public static double LONG = 6000.0;

    /**
     * Sets up toast space
     * @param sp
     */
    public SnackBar(StackPane sp){
        this.sp = sp;
        sp.setMaxHeight(50);
        sp.getStyleClass().add("toast");
    }

    /**
     * Creates Toast Message
     * @param message - toast message
     * @param toastDuration - toast duration
     */
    public void createSnackBar(String message, Double toastDuration){
        deleteSnackBar();

        sp.getChildren().clear();
        Label toastMessage = new Label(message);
        toastMessage.setStyle("-fx-font-size: 0");
        sp.getChildren().add(toastMessage);

        timeline = new Timeline(new KeyFrame(
                Duration.millis(toastDuration),
                ae -> deleteSnackBar()));
        timeline.play();

    }

    /**
     * Deletes Toast
     */
    private void deleteSnackBar(){
        sp.getChildren().clear();
        try{
            timeline.stop();
        } catch(NullPointerException e){
        }
    }
}
