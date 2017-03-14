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

    public class LoginController {

        @FXML
        private TextField passwordTextField;

        @FXML
        private Button submit;

        @FXML
        private TextField loginTextField;

        @FXML
        void submitOnAction(ActionEvent event) {
//            System.out.println(loginTextField.getText());
//            System.out.println(passwordTextField.getText());
            UserService userService = new UserService();
           User user = new User (loginTextField.getText(), passwordTextField.getText());
//            userField.setLogin(loginTextField.getText());
            //linijka powyzej wpisana bezposrednio w konstruktor User userField
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Hello");
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Hello");
            userService.authenticatie(user);
            if () {

                alert1.show();
            } else {
                alert2.show();

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


