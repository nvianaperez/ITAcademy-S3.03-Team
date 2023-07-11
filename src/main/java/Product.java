import java.io.Serializable;
import java.util.Scanner;

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

    public Product(String name, int stock, float price, Category category){
        this.idProduct = idNext++;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
    }

    public Product(String name,int stock, float price){
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

    public void setId(int id) {

        this.idProduct = idProduct;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock(){
        return this.stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addStock(int quantity){
             this.stock = getStock() + quantity;
             System.out.println("Updated Stock:   Name : " + this.name + " Stock : " + this.getStock());
    }
    public void removeStock(int quantity){

            this.stock = this.getStock() - quantity;
            System.out.println("Updated Stock:   Name : " + this.name  + " Stock : " + this.getStock());
        }

        @Override
        public String toString(){

        return "Id del producto: " + this.idProduct + " || " + "Nombre del producto: " + this.name +
                " Precio del producto" + this.price + "€";
        }



}