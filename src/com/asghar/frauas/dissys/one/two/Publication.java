package com.asghar.frauas.dissys.one.two;

public class Publication {
    private final String title;
    private final String language;
    private final float price;

    public Publication(String title, String language, float price) {
        this.title = title;
        this.language = language;
        this.price = price;
    }

    public void print() {
        System.out.println("Title : " + title);
        System.out.println("Language : " + language);
        System.out.println("Price : " + price + " $");
    }
}
