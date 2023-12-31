package Entities;

import java.io.Serializable;
public class Product implements Serializable {
    private int idProduct;
    private static int idNext = 1;
    private String name;
    private int stock;
    private float price;
    private Category category;

    public enum Category {
        TREE, FLOWER, DECO
    }

    public Product(String name, int stock, float price, Category category) {
        this.idProduct = idNext++;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
    }

    public Product(int idProduct, String name, int stock, float price, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
    }

    public Product(String name, int stock, float price) {
        this.name = name;
        this.stock = stock;
        this.price = price;

    }

    public Product(String name) {
        this.name = name;
    }

    public int getIdProduct() {
        return this.idProduct;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public Category getCategory() {
        return category;
    }

    public void addStock(int quantity) {

        this.stock = getStock() + quantity;

        System.out.println("Updated Stock -->  Name : " + this.name + " Stock : " + this.getStock());

    }

    public int removeStock(int quantity) throws ArithmeticException {

        if (quantity <= this.stock) {
            this.stock = this.getStock() - quantity;
        } else {
            throw new ArithmeticException("Stock insuficient per la quantitat demandada: ");
        }

        System.out.println("Updated Product Stock:   Name : " + this.name + " Stock : " + this.getStock());

        return this.stock;
    }

    @Override
    public String toString() {

        return "Nombre del producto: " + this.name +
                " Precio del producto" + this.price + "€";
    }
}