package miniproject2;

/**
 * 1. Phone Number should be 10 digits concatenated by space or dash (e.g. 123-456-7890).
 *      - validate when get user inputs, no validation in Phone class.
 * 2. Added menus:
 *      - No. 6: insert sample data.
 *      - No. 7: clear all contacts data.
 * 3. Duplicate entries:
 *      - when Name and Phone Name/Number are same.
 *      - if Phone Number is same but Phone Name is different, regard as a different entry.
 */
public class Driver {
    public static void main(String[] args) {
        InputCollector ic = new InputCollector();
        ic.run();
    }
}
