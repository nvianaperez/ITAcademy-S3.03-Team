import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ticket implements Serializable {

    private List<Product> productsSold;
    private static int contador = 0;
    private int id;

    private Store s0;

    public Ticket() {
        this.productsSold = new ArrayList<Product>();
        contador++;
        id = contador;
        s0 = Store.getInstance();
    }
    public Ticket(int id) {
        this.productsSold = new ArrayList<Product>();
        contador++;
        id = contador;
        s0 = Store.getInstance();
    }
    public List<Product> getProducts() {
        return productsSold;
    }

    public  int getId() {
        return id;
    }

    public void addProductsToTicket(Product products,int quantity) {

            Optional<Product> productOptional = s0.getProducts().stream()
                    .filter(p -> products.getName().equalsIgnoreCase(p.getName()))
                    .findFirst();

            productOptional.ifPresent(product -> {
                if (quantity <= product.getStock()) {
                    productsSold.add(new Product(products.getName(),quantity, products.getPrice(), products.getCategory()));
                    product.removeStock(quantity);
                } else {
                    System.out.println("There's not enough stock for this product.");
                }
            });

            if (!productOptional.isPresent()) {
                System.out.println("Product not found.");
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

    public String ticketToString() {
        return "Ticket ID" + id + " " + productsSold + " " + calculateTotalTicket();
    }



}
