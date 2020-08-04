package org.allvens.controller_ui.deafult_methods.ui_feedback;

import org.allvens.assets.Constants;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Notify User
 */
public class Toast {

    /**
     * Sets up basic message toast
     * @param message
     * @param windowTitle
     */
    public void showMessage(String message, String windowTitle){
        createNewWindow(message, windowTitle);
    }

    /**
     * Creates Toast With A New Stage
     * @param message
     * @param windowTitle
     */
    private void createNewWindow(String message, String windowTitle){
        Stage stage = new Stage();

        BorderPane bpAll = new BorderPane();
        bpAll.getStyleClass().add("background");
        bpAll.getStyleClass().add("toast");
        VBox vbContainer = new VBox();
        vbContainer.getStyleClass().add("container");
        vbContainer.getStyleClass().add("vbContainer");

        Label lbMessage = new Label(message);

        Button btnCloseWindow = new Button(Constants.TOAST_MESSAGE_OKAY);
        btnCloseWindow.getStyleClass().add("btnDefault");

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                stage.hide();
            }
        });
        btnCloseWindow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.hide();
            }
        });

        vbContainer.setAlignment(Pos.CENTER);
        vbContainer.getChildren().add(lbMessage);
        vbContainer.getChildren().add(btnCloseWindow);
        bpAll.setCenter(vbContainer);

        stage.setTitle(windowTitle);
        stage.resizableProperty().setValue(false);

        Scene scene = new Scene(bpAll, Constants.DEFAULT_TOAST_WIDTH, Constants.DEFAULT_TOAST_HEIGHT);
        scene.getStylesheets().add(getClass().getResource(Constants.FILE_CSS_DefaultStyles).toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();
    }
}
