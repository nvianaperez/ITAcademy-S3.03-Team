import org.json.JSONObject;

public class Menu {

    private static Store s0;


    public static void createStore() {

        Store s0 = Store.getInstance();

        if(Reader.checkStoreExist()) {
            System.out.println("Ja tens una botiga creada amb nom: "+s0.getName());
        } else {
            s0.setName(User.readString("Entre el nom de la botiga"));
            Reader.writeStoreObjectToJson(s0);
        }
    }

    public static void addProduct() {
//        check if store exist
//        check if product exist
//        crear el producto
//        crear el JsonProduct
//        write el JsonProduct

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
//        jsonProduct.putOnce("product", newProduct);
        jsonProduct.put("name", newProduct.getName());
        jsonProduct.put("stock", newProduct.getStock());
        jsonProduct.put("price", newProduct.getPrice());
        jsonProduct.put("category", newProduct.getCategory());
        if (newProduct.getCategory() == Product.Category.TREE) {
            jsonProduct.put("height", ((Tree) newProduct).getHeigh() );
        }
        if (newProduct.getCategory() == Product.Category.FLOWER ) {
            jsonProduct.put("colour", ((Flower) newProduct).getColour() );
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

        if(category == Product.Category.TREE) {
            float height = User.readFloat("Alçada de l'arbre: ");
            product = new Tree(name, stock, price, category, height);
        }
        if(category == Product.Category.FLOWER) {
            String colour = User.readString("Color de la flor: ");
            product = new Flower(name, stock, price, category, colour);
        }
        if(category == Product.Category.DECO){
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
}


