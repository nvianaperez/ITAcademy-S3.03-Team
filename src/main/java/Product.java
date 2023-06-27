import java.util.Scanner;

public class Product {

    private Scanner sc = new Scanner(System.in);

    private int id;
    private String name;

    private int stock;
    private float price;

    public Product(int id, String name, int stock, float price){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

             this.getStock() = getStock() + User.readInteger("Cantidad de producto para añadir: ",sc);

            System.out.println("Name : " + this.name + " || " + " Stock : " + this.getStock());
    }

    public void removeStock(){

            this.stock = this.getStock() - User.readInteger("Cantidad de producto a retirar: ",sc);

            System.out.println("No es pot donar aquesta peça per manca de stock");
        }

}