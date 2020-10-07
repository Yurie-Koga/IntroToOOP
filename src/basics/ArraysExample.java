package basics;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // List uses Array internally:
        // when list.append = make a new array with a new size, and copy values to new array and return as a new list
        // from this, list.append takes time O(n)

        // Array: fixed size, a sequence of elements of the same data type
        // stores memory address, and the real value is stored in that address.

        // initialize Array
        int[] arr1 = {1, 2, 3, 4};  // array literal syntax
        System.out.println("len: " + arr1.length);
        System.out.println(arr1[0] + arr1[arr1.length-1]);
        arr1[0] = 100;
        System.out.println(arr1[0] + arr1[arr1.length-1]);

        // access to each elements
        for (int elem: arr1) {
            System.out.print(elem + " ");
        }
        System.out.println();

        System.out.println("returns hash code: " + arr1);
        System.out.println("returns array elements: " + Arrays.toString(arr1));

        // create an array
        int[] arr2 = new int[10];   // "new": stores in heap. without "new": stores in stack
        System.out.println(Arrays.toString(arr2));
        for (int i =0; i < arr2.length; i++){
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));

        String[] countries = {"Canada", "Japan", "Brazil", "Spain", "Germany", "Korea"};
        for (String c : countries){
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
