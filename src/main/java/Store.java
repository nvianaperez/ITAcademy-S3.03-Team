import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Store implements Serializable {

    private String name;

    private List<Product> productList;

    private List<Ticket> ticketList;

    private static Store instance;

    private Store(String name){
        this.name = name;
        this.productList = new ArrayList<>();
        this.ticketList = new ArrayList<>();
    }

    private Store() {
        this.productList = new ArrayList<>();
        this.ticketList = new ArrayList<>();
    }

    public static Store getInstance(){
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return this.productList;
    }

    public void addProductToProducts(Product product) {
        this.productList.add(product);
    }

    public void removeProductFromProducts(Product productList) {
        this.productList.remove(productList);
    }

    public List<Ticket> getTickets() {
        return this.ticketList;
    }

    public void addTicketToTickets(Ticket ticket) {
        this.ticketList.add(ticket);
    }

    @Override
    public String toString() {
        return  "Store name: " + this.name;
    }
}
