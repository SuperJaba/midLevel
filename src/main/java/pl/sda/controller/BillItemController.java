package pl.sda.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.sda.model.BillItem;
import pl.sda.service.BillItemService;
import pl.sda.xml.JsonFactory;

import java.io.IOException;
import java.util.List;

public class BillItemController extends Controller {

    @FXML
    private TextField productTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button addProductButton;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextArea descriptionTextField;

    @FXML
    void addProductController(ActionEvent event) throws IOException {
        addNewProductToDatabase();
    }

    private List<BillItem> addNewProductToDatabase() {
        JsonFactory jsonFactory = new JsonFactory();
        BillItemService billItemService = BillItemService.getInstance();
        List<BillItem> billitemList = billItemService.getBillitemList();
        BillItem billItem = new BillItem();
        billItem.setAmount(amountTextField.getPrefColumnCount());
        billItem.setPrice((double) priceTextField.getPrefColumnCount());
        billItem.setTax((double) taxTextField.getPrefColumnCount());
        billItem.setCode(codeTextField.getText()+"\n");
        billItem.setItemName(productTextField.getText());
        billItem.setDescription(descriptionTextField.getText());
        billitemList.add(billItem);
        String listInJSon = jsonFactory.listToJSon(billitemList);
        jsonFactory.saveData(listInJSon);
        return billitemList;
    }

}