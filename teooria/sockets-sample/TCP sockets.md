Socket s = connect();
InputStream in = s.getInputStream();
OutputStream out = s.getOutputStream();
// send and receive data from the connected program



# Socket
client side, creates a connection with the server

Client workflow:
- Socket(host, port) > Input/Outputstream

## Using a socket



# ServerSocket
Server side, listens for incoming connections

Server workflow:
- Serversocket > accept() > Socket > Input/OutputStream

## using a serversocket
public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server listening...");

        Socket client = server.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(client.getInputStream())
        );

        String message = in.readLine();
        System.out.println("Received: " + message);

        client.close();
        server.close();
    }
}