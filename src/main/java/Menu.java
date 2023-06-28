import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private static Store store;
    private static Scanner sc;

    public static void createStore() {

        if(Txt.checkStoreExist() != null) {
            store = Txt.checkStoreExist();
            System.out.println("Ja tens una botiga creada, amb nom: "+store.getName());
        } else {
//                llamar a getInstance(User.readString("")) para tener la instancia de la tienda
            Txt.writeStore(store);
        }
    }

    public static void addTree() {
//        1) look for store
//        2) check if the tree already axist
//        3) if exist, add stock.
//        4) If not exist, new Tree
//        5) escribir txt

        if(Txt.checkStoreExist() != null) {
            String newNameTree = User.readString("Quin tipus d'arbre vols afegir?", sc);
            //buscarlo en la lista de productos y en el Txt de products
            Product treeFoundInProductList = searchProductInProductList(newNameTree);

            if (treeFoundInProductList != null && Txt.readProductTxt(newNameTree)) {
                //ToDo: falta addStock(). ha de sumar el número que entra el usuario al stock que ya tiene el producto.
                //actualizar producto en la lista de productos
//                    treeFoundInProductList.addStock(User.readInteger("Quantes unitats de "+treeFoundInProductList.getName()+" vols afegir?", sc));
                System.out.println("Stock del producte "+treeFoundInProductList.getName()+" actualitzat en la llista de productes");
                System.out.println(treeFoundInProductList);
                //actualizar producto en el Txt de producto
                Txt.writeProductToTxt(treeFoundInProductList);
            } else {
                Product newTree = new Tree(
                        1,
                        newNameTree,
                        User.readInteger("Quantes unitats de "+newNameTree+" vols afegir?", sc),
                        User.readFloat("Quin preu tindrà el producte "+newNameTree+" ?", sc),
                        User.readFloat("Quina alçada tindrà el producte: "+newNameTree+" ?", sc)
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
