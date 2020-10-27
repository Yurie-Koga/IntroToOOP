package oop.interfaces;

// Subclass of Vehicle Class
public class Car extends Vehicle {
    private int numOfSeats;

    public Car(String brand, int numOfSeats) {
        super(brand);
        this.numOfSeats = numOfSeats;
    }
}
