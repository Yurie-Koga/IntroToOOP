package oop.interfaces;

public class Driver {
    public static void main(String[] args) {
        Habitable caravan1 = new Caravan(10, 0);
        Movable caravan2 = new Caravan(10, 0);
        Movable car1 = new Car("BMW", 2);
        Habitable house1 = new House(5, 2020);


        car1.move(50);
        System.out.println(car1);

    }
}
