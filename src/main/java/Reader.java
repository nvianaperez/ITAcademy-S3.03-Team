import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public void ReadStoreFromTxt() throws IOException {

        FileReader r0 = new FileReader("r0.txt");
        BufferedReader ReadStoreFromTxt = new BufferedReader(r0);

        String linea = "";

        while(linea != null){
            if(linea != null){
                linea = ReadStoreFromTxt.readLine();
                System.out.println(linea);
            }
        }ReadStoreFromTxt.close();
        r0.close();
    }

    public void ReadProductFromTxt() throws IOException {

        FileReader r0 = new FileReader("r0.txt");
        BufferedReader ReadProductFromTxt = new BufferedReader(r0);

        String linea = "";

        while(linea != null){
            if(linea != null){
                linea = ReadProductFromTxt.readLine();
                System.out.println(linea);
            }
        }ReadProductFromTxt.close();
        r0.close();
    }

    public void ReadTicketFromTxt() throws IOException {

        FileReader r0 = new FileReader("r0.txt");
        BufferedReader ReadTicketFromTxt = new BufferedReader(r0);

        String linea = "";

        while(linea != null){
            if(linea != null){
                linea = ReadTicketFromTxt.readLine();
                System.out.println(linea);
            }
        }ReadTicketFromTxt.close();
        r0.close();
    }
}
