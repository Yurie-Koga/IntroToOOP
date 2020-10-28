package oop.interfaces.caravan;

/**
 * < Structures >
 * Interface:  | Movable  |  Habitable |
 * SuperClass: | Vehicle  |  House     |
 * SubClass:   | Car      |            |
 * OtherClass: |       Caravan         |  <-- use both interfaces
 */

public class Driver {
    public static void main(String[] args) {
        // Create instances from interface:
        //  - methods are available since they are overridden
        Habitable caravan1 = new Caravan(10, 0);
        Movable caravan2 = new Caravan(10, 0);
        Habitable house1 = new House(5, 2020);
        System.out.println("caravan1, canFit: " + caravan1.canFit(8));

        // Create instances from class implements interface:
        //  - methods are available since they are overridden
        //  - getter/setter of Caravan class variables are available
        Caravan caravan3 = new Caravan(0, 5);
        System.out.printf("caravan3, maxCapa: %d, check capa: %d, canFit: %s%n", caravan3.getMaxCapacity(), 10, caravan3.canFit(3));


        // Vehicle superclass and Car subclass
        // no setting for fuel = default to 0
        System.out.println("----- car 1: fuel 0 -----");
        Movable car1 = new Car("BMW", 2);
        car1.move(50);

        System.out.println("----- car 2: fuel 50 -----");
        Vehicle car2 = new Car(50, "Toyota", 40);
        car2.move(50);
        car2.move(50);

    }
}
