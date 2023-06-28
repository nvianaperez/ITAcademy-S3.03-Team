import java.io.*;

public class Writer {

      //Store s0 = Store.getInstance();  Hay que crear un metodo para checkear que existe store.
    public void WriteStoreToTxt() throws IOException {

        FileWriter w0 = new FileWriter("path");
        BufferedWriter writeStoreToTxt = new BufferedWriter(w0);

        writeStoreToTxt.write(s0.toString());

        writeStoreToTxt.close();
        w0.close();
    }
        public void WriteProductToTxt() throws IOException {

            FileWriter w0 = new FileWriter("path");
            BufferedWriter WriteProductToTxt = new BufferedWriter(w0);

            s0.getProducts().stream().forEach(product -> {
                try {
                    WriteProductToTxt.write(product.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            WriteProductToTxt.close();
            w0.close();
        }

    public void WriteTicketToTxt() throws IOException {

        FileWriter w0 = new FileWriter("path");
        BufferedWriter WriteTicketToTxt = new BufferedWriter(w0);

        s0.getTickets().stream().forEach(ticket -> {
            try {
                WriteTicketToTxt.write(ticket.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        WriteTicketToTxt.close();
        w0.close();
    }
    }



