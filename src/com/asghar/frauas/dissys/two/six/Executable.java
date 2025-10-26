package com.asghar.frauas.dissys.two.six;

public class Executable {
    public static void main(String[] arguments) {
        Display[] displays = new Display[4];

        displays[0] = new Publication("A Title", "English", 22.23f);
        displays[1] = new Book("C++", "English", 33.34f, "Some One", "234324234223");
        displays[2] = new Car("Black", 420, 2800);
        displays[3] = new Car("Red", 220, 4800);


        String filePath = "src/frauas/asghar/sheet/two/exercise/six/output/test2.ser";
        Serialization serialization = new Serialization(filePath);
        
        serialization.serialize(displays);

        Display[] objects = serialization.deserialize();
        if (objects != null) {
            for (Display object : objects) {
                object.print();
                System.out.println();
            }
        }
    }
}


