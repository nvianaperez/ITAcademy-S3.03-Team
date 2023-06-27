import java.util.Scanner;

public class Product {

    private Scanner sc = new Scanner(System.in);

    private int idProduct;
    private String name;

    private int stock;
    private float price;

    public Product(int idProduct, String name, int stock, float price){
        this.idProduct = idProduct;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
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

        if(this.getStock() > 0){
            System.out.println("Stock available: " + this.getStock() + " Unit/s");
            System.out.println("");
        }else{
            System.out.println("No stock available");
            System.out.println("");
        }
        return this.stock;
    }

    public void addStock(){
             this.stock = getStock() + User.readInteger("Cantidad de producto para añadir: ",sc);
             System.out.println("Updated Stock:   Name : " + this.name + " || " + " Stock : " + this.getStock());
    }

    public void removeStock(){

            this.stock = this.getStock() - User.readInteger("Cantidad de producto a retirar: ",sc);
            System.out.println("Updated Stock:   Name : " + this.name + " || " + " Stock : " + this.getStock());
        }

}