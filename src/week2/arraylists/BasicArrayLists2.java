package week2.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static week2.CommonMethods.*;

/**
 * Create an ArrayList of Integers. Fill up the list with ten random numbers, each from 1 to 100.
 * Then display the contents of the ArrayList on the screen.
 *
 * You must use a loop to fill up the list. However, you may display it the easy way (no loop needed) like so:
 */
public class BasicArrayLists2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = randomIntArrList(10, 1, 100);
//        System.out.println(nums.get(0) + ", " + nums.get(1));


        // ArrayList: 56 76 31 93 22 38 44 11 8 6
        System.out.println("ArrayList: " + nums.stream().map(Object::toString).collect(Collectors.joining(" ")));

        // ArrayList: [56, 76, 31, 93, 22, 38, 44, 11, 8, 6]    : 'delimiter' does not work
        System.out.println("ArrayList: " + Arrays.asList(nums).stream().map(Objects::toString).collect(Collectors.joining(" ")));
        System.out.println("ArrayList: " + Arrays.asList(nums).stream().map(Objects::toString).collect(Collectors.joining()));
    }
}
