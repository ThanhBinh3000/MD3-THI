package com.codegym.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int amount;
    private String color;
    private String description;
    private int categoryId;
    private Category category;

    public Product() {

    }

    public Product(int productId, String productName, double price, int amount, String color, String description, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Product(int productId, String productName, double price, int amount, String color, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
    }

    public Product(String productName, double price, int amount, String color, String description) {
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
