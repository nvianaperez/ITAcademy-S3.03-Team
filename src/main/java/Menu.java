
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    static Store s0 = Store.getInstance();
    public static void createStore() {
        if (Reader.checkStoreExist()) {
            System.out.println("Ja tens una botiga creada amb nom: " + Reader.readStoreObjectFromJson());
        } else {
            s0.setName(User.readString("Entre el nom de la botiga"));
            Reader.writeStoreObjectToJson(s0);
            System.out.println("La seva botiga "+s0.getName()+" s'ha creat correctament.\nComenci a introduir productes.");
        }
    }

    public static void addProduct() {
        if (Reader.checkStoreExist()) {
            String name = User.readString("Nom del producte: ");
            if (Reader.checkProductExist(name)) {
                Product product = Reader.readProductObjectFromJson(name);
                int quantity = User.readInteger("Unitats d'estoc a afegir al producte existent: ");
                product.addStock(quantity);
                JSONObject newJsonProduct = Menu.updateJsonProduct(product);
                Reader.updateStockJsonProduct(newJsonProduct);
            } else {
                System.out.println("El producte '"+name+"' no es troba al catàleg");
                Reader.readAllProductsFromTxt();
                String option = User.readString("Vols afegir un producte nou? [Si / No]");
                if (option.equalsIgnoreCase("si")) {
                    Product newProduct = Menu.createProduct(name);
                    JSONObject newJsonProduct = Menu.createJsonProduct(newProduct);
                    Reader.writeJsonProduct(newJsonProduct);
                    System.out.println(newProduct);
                }
            }
        } else {
            System.out.println("Primer crea la botiga");
        }
    }

    private static JSONObject updateJsonProduct(Product product) { //product tiene id 1 siempre
        JSONObject jsonProduct = new JSONObject(); //jsonProduct: "{"idProduct":1}"
        jsonProduct.put("idProduct", product.getIdProduct());
        jsonProduct.put("name", product.getName());
        jsonProduct.put("stock", product.getStock());
        jsonProduct.put("price", product.getPrice());
        jsonProduct.put("category", product.getCategory());
        if (product.getCategory() == Product.Category.TREE) {
            jsonProduct.put("height", ((Tree) product).getHeigh());
        }
        if (product.getCategory() == Product.Category.FLOWER) {
            jsonProduct.put("colour", ((Flower) product).getColour());
        }
        if (product.getCategory() == Product.Category.DECO) {
            jsonProduct.put("decoType", ((Deco) product).getDecoType());
        }
        return jsonProduct;
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

    private static Product createProduct(String name) {
        Product product = null;
        Product.Category category = Menu.askForCategory();
        name = name.toLowerCase().trim();
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

    public static void removeProduct() {
        if (Reader.checkStoreExist()) {
            String name = User.readString("Nom del producte: ");
            if (Reader.checkProductExist(name)) {
                Product product = Reader.readProductObjectFromJson(name);
                int quantity = User.readInteger("Unitats d'estoc a retirar del producte existent: ");
                product.removeStock(quantity);
                JSONObject newJsonProduct = Menu.updateJsonProduct(product);
                Reader.updateStockJsonProduct(newJsonProduct);
            } else {
                System.out.println("El producte '"+name+"' no es troba al catàleg");
                Reader.readAllProductsFromTxt();
                String option = User.readString("Vols afegir un producte nou? [Si / No]");
                if (option.equalsIgnoreCase("si")) {
                    Product newProduct = Menu.createProduct(name);
                    JSONObject newJsonProduct = Menu.createJsonProduct(newProduct);
                    Reader.writeJsonProduct(newJsonProduct);
                    System.out.println(newProduct);
                }
            }
        } else {
            System.out.println("Primer crea la botiga");
        }        }

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
                    //ToDo: añadir if no se encuentra el producto en el Txt de products
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


