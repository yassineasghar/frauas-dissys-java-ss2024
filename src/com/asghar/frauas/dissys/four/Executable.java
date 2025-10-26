package com.asghar.frauas.dissys.four;

public class Executable {
    public static void main(String[] args) {

        Library fraUasLib = new Library("FRA-UAS Library");

        fraUasLib.addBook("Introduction in C++", "FB2-CS", "Available");
        fraUasLib.addBook("Distributed Systems", "FB2-EIT", "Yassine Asghar");
        fraUasLib.addBook("Oracle Siebel", "FB2-CS", "Available");
        fraUasLib.addBook("FDD", "FB2-EIT", "Steven Alberts");
        fraUasLib.addBook("OCM to OCI", "FB2-MB", "Thomas Müller");

        int totalBooks = 0;
        for (Book book : fraUasLib.getBooks()) {
            if (book.getState().equals("Available")) {
                totalBooks++;
            }
        }
        System.out.println("Total Available Books in " + fraUasLib.getName() + " is : " + totalBooks);

        Book book1 = fraUasLib.searchForBookByTitle("OCM to OCI");
        Book book2 = fraUasLib.searchForBookByTitle("Introduction in C++");
    }
}
