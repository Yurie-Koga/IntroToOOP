package week2.arraylists;

import java.util.ArrayList;

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
        displayArrList(arr);

        System.out.print("Value to find: ");
        Integer input = getInt();
        if (!isMatchArrList(arr, input, false)) {
            //System.out.printf("%d is not in the ArrayList.%n", input);
        } else {
            System.out.printf("%d is in the ArrayList.%n", input);
        }

        System.out.println();
        System.out.println("Result (if contains): " + arr.contains(input));
    }
}
