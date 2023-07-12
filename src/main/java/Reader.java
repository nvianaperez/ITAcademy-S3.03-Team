import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.*;
import java.io.*;
import java.util.ArrayList;

//ToDo: no funciona el JsonPropertyOrder
@JsonPropertyOrder({"id", "name", "price","category", "stock"})
public class Reader {
    private static final String productPath = "productPath.txt";
    private static final String ticketPath = "ticketPath.txt";
    private static final String storePath = "storePath.txt";

    public static boolean checkStoreExist() {
        boolean found = false;
        File file = new File(storePath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            if (file.exists() && br.readLine() != null) {
                br.readLine();
                found = true;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return found;
    }

//    public static boolean checkProductExist(String idS, String name) {
//        boolean found = false;
//        File file = new File(productPath);
//
//        if (file.exists()) {
//            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//                String line = br.readLine();
//                while (line != null) {
//                    if (line.contains(idS) && line.contains(name)) {
//                        found = true;
//                        break;
//                    }
//                    line = br.readLine();
//                }
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return found;
//    }

    public static boolean checkProductExist(String name) {
        boolean found = false;
        File file = new File(productPath);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    if (line.contains(name)) {
                        found = true;
                        break;
                    }
                    line = br.readLine();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return found;
    }

    public static void writeStoreObjectToJson(Store s0) {
        JSONObject s0Json = new JSONObject();
        s0Json.put("name", s0.getName());
        File file = new File(storePath);
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(s0Json.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String readStoreObjectFromJson() {
        File file = new File(storePath);
        String name="";

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    JSONObject json = new JSONObject(line);
                    name = json.getString("name");
                    line = br.readLine();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return name;
    }

    //ToDo: imprimir el jsonProduct de manera ordenada --> {"price":5,"name":"bonsai","stock":5,"category":"TREE","height":5}
    public static void writeJsonProduct(JSONObject newJsonProduct) {
        File file = new File(productPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(newJsonProduct + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writeJsonTicket(JSONObject newJsonTicket) {
        File file = new File(ticketPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(newJsonTicket + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Ticket readProductFromTicket() {
        File file = new File(productPath);
        Ticket ticket = new Ticket();
        Product product;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {

                        JSONObject json = new JSONObject(line);
                        int id = readLastId();
                        String products = json.getString("Product");
                        int quantity = json.getInt("Quantity");
                        float price = json.getFloat("Price");
                        product = new Product(products, quantity, price);
                        ticket.getProducts().add(product);
                        break;
                    }
                    line = br.readLine();
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ticket;
    }
    public static Product readProductObjectFromJson(String name) {
        File file = new File(productPath);
        Product product = null;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
              
                while (line != null) {
                    if (line.contains(name)) {
                        JSONObject json = new JSONObject(line);
                        int id = json.getInt("idProduct");
                        name = json.getString("name");
                        int stock = json.getInt("stock");
                        float price = json.getFloat("price");
                        String category = json.getString("category");
                        if (category.equals("TREE")) {
                            float height = json.getFloat("height");
                            product = new Tree(id, name, stock, price, Product.Category.TREE, height);
                        }
                        if (category.equals("FLOWER")) {
                            String colour = json.getString("colour");
                            product = new Flower(id, name, stock, price, Product.Category.FLOWER, colour);

                        }
                        if (category.equals("DECO")) {
                            String decoType = json.getString("decoType");
                            product = new Deco(id, name, stock, price, Product.Category.DECO, decoType);

                        }
                        break;
                    }
                    line = br.readLine();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return product;
    }

    public static void readAllProductsFromTxt() {

        ArrayList<Product> llistaProductesTxt = new ArrayList<>();

        File file = new File(productPath);

        Product product;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();

                while (line != null) {

                    JSONObject json = new JSONObject(line);

                    String name = json.getString("name");
                    int stock = json.getInt("stock");
                    float price = json.getFloat("price");
                    String category = json.getString("category");
                    if (category.equals("TREE")) {
                        float height = json.getFloat("height");
                        product = new Tree(name, stock, price, Product.Category.TREE, height);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("FLOWER")) {
                        String colour = json.getString("colour");
                        product = new Flower(name, stock, price, Product.Category.FLOWER, colour);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("DECO")) {
                        String decoType = json.getString("decoType");
                        product = new Deco(name, stock, price, Product.Category.DECO, decoType);
                        llistaProductesTxt.add(product);
                    }

                    line = br.readLine();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (Reader.checkStoreExist()) {
            if (llistaProductesTxt.size() != 0) {
                for (int i = 0; i < llistaProductesTxt.size(); i++) {
                    System.out.println(" Name: "
                            + llistaProductesTxt.get(i).getName() +
                            " Price: "
                            + llistaProductesTxt.get(i).getPrice() +
                            " Category: "
                            + llistaProductesTxt.get(i).getCategory());
                }
            } else {
                System.out.println("La botiga no disposa encara d´existències");
                System.out.println("");
            }
        } else {
            System.out.println("Primer crea la botiga");
        }

    }

    public static void readAllStockFromTxt() {

        ArrayList<Product> llistaProductesTxt = new ArrayList<>();

        File file = new File(productPath);

        Product product;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();

                while (line != null) {

                    JSONObject json = new JSONObject(line);

                    String name = json.getString("name");
                    int stock = json.getInt("stock");
                    float price = json.getFloat("price");
                    String category = json.getString("category");
                    if (category.equals("TREE")) {
                        float height = json.getFloat("height");
                        product = new Tree(name, stock, price, Product.Category.TREE, height);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("FLOWER")) {
                        String colour = json.getString("colour");
                        product = new Flower(name, stock, price, Product.Category.FLOWER, colour);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("DECO")) {
                        String decoType = json.getString("decoType");
                        product = new Deco(name, stock, price, Product.Category.DECO, decoType);
                        llistaProductesTxt.add(product);
                    }

                    line = br.readLine();
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (Reader.checkStoreExist()) {
                if (llistaProductesTxt.size() != 0) {
                    for (int i = 0; i < llistaProductesTxt.size(); i++) {
                        System.out.println(" Name: "
                                + llistaProductesTxt.get(i).getName() +
                                " Stock: "
                                + llistaProductesTxt.get(i).getStock());
                    }
                }
            } else {
                System.out.println("La botiga no disposa encara d´existències");
                System.out.println("");
            }
        } else {
            System.out.println("Primer crea la botiga");
        }
    }

    public static void totalPriceValuesFromTxt() {

        float totalValue = 0f;

        ArrayList<Product> llistaProductesTxt = new ArrayList<>();

        File file = new File(productPath);

        Product product;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();

                while (line != null) {

                    JSONObject json = new JSONObject(line);

                    String name = json.getString("name");
                    int stock = json.getInt("stock");
                    float price = json.getFloat("price");
                    String category = json.getString("category");
                    if (category.equals("TREE")) {
                        float height = json.getFloat("height");
                        product = new Tree(name, stock, price, Product.Category.TREE, height);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("FLOWER")) {
                        String colour = json.getString("colour");
                        product = new Flower(name, stock, price, Product.Category.FLOWER, colour);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("DECO")) {
                        String decoType = json.getString("decoType");
                        product = new Deco(name, stock, price, Product.Category.DECO, decoType);
                        llistaProductesTxt.add(product);
                    }

                    line = br.readLine();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (Reader.checkStoreExist()) {
            if (llistaProductesTxt.size() != 0) {
                for (int i = 0; i < llistaProductesTxt.size(); i++) {
                    totalValue += (llistaProductesTxt.get(i).getPrice() * llistaProductesTxt.get(i).getStock());
                }
                System.out.println("El valor total de las existencias es de " + totalValue + "€");
                System.out.println("");
            } else {
                System.out.println("La botiga no disposa encara d´existències");
                System.out.println("");
            }
        } else {
            System.out.println("Primer crea la botiga");
        }

    }

    public static JSONArray createJSONArrayFromTxt() {

        File file = new File(productPath);
        JSONObject jsonObject;
        JSONArray jsonList = new JSONArray();

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();

                while (line != null) {

                    jsonObject = new JSONObject(line);
                    jsonList.put(jsonObject);

                    line = br.readLine();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonList;
    }

    public static int readLastId() {

        JSONArray jsonList = createJSONArrayFromTxt();

        int lastId;
        int i;

        if (jsonList.length() != 0) {
            i = jsonList.length() - 1;
            JSONObject lastJsonObject = jsonList.getJSONObject(i);
            lastId = lastJsonObject.getInt("idProduct");
            System.out.println("Last idProduct is : " + lastId);
        } else {
            lastId = 0;
        }

        return lastId;
    }

    public static ArrayList<Product> getLlistaproductesTxt() {

        ArrayList<Product> llistaProductesTxt = new ArrayList<>();
        Product product;

        File file = new File(productPath);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();

                while (line != null) {

                    JSONObject json = new JSONObject(line);

                    String name = json.getString("name");
                    int stock = json.getInt("stock");
                    float price = json.getFloat("price");
                    String category = json.getString("category");
                    if (category.equals("TREE")) {
                        float height = json.getFloat("height");
                        product = new Tree(name, stock, price, Product.Category.TREE, height);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("FLOWER")) {
                        String colour = json.getString("colour");
                        product = new Flower(name, stock, price, Product.Category.FLOWER, colour);
                        llistaProductesTxt.add(product);
                    }
                    if (category.equals("DECO")) {
                        String decoType = json.getString("decoType");
                        product = new Deco(name, stock, price, Product.Category.DECO, decoType);
                        llistaProductesTxt.add(product);
                    }

                    line = br.readLine();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return llistaProductesTxt;
    }
    public static void writeJsonProductStock(JSONObject jsonObject) {
        File file = new File(productPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(jsonObject + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

        public static void updateStockJsonProduct(JSONObject jsonProduct) {
        File file = new File(productPath);
        File tempFile = new File("temp.json");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            jsonProduct.put("stock", jsonProduct.getInt("stock"));
            jsonProduct.put("idProduct", jsonProduct.getInt("idProduct")); //espero que coja el idProduct que tiene el producto, jsonProduct: "{"idProduct":x}"
            bw.write(jsonProduct + System.lineSeparator());

            String line;
            while ((line = br.readLine()) != null) {
                JSONObject jsonObject = new JSONObject(line);
                if (!(jsonObject.getInt("idProduct") == jsonProduct.getInt("idProduct"))) {
                    bw.write(line + System.lineSeparator());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Reemplazar el archivo original con el archivo temporal
        if (file.exists()) {
            file.delete();
        }
        tempFile.renameTo(file);
    }

}



