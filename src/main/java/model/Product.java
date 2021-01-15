package model;

public class Product {

    private int id;
    private String productName;
    private double productPrice;
    private int quantity;
    private String color;
    private String productDesc;
    private int categoryId;
    private Category category;
    private int status;

    public Product() {
    }

    public Product(int id, String productName, double productPrice, int quantity, String color, String productDesc, Category category, int status) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.productDesc = productDesc;
        this.category = category;
        this.status = status;
    }

    public Product(int id, String productName, double productPrice, int quantity, String color, Category category, int status) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.status = status;
    }

    public Product(String productName, double productPrice, int quantity, String color, String productDesc, Category category, int status) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.productDesc = productDesc;
        this.category = category;
        this.status = status;
    }

    public Product(String productName, double productPrice, int quantity, String color, String productDesc, int categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.productDesc = productDesc;
        this.categoryId = categoryId;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
