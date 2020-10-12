package extraweek;

public class StringMethods {
    /**
     * Return a string which is padded with spaces in the right hand.
     * @param str: A string which is to be padded
     * @param num: An integer of the number of padding spaces
     * @return: A string after padding
     */
    public static String padSpaceRight(String str, int num) {
        return String.format("%-" + num + "s", str);
    }

    /**
     * Return a string which is padded with spaces in the left hand.
     * @param str: A string which is to be padded
     * @param num: An integer of the number of padding spaces
     * @return: A string after padding
     */
    public static String padSpaceLeft(String str, int num) {
        return String.format("%" + num + "s", str);
    }
}
