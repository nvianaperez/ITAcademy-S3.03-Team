package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {

    private List<Product> productsSold;
    private static int contador = 1;
    private int id;

    private Store s0;

    public Ticket() {
        this.productsSold = new ArrayList<Product>();
        id = contador++;
        s0 = Store.getInstance();
    }

    public List<Product> getProducts() {
        return productsSold;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}

    public void addProductsToTicket(Product product, int quantity) {
            if (quantity <= product.getStock()) {
                productsSold.add(new Product(product.getName(), quantity, product.getPrice(), product.getCategory()));
            } else {
                System.out.println("There's not enough stock for this product.");
            }
    }

    public double calculateTotalTicket() {
        double total = 0;
        if (productsSold.size() == 0) {
            System.out.println("The ticket is empty");
        } else {

            for (Product p : productsSold) {
                total += p.getPrice()*p.getStock();
            }
        }
        return total;
    }

    public String calculateAll(){
        return "" + calculateTotalTicket();
    }

    public String ticketToString() {
        return "Ticket ID" + id + " " + productsSold + " Preu total tíquet " + calculateTotalTicket();
    }



}
