package week1;

import java.util.Scanner;

public class InputMethods {
    public static String getString() {
        Scanner inp = new Scanner(System.in);
        try {
            return inp.nextLine();
        } catch (Exception e){
            System.out.println("Invalid input! Try again.");
            return getString();
//        } finally {
//            inp.close();
        }
    }

    public static int getInt() {
        Scanner inp = new Scanner(System.in);
        try {
            return inp.nextInt();
        } catch (Exception e){
            System.out.println("Invalid input! Try again.");
            return getInt();
//        } finally {
//            inp.close();  // if close here when input is invalid, unable to return properly.
        }
    }

    public static float getFloat() {
        Scanner inp = new Scanner(System.in);
        try {
            return inp.nextFloat();
        } catch (Exception e){
            System.out.println("Invalid input! Try again.");
            return getFloat();
//        } finally {
//            inp.close();
        }
    }
}
