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
            if(store != null) {
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

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                store = (Store) ois.readObject();
            } catch (EOFException ex) {
                System.out.println("Final del fitxer");
            } catch (IOException | ClassNotFoundException | SecurityException ex) {
                ex.printStackTrace();
            }
        }
        return store;
    }

    public static boolean productFoundInProductTxt(String newProductName) {
        File file = new File(productPath);
        String s = newProductName.trim();
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //ToDo: NullPointerException br.readLine() is null
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

    public static List<Product> readProductTxt() {
        List<Product> productList = new ArrayList<>();
        File file = new File(productPath);
        Product product;

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while((product = (Product)ois.readObject()) != null) {
                    productList.add(product);
                }
            } catch (EOFException ex) {
                System.out.println("Final del fitxer");
            } catch (IOException | ClassNotFoundException | SecurityException ex) {
                ex.printStackTrace();
            }
        }
        return productList;

    }

    //ToDo: único método writeTxt(Object object) y que dentro pregunte si quiere escribir en el File de store o en el de product o en el de ticket
    public static void writeProductToTxt(Product newProduct) {
        File file = new File(productPath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            if(newProduct != null) {
                oos.writeObject(newProduct);
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


