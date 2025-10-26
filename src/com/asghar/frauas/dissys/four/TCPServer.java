package com.asghar.frauas.dissys.four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class TCPServer {
    private static final int port = 7890;

    public static void main(String[] args) {
        Map<String, Library> libraries = getLibraries();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listening on port " + port + " for client connections");
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    new Connection(clientSocket, libraries);
                } catch (IOException err) {
                    System.out.println("Error: " + err.getMessage());
                    break;
                }
            }


        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    private static Map<String, Library> getLibraries() {
        Map<String, Library> libraries = new HashMap<>();
        libraries.put("lib1", new Library("lib1"));
        libraries.put("lib2", new Library("lib2"));
        libraries.put("lib3", new Library("lib3"));
        return libraries;
    }
}
