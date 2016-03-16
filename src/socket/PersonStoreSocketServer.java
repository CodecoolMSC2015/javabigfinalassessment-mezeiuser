package socket;

import servlet.SearchServlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Péter on 2016. 03. 16..
 */
public class PersonStoreSocketServer {
    static FileOutputStream fos;
    static ObjectOutputStream oos;

    public void runServer() {
        System.out.println("[SERVER][INFO] - Starting server.\n");
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            System.out.println("[SERVER][INFO] - Client connected");

            ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
            while (true) if (fromClient.read() > -1) {
                Object objectFromClient = fromClient.readObject();
                if (objectFromClient.equals("test")) {  //test criteria, i would like change later to DataReader
                    send(toClient, "Search found.");
                } else {
                    System.out.println("Not found search criteria.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        PersonStoreSocketServer server = new PersonStoreSocketServer();
        server.runServer();
    }

    public static void send(ObjectOutputStream x, Object object) throws IOException {
        x.write(0);
        x.writeObject(object);
    }
}
