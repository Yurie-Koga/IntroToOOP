package week2.arrays;

import java.util.Arrays;

import static week2.CommonMethods.*;

/**
 * Write a program that creates an array of ten integers.
 * It should put ten random numbers from 1 to 100 in the array.
 * It should copy all the elements of that array into another array of the same size.
 * Then display the contents of both arrays.
 * To get the output to look like mine, you'll need a several for loops.
 * <p>
 * Create an array of ten integers
 * Fill the array with ten random numbers (1-100)
 * Copy the array into another array of the same capacity
 * Change the last value in the first array to a -7
 * Display the contents of both arrays
 */
public class CopyingArrays {
    ////////////////////////////////////////////////////
    // with Primitive type : deep copy
    //  - copy values and store in different address.
    // with Non-Primitive type :
    //  - Shallow copy. reference same address. Updating one of the array will update the other one.
    ////////////////////////////////////////////////////

    public static void main(String[] args) {
        ////////////////////////////////////////////////////
        // Wrapper objects and Auto-Boxing
//        Integer i = 10; // auto-boxing
//        int j = i;      // auto-unboxing
//        Integer k = j;  // <-- equal to 'Integer i = 10;' auto-boxing
        ////////////////////////////////////////////////////

        // initialize array
        int[] nums = randomIntArr(10, 1, 100);


        // Array class
        int[] copied = Arrays.copyOf(nums, nums.length);

        // change values
        nums[nums.length - 1] = -7;

        // display arrays
        displayArrLoop(nums, 1);
        displayArrLoop(copied, 2);

//        myTest();
    }

    private static void myTest() {
        // initialize array
        int[] nums = randomIntArr(10, 1, 100);

        System.out.println("---------- System Class - arraycopy ----------");
        systemArrCopy(nums);
        System.out.println("---------- Arrays Class - copyOf ----------");
        arrayCopyOf(nums);
        System.out.println("---------- Object Clone - clone ----------");
        objectClone(nums);
        System.out.println("---------- Stream API - stream().toArray() ----------");
        streamAPI(nums);
    }

    private static void systemArrCopy(int[] arr) {
        // System class
        int[] copied = new int[arr.length];
        System.arraycopy(arr, 0, copied, 0, arr.length);
        displayArrLoop(arr, 1);
        displayArrLoop(copied, 2);

        arr[3] = 2000;
        displayArrLoop(arr, 1);
        displayArrLoop(copied, 2);
    }

    private static void arrayCopyOf(int[] arr) {
        ////////////////////////////////////////////////////
        // with Primitive type      : deep copy
        // with Non-Primitive type  : shallow copy
        ////////////////////////////////////////////////////
        // Array class
        int[] copied = Arrays.copyOf(arr, arr.length);

        // change values
        arr[arr.length - 1] = 500;

        // display arrays
        displayArrLoop(arr, 1);
        displayArrLoop(copied, 2);
    }

    private static void objectClone(int[] arr) {
        ////////////////////////////////////////////////////
        // with Primitive type      : deep copy
        // with Non-Primitive type  : shallow copy
        ////////////////////////////////////////////////////
        int[] copied = arr.clone();

        // change values
        arr[arr.length - 1] = -7;

        // display arrays
        displayArrLoop(arr, 1);
        displayArrLoop(copied, 2);
    }

    private static void streamAPI(int[] arr) {
        ////////////////////////////////////////////////////
        // with Primitive type      : deep copy
        // with Non-Primitive type  : shallow copy
        ////////////////////////////////////////////////////
        int[] copied = Arrays.stream(arr).toArray();

        // change values
        arr[arr.length - 1] = 300;

        // display arrays
        displayArrLoop(arr, 1);
        displayArrLoop(copied, 2);
    }
}
