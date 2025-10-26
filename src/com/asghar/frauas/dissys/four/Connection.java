package com.asghar.frauas.dissys.four;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class Connection extends Thread {
    ObjectOutputStream out;
    ObjectInputStream in;
    Socket clientSocket;
    Map<String, Library> libraries;

    public Connection(Socket aClientSocket, Map<String, Library> someLibs) throws IOException {
        libraries = someLibs;
        clientSocket = aClientSocket;
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
        this.start();
    }


    public void run() {
        try {
            Message message = (Message) in.readObject();
            String libraryName = message.getLibraryName();
            String methodName = message.getMethodName();
            Library library = libraries.get(libraryName);

            String resultHandler = "";
            switch (methodName) {
                case "add" -> resultHandler = addNewBook(message, library);
                case "all" -> resultHandler = getAllBooks(library);
                default -> resultHandler = "Unknown Method Name";
            }
            out.writeObject(resultHandler);
            out.close();
            in.close();
            /*
            if (message.getMethodName().equals("add")) {
                String[] params = message.getParameters();
                System.out.println("CLIENT requested to add a new Book " + params[0]);
                library.addBook(
                        params[0],
                        params[1],
                        params[2]
                );
                resultHandler = "Book added";
                resultHandler = addNewBook(message, library);
            } else if (message.getMethodName().equals("getAll")) {
                System.out.println("CLIENT requested getAll");
                StringBuilder sb = new StringBuilder("All Books : ");
                for (Book book : library.getBooks()) {
                    sb.append(book.getTitle()).append(" , ");
                }
                resultHandler = sb.toString();
                resultHandler = getAllBooks(library);
            } else {
                resultHandler = "Unknown Method Name";
            }
            out.writeObject(resultHandler);
            out.close();
            in.close();
             */
        } catch (IOException | ClassNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    private static String addNewBook(Message message, Library library) {
        String[] parameters = message.getParameters();
        System.out.println("CLIENT requested to add a new Book " + parameters[0]);
        library.addBook(parameters[0], parameters[1], parameters[2]);
        return "Book Named " + parameters[0] + " added to Library " + library.getName();
    }

    private static String getAllBooks(Library library) {
        System.out.println("CLIENT requested to get all Book Titles from the Library " + library.getName());
        StringBuilder sb = new StringBuilder("All Books : ");
        for (Book book : library.getBooks()) {
            sb.append(book.getTitle()).append(" , ");
        }
        return sb.toString();
    }
}