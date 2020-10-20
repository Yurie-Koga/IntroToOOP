package miniproject1;

import java.nio.file.*;
import java.util.List;

import static miniproject1.QuestionValidation.*;
import static week1.InputMethods.*;

public class QuestionIO {
    ////////////////////////////////////////////////////
    private static final String FILE_NAME = "cites.txt";
    ////////////////////////////////////////////////////

    public static void runQuestion() {
        runQuestion("");
    }

    public static void runQuestion(String city) {
        try {
            List<String> cities = Files.readAllLines(Paths.get(FILE_NAME));
            Question q = new Question(cities, city);

//            System.out.printf("word: %s, len: %d%n", q.getCity(), q.getCity().length());
            System.out.println("Here's the question.");
            System.out.println(q.getUnRevealed());

            while (true) {
                System.out.print("Guess a letter: ");
                String inp = getString();   // read input as String to change behaviour depends on it

                // Invalid length
                if (!isValidLength(inp)) {
                    System.out.println("Invalid input length!");
                    System.out.printf("You are guessing: %s%n", q.getUnRevealed());
                    displayWrongLog(q);
                    continue;
                }

                // Invalid input/Wrong answer
                char inpChar = inp.charAt(0);
                if (!isValidInput(inpChar)) {
                    System.out.println("Invalid input!");
                    q.getWrongLog().add(inpChar);
                } else if (q.isContains(inpChar)) {
                    System.out.println("Already you entered. Please choose else!");
                    q.getWrongLog().add(inpChar);
                } else if (!q.isReveal(inpChar))
                    q.getWrongLog().add(inpChar);

                // Game Fin
//                if (isGameOver(q.getWrongLog().size())) {
                if(q.isGameOver()) {
                    displayWrongLog(q);
                    System.out.println("You lose!");
                    System.out.printf("The correct word was '%s'!%n", q.getCity());
                    break;
                } else if (isFin(q.getUnRevealed(), q.getCity())) {
                    System.out.println("You win!");
                    System.out.printf("You have guessed '%s' correctly!%n", q.getCity());
                    break;
                }

                System.out.printf("You are guessing: %s%n", q.getUnRevealed());
                displayWrongLog(q);
            }
        } catch (
                Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static void displayWrongLog(Question q) {
        System.out.printf("You have guessed (%d) wrong letters: %s%n",
                q.getWrongLog().size(), q.wrongLogToString());
    }
}
