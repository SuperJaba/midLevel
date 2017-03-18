package pl.sda.model;

/**
 * Created by RENT on 2017-03-18.
 */
public class BillItem {
    private Integer amount;
    private String itemName;
    private Double price;
    private Double tax;
    private String description;
    private String code;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "amount=" + amount +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    //    public void createImageWithBarcode() {
//        BarcodeEAN codeEAN = new BarcodeEAN();
//        codeEAN.setCodeType(codeEAN.EAN13);
//        codeEAN.setCode("9780201615883");
//        Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
//    }
}

