package lab1;

public class Driver {
    public static void main(String[] args) {
        Model m = new Model("Susan", "Smith", 70, 120, true, false);

        m.printDetails();
        System.out.println();
        m.displayModelDetails();
    }
}
