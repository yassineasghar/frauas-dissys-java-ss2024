package com.asghar.frauas.dissys.six.base;

public class Book {
    private final String title;
    private final String shelfMark;
    private String state;

    public Book(String title, String shelfMark, String state) {
        this.title = title;
        this.shelfMark = shelfMark;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public String getShelfMark() {
        return shelfMark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
