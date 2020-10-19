package miniproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static week1.InputMethods.getChar;

public class Driver {
    public static void main(String[] args) {
        ///////////////////////////////////////////////////
        // String: immutable.
        // StringBuilder: mutable, w/o thread-safety, faster than StringBuffer
        // StringBuffer: mutable, thread-safety
        ///////////////////////////////////////////////////
//        StringBuilder sb = new StringBuilder(10);
//        System.out.printf("length: %d, capacity: %d%n", sb.length(), sb.capacity());
//        sb.replace(0, 10, "A");
//        System.out.println(sb.toString());
//
//        char[] c = new char[10];
//        Arrays.fill(c, '_');
//        StringBuilder sb1 = new StringBuilder(String.valueOf(c));
//        System.out.println("Array fill: " + sb1);

//        System.out.println(initializeSB('_', 5));

//        setLinesToArrLoop();

        setLinesToArrIndexOf();
    }

    public static StringBuilder initializeSB(char fillChar, int len) {
        char[] c = new char[len];
        Arrays.fill(c, fillChar);
        return new StringBuilder(String.valueOf(c));
    }

    private static void setLinesToArrLoop() {
        try {
            List<String> cities = Files.readAllLines(Paths.get("cites.txt"));
//            System.out.println(cities.get(0));
//            System.out.println("cities count: " + cities.size());
//            System.out.println("last word: " + cities.get(cities.size()-1));

//            for (String c : cities) {
//                System.out.println(c);
//            }
            int r = new Random().nextInt(cities.size()-1);
//            String city = String.valueOf(cities.get(r-1)).toLowerCase();
            String city = cities.get(r-1);
            System.out.println(String.format("index: %d, word: %s, len: %d", r, city, city.length()));
            String unRevealed = "";
            for (int i = 0; i < city.length(); i++) {
                unRevealed += "_";
            }

            System.out.println("Here's the question.");
            System.out.println("start: " + unRevealed);

            List<Character> inputLog = new ArrayList<Character>();
            List<Character> worngLog = new ArrayList<Character>();
            String revealed = "";

            boolean isReveal = false;
            // read user input
            while (true) {
                System.out.print("Guess a letter: ");
                ///////////////////////////////////////////////////////////////
                // better to create a input method and input validation method
                // 1. in the input method:
                //  - simply just return the value which the use input
                // 2. in the input validation:
                //  - check the input using regex, and return boolean
                // 3. after validation:
                //  - if true: go to the character revealing
                //  - if false: take a step for wrong answer > add to list, show message > go back to the input step
                char inpChar = Character.toLowerCase(getChar()); // <- returns only one char
                System.out.println("input: " + inpChar);
                // only alphabet is valid
                if (!Pattern.compile("[a-z]{1}", Pattern.CASE_INSENSITIVE).matcher(String.valueOf(inpChar)).find()) {
                    System.out.println("Invalid!!!");
                }
                ///////////////////////////////////////////////////////////////
                if (inputLog.contains(inpChar))
                    System.out.println("Already you entered. Please choose else!");
                else
                    inputLog.add(inpChar);

                for (int i = 0; i < city.length(); i++) {
                    if (Character.toLowerCase(city.charAt(i)) == inpChar) {
                        revealed += inpChar;
                        isReveal = true;
                    }
                    else if (unRevealed.charAt(i) != '_')
                        revealed += unRevealed.charAt(i);
                    else {
                        revealed += "_";
                    }
                }

                if (!isReveal)
                    worngLog.add(inpChar);
//                System.out.println("revealed: " + revealed + ", city: " + city);
                System.out.println(String.format("You are guessing: %s", revealed));
//                System.out.println(inputLog);
                System.out.println(String.format("You have guessed (%d) wrong letters: %s", worngLog.size(), worngLog.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" "))));
                if (revealed.equals(city.toLowerCase())) {
                    if (worngLog.size() <= 10) {
                        System.out.println(">>>>> Congrats You Won! <<<<<");
                        System.out.println(String.format("You have guessed '%s' correctly", city));
                    }
                    else {
                        System.out.println("===== Sorry You Lose! =====");
                        System.out.println(String.format("You have guessed (%d) wrong letters: %s", worngLog.size(), worngLog.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" "))));
                        System.out.println(String.format("The correct word was '%s'", city));
                    }
                    break;
                }
                unRevealed = revealed;
                revealed = "";
                isReveal = false;
            }


        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static void setLinesToArrIndexOf() {
        try {
            List<String> cities = Files.readAllLines(Paths.get("cites.txt"));
//            System.out.println(cities.get(0));
//            System.out.println("cities count: " + cities.size());
//            System.out.println("last word: " + cities.get(cities.size()-1));

//            for (String c : cities) {
//                System.out.println(c);
//            }
            int r = new Random().nextInt(cities.size()-1);
            String city = cities.get(r-1);
            System.out.printf("index: %d, word: %s, len: %d%n", r, city, city.length());
            StringBuilder unRevealed = initializeSB('_', city.length());



            System.out.println("Here's the question.");
            System.out.println("start: " + unRevealed);

            List<Character> inputLog = new ArrayList<Character>();
            List<Character> worngLog = new ArrayList<Character>();

            boolean isReveal = false;
            // read user input
            while (true) {
                System.out.print("Guess a letter: ");
                ///////////////////////////////////////////////////////////////
                // better to create a input method and input validation method
                // 1. in the input method:
                //  - simply just return the value which the use input
                // 2. in the input validation:
                //  - check the input using regex, and return boolean
                // 3. after validation:
                //  - if true: go to the character revealing
                //  - if false: take a step for wrong answer > add to list, show message > go back to the input step
                char inpChar = Character.toLowerCase(getChar()); // <- returns only one char
                System.out.println("input: " + inpChar);
                // only alphabet is valid
                if (!Pattern.compile("[a-z]{1}", Pattern.CASE_INSENSITIVE).matcher(String.valueOf(inpChar)).find()) {
                    System.out.println("Invalid!!!");
                }
                ///////////////////////////////////////////////////////////////
                if (inputLog.contains(inpChar))
                    System.out.println("Already you entered. Please choose else!");
                else
                    inputLog.add(inpChar);

                int ind = -1;
                while (true) {  // should i put "int ind = 0; while (ind < citylength()-1) ?
                    ind = city.toLowerCase().indexOf(inpChar, ind+1);
                    if (ind < 0)
                        break;
                    System.out.println("found index: " + ind);
                    unRevealed.setCharAt(ind, inpChar);
//                    unRevealed.replace(ind, ind+1, Character.toString(inpChar));
                    isReveal = true;
                }

                if (!isReveal)
                    worngLog.add(inpChar);
                System.out.println(String.format("You are guessing: %s", unRevealed));
//                System.out.println(inputLog);
                System.out.println(String.format("You have guessed (%d) wrong letters: %s", worngLog.size(), worngLog.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" "))));
                System.out.println(String.format("City: %s, unRevealed: %s", city.toLowerCase(), unRevealed));

                // have to think about a space e.g. New York <-- user don't need to enter space
                if (unRevealed.toString().equals(city.toLowerCase())) {
                    if (worngLog.size() <= 10) {
                        System.out.println(">>>>> Congrats You Won! <<<<<");
                        System.out.println(String.format("You have guessed '%s' correctly", city));
                    }
                    else {
                        System.out.println("===== Sorry You Lose! =====");
                        System.out.println(String.format("You have guessed (%d) wrong letters: %s", worngLog.size(), worngLog.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" "))));
                        System.out.println(String.format("The correct word was '%s'", city));
                    }
                    break;
                }
                isReveal = false;
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
