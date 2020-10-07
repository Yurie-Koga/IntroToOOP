package basics;

import java.util.Arrays;

public class StaticMethods {
    // void: return nothing
    public static void main(String[] args) {
        System.out.println(addTwo(10, 20));

        int a = 10;
        int b = 20;
        System.out.printf("a = %d, b = %d\n", a, b);
        swap(a, b);
        System.out.printf("a = %d, b = %d\n", a, b);

        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));   // 1, 2, 3
        changeFirstElement(arr);
        System.out.println(Arrays.toString(arr));   // 7, 2, 3

        String s = "test";
        System.out.println(s);

        // int[] is not primitive type, so copy reference (memory address)
        int[] arr1 = arr.clone();
        int[] arr2 = Arrays.copyOf(arr ,arr.length);
        System.out.println(arr == arr1);    // false: in different address
        System.out.println(arr == arr2);    // false: in different address
        System.out.println(Arrays.equals(arr, arr1));   // true: values in the address are same

    }

    // String is not primitive, so not gonna change value
    public static void changeString(String str) {
        str = "aaa";
    }

    // pass by value (int=primitive type): x and y are copy of a and b and not gonna change values of a and b
    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    // pass by reference (int[] != primitive type): array is reference of array, and update the value in that address
    public static void changeFirstElement(int[] array) {
        array[0] = 7;
    }

    // int: return int
    public static int addTwo(int a, int b){
        return a + b;
    }
}
