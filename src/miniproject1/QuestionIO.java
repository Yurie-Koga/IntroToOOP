package miniproject1;

import java.nio.file.*;
import java.util.List;

import static miniproject1.QuestionValidation.*;
import static week1.InputMethods.*;

public class QuestionIO {
    ////////////////////////////////////////////////////
    private static final String FILE_NAME = "cites.txt";
    ////////////////////////////////////////////////////
    private List<String> cities;
    private Question question;

    public QuestionIO() {
        this("");
    }

    public QuestionIO(String city) {
        loadQuestion();
        this.question = new Question(this.cities, city);
    }

    public static String getFileName() {
        return FILE_NAME;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    private void loadQuestion() {
        try {
            this.cities = Files.readAllLines(Paths.get(FILE_NAME));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void runQuestion() {
//        System.out.printf("word: %s, len: %d%n", question.getCity(), question.getCity().length());
        System.out.println("Here's the question.");
        System.out.println(question.getUnRevealed());

        while (true) {
            System.out.print("Guess a letter: ");

            // read input and check answer
            if (!processInput())
                continue;

            // Game Fin
            if (isGameFin())
                break;

            // Show current guessing and continue
            System.out.printf("You are guessing: %s%n", question.getUnRevealed());
            displayWrongLog();
        }
    }

    private boolean processInput() {
        String inp = getString();   // read input as String to change behaviour depends on it

        // Invalid length
        if (!isValidLength(inp)) {
            System.out.println("Invalid input length!");
            System.out.printf("You are guessing: %s%n", question.getUnRevealed());
            displayWrongLog();
            return false;
        }

        // Invalid input/Wrong answer
        char inpChar = inp.charAt(0);
        if (!isValidInput(inpChar)) {
            System.out.println("Invalid input!");
            question.getWrongLog().add(inpChar);
        } else if (question.isContains(inpChar)) {
            System.out.println("Already you entered. Please choose else!");
            question.getWrongLog().add(inpChar);
        } else if (!question.isReveal(inpChar))
            question.getWrongLog().add(inpChar);

        return true;
    }

    private boolean isGameFin() {
        if (question.isGameOver()) {
            displayWrongLog();
            System.out.println("You lose!");
            System.out.printf("The correct word was '%s'!%n", question.getCity());
            return true;
        } else if (question.isFin()) {
            System.out.println("You win!");
            System.out.printf("You have guessed '%s' correctly!%n", question.getCity());
            return true;
        }
        return false;
    }

    private void displayWrongLog() {
        System.out.printf("You have guessed (%d) wrong letters: %s%n",
                question.getWrongLog().size(), question.wrongLogToString());
    }
}
