package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonMethods {

    public static void displayArrLoop(int[] arr) {
        StringBuilder sb = new StringBuilder(String.format("Array : "));
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1)
                sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void displayArrLoop(int[] arr, int arrNum) {
        StringBuilder sb = new StringBuilder(String.format("Array %d: ", arrNum));
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1)
                sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void displayArrMap(int[] arr) {
        System.out.println("Array: " + Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static int[] randomIntArr(Integer size, Integer min, Integer max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(max - min + 1) + min;
        }
        return arr;
    }

    /**
     * Return a max value of an array
     *
     * @param arr an array to look for a max value
     * @return
     */
    public static int getMaxValueOfArr(int[] arr) {
        int maxVal = arr[0];
        for (int a : arr) {
            if (maxVal < a)
                maxVal = a;
        }
        return maxVal;
    }

    /**
     * Return an index of array which is the max value of the array and the max value.
     *
     * @param arr an array to look for a max value
     * @return an array of int with {index of max value, max value}
     */
    public static int[] getMaxValueOfArrWithIndex(int[] arr) {
        int[] result = new int[]{0, arr[0]};  // index, max value
        for (int i = 1; i < arr.length; i++) {
            if (result[1] < arr[i]) {
                result[0] = i;
                result[1] = arr[i];
            }
        }
        return result;
    }



    public static ArrayList<Integer> randomIntArrList(Integer size, Integer min, Integer max) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(new Random().nextInt(max - min + 1) + min);
        }
        return arr;
    }
}
