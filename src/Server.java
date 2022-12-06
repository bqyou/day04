import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int PORT = 12345;

        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket sc = server.accept();

            DataInputStream dis = new DataInputStream(new BufferedInputStream(sc.getInputStream()));

            String line = "";
            while (line != null) {
                try {
                    line = dis.readUTF();
                    System.out.println("Got: --> " + line);
                } catch (EOFException e) {
                    System.out.println("End of file reached");
                    break;
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("IO ERROR");
        }

    }
}