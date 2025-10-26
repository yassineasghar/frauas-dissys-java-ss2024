package com.asghar.frauas.dissys.five;

import java.rmi.Naming;


public class LibraryServer {

    public static void main(String[] args) {
        try {
            LibraryImp libraryOne = new LibraryImp("FRAUAS");
            LibraryImp libraryTwo = new LibraryImp("GOETHE");


            Naming.rebind("FRAUAS", libraryOne);
            Naming.rebind("GOETHE", libraryTwo);

            System.out.println("LibraryServer running ...");

        } catch (Exception e) {
            System.out.println("DateClient: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
