package oop.interfaces.caravan;

// Superclass of Car Class
public abstract class Vehicle implements Movable {
    private int fuel;
    private String brand;

    public Vehicle(int fuel, String brand) {
        this.fuel = fuel;
        this.brand = brand;
    }

    // changed to receive fuel since fuel=0 cannot move at all.
    //    public Vehicle(String brand) {
//        this.fuel = 0;
//        this.brand = brand;
//    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // when 'implements' interface but this class is 'abstract', no need to override methods
    // when to set the class as 'abstract'?
    //      - if the class is too generic and methods should be accommodated in each subclass
    //      - e.g. Vehicle includes car, air plane, train, etc.
    //              these behaviour should be different in each vehicle.
//    @Override
//    public void move(int distance) {
//        if (distance < 0)
//            System.out.println("Wrong distance");
//        else {
//            if (fuel >= distance) {
//                System.out.println("moving to the destination.");
//            } else {
//                System.out.println("cannot reach to the destination.");
//
//            }
//            fuel -= distance;
//        }
//    }
//
//    @Override
//    public boolean canMove() {
//        return fuel > 0;
//    }
}
