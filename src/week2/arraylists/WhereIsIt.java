package week2.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

import static week1.InputMethods.getInt;
import static week2.CommonMethods.*;

/**
 * Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50.
 * Display those values on the screen, and then prompt the user for an integer.
 * Search through the ArrayList, and if the item is present, give the slot number where it is located.
 * If the value is not in the ArrayList, display a single message saying so.
 * If the value is present more than once, you may either display the message as many times as necessary,
 * or display a single message giving the last slot number in which it appeared.
 */
public class WhereIsIt {
    public static void main(String[] args) {
        ArrayList<Integer> nums = randomIntArrList(10, 1, 50);
        findNumber(nums);

//        myTest();
    }
    private static void myTest() {
        ArrayList<Integer> nums = randomIntArrList(10, 1, 10);
        findNumber(nums);
    }

    private static void findNumber(ArrayList<Integer> arr) {
        displayArrList(arr);

        System.out.print("Value to find: ");
        Integer input = getInt();
        if (!isMatchArrList(arr, input, true)) {
            System.out.printf("%d is not in the ArrayList.%n", input);
        }

        System.out.println();
        System.out.printf("Result (if contains): %s %n", arr.contains(input));
    }
}
