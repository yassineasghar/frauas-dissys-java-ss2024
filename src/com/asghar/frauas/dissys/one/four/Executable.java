package com.asghar.frauas.dissys.one.four;

import java.util.Scanner;

public class Executable {
    public static void main(String[] arguments) {
        int counter = 0;
        Scanner userInput = new Scanner(System.in);

        while (true) {
            String line = userInput.nextLine();
            if (line.equals("Quit")) {
                break;
            }
            NumThread numThread = new NumThread(counter++);
            numThread.start();
        }
        userInput.close();

    }
}
