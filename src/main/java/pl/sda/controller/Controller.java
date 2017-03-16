package pl.sda.controller;

import javafx.scene.control.Alert;

/**
 * Created by RENT on 2017-03-16.
 */
public class Controller {

    protected void showErrorAlert(String message) {
        showAllert(Alert.AlertType.ERROR, message);
    }

    protected void showConfirmationAllert(String message) {
        showAllert(Alert.AlertType.CONFIRMATION, message);
    }

    private void showAllert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).show();
    }
}
