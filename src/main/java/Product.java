import java.util.ArrayList;
import java.util.List;

public class Product {

    private int id;
    private String name;

    private int numb;
    private float price;

    public Product(int id,String name,int numb,float price){
        this.id = id;
        this.name = name;
        this.numb = numb;
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

    public int getNumb() {
        return this.numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getStock(){

        if(this.getNumb() > 0){
            System.out.println("Stock available: " + this.getNumb() + " Unit/s");
            System.out.println("");
        }else{
            System.out.println("No stock available");
            System.out.println("");
        }
        return this.getNumb();
    }

    public void setStock(int numb){

        // Falta por definir como modificamos el stock a partir de los pedidos del ticket
        int stock = getStock();

    }
}