import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        // loob serveri, mis kuulab porti 8080
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Now listening on: 8080");

        // ootab kliendi ühendust (blokeeriv)
        Socket client = server.accept();
        System.out.println("Client connected");

        // read incoming traffic
        DataInputStream in = new DataInputStream(client.getInputStream());
        int received = in.readInt();
        System.out.printf("Received: %s\n", received);

        // end program
        server.close();
        client.close();
        System.out.println("Connection closed");
    }
}


