package oop.userinteraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    /////////////////////////////////////////////////////////////////////////////////
    // Handling Exceptions
    // 1. throw new Exception to parent function
    //      public static void main(String[] args) throws FileNotFoundException {
    // 2. handle exception using try-catch
    //      try {
    //            Scanner in = new Scanner(file);
    //        }catch (FileNotFoundException e)
    //        {
    //            System.err.println(e.getLocalizedMessage());
    //        }
    // 3. throw new Exceptions to parent function in try-catch and handle it in parent function
    //      try {
    //            Scanner in = new Scanner(file);
    //        }catch (FileNotFoundException e)
    //        {
    //            throw e;
    //        }
    /////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Invalid number of arguments");
        }else{
            // File file = new File("vancouver.txt");
            String filename = args[0] + ".txt"; // added 'Program Argument' in config^^
            int counter = 0;
            try {
                File file = new File(filename);
                Scanner in = new Scanner(file);
                while (in.hasNextLine()){
                    String line = in.nextLine();
                    String[] words = line.split(" ");
                    counter += words.length;
                }
                System.out.println(filename + " has " + counter + " words.");
            }catch (FileNotFoundException e)
            {

                System.err.println(e.getLocalizedMessage());
            }
        }
    }
}
