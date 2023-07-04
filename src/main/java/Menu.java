import java.util.Scanner;

public class Menu {

    private static Store store;
    private static Scanner sc;

    public static void createStore() {

        if (Txt.checkStoreExist() != null) {
            store = Txt.checkStoreExist();
            System.out.println("Ja tens una botiga creada, amb nom: " + store.getName());
        } else {
            Store s0 = new Store(User.readString("Entre el nom de la botiga"));
            //llamo al constructor con el name -- reapasar singleton
            //llamar a getInstance(User.readString("")) para tener la instancia de la tienda
            Txt.writeStore(s0);
        }
    }

    public static void addTree() {
//        1) look for store
//        2) check if the tree already axist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        if (Txt.checkStoreExist() != null) {
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

    private static Product searchProductInProductList(String newNameTree) {
        //ToDo: revisar si se puede hacer con un bucle while o for con el found como tecla de escpae si ya lo encuentra
        for (Product product : store.getProducts()) {
            if (product.getName().equalsIgnoreCase(newNameTree)) {
                return product;
            }
        }
        return null;
    }


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
            Product treeFoundInProductList = searchProductInProductList(newNameTree);

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
    }

