package basics;

import java.util.Scanner;

public class IOExample {
    public static void main(String[] args) {
        // scanner object
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String input =  in.nextLine();
        System.out.println("your input is: " + input);

        // Write a program to say "I love you" in each language
        // "en" - English
        // "pt-br" - Portuguese (Brazil)
        // "es" - Spanish
        // "jp" - Japanese
        // "kr" - Korean
        while (true) {
            System.out.print("Enter the language code: ");
            String code =  in.nextLine();
            switch (code.toLowerCase()) {
                case "en":
                    System.out.println("I Love You");
                    break;
                case "pt-br":
                    System.out.println("Eu Amo Voce");  // Eu=I, Voce=You
                    break;
                case "es":
                    System.out.println("Te Amo");   // Amo is Love
                    break;
                case "jp":
                    System.out.println("Aishiteru");
                    break;
                case "kr":
                    System.out.println("Saranghae");
                    break;
                case "q":
//                    break;
                    System.exit(0); // terminate the program without errors
                default:
                    System.out.println("Not supported");
                    break;
            }
        }

    }
}
