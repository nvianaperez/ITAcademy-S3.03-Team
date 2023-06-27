import java.util.ArrayList;
import java.util.List;

public class Store {

    private String name;
    private int idStore;
    private static int idNext = 1;
    private List<Product> productList;

    private List<Ticket> ticketList;

    private static Store instance;

    public Store(String name){
        this.idStore += idNext;
        this.name = name;
        this.productList = new ArrayList<>();
        this.ticketList = new ArrayList<>();
    }

    private Store(){

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

    public int getId() {
        return this.idStore;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void addProductToProducts(Product productList) {
        this.productList.add(productList);
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
        return  "Store Id:  " + this.idStore + " || " + "Store name: " + this.name;
    }
}
