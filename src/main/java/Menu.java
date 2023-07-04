import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static Store store;


    public static void createStore() {

        Store s0 = Store.getInstance();

        if(Txt.checkStoreExist() != null) {
            store = Txt.checkStoreExist();
            System.out.println("Ja tens una botiga creada, amb nom: "+store.getName());
        } else {
            s0.setName(User.readString("Entre el nom de la botiga"));
            Txt.writeStore(s0);
        }
    }

    public static void addProduct() {
        if (Txt.checkStoreExist() != null) {
            store = Txt.checkStoreExist();
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
                                1,
                                newNameTree,
                                User.readInteger("Quantes unitats de " + newNameTree + " vols afegir?"),
                                User.readFloat("Quin preu tindrà el producte " + newNameTree + " ?"),
                                Product.Category.TREE,
                                User.readFloat("Quina alçada tindrà el producte: " + newNameTree + " ?")
                        );
//                    ToDo: ERROR --> no guarda el nuevo producto en la lista de productos
                        Txt.writeProductToTxt(newTree);
//                    1. productList = readProductsFromProductTxt
//                    2. después añadir el nuevo producto a productList
                        List<Product> productList = Txt.readProductTxt();
                        productList.add(newTree);
                        System.out.println("Nou producte afegit: " + newTree);
                        productList.stream()
                                .forEach(System.out::println);
                        System.out.println(store.getProducts());
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
                            1,
                            newNameFlower,
                            User.readInteger("Quantes unitats de " + newNameFlower + " vols afegir?"),
                            User.readFloat("Quin preu tindrà el producte " + newNameFlower + " ?"),
                            Product.Category.FLOWER,
                            User.readString("De quin color serà el producte " + newNameFlower)
                    );
                    store.getProducts().add(newFlower);
                    System.out.println("Nou producte afegit: " + newFlower);
                    System.out.println(store.getProducts());
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
                            1,
                            newNameDeco,
                            User.readInteger("Quantes unitats de " + newNameDeco + " vols afegir?"),
                            User.readFloat("Quin preu tindrà el producte " + newNameDeco + " ?"),
                            Product.Category.DECO,
                            User.readString("De quin material serà la decoració de "+newNameDeco+" ?\n\t1. Fusta\n\t2.Plàstic")
                    );
                    store.getProducts().add(newDeco);
                    System.out.println("Nou producte afegit: " + newDeco);
                    System.out.println(store.getProducts());
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
            store = Txt.checkStoreExist();
            for (Product product : store.getProducts()) {
                if (product.getName().equalsIgnoreCase(newProductName)) {
                    return true;
                }
            }
        }
        return false;
    }
}



/*
    public static void addTree() {
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

 */
