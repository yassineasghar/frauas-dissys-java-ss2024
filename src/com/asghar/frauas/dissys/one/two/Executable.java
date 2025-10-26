package com.asghar.frauas.dissys.one.two;

public class Executable {
    public static void main(String[] arguments) {
        Publication[] publications = new Publication[3];
        publications[0] = new Publication("Java and Coffee, Story", "English", 99.98f);
        publications[1] = new Publication("Snake Programming Language", "English", 40.89f);
        publications[2] = new Book("C++ is Abysmal", "English", 234.45f, "Some One", "234-324732432");

        for (Publication publication : publications) {
            publication.print();
            System.out.println();
        }
    }
}


