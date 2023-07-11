//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.json.*;
//
//import java.io.*;
//import java.util.ArrayList;
//
////ToDo: no funciona el JsonPropertyOrder
//@JsonPropertyOrder({"category", "name", "price", "stock"})
//public class Writer {
//    private static final String productPath = "productPath.txt";
//    private static final String ticketPath = "ticketPath.txt";
//    private static final String storePath = "storePath.txt";
//
//
//    public static boolean checkStoreExist() {
//        boolean found = false;
//        File file = new File(storePath);
//
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            if (file.exists() && br.readLine() != null) {
//                br.readLine();
//                found = true;
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return found;
//    }
//
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
//
//    }
//
//    public static void writeStoreObjectToJson(Store s0) {
//        JSONObject s0Json = new JSONObject();
//        s0Json.put("name", s0.getName());
//        File file = new File(storePath);
//        if (file.exists()) {
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
//                bw.write(s0Json.toString());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public static void writeJsonProduct(JSONObject newJsonProduct) {
//        File file = new File(productPath);
//
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        if (file.exists()) {
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
//                bw.write(newJsonProduct + "\n");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public static Product readProductObjectFromJson(String idS, String name) {
//        File file = new File(productPath);
//        Product product = null;
//
//        if (file.exists()) {
//            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//                String line = br.readLine();
//
//                while (line != null) {
//
//                    if (line.contains(name) && line.contains(idS)) {
//
//                        JSONObject json = new JSONObject(line);
//                        name = json.getString("name");
//                        int stock = json.getInt("stock");
//                        float price = json.getFloat("price");
//                        String category = json.getString("category");
//                        if (category.equals("TREE")) {
//                            float height = json.getFloat("height");
//                            product = new Tree(name, stock, price, Product.Category.TREE, height);
//                        }
//                        if (category.equals("FLOWER")) {
//                            String colour = json.getString("colour");
//                            product = new Flower(name, stock, price, Product.Category.FLOWER, colour);
//
//                        }
//                        if (category.equals("DECO")) {
//                            String decoType = json.getString("decoType");
//                            product = new Deco(name, stock, price, Product.Category.DECO, decoType);
//
//                        }
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
//        return product;
//    }
//
//    public static void readAllProductsFromTxt() {
//
//        ArrayList<Product>llistaProductesTxt = new ArrayList<>();
//
//        File file = new File(productPath);
//
//        Product product;
//
//        if (file.exists()) {
//            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//                String line = br.readLine();
//
//                while (line != null) {
//
//                    JSONObject json = new JSONObject(line);
//
//                    String name = json.getString("name");
//                    int stock = json.getInt("stock");
//                    float price = json.getFloat("price");
//                    String category = json.getString("category");
//                    if (category.equals("TREE")) {
//                        float height = json.getFloat("height");
//                        product = new Tree(name, stock, price, Product.Category.TREE, height);
//                        llistaProductesTxt.add(product);
//                    }
//                    if (category.equals("FLOWER")) {
//                        String colour = json.getString("colour");
//                        product = new Flower(name, stock, price, Product.Category.FLOWER, colour);
//                        llistaProductesTxt.add(product);
//                    }
//                    if (category.equals("DECO")) {
//                        String decoType = json.getString("decoType");
//                        product = new Deco(name, stock, price, Product.Category.DECO, decoType);
//                        llistaProductesTxt.add(product);
//                    }
//
//                    line = br.readLine();
//                }
//
//
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        if (Reader.checkStoreExist()) {
//            if(llistaProductesTxt.size() != 0){
//                llistaProductesTxt.stream().forEach(System.out::println);
//            }else{
//                System.out.println("La botiga no disposa encara d´existències");
//                System.out.println("");
//            }
//        }else {
//            System.out.println("Primer crea la botiga");
//        }
//
//    }
//
//    public static JSONArray createJSONArrayFromTxt() {
//
//        File file = new File(productPath);
//        JSONObject jsonObject;
//        JSONArray jsonList = new JSONArray();
//
//        if (file.exists()) {
//            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//                String line = br.readLine();
//
//                while (line != null) {
//
//                    jsonObject = new JSONObject(line);
//                    jsonList.put(jsonObject);
//
//                    line = br.readLine();
//                }
//
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return jsonList;
//    }
//
//    public static int readLastId() {
//
//        int lastId;
//        int i;
//        JSONArray jsonList = createJSONArrayFromTxt();
//
//        if (jsonList.length() != 0) {
//            i = jsonList.length() - 1;
//            JSONObject lastJsonObject = jsonList.getJSONObject(i);
//            lastId = lastJsonObject.getInt("idProduct");
//            System.out.println("Last idProduct is : " + lastId);
//        } else {
//            lastId = 0;
//        }
//
//        return lastId;
//    }
//
//}


