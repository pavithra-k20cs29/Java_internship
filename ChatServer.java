package Java_Internship;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to a specific port
            ServerSocket serverSocket = new ServerSocket(1235);

            System.out.println("Chat server started. Listening on port 1234...");

            // Accept client connections
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());

            // Create input and output streams for communication with the client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // Start listening for client messages
            String clientMessage;
            while ((clientMessage = inFromClient.readLine()) != null) {
                System.out.println("Client: " + clientMessage);

                // Broadcast the message to all connected clients (you'll need to keep track of multiple clients in a list)
                // For simplicity, this example only supports one client at a time
                outToClient.println("Server: Received your message - " + clientMessage);
            }

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
