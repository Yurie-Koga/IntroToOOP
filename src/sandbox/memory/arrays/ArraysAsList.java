package sandbox.memory.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArraysAsList {
    public static void main(String[] args) {
        arrVsArrList();
    }

    private static void arrVsArrList() {
        // cannot find index: asList(primitive array) -> List<Array>
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("primitive - asList: " + Arrays.asList(arr).indexOf(5));
        System.out.println("primitive - singletonList: " + Collections.singletonList(arr).indexOf(5));

        // can find: asList(non-primitive array) -> List<>
        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5, 6};
        System.out.println("non-primitive - asList: " + Arrays.asList(arr2).indexOf(5));

        // Primitive array vs Non-Primitive array with Arrays.asList()
        // asList(int[]) -> List<int[]>
        // asList(Integer[]) -> List<Integer>
        // so how to access to each element is different
    }
}
