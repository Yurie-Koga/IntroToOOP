package week2.arrays;

import static week2.CommonMethods.*;

/**
 * Create an array that can hold ten integers.
 * Fill up each slot of the array with a random number from 1 to 100.
 * Then display the contents of the array on the screen. You must use a loop.
 * <p>
 * And, like last time, you must use the length field of your array and not a literal number (like 10) in the condition of the loop.
 */
public class BasicArrays2 {
    public static void main(String[] args) {
        int[] nums = randomIntArr(10, 1, 100);

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("Slot %d contains a %d%n", i, nums[i]);
        }
    }
}
