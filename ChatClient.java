package Java_Internship;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 1235);

            System.out.println("Connected to server: " + clientSocket.getInetAddress().getHostName());

            // Create input and output streams for communication with the server
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Start listening for server messages
            String serverMessage;
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                // Read user input
                String message = userInput.readLine();

                // Send the message to the server
                outToServer.println(message);

                // Wait for server response
                serverMessage = inFromServer.readLine();
                System.out.println("Server: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}