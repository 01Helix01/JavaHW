import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCP_Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Boolean debug = false;

        try {
            serverSocket = new ServerSocket(5001);

            // Gets the actual PC name
            InetAddress addr = InetAddress.getLocalHost();
            String serverName = addr.getHostName();
            System.out.println(serverName + " is listening...");

            Boolean accept = true;
            while (accept) {
                Socket clientSocket = serverSocket.accept();
                int clientSocketPort = clientSocket.getPort();

                // Establish DataStreams for IN (to server) and OUT (from server)
                DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

                // Get message from the user, parse the string
                String clientMessage = dataIn.readUTF();
                if(debug) System.out.println("Debug: The following message was recieved: " + clientMessage);
                String[] parts = clientMessage.split(", ");
                String clientName = parts[0];
                int clientNumber = Integer.parseInt(parts[1]);

                // If client number out of range terminate after releasing created sockets
                if (clientNumber < 0 || clientNumber > 100) {
                    System.out.println("Client number is out of range. Terminating connection...");
                    dataIn.close();
                    dataOut.close();
                    clientSocket.close();
                    accept = false;
                    break;
                }

                // Generate random number (0-100) and add to client number
                Random rand = new Random();
                int serverNumber = rand.nextInt(101);
                int sumNumber = clientNumber + serverNumber;

                // Receipt:
                System.out.println("[" + serverName + "] " + "connected to [" + clientName + "] with [Port: " + clientSocketPort + "]");
                System.out.println("Received [" + clientNumber + "] and generated [" + serverNumber + "] adding to [" + clientNumber + "] = [" + sumNumber + "]");

                // Reply with name string and server-chosen integer
                String serverMessage = serverName + ", " + serverNumber;
                dataOut.writeUTF(serverMessage);
                if(debug) System.out.println("Debug: Writing message to client");

                // Close streams and socket for this client
                if(debug) System.out.println("Debug: Closing socket for this socket");
                dataIn.close();
                dataOut.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            	// Ensure socket is closed
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
