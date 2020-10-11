package week1.classes;

public class Driver {
    public static void main(String[] args) {
        Rectangle r;
        r = new Rectangle(5, 7, "Blue");
        System.out.println(r.draw() + "\n");

        r = new Rectangle(10, 2, "Green");
        System.out.println(r.draw() + "\n");

        r = new Rectangle(15, 12, "Red");
        System.out.println(r.draw() + "\n");

        System.out.println("----- edge cases -----");
        edgeCases();
        System.out.println("----- invalid cases -----");
        invalidCases();
    }

    private static void edgeCases(){
        Rectangle r;
        // Color: length=3
        r = new Rectangle(10, 2, "ab3");
        System.out.println(r.draw() + "\n");

        // Color: length=19
        r = new Rectangle(5, 3, "Red4567890123456789");
        System.out.println(r.draw() + "\n");

        // Color: use default
        r = new Rectangle(6, 3);
        System.out.println(r.draw() + "\n");
    }

    private static void invalidCases(){
        Rectangle r;
        // Color: length=2
        r = new Rectangle(5, 7, "12");
        System.out.println(r.draw() + "\n");

        // Color: length=20
        r = new Rectangle(5, 3, "Red45678901234567890");
        System.out.println(r.draw() + "\n");
    }
}
