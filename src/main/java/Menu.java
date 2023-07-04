import java.util.List;

public class Menu {

    private static Store s0;


    public static void createStore() {

        Store s0 = Store.getInstance();

        if(Txt.checkStoreExist() != null) {
            Menu.s0 = Txt.checkStoreExist();
            System.out.println("Ja tens una botiga creada, amb nom: " + Menu.s0.getName());
        } else {
            s0.setName(User.readString("Entre el nom de la botiga"));
            Txt.writeStore(s0);
        }
    }

    public static void addProduct() {
        if (Txt.checkStoreExist() != null) {
            s0 = Txt.checkStoreExist();
            String askForCategory = User.readString("Quin tipus de producte vols afegir?\n\t1. Tree\n\t2. Flower\n\t3. Decoration");

            if (askForCategory.equals("1")) {
                String newNameTree = User.readString("Quin tipus d'arbre vols afegir?");

//                if (searchProductInProductList(newNameTree) && Txt.productFoundInProductTxt(newNameTree)) {
                if (Txt.productFoundInProductTxt(newNameTree)) {

                        Product updatedTree = updateProduct();
                        //actualizar producto en la lista de productos
                        updatedTree.addStock(User.readInteger("Quantes unitats de " + updatedTree.getName() + " vols afegir?"));
                        System.out.println("Stock del producte " + updatedTree.getName() + " actualitzat en la llista de productes");
                        System.out.println(updatedTree);
                        //actualizar producto en el Txt de producto
                        Txt.writeProductToTxt(updatedTree);
                    } else {
                        Product newTree = new Tree(
                                newNameTree,
                                User.readInteger("Quantes unitats de " + newNameTree + " vols afegir?"),
                                User.readFloat("Quin preu tindrà el producte " + newNameTree + " ?"),
                                Product.Category.TREE,
                                User.readFloat("Quina alçada tindrà el producte: " + newNameTree + " ?")
                        );
//                    ToDo: ERROR --> no guarda el nuevo producto en la lista de productos y no escribe el nuevo producto en el txt
                        Txt.writeProductToTxt(newTree);
                        System.out.println("Nou producte afegit: " + newTree);

//                        s0.addProductToProducts(newTree);
                        System.out.println(s0.getProducts().toString());
                    }

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

                if (searchProductInProductList(newNameDeco) && Txt.productFoundInProductTxt(newNameDeco)) {
                    Product updatedDeco = updateProduct();
                    updatedDeco.addStock(User.readInteger("Quantes unitats de " + updatedDeco.getName() + " vols afegir?"));
                    System.out.println("Stock del producte " + updatedDeco.getName() + " actualitzat en la llista de productes");
                    System.out.println(updatedDeco);
                    //actualizar producto en el Txt de producto
                    Txt.writeProductToTxt(updatedDeco);
                } else {
                    Product newDeco = new Deco(
                            newNameDeco,
                            User.readInteger("Quantes unitats de " + newNameDeco + " vols afegir?"),
                            User.readFloat("Quin preu tindrà el producte " + newNameDeco + " ?"),
                            Product.Category.DECO,
                            User.readString("De quin material serà la decoració de "+newNameDeco+" ?\n\t1. Fusta\n\t2.Plàstic")
                    );
                    s0.getProducts().add(newDeco);
                    System.out.println("Nou producte afegit: " + newDeco);
                    System.out.println(s0.getProducts());
                    Txt.writeProductToTxt(newDeco);
                }
            }

        } else {
            System.out.println("Primer crea la botiga");
        }
    }

    private static Product updateProduct() {
        return new Product("hacerMétodo");
    }

    private static boolean searchProductInProductList(String newProductName) {
        if (Txt.checkStoreExist() != null) {
            s0 = Txt.checkStoreExist();
            for (Product product : s0.getProducts()) {
                if (product.getName().equalsIgnoreCase(newProductName)) {
                    return true;
                }
            }
        }
        return false;
    }


/*
    public static void addTree() {
        if(Txt.checkStoreExist() != null) {
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
 */

//    private static Product searchProductInProductList(String newNameTree) {
//        //ToDo: revisar si se puede hacer con un bucle while o for con el found como tecla de escpae si ya lo encuentra
//        for (Product product : store.getProducts()) {
//            if (product.getName().equalsIgnoreCase(newNameTree)) {
//                return product;
//            }
//        }
//        return null;
//    }

/*
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
*/

}


