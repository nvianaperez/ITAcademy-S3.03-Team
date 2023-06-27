import java.util.ArrayList;
import java.util.List;

public class Store {

    private String name;
    private int id;
    private static int idNext = 1;
    private List<Product> productList;

    public Store(String name){
        this.id += idNext;
        this.name = name;
        this.productList = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(Product productList) {
        this.productList.add(productList);
    }

    @Override
    public String toString() {
        return  "Store Id:  " + this.id + " || " + "Store name: " + this.name;
    }
}
