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

    public List<Product> getProducts() {
        return productsSold;
    }

    public  int getId() {
        return id;
    }

    public void addProductsToTicket(String name, int quantity, Store store) {
   //       if(s0.getProducts() != null) {
   //         System.out.println("There are no products in the store");
   //     }else {
            Optional<Product> productOptional = store.getProducts().stream()
                    .filter(p -> name.equalsIgnoreCase(p.getName()))
                    .findFirst();

            productOptional.ifPresent(product -> {
                if (quantity <= product.getStock()) {
                    productsSold.add(new Product(name, quantity));
                    product.removeStock(quantity);
                } else {
                    System.out.println("There's not enough stock for this product.");
                }
            });

            if (!productOptional.isPresent()) {
                System.out.println("Product not found.");
            }
     //   }
    }

    public double calculateTotalTicket() {
        double total = 0;
        if (productsSold.size() == 0) {
            System.out.println("The ticket is empty");
        } else {

            for (Product p : productsSold) {
                total += p.getPrice();
            }
        }
        return total;
    }
}
