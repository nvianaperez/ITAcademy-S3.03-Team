import org.json.JSONObject;

public class Menu {

  
    private static Store s0;
    private static Ticket ticket;
  
    public static void createStore() {

<<<<<<< HEAD
        Store s0 = Store.getInstance();

        if(Reader.checkStoreExist()) {
            System.out.println("Ja tens una botiga creada amb nom: "+s0.getName());
=======
        if (Txt.checkStoreExist() != null) {
            s0 = Txt.checkStoreExist();
            System.out.println("Ja tens una botiga creada, amb nom: " + store.getName());
   
>>>>>>> 3a40edf6f44b0c9b6365a3e797728b4917e5ea77
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

<<<<<<< HEAD
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
=======
            } else if (askForCategory.equals("2")) {
                String newNameFlower = User.readString("Quin tipus de flor vols afegir?");

                if (searchProductInProductList(newNameFlower) && Txt.productFoundInProductTxt(newNameFlower)) {
                    Product updatedFlower = updateProduct();
                    updatedFlower.addStock(User.readInteger("Quantes unitats de " + updatedFlower.getName() + " vols afegir?"));
                    System.out.println("Stock del producte " + updatedFlower.getName() + " actualitzat en la llista de productes");
                    System.out.println(updatedFlower);
                    //actualizar producto en el Txt de producto
                    Txt.writeProductToTxt(updatedFlower);
                } else {
                    Product newFlower = new Flower(
                            newNameFlower,
                            User.readInteger("Quantes unitats de " + newNameFlower + " vols afegir?"),
                            User.readFloat("Quin preu tindrà el producte " + newNameFlower + " ?"),
                            Product.Category.FLOWER,
                            User.readString("De quin color serà el producte " + newNameFlower)
                    );
                    s0.getProducts().add(newFlower);
                    System.out.println("Nou producte afegit: " + newFlower);
                    System.out.println(s0.getProducts());
                    Txt.writeProductToTxt(newFlower);
                }
            } else {
                String newNameDeco = User.readString("Quin tipus de decoració vols afegir?");


            String newNameTree = User.readString("Quin tipus d'arbre vols afegir?");
            //buscarlo en la lista de productos y en el Txt de products
            Product treeFoundInProductList = searchProductInProductList(newNameTree);

            if (treeFoundInProductList != null && Txt.readProductTxt(newNameTree)) {
                //actualizar producto en la lista de productos
                treeFoundInProductList.addStock(User.readInteger("Quantes unitats de " + treeFoundInProductList.getName() + " vols afegir?"));
                System.out.println("Stock del producte " + treeFoundInProductList.getName() + " actualitzat en la llista de productes");
                System.out.println(treeFoundInProductList);
                //actualizar producto en el Txt de producto
                Txt.writeProductToTxt(treeFoundInProductList);
            } else {
                Product newTree = new Tree(
                        1,
                        newNameTree,
                        User.readInteger("Quantes unitats de " + newNameTree + " vols afegir?"),
                        User.readFloat("Quin preu tindrà el producte " + newNameTree + " ?"),
                        User.readFloat("Quina alçada tindrà el producte: " + newNameTree + " ?")
                );
                store.getProducts().add(newTree);
                System.out.println("Nou producte afegit: " + newTree);
                System.out.println(store);
                Txt.writeProductToTxt(newTree);
            }

        } else {
            System.out.println("Primer crea la botiga");
        }

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

        //     1) look for store
//        2) check if the tree already axist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        //ToDo: Habria que crear un writeProductListToTxt y readProductListFromTxt para crear la persistencia?

        int i = 0;
        boolean esc = false;

        if (Txt.checkStoreExist() != null) {
            while(i < store.getProducts().size() && !esc){
                if(store.getProducts().size() != 0){
                    System.out.println(store.getProducts().get(i).toString());
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

    public static void removeTree() {

        //     1) look for store
//        2) check if the tree already exist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        if (Txt.checkStoreExist() != null) {
            String newNameTree = User.readString("Quin tipus d'arbre vols retirar?");
            //buscarlo en la lista de productos y en el Txt de products
            boolean foundTree = searchProductInProductList(newNameTree);

            if (treeFoundInProductList != null && Txt.readProductTxt(newNameTree)) {
                //actualizar producto en la lista de productos
                treeFoundInProductList.removeStock(User.readInteger("Quantes unitats de " + treeFoundInProductList.getName() + " vols eliminar?"));
                System.out.println("Stock del producte " + treeFoundInProductList.getName() + " actualitzat en la llista de productes");
                System.out.println(treeFoundInProductList);
                //actualizar producto en el Txt de producto
                Txt.writeProductToTxt(treeFoundInProductList);
            } else {
                System.out.println("Aquest arbre no es troba a la llista");
            }

        } else {
            System.out.println("Primer crea la botiga");
        }

        }

    public static void removeFlower() {

        //     1) look for store
//        2) check if the tree already exist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        if (Txt.checkStoreExist() != null) {
            String newNameFlower = User.readString("Quin tipus de flor vols retirar?");
            //buscarlo en la lista de productos y en el Txt de products
            Product flowerFoundInProductList = searchProductInProductList(newNameFlower);

            if (flowerFoundInProductList != null && Txt.readProductTxt(newNameFlower)) {
                //actualizar producto en la lista de productos
                flowerFoundInProductList.removeStock(User.readInteger("Quantes unitats de " + flowerFoundInProductList.getName() + " vols eliminar?"));
                System.out.println("Stock del producte " + flowerFoundInProductList.getName() + " actualitzat en la llista de productes");
                System.out.println(flowerFoundInProductList);
                //actualizar producto en el Txt de producto
                Txt.writeProductToTxt(flowerFoundInProductList);
            } else {
                System.out.println("Aquesta flor no es troba a la llista");
            }

        } else {
            System.out.println("Primer crea la botiga");
        }

    }
    public static void removeDeco() {

        //     1) look for store
//        2) check if the tree already exist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        if (Txt.checkStoreExist() != null) {
            String newNameDeco = User.readString("Quin tipus de decoració vols retirar?");
            //buscarlo en la lista de productos y en el Txt de products
            Product decoFoundInProductList = searchProductInProductList(newNameDeco);

            if (decoFoundInProductList != null && Txt.readProductTxt(newNameDeco)) {
                //actualizar producto en la lista de productos
                decoFoundInProductList.removeStock(User.readInteger("Quantes unitats de " + decoFoundInProductList.getName() + " vols eliminar?"));
                System.out.println("Stock del producte " + decoFoundInProductList.getName() + " actualitzat en la llista de productes");
                System.out.println(decoFoundInProductList);
                //actualizar producto en el Txt de producto
                Txt.writeProductToTxt(decoFoundInProductList);
            } else {
                System.out.println("Aquesta decoració no es troba a la llista");
            }


        } else {
            System.out.println("Primer crea la botiga");
        }

    }


    public static void printTotalValue() {

        //     1) look for store
//        5) escribir txt

        //ToDo: Habria que crear un writeStoreValueToTxt y readStoreValueFromTxt para crear la persistencia?

        float total = 0f;

        if (Txt.checkStoreExist() != null) {
            for(Product p : store.getProducts()){
                total += p.getPrice();
                }
            }else {
            System.out.println("Primer crea la botiga");
        }
        System.out.println("El valor total de les exitències de la floristeria es de : " + total + "€");
    }
    
   
   public static void addTicket() {
//        1) look for store
//        2) if exist, add stock.
//        3) escribir txt

        if (Txt.checkStoreExist() != null) {
            store = Txt.checkStoreExist();
            Ticket ticket = new Ticket();
            store.getTickets().add(ticket);
            if (store.getProducts() != null) {
                ticket.addProductsToTicket(User.readString("What product do you want to add to the ticket?"), User.readInteger("How many products of this type do you want to add?"), store);
                Txt.writeTicket(ticket);
            } else {
                System.out.println("There are no products in the store");
            }
              public static void printStock() {

        //     1) look for store
//        2) check if the tree already exist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        //ToDo: Habria que crear un writeProductStockToTxt y readProductStockFromTxt para crear la persistencia?

        int i = 0;
        boolean esc = false;

        if (Txt.checkStoreExist() != null) {
            while(i < store.getProducts().size() && !esc){
                if(store.getProducts().size() != 0){
                    System.out.println(store.getProducts().get(i).toString() + " " + store.getProducts().get(i).getStock() + " Unitats");
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

>>>>>>> 3a40edf6f44b0c9b6365a3e797728b4917e5ea77
}


