package week1.whileloops;

import static week1.InputMethods.*;

public class AddingValuesInLoop {
    public static void main(String[] args) {
        int sum = 0;
        int input;
        System.out.println("I will add up the numbers you give me.");
        while (true) {
            System.out.print("Number: ");
            input = getInt();
            if (input == 0){
                break;
            }
            sum += input;
            System.out.println("The total so far is " + sum);
        }

        System.out.println("\nThe total is " + sum);
    }
}
