package com.asghar.frauas.dissys.five;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Objects;
import java.util.Set;

public class LibraryClient {
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Insufficient arguments provided.");
                printUsage();
                return;
            }


            String libraryName = args[0];
            String operation = args[1].toUpperCase();
            Library library;

            if (Objects.equals(libraryName, "FRAUAS")) {
                library = (Library) Naming.lookup("rmi://localhost/FRAUAS");

            } else if (Objects.equals(libraryName, "GOETHE")) {
                library = (Library) Naming.lookup("rmi://localhost/GOETHE");

            } else {
                System.out.println("Unknown library name: " + libraryName);
                printUsage();
                return;
            }

            switch (operation) {
                case "ADD_NEW_BOOK":
                    if (args.length < 5) {
                        System.out.println("Insufficient arguments for ADD_NEW_BOOK operation.");
                        printUsage();
                        return;
                    }
                    addNewBook(library, args[2], args[3], args[4]);
                    break;

                case "SEARCH_FOR_BOOK":
                    if (args.length < 3) {
                        System.out.println("Insufficient arguments for SEARCH_FOR_BOOK operation.");
                        printUsage();
                        return;
                    }
                    searchBook(library, args[2]);
                    break;

                case "GET_ALL_BOOKS":
                    getLibraryBooks(library);
                    break;

                case "GET_BOOKS_COUNT":
                    calculateBooksCount(library);
                    break;

                case "CHANGE_BOOK_STATE":
                    if (args.length < 4) {
                        System.out.println("Insufficient arguments for CHANGE_BOOK_STATE operation.");
                        printUsage();
                        return;
                    }
                    changeBookState(library, args[2], args[3]);
                    break;

                default:
                    System.out.println("Unknown operation: " + operation);
                    printUsage();
            }
        } catch (RemoteException re) {
            System.out.println("LibraryClient - RemoteException: " + re.getMessage());
        } catch (MalformedURLException mfe) {
            System.out.println("LibraryClient - MalformedURLException: " + mfe.getMessage());
        } catch (NotBoundException nbe) {
            System.out.println("LibraryClient - NotBoundException: " + nbe.getMessage());
        }
    }

    private static void addNewBook(Library library, String title, String shelfMark, String state) throws RemoteException {
        System.out.println("Adding new book -> " + title + " in -> " + library.getName());
        library.addBook(title, shelfMark, state);
    }

    private static void searchBook(Library library, String title) throws RemoteException {
        Book book = library.searchForBookByTitle(title);
        if (book != null) {
            System.out.println("Book found: Title: " + book.getTitle() + ", Shelf Mark: " + book.getShelfMark() + ", State: " + book.getState());
        } else {
            System.out.println("The desired book '" + title + "' does not exist.");
        }
    }

    private static void getLibraryBooks(Library library) throws RemoteException {
        Set<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("No Books in Library");
            return;
        }
        System.out.println("All Books in Library " + library.getName() + " are:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Shelf Mark: " + book.getShelfMark() + ", State: " + book.getState());
        }
    }

    private static void changeBookState(Library library, String title, String newState) throws RemoteException {
        Book book = library.searchForBookByTitle(title);
        if (book != null) {
            System.out.println("Changing Book state from  " + book.getState() + " to " + newState);
            book.setState(newState);
        }
    }

    private static void calculateBooksCount(Library library) throws RemoteException {
        int totalBooks = 0;
        for (Book book : library.getBooks()) {
            if (book.getState().equals("Available")) {
                totalBooks++;
            }
        }
        System.out.println("Total Available Books in " + library.getName() + " is : " + totalBooks);
    }

    private static void printUsage() {
        System.out.println("Usage: <library name> <operation> <title> <shelfMark> <state>");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Libraries available : FRAUAS, GOETHE");
        System.out.println("Operations available are : ADD, SEARCH, GET_ALL, COUNT");
        System.out.println("> ADD_NEW_BOOK      : title, shelf Mark, state are required");
        System.out.println("> SEARCH_FOR_BOOK   : title is required");
        System.out.println("> GET_ALL_BOOKS     : nothing is required");
        System.out.println("> CHANGE_BOOK_STATE : title and book new state are required");
        System.out.println("> GET_BOOKS_COUNT   : nothing is required");

    }
}
