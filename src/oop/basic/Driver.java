package oop.basic;
// Main Class / Client Class
public class Driver {
    public static void main(String[] args) {
        // Car instance (object)
        // new Car(); -> calls constructor (special method)
        // - if no constructor is given in Car class, JAVA gives you 'default constructor'
        // - default constructor: constructor without parameters

        Car c1 = new Car(); // (way2) use default constructor, but override instance variables after creating object
        c1.color = "Yellow";
        c1.brand = "Lamborghini";
        c1.year = 2020;
        c1.hoursePower = 550;
        c1.seats = 2;

        System.out.print("c1 drive: ");
        c1.drive();
        c1.stop();

        Car c2 = new Car(); // (way2) use default constructor w/o parameters = instance variables are initialized at constructor

        System.out.println("c1 brand: " + c1.brand);
        System.out.println("c2 brand: " + c2.brand);

        Car c3 = new Car("Back", "Toyota", 2015, 250, 5);   // (way3) use constructor with values
        System.out.println("c3 brand: " + c3.brand);
        System.out.print("c3 drive: ");
        c3.drive();            // (method1)
        c3.drive(100);  // (method2)
    }
}


