package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pl.sda.model.Adress;
import pl.sda.model.Company;

/**
 * Created by RENT on 2017-03-15.
 */
public class CompanyCreateControler {


    @FXML
    private Button addButon;

    @FXML
    private TextField numerLokalu;

    @FXML
    private RadioButton avenueRButton;

    @FXML
    private RadioButton squareRButton;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField NIPField;

    @FXML
    private TextField streetNameField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private TextField cityNameFild;

    @FXML
    private RadioButton streetRButton;

    @FXML
    private TextField numerBudynku;
    private Adress.StreetPrefix streetPrefix;

    @FXML
    void choosePrefixOnAction(ActionEvent event) {
        if (event.getSource() instanceof RadioButton) {
            RadioButton curentPrefixRadioButton = (RadioButton) event.getSource();
            String buttonName = curentPrefixRadioButton.getText();
            switch (buttonName) {
                case "Street":
                    streetPrefix = Adress.StreetPrefix.STREET;
                    break;
                case "Square":
                    streetPrefix = Adress.StreetPrefix.SQUARE;
                    break;
                case "Avenue":
                    streetPrefix = Adress.StreetPrefix.AVENUE;
                    break;
            }
        }
    }

    @FXML
    void AddCompanyOnAction(ActionEvent event) {
        Company company = new Company();
        Adress adress = new Adress();
        adress.setCity(cityNameFild.getText());
        adress.setPostalCode(postalCodeField.getText());
        adress.setStreetName(streetNameField.getText());
        adress.setHouseNumber(numerBudynku.getText());
        adress.setStreetPrefix(streetPrefix);

        company.setName(cityNameFild.getText());
        company.setNip(NIPField.getText());
        company.setAdress(adress);
        System.out.println(company.toString());
    }

    @FXML
    void initialize() { //grupowanie guzikow RadioButton
        ToggleGroup group = new ToggleGroup();
        streetRButton.setToggleGroup(group);
        avenueRButton.setToggleGroup(group);
        squareRButton.setToggleGroup(group);
    }
}


