package oop.interfaces;

/**
 * can set multiple interfaces - don't forget override all methods from both interfaces
 */
public class Caravan implements Habitable, Movable {
    private int location;
    /* distance from 0 (home) to current location */
    private int maxCapacity;

    public Caravan(int location, int maxCapacity) {
        this.location = location;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean canFit(int inhabitants) {
        return maxCapacity <= inhabitants;
    }

    @Override
    public void move(int distance) {
        location += distance;
    }

    @Override
    public boolean canMove() {
        return true;
    }
}
