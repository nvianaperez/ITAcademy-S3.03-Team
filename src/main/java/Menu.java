import java.util.Scanner;

public class Menu {

    private static Store store;
    private static Scanner sc;

    public static void createStore() {

        if(Txt.checkStoreExist() != null) {
            store = Txt.checkStoreExist();
            System.out.println("Ja tens una botiga creada, amb nom: "+store.getName());
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

        if(Txt.checkStoreExist() != null) {
            String newNameTree = User.readString("Quin tipus d'arbre vols afegir?");
            //buscarlo en la lista de productos y en el Txt de products
            Product treeFoundInProductList = searchProductInProductList(newNameTree);

            if (treeFoundInProductList != null && Txt.readProductTxt(newNameTree)) {
                //actualizar producto en la lista de productos
                treeFoundInProductList.addStock(User.readInteger("Quantes unitats de "+treeFoundInProductList.getName()+" vols afegir?"));
                treeFoundInProductList.addStock(User.readInteger("Quantes unitats de "+treeFoundInProductList.getName()+" vols afegir?"));
                System.out.println("Stock del producte "+treeFoundInProductList.getName()+" actualitzat en la llista de productes");
                System.out.println(treeFoundInProductList);
                //actualizar producto en el Txt de producto
                Txt.writeProductToTxt(treeFoundInProductList);
            } else {
                Product newTree = new Tree(
                        1,
                        newNameTree,
                        User.readInteger("Quantes unitats de "+newNameTree+" vols afegir?"),
                        User.readFloat("Quin preu tindrà el producte "+newNameTree+" ?"),
                        User.readFloat("Quina alçada tindrà el producte: "+newNameTree+" ?")
                        );
                store.getProducts().add(newTree);
                System.out.println("Nou producte afegit: "+ newTree);
                System.out.println(store);
                Txt.writeProductToTxt(newTree);
            }

        } else {
            System.out.println("Primer crea la botiga");
        }

    }

    private static Product searchProductInProductList(String newNameTree) {
        for (Product product : store.getProducts()) {
            if (product.getName().equalsIgnoreCase(newNameTree)) {
                return product;
            }
        }
        return null;
    }
}
