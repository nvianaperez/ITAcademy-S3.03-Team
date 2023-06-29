import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Txt {
    private static final String productPath = "productPath.txt";
    private static final String ticketPath = "ticketPath.txt";
    private static final String storePath = "storePath.txt";

    public static void writeStore(Store store) {
        File file = new File(storePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            if (store != null) {
                oos.writeObject(store);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Store checkStoreExist() {
        File file = new File(storePath);
        Store store = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            store = (Store) ois.readObject();
        } catch (EOFException ex) {
            System.out.println("Final del fitxer");
        } catch (IOException | ClassNotFoundException | SecurityException ex) {
            ex.printStackTrace();
        }
        return store;
    }

    public static boolean readProductTxt(String newNameTree) {
        File file = new File(productPath);
        String s = newNameTree.trim();
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(file.exists() && (br.readLine() != null) && !found) {
                if(br.readLine().contains(s)) {
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return found;
    }

    //ToDo: cambiar este método para que reciba por parámetro un Product product y dentro pregunte qué es: tree, flower o deco y escriba el objeto
    //ToDo: quizá podamos hacer un único método writeTxt(Object object) y que dentro pregunte si quiere escribir en el File de store o en el de product o en el de ticket
    public static void writeProductToTxt(Product newTree) {
        File file = new File(productPath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            while(newTree != null) {
                oos.writeObject(newTree);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    public static Store checkStoreExist() {
//        try (BufferedReader br = new BufferedReader(new FileReader("store.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                Store store = parseStore(line);
//                if (store != null) {
//                    return store;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static Store parseStore(String line) {
//        // Lógica para analizar la línea y crear un objeto Store
//        String[] parts = line.split(",");
//        if (parts.length >= 4) {
//            String name = parts[0];
//            return new Store(name);
//        }
//        return null;
//    }
}


