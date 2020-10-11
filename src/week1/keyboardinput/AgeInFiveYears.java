package week1.keyboardinput;

import static week1.InputMethods.*;

public class AgeInFiveYears {
    public static void main(String[] args) {
        System.out.print("Hello.  What is your name? ");
        String name =  getString();

        System.out.print("\nHi, " + name + "!  How old are you? ");
        int age = getInt();

        System.out.println("\nDid you know that in five years you will be " + (age + 5) + " years old?");
        System.out.println("And five years ago you were " + (age - 5) + "! Imagine that!");
    }
}
