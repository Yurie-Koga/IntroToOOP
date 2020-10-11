package week1.classes;

public class Driver {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 7, "Blue");
        r1.draw();
        System.out.println();

        Rectangle r2 = new Rectangle(10, 2, "Green");
        r2.draw();
        System.out.println();

        Rectangle r3 = new Rectangle(15, 12, "Red");
        r3.draw();

//        System.out.println();
//        System.out.println("----- invalid cases -----");
//        invalidCases();
//        System.out.println("----- edge cases -----");
//        edgeCases();
    }

    private static void invalidCases(){
        // Color: length=2
        Rectangle r1 = new Rectangle(5, 7, "12");
        r1.draw();
        System.out.println();

        // Color: length=20
        Rectangle r4 = new Rectangle(5, 3, "Red45678901234567890");
        r4.draw();
        System.out.println();
    }

    private static void edgeCases(){
        // Color: length=3
        Rectangle r2 = new Rectangle(10, 2, "ab3");
        r2.draw();
        System.out.println();

        // Color: length=19
        Rectangle r3 = new Rectangle(5, 3, "Red4567890123456789");
        r3.draw();
        System.out.println();

        // Color: use default
        Rectangle r5 = new Rectangle(6, 3);
        r5.draw();
        System.out.println();
    }
}
