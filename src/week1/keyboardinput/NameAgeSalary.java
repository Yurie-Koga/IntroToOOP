package week1.keyboardinput;

import static week1.InputMethods.*;

public class NameAgeSalary {
    public static void main(String[] args) {
        System.out.println("Hello.  What is your name?");
        String name = getString();

        System.out.println("\nHi, " + name + "!  How old are you?");
        int age = getInt();

        System.out.println("\nSo you're " + age + ", eh?  That's not old at all!");
        System.out.println("How much do you make, " + name + "?");
        float salary = getFloat();

        System.out.println("\n" + salary + "!  I hope that's per hour and not per year! LOL!");
    }
}
