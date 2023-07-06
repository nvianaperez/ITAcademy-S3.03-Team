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
        if(file.exists()) {
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                line = br.readLine();
                //ToDo: NullPointerException br.readLine() is null
                while ((line != null) && !found) {
                    if (line.contains(s)) {
                        found = true;
                    }
                    line = br.readLine();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
                System.out.println("No existeix cap producte registrat");
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

    public static void writeProductToTxt(Product newProduct) {
        File file = new File(productPath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true))) {
            if(newProduct != null) {
                oos.writeObject(newProduct+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


