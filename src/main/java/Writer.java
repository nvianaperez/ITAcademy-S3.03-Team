import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.*;

import java.io.*;
import java.util.List;
//ToDo: no funciona el JsonPropertyOrder
@JsonPropertyOrder({"category", "name", "price", "stock"})
public class Writer {
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
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            if(file.exists() && br.readLine()!=null) {
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
    public static boolean checkProductExist(String idS,String name) {// Chequeo del Id a falta del getId del Json
        boolean found = false;
        File file = new File(productPath);

        if(file.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while(line != null) {
                    if(line.contains(idS) && line.contains(name)) {// Chequeo del Id a falta del getId del Json
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
        if(file.exists()) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(s0Json.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writeJsonProduct(JSONObject newJsonProduct) {
        File file = new File(productPath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(file.exists()) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(newJsonProduct+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Product readProductObjectFromJson(String idS,String name) {
        File file = new File(productPath);
        Product product = null;

        if(file.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while(line != null) {
                    if(line.contains(name) && line.contains(idS)) {
                        JSONObject json = new JSONObject(line);
                        name = json.getString("name");
                        int stock = json.getInt("stock");
                        float price = json.getFloat("price");
                        String category = json.getString("category");
                        if(category.equals("TREE")) {
                            float height = json.getFloat("height");
                            product = new Tree(name,stock, price, Product.Category.TREE, height);
                        }
                        if(category.equals("FLOWER")) {
                            String colour = json.getString("colour");
                            product = new Flower(name,stock,price, Product.Category.FLOWER, colour);

                        }
                        if(category.equals("DECO")) {
                            String decoType = json.getString("decoType");
                            product = new Deco(name, stock, price, Product.Category.DECO, decoType);

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

}
