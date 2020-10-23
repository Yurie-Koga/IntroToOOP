package week2.arrays;

import static week1.InputMethods.*;
import static week2.CommonMethods.*;

/**
 * Create an array that can hold ten integers,
 * and fill each slot with a different random value from 1-50.
 * Display those values on the screen, and then prompt the user for an integer.
 * Search through the array, and if the item is present,
 * give the slot number where it is located. If the value is not in the array,
 * display a single message saying so.
 * If the value is present more than once,
 * you may either display the message as many times as necessary,
 * or display a single message giving the last slot number in which it appeared.
 */
public class WhereIsIt {
    public static void main(String[] args) {

        int[] nums = randomIntArr(10, 1, 50);
        findNumber(nums);

//        myTest();
    }

    private static void myTest() {
        int[] nums = randomIntArr(10, 1, 10);
        findNumber(nums);
    }

    private static void findNumber(int[] arr) {
        displayArrMap(arr);

        System.out.print("Value to find: ");
        Integer input = getInt();
        if (!isMatch(arr, input))
            System.out.printf("%d is not in the array.%n", input);
    }

    private static boolean isMatch(int[] arr, Integer input) {
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == input) {
                System.out.printf("%d is in slot %d.%n", input, i);
                isFound = true;
            }
        }
        return isFound;
    }
}
