package com.asghar.frauas.dissys.one.one;

public class Executable {

    public static void main(String[] arguments) {
        int Number = 5;
        System.out.println("Using for loop  : " + usingForLoop(Number));
        System.out.println("Using recursion  : " + usingRecursion(Number));
    }

    private static int usingForLoop(int Number) {
        validateInput(Number);
        int resutl = 1;
        for (int i = 1; i <= Number; i++) {
            resutl *= i;
        }
        return resutl;
    }

    private static int usingRecursion(int Number) {
        validateInput(Number);
        if (Number == 1 || Number == 0) {
            return 1;
        } else {
            return Number * usingRecursion(Number - 1);
        }
    }

    private static void validateInput(int Number) {
        if (Number < 0) {
            throw new IllegalArgumentException("Enter a positive Integer not " + Number);
        }
    }
}

