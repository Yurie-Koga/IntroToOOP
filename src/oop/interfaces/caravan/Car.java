package oop.interfaces.caravan;

// Subclass of Vehicle Class
public class Car extends Vehicle {
    private int numOfSeats;

    public Car(String brand, int numOfSeats) {
        this(0, brand, numOfSeats);
    }

    public Car(int fuel, String brand, int numOfSeats) {
        super(fuel, brand);
        this.numOfSeats = numOfSeats;
    }

    // Vehicle class is 'abstract' and 'implements' interface, so need to override methods here
    @Override
    public void move(int distance) {
        if (distance < 0)
            System.out.println("Wrong distance");
        else {
            if (getFuel() >= distance) {
                System.out.println("moving to the destination.");
            } else {
                System.out.println("cannot reach to the destination. not enough fuel.");
            }
            setFuel(getFuel() - distance);
        }
    }

    @Override
    public boolean canMove() {
        return getFuel() > 0;
    }
}
