package week1.forloops;

import static week1.InputMethods.getInt;

public class CountingMachine {
    public static void main(String[] args) {
        System.out.print("Count to: ");
        int inp = getInt();
        for (int i = 0; i <= inp; i++){
            System.out.print(i);
            if(i < inp){
                System.out.print(" ");
            }
        }
    }
}
