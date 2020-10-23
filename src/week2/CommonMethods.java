package week2;

import java.util.*;
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
     * Return an index of array which is the max value of the array and the max value.
     *
     * @param arr an array to look for a max value
     * @return an array of int with {index of max value, max value}
     */
    public static int[] getMaxValueOfArr(int[] arr) {
        int[] result = new int[]{0, arr[0]};  // index, max value
        for (int i = 1; i < arr.length; i++) {
            if (result[1] < arr[i]) {
                result[0] = i;
                result[1] = arr[i];
            }
        }
        return result;
    }


    public static void displayArrList(ArrayList<Integer> arr) {
        // ArrayList: [3, 31, 16, 19, 43, 27, 13, 35, 13, 24]   // both are the same
        System.out.println("ArrayList: " + Arrays.asList(arr).stream().map(Objects::toString).collect(Collectors.joining()));
//        System.out.println("ArrayList: " + Collections.singletonList(arr).stream().map(Objects::toString).collect(Collectors.joining()));

        // ArrayList: 56 76 31 93 22 38 44 11 8 6
//        System.out.println("ArrayList: " + arr.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    public static ArrayList<Integer> randomIntArrList(Integer size, Integer min, Integer max) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(new Random().nextInt(max - min + 1) + min);
        }
        return arr;
    }

    public static boolean isMatchArrList(ArrayList<Integer> arr, Integer input, boolean displayIndex) {
        boolean isFound = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == input) {
                if (displayIndex)
                    System.out.printf("%d is in slot %d.%n", input, i);
                isFound = true;
            }
        }
        return isFound;
    }

    public static int[] getMaxValueOfArrList(ArrayList<Integer> arr) {
        int[] result = new int[]{0, arr.get(0)};  // index, max value
        for (int i = 1; i < arr.size(); i++) {
            if (result[1] < arr.get(i)) {
                result[0] = i;
                result[1] = arr.get(i);
            }
        }
        return result;
    }
}
