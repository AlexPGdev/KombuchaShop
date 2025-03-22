public class Kombucha {

    // Setting variables
    private String type;
    private int price;
    private int quantity;
    private String prodcuctCode;

    // Setting Constructor
    public Kombucha(String type, int price, int quantity, String productCode) {
        setType(type);
        setPrice(price);
        setQuantity(quantity);
        setProdcuctCode(productCode);
    }

    // Getters and Setters
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductCode() {
        return prodcuctCode;
    }

    public void setProdcuctCode(String prodcuctCode) {
        this.prodcuctCode = prodcuctCode;
    }
}
