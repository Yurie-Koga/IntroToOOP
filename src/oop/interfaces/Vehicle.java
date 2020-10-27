package oop.interfaces;

// Superclass of Car Class
public class Vehicle implements Movable {
    private int fuel;
    private String brand;

    public Vehicle(String brand) {
        this.fuel = 0;
        this.brand = brand;
    }

    @Override
    public void move(int distance) {
        if (distance < 0)
            System.out.println("Wrong distance");
        else {
            if (fuel >= distance) {
                System.out.println("moving to the destination.");
            } else {
                System.out.println("cannot reach to the destination.");

            }
            fuel -= distance;
        }
    }

    @Override
    public boolean canMove() {
        return fuel > 0;
    }
}
