import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        // create a connection with the server at port 8080
        // this connection is shared with Server's "client" socket
        System.out.println("connecting to server");
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected");

        // send data through the socket
        System.out.println("Sending data");
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        int tosend = 123456789;
        out.writeInt(tosend);
        System.out.printf("Sent: %s\n", tosend);

        // end program
        socket.close();
        System.out.println("Connection closed");
    }
}
