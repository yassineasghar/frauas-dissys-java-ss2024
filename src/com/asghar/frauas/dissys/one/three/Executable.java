package com.asghar.frauas.dissys.one.three;

import java.util.HashSet;
import java.util.Iterator;

public class Executable {

    public static void main(String[] arguments) {
        HashSet<String> wordsSet = wordsSet(arguments);
        if (!wordsSet.isEmpty()) {
            System.out.println("Unique words:");
            wordsIterator(wordsSet);
        } else {
            System.out.println("No arguments provided.");
        }
    }

    private static HashSet<String> wordsSet(String[] arguments) {
        HashSet<String> uniqueWords = new HashSet<>();
        for (String word : arguments) {
            uniqueWords.add(word);
        }
        return uniqueWords;
    }

    private static void wordsIterator(HashSet<String> wordsSet) {
        Iterator<String> iterator = wordsSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
