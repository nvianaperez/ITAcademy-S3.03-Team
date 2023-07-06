import org.json.JSONObject;

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
            String name = User.readString("Nom del producte: ");
            if (Reader.checkProductExist(name)) {
                Product product = Reader.readProductObjectFromJson(name);
                int quantity = User.readInteger("Unitats d'estoc a afegir al producte existent: ");
                product.addStock(quantity);
                System.out.println(product);
            } else {
                System.out.println("El producte no es troba al catàleg. Afegeix-lo");
                Product newProduct = Menu.createProduct();
                JSONObject newJsonProduct = Menu.createJsonProduct(newProduct);
                //ToDo: imprimir el jsonProduct de manera ordenada --> {"price":5,"name":"bonsai","stock":5,"category":"TREE","height":5}
                Reader.writeJsonProduct(newJsonProduct);
            }
        } else {
            System.out.println("Primer crea la botiga");
        }
    }

    private static JSONObject createJsonProduct(Product newProduct) {
        JSONObject jsonProduct = new JSONObject();
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
        }
        if (category == Product.Category.FLOWER) {
            String colour = User.readString("Color de la flor: ");
            product = new Flower(name, stock, price, category, colour);
        }
        if (category == Product.Category.DECO) {
            String decoType = User.readString("Material del producte de decoració: ");
            product = new Deco(name, stock, price, category, decoType);
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



//    private static Product searchProductInProductList(String newNameTree) {
//        //ToDo: revisar si se puede hacer con un bucle while o for con el found como tecla de escpae si ya lo encuentra
//        for (Product product : store.getProducts()) {
//            if (product.getName().equalsIgnoreCase(newNameTree)) {
//                return product;
//            }
//        }
//        return null;
//    }


    public static void printProducts() {
        int i = 0;
        boolean esc = false;

        if (Txt.checkStoreExist() != null) {
            while(i < s0.getProducts().size() && !esc){
                if(s0.getProducts().size() != 0){
                    System.out.println(s0.getProducts().get(i).toString());
                    //Introducir el metodo para persistencia
                }else{
                    System.out.println("La botiga no disposa encara d´existències");
                    System.out.println("");
                    esc = true;
                }
            }
        }else {
            System.out.println("Primer crea la botiga");
        }
    }


    public static void printTotalValue() {
        float total = 0f;

        if (Reader.checkStoreExist()) {
            for(Product p : s0.getProducts()){
                total += p.getPrice()*p.getStock();
                }
            }else {
            System.out.println("Primer crea la botiga");
        }
        System.out.println("El valor total de les exitències de la floristeria es de : " + total + "€");
    }


    public static void createTicket () {
        Store s0 = Txt.checkStoreExist();

        if (s0 != null) {
            Ticket ticket = new Ticket();
            s0.getTickets().add(ticket);

            if (s0.getProducts() != null) {
                ticket.addProductsToTicket(User.readString("What product do you want to add to the ticket?"),
                        User.readInteger("How many products of this type do you want to add?"), s0);
                Txt.writeTicket(ticket);
            } else {
                System.out.println("There are no products in the store");
            }
        }
    }

    public static void printAllTickets() {
        Store s0 = Txt.checkStoreExist();
        if (s0 != null) {
            if (s0.getTickets() != null) {
                s0.getTickets().forEach(ticket -> System.out.println(ticket.ticketToString()));
            }else{
                System.out.println("There isn´t tickets at this moment");
            }
        } else {
            System.out.println("First create a store");
        }
    }

    public static void printTotalTickets() {
        Store s0 = Txt.checkStoreExist();
        double total = 0;

        if (s0 != null) {
            List<Ticket> tickets = s0.getTickets();

            if (tickets != null && !tickets.isEmpty()) {
                for (Ticket ticket : tickets) {
                    total += ticket.calculateTotalTicket();
                }
                System.out.println("Total amount sold: " + total);
            } else {
                System.out.println("There are no tickets at this moment");
            }
        } else {
            System.out.println("First create a store");
        }
    }

}


