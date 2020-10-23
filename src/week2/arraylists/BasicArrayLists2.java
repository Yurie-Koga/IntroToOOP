package week2.arraylists;

import java.util.ArrayList;

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
        displayArrList(nums);
    }
}
