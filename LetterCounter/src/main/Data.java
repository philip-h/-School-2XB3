package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by philip on 06/04/15.
 */
public class Data {
    private static ArrayList<String> words;

    public static void readWords() {
        words = new ArrayList<>(); 
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("data.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext())
            words.add(input.next());
    }

    public static Iterable<String> getWords() {
        return words;
    }


}
