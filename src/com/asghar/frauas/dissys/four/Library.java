package com.asghar.frauas.dissys.four;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private String name;
    private Set<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new HashSet<>();
    }

    public Book searchForBookByTitle(String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(searchTitle)) {
                if (book.getState().equals("Available")) {
                    System.out.println("The book '" + book.getTitle() + "' is Available");
                    return book;
                } else {
                    System.out.println("The book '" + book.getTitle() + "' is currently lent out to " + book.getState());
                    return book;
                }
            }
        }
        System.out.println("The desired book '" + searchTitle + "' does not exist.");
        return null;
    }


    public void addBook(String title, String shelfMark, String state) {
        Book newBook = new Book(title, shelfMark, state);
        books.add(newBook);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }


}
