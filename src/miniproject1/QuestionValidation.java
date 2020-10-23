package miniproject1;

import java.util.regex.Pattern;

public class QuestionValidation {
    ////////////////////////////////////////////////////
    private static final int VALID_INPUT_LENGTH = 1;
    private static final int MAX_STEPS = 10;
    ////////////////////////////////////////////////////

    public static boolean isValidLength(Object input) {
        return (input.toString().trim().length() == VALID_INPUT_LENGTH);
    }

    public static boolean isValidInput(Object input) {
        // only alphabet is valid
        return (Pattern.compile("^[a-z]$", Pattern.CASE_INSENSITIVE).matcher(String.valueOf(input)).find());
    }

    public static boolean isFin(Object input, String target) {
        return (input.toString().toLowerCase().equals(target.toLowerCase()));
    }

    public static boolean isGameOver(int steps) {
        return (steps >= MAX_STEPS);
    }
}
