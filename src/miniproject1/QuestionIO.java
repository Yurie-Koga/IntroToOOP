package miniproject1;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static week1.InputMethods.getChar;
import static miniproject1.QuestionValidation.*;

public class QuestionIO {
    public static void runQuestion() {
        try {
            List<String> cities = Files.readAllLines(Paths.get("cites.txt"));

            // testing
            Question q = new Question(cities, "New York");

            System.out.printf("word: %s, len: %d%n", q.getCity(), q.getCity().length());
            System.out.println("Here's the question.");
            System.out.println("start: " + q.getUnRevealed());

            List<Character> inputLog = new ArrayList<Character>();
            List<Character> wrongLog = new ArrayList<Character>();

            while (true) {
                System.out.print("Guess a letter: ");

                char inpChar = Character.toLowerCase(getChar()); // <- returns only one char
                System.out.println("input: " + inpChar);

                // Invalid input
                if (!isValidInput(inpChar)) {
                    System.out.println("Invalid input!");
                    wrongLog.add(inpChar);
                    continue;
                }
                // Duplicated input
                if (inputLog.contains(inpChar)) {
                    System.out.println("Already you entered. Please choose else!");
                    wrongLog.add(inpChar);
                    continue;
                }

                // Valid input: set to inputLog
                inputLog.add(inpChar);

                if (!q.isReveal(inpChar))
                    wrongLog.add(inpChar);

                System.out.printf("You are guessing: %s%n", q.getUnRevealed());
                System.out.printf("You have guessed (%d) wrong letters: %s%n", wrongLog.size(), displayWrongLog(wrongLog));
                System.out.printf("City: %s, unRevealed: %s%n", q.getCity().toLowerCase(), q.getUnRevealed());

                if (isFin(q.getUnRevealed(), q.getCity())) {
                    if (isWin(wrongLog.size())) {
                        System.out.println(">>>>> Congrats You Won! <<<<<");
                        System.out.printf("You have guessed '%s' correctly%n", q.getCity());
                    } else {
                        System.out.println("===== Sorry You Lose! =====");
                        System.out.printf("You have guessed (%d) wrong letters: %s%n", wrongLog.size(), displayWrongLog(wrongLog));
                        System.out.printf("The correct word was '%s'%n", q.getCity());
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static String displayWrongLog(List<Character> wrongLog) {
        return wrongLog.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
