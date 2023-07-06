import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.*;

import java.io.*;

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
    public static boolean checkProductExist(String name) {
        boolean found = false;
        File file = new File(productPath);

        if(file.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while(line != null) {
                    if(line.contains(name)) {
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

    @JsonPropertyOrder({"category", "name", "price", "stock"})
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

    public static Product readProductObjectFromJson(String name) {
        File file = new File(productPath);
        Product product = null;

        if(file.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while(line != null) {
                    if(line.contains(name)) {




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
