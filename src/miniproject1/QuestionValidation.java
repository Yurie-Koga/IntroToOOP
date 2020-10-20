package miniproject1;

import java.util.regex.Pattern;

public class QuestionValidation {
    ////////////////////////////////////////////////////
    private static final int MAX_STEPS = 10;
    ////////////////////////////////////////////////////

    public static boolean isValidInput(char inpChar) {
        // only alphabet is valid
        if (!Pattern.compile("^[a-z]{1}$", Pattern.CASE_INSENSITIVE).matcher(String.valueOf(inpChar)).find())
            return false;
        else
            return true;
    }

    public static boolean isFin(Object input, String target) {
        return (input.toString().equals(target.toLowerCase()));
    }

    public static boolean isWin(int steps) {
        return (steps <= MAX_STEPS);
    }
}
