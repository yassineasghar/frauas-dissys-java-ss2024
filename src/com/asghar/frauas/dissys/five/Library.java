package com.asghar.frauas.dissys.five;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface Library extends Remote {
    Book searchForBookByTitle(String searchTitle) throws RemoteException;

    void addBook(String title, String shelfMark, String state) throws RemoteException;

    Set<Book> getBooks() throws RemoteException;

    String getName() throws RemoteException;
}
