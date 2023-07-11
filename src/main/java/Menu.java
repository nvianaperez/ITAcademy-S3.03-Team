
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    static Store s0 = Store.getInstance();
    public static void createStore() {
        if (Reader.checkStoreExist()) {
            System.out.println("Ja tens una botiga creada amb nom: " + s0.getName());
        } else {
            s0.setName(User.readString("Entre el nom de la botiga"));
            Reader.writeStoreObjectToJson(s0);
        }
    }

    public static void addProduct() {

        if (Reader.checkStoreExist()) {

          //  int idProduct = User.readInteger("Id del Producte: ");
            String name = User.readString("Nom del producte: ");

           // String idS = String.valueOf(idProduct);

            if (Reader.checkProductExist(name)) {
                Product product = Reader.readProductObjectFromJson(name);
                int quantity = User.readInteger("Unitats d'estoc a afegir al producte existent: ");
                product.addStock(quantity);
                System.out.println(product);

            } else {
                System.out.println("El producte no es troba al catàleg. Afegeix-lo");
                Product newProduct = Menu.createProduct();
                JSONObject newJsonProduct = Menu.createJsonProduct(newProduct);
                //imprimir el jsonProduct de manera ordenada --> {"price":5,"name":"bonsai","stock":5,"category":"TREE","height":5}
                Reader.writeJsonProduct(newJsonProduct);

            }
        } else {
            System.out.println("Primer crea la botiga");
        }
    }

    private static JSONObject createJsonProduct(Product newProduct) {
        JSONObject jsonProduct = new JSONObject();
        int lastId = Reader.readLastId();

        jsonProduct.put("idProduct", lastId + 1);
        jsonProduct.put("name", newProduct.getName());
        jsonProduct.put("stock", newProduct.getStock());
        jsonProduct.put("price", newProduct.getPrice());
        jsonProduct.put("category", newProduct.getCategory());
        if (newProduct.getCategory() == Product.Category.TREE) {
            jsonProduct.put("height", ((Tree) newProduct).getHeigh());
        }
        if (newProduct.getCategory() == Product.Category.FLOWER) {
            jsonProduct.put("colour", ((Flower) newProduct).getColour());
        }
        if (newProduct.getCategory() == Product.Category.DECO) {
            jsonProduct.put("decoType", ((Deco) newProduct).getDecoType());
        }
        return jsonProduct;
    }

    private static Product createProduct() {
        Product product = null;
        Product.Category category = Menu.askForCategory();
        String name = User.readString("Nom del producte: ");
        int stock = User.readInteger("Quantitat d'estoc: ");
        float price = User.readFloat("Preu del producte: ");

        if (category == Product.Category.TREE) {
            float height = User.readFloat("Alçada de l'arbre: ");
            product = new Tree(name, stock, price, category, height);
            s0.addProductToProducts(product);
        }
        if (category == Product.Category.FLOWER) {
            String colour = User.readString("Color de la flor: ");
            product = new Flower(name, stock, price, category, colour);
            s0.addProductToProducts(product);
        }
        if (category == Product.Category.DECO) {
            String decoType = User.readString("Material del producte de decoració: ");
            product = new Deco(name, stock, price, category, decoType);
            s0.addProductToProducts(product);
        }
        return product;
    }

    private static Product.Category askForCategory() {
        Product.Category category = null;
        int option = User.readInteger("Quin tipus de producte vols afegir?\n\t1. Tree\n\t2. Flower\n\t3. Decoration");
        if (option == 1) {
            category = Product.Category.TREE;
        } else if (option == 2) {
            category = Product.Category.FLOWER;
        } else if (option == 3) {
            category = Product.Category.DECO;
        } else {
            System.out.println("Error al introduir la categoria de producte");
        }
        return category;
    }
    public static void printProducts() {
       Reader.readAllProductsFromTxt();
    }

    public static void addStock(){

        int j = 0;
        boolean esc = false;
        int posProdu = -1;

        ArrayList<Product> llistaProductes = Reader.getLlistaproductesTxt();
        llistaProductes.stream().forEach(p-> System.out.println(p.toString()));
        System.out.println("");

        if (Reader.checkStoreExist()) {

            int idProduct = User.readInteger("Id del Producte: ");
            String name = User.readString("Nom del producte: ");

            while (j < llistaProductes.size() && !esc) {
                Product p0 = llistaProductes.get(j);
                if ((idProduct == p0.getIdProduct()) && name.equalsIgnoreCase(p0.getName())) {
                    posProdu = j;
                    esc = true;
                }
                j++;
            }
            if (esc) {
                JSONArray jsonArray = Reader.createJSONArrayFromTxt();
                JSONObject newJsonObject = jsonArray.getJSONObject(posProdu);
                System.out.println(llistaProductes.get(posProdu).toString());
                System.out.println("");

                int quantity = (User.readInteger("Unitats d'estoc a retirar del producte existent:  "));

                if(quantity > newJsonObject.getInt("stock")){
                    newJsonObject.put("stock", llistaProductes.get(posProdu).removeStock(quantity));
                    System.out.println("");
                    llistaProductes.stream().forEach(p -> Reader.writeJsonProduct(newJsonObject));
                    llistaProductes.stream().forEach(p-> System.out.println(p.toString()));
                    System.out.println("");
                }else{
                    System.out.println("La quantitat supera l´Stock!");
                    System.out.println("");
                }

            } else {
                System.out.println("El producte no es troba al catàleg");
                System.out.println("");
            }
        } else {
            System.out.println("Primer crea la botiga");
            System.out.println("");
        }
    }
    public static void removeProduct() {

        int j = 0;
        boolean esc = false;
        int posProdu = -1;

        ArrayList<Product> llistaProductes = Reader.getLlistaproductesTxt();
        llistaProductes.stream().forEach(p-> System.out.println(p.toString()));
        System.out.println("");

        if (Reader.checkStoreExist()) {

            int idProduct = User.readInteger("Id del Producte: ");
            String name = User.readString("Nom del producte: ");

                while (j < llistaProductes.size() && !esc) {
                    Product p0 = llistaProductes.get(j);
                    if ((idProduct == p0.getIdProduct()) && name.equalsIgnoreCase(p0.getName())) {
                        posProdu = j;
                        esc = true;
                    }
                    j++;
                }
                if (esc) {
                    JSONArray jsonArray = Reader.createJSONArrayFromTxt();
                    JSONObject newJsonObject = jsonArray.getJSONObject(posProdu);
                    System.out.println(llistaProductes.get(posProdu).toString());
                    System.out.println("");

                    int quantity = (User.readInteger("Unitats d'estoc a retirar del producte existent:  "));

                    if(quantity < llistaProductes.get(posProdu).getStock()){
                        newJsonObject.put("stock", llistaProductes.get(posProdu).removeStock(quantity));
                        System.out.println("");

                        llistaProductes.stream().forEach(p -> Reader.writeJsonProductStock(newJsonObject));
                        llistaProductes.stream().forEach(p-> System.out.println(p.toString()));
                        System.out.println("");
                    }else{
                        System.out.println("La quantitat supera l´Stock!");
                        System.out.println("");
                    }

                } else {
                    System.out.println("El producte no es troba al catàleg");
                    System.out.println("");
                }
            } else {
                System.out.println("Primer crea la botiga");
                System.out.println("");
            }
        }

    public static void printStock() {
        Reader.readAllStockFromTxt();
    }

    public static void printTotalValue() {

        Reader.totalPriceValuesFromTxt();
    }

    private static JSONObject createJsonTicket(Ticket newTicket) {
        JSONObject jsonTicket = new JSONObject();

        return jsonTicket;
    }

    public static void createTicket() {
        if (Reader.checkStoreExist()) {
            Ticket ticket = new Ticket();
            s0.getTickets().add(ticket);

            if (s0.getProducts() != null) {
                boolean aux = false;
                while (!aux) {
                    ticket.addProductsToTicket(Reader.readProductObjectFromJson(User.readString("What product dou you want to add: ")), User.readInteger("What quantity do you want to add: "));
                    String option = User.readString("Do you want to keep adding items to ticket? Yes / No");
                    System.out.println(ticket.ticketToString());
                    if (option.equalsIgnoreCase("No")) {
                        aux = true;
                    }
                }
                JSONObject newJsonTicket = Menu.createJsonTicket(ticket);
                ticket.getProducts().forEach(product -> {
                        newJsonTicket.put("Product",product.getName());
                        newJsonTicket.put("Quantity",product.getStock());
                        newJsonTicket.put("Price",product.getPrice());
                        newJsonTicket.put("Id", ticket.getId());});
                Reader.writeJsonTicket(newJsonTicket);
            } else {
                System.out.println("There are no products in the store");
            }
        } else {
            System.out.println("First create a store");
        }
    }
    



}


