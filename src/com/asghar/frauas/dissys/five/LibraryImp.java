package com.asghar.frauas.dissys.five;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class LibraryImp extends UnicastRemoteObject implements Library {
    private final String name;
    private final Set<Book> books;

    public LibraryImp(String name) throws RemoteException {
        this.name = name;
        this.books = new HashSet<Book>();
    }

    @Override
    public Book searchForBookByTitle(String searchTitle) throws RemoteException {
        for (Book book : books) {
            if (book.getTitle().equals(searchTitle)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void addBook(String title, String shelfMark, String state) throws RemoteException {
        Book newBook = new BookImp(title, shelfMark, state);
        books.add(newBook);
    }

    @Override
    public Set<Book> getBooks() throws RemoteException {
        return books;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
}
