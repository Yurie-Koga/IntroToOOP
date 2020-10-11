package week1.ifstatements;

import static week1.InputMethods.*;

public class HowOldAreYouSpecifically {
    public static void main(String[] args) {
        System.out.print("Hey, what's your name? (Sorry, I keep forgetting.) ");
        String name = getString();

        System.out.print("Ok, " + name + ", how old are you? ");
        int age = getInt();

        String out;
        if (age < 16) {
            out = "You can't drive";
        } else if (16 <= age && age <= 17) {
            out = "You can drive but not vote";
        } else if (18 <= age && age <= 24) {
            out = "You can vote but not rent a car";
        } else {
            out = "You can do pretty much anything";
        }

        System.out.println(out + ", " + name + ".");
    }
}
