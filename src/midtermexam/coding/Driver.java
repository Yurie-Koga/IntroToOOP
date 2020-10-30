package midtermexam.coding;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("c1", 250, true));
        vehicles.add(new Car("c2", 220, true));
        vehicles.add(new Car("c3", -210, false));
        vehicles.add(new Boat("b1", 500));
        vehicles.add(new Boat("b2", 700));
        vehicles.add(new Boat("b3", 800));

        System.out.println("----- objects -----");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        System.out.println("----- accelerate -----");
        for (Vehicle v : vehicles) {
            v.accelerate();
        }
    }
}
