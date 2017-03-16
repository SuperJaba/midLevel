package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.sda.model.User;
import pl.sda.service.UserService;

/**
 * Created by RENT on 2017-03-14.
 */

public class LoginController extends Controller {

    @FXML
    private TextField passwordField;

    @FXML
    private Button submit;

    @FXML
    private TextField loginTextField;

    @FXML
    void submitOnAction(ActionEvent event) {
//            System.out.println(loginTextField.getText());
//            System.out.println(passwordTextField.getText().getCause());
        UserService userService = new UserService();
        User user = new User(loginTextField.getText(), passwordField.getText());
//            userField.setLogin(loginTextField.getText());
        //linijka powyzej wpisana bezposrednio w konstruktor User userField
        boolean flag = userService.authenticatie(user);
        if (flag == true) {
            showErrorAlert("Zalogowano");
        } else {
            showErrorAlert("Bledne dane logowania");
        }


        //napisac if'a czy login sie zgadza i czy pass dziala! wyswietlac komunikaty w odpowiednich przypadkach
        /**
         * 1. powolac do zycia UserService
         * 2. tworzymy usera z pobranych pol textowych
         * 3. korzystamy z metody Authenticate z UserService
         * 4. sprawdzenie, czy haslo jest OK
         */
    }

}


