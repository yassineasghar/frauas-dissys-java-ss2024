package com.asghar.frauas.dissys.two.five;

public class Executable {
    public static void main(String[] arguments) {
        Display[] displays = new Display[3];
        displays[0] = new Publication("A Title", "English", 22.23f);
        displays[1] = new Book("C++", "English", 33.34f, "Some One", "234324234223");
        displays[2] = new Car("Black", 420, 2800);


        for(Display display : displays){
            display.print();
            System.out.println();

        }
    }
}


