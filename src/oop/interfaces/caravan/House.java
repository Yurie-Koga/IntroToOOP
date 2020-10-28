package oop.interfaces.caravan;

public class House implements Habitable {
    private int numOfBedrooms;
    private int builtYear;

    public House(int numOfBedrooms, int builtYear) {
        this.numOfBedrooms = numOfBedrooms;
        this.builtYear = builtYear;
    }

    // override methods in the interface
    @Override
    public boolean canFit(int inhabitants) {
        return (numOfBedrooms * 2 >= inhabitants);
    }
}
