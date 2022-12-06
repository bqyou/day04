import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {

        try {
            Socket sc = new Socket("localhost", 12345);

            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());

            FileReader fr = new FileReader("src/Cookies.txt");

            BufferedReader br = new BufferedReader(fr);

            String line;

            while (null != (line = br.readLine())) {
                dos.writeUTF(line);
                dos.flush();
            }

            // dos.writeUTF("EOF");
            // dos.flush();
            br.close();
            sc.close();
        } catch (UnknownHostException e) {
            System.out.println("Unable to find host");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

}
