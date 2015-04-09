package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by philip on 06/04/15.
 */
public class Data {
    private static ArrayList<String> words1;
    private static ArrayList<String> words2;
    // This method reads the test input one from file and adds it to the Words1 arraylist
    public static void readTest1() {
        words1 = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("test1.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext())
            words1.add(input.next());
    }

    public static void readTest2() {
        words2 = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("test2.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext())
            words2.add(input.next());
    }

    public static String getStringRep1() {
       String out = "";
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("test1.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext())
           out += (input.nextLine() + "\n");
        return out;
    }

    public static String getStringRep2() {
        String out = "";
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("test2.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext())
            out += (input.nextLine() + "\n");
        return out;
    }

    public static Iterable<String> getTest1() {
        return words1;
    }

    public static Iterable<String> getTest2() {
        return words2;
    }


}
