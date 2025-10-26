package com.asghar.frauas.dissys.two.five;

public class Book extends Publication {
    private final String author;
    private final String ISBN;

    public Book(String title, String language, float price, String author, String ISBN) {
        super(title, language, price);
        this.author = author;
        this.ISBN = ISBN;
    }

    public void print() {
        super.print();
        System.out.println("Author : " + author);
        System.out.println("ISBN : " + ISBN);
    }
}
