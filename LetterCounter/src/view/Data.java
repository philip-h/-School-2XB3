package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by philip on 06/04/15.
 */
public class Data {
    // This method reads the test input one from file and adds it to the Words1 arraylist
    public static String getStringRep1() 
    {
       String out = "";
        Scanner input = null;
        try {
        	// get the input from the scanner
            input = new Scanner(new FileReader("test1.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // convert the file input into a string
           out += (input.nextLine() + "\n");
        return out;
    }
    // returns 
    public static String getStringRep2() 
    {
        String out = "";
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("test2.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // add the lines of the file into a string
        while (input.hasNext())
            out += (input.nextLine() + "\n");
        return out;
    }
}
