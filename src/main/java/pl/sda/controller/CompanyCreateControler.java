package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.sda.model.Adress;
import pl.sda.model.Company;
import pl.sda.pdf.PdfFactory;
import pl.sda.service.DataService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RENT on 2017-03-15.
 */
public class CompanyCreateControler extends Controller {


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
        bindToModelCompany();
        //TODO poprawic company.setName na poprawne pole nazwyFirmy a nie nazwa miasta
        //TODO test zapisu w mokito w PDFie
    }

    private void bindToModelCompany() {
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
        DataService dataService = new DataService();
        dataService.printOut(company);
    }

    @FXML
    void initialize() { //grupowanie guzikow RadioButton
        ToggleGroup group = new ToggleGroup();

        streetRButton.setToggleGroup(group);
        avenueRButton.setToggleGroup(group);
        squareRButton.setToggleGroup(group);
    }

    private void validatePostalCode() {
        Pattern zipPattern = Pattern.compile("(^\\d{2}-\\d{3}$)");
        Matcher zipMatcher = zipPattern.matcher(postalCodeField.getText());
        if (zipMatcher.find()) {
            String zip = zipMatcher.group(1);
            showConfirmationAllert("Poprawny format kodu pocztowego");
        } else {
            showErrorAlert("Wrong zip code format\n10-100");
        }

    }

    @FXML
    void makePDFOnAction(ActionEvent event) {
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
        DataService dataService = new DataService();
        dataService.printOut(company);
        validatePostalCode();

        PdfFactory pdfFactory = new PdfFactory();
        pdfFactory.pdfFromCompany(company);


    }

    @FXML
    void validateOnAction(ActionEvent event) {
        validatePostalCode();
    }
}


