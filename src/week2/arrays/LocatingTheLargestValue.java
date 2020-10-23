package week2.arrays;

import java.util.Arrays;

import static week2.CommonMethods.*;

/**
 * Write a program that creates an array which can hold ten values.
 * Fill the array with random numbers from 1 to 100. Display the values in the array on the screen.
 * Then use a linear search to find the largest value in the array, and display that value and its slot number.
 */
public class LocatingTheLargestValue {
    public static void main(String[] args) {
        int[] nums = randomIntArr(10, 1, 100);

        displayArrMap(nums);

        int[] result = getMaxValueOfArrWithIndex(nums);
        System.out.printf("The largest value is %d%n", result[1]);
        System.out.printf("It is in slot %d%n", result[0]);

        System.out.println();
        System.out.printf("Result is: %d%n", Arrays.stream(nums).max().getAsInt());

    }
}
