package week2.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static week1.InputMethods.getInt;
import static week2.CommonMethods.*;

/**
 * Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50.
 * Display those values on the screen, and then prompt the user for an integer.
 * Search through the ArrayList, and if the item is present, say so.
 * It is not necessary to display anything if the value was not found.
 * If the item is in the ArrayList multiple times, it's okay if the program prints the message more than once.
 */
public class FindingValueInArrayList {
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
        System.out.println("ArrayList: " + Arrays.asList(arr).stream().map(Objects::toString).collect(Collectors.joining()));

        System.out.print("Value to find: ");
        Integer input = getInt();
        if (!isMatch(arr, input)) {
            //System.out.printf("%d is not in the ArrayList.%n", input);
        }

        System.out.println("Result (if contains): " + arr.contains(input));
    }

    private static boolean isMatch(ArrayList<Integer> arr, Integer input) {
        boolean isFound = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == input) {
//                System.out.printf("%d is in slot %d.%n", input, i);
                System.out.printf("%d is in the ArrayList.%n", input);
                isFound = true;
            }
        }
        return isFound;
    }
}
