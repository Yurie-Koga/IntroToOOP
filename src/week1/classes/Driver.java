package week1.classes;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 7, "Blue");
        System.out.println(r1.draw() + "\n");

        Rectangle r2 = new Rectangle(10, 2, "Green");
        System.out.println(r2.draw() + "\n");

        Rectangle r3 = new Rectangle(15, 12, "Red");
        System.out.println(r3.draw() + "\n");

        System.out.println("----- edge cases -----");
        edgeCases();
        System.out.println("----- invalid cases -----");
        invalidCases();
    }

    private static void edgeCases(){
        // Color: length=3
        Rectangle r2 = new Rectangle(10, 2, "ab3");
        System.out.println(r2.draw() + "\n");

        // Color: length=19
        Rectangle r3 = new Rectangle(5, 3, "Red4567890123456789");
        System.out.println(r3.draw() + "\n");

        // Color: use default
        Rectangle r5 = new Rectangle(6, 3);
        System.out.println(r5.draw() + "\n");
    }

    private static void invalidCases(){
        // Color: length=2
        Rectangle r1 = new Rectangle(5, 7, "12");
        System.out.println(r1.draw() + "\n");

        // Color: length=20
        Rectangle r4 = new Rectangle(5, 3, "Red45678901234567890");
        System.out.println(r4.draw() + "\n");
    }
}
