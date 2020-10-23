package week2.arraylists;

import java.util.ArrayList;
import java.util.Collections;

import static week2.CommonMethods.*;

/**
 * Write a program that creates an ArrayList of Integers.
 * Fill the ArrayList with random numbers from 1 to 100. Display the values in the ArrayList on the screen.
 * Then use a linear search to find the largest value in the ArrayList, and display that value and its slot number.
 */
public class LocatingTheLargestValue {
    public static void main(String[] args) {
        ArrayList<Integer> nums = randomIntArrList(10, 1, 100);
        displayArrList(nums);

        int[] result = getMaxValueOfArrList(nums);
        if (result.length == 2) {
            System.out.printf("The largest value is %d, which is in slot %d %n", result[1], result[0]);
        }

        System.out.println();
        System.out.printf("Result is: %d, index: %d%n", Collections.max(nums), nums.indexOf(Collections.max(nums)));
    }
}
