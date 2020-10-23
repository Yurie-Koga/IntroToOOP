package week2.arrays;

import java.util.Random;

/**
 * Write a program that creates an array of ten integers.
 * It should put ten random numbers from 1 to 100 in the array.
 * It should copy all the elements of that array into another array of the same size.
 * Then display the contents of both arrays.
 * To get the output to look like mine, you'll need a several for loops.
 *
 * Create an array of ten integers
 * Fill the array with ten random numbers (1-100)
 * Copy the array into another array of the same capacity
 * Change the last value in the first array to a -7
 * Display the contents of both arrays
 */
public class CopyingArrays {
    public static void main(String[] args) {
//        String s;
//        Integer i = 10; // auto-boxing
//        int j = i;      // auto-unboxing
//        Integer k = j;  // <-- equal to 'Integer i = 10;' auto-boxing

        Integer size = 10;
        int[] nums = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(100);
        }

        // copy the array
        int[] copied = nums.clone();

        // change values
        nums[nums.length-1] = -7;

        // display arrays
        displayArr(nums, 1);
        displayArr(copied, 2);
    }

    public static void displayArr(int[] arr, int arrNum) {
        StringBuilder sb = new StringBuilder(String.format("Array %d: ", arrNum));
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length-1)
                sb.append(" ");
        }
        System.out.println(sb);
    }
}
