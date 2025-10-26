package com.asghar.frauas.dissys.four;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class TCPClient {
    private static final String host = "localhost";
    private static final int port = 7890;

    public static void main(String[] args) {
        if (args.length < 5) {
            System.err.println("Usage: library, method, title, shelf mark, state");
        }

        String libraryName = args[0];
        String methodName = args[1];
        String bookName = args[2];
        String bookShelfMark = args[3];
        String bookState = args[4];
        String[] bookParams = {bookName, bookShelfMark, bookState};

        try (Socket socket = new Socket(host, port)) {
            Message message = new Message(libraryName, methodName, bookParams);
            writeRequest(message, socket);
            String serverResponse = readResponse(socket);
            System.out.println(serverResponse);
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    private static void writeRequest(Message message, Socket socket) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(message);
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }

    }

    private static String readResponse(Socket socket) {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return "Server Response : " + ois.readObject();
        } catch (IOException | ClassNotFoundException err) {
            System.out.println("Error: " + err.getMessage());
        }
        return "Failed to Read Object";
    }
}
