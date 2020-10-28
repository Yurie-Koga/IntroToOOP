package oop.interfaces.marvel;

import java.util.ArrayList;

/**
 * < Structures >
 * Interface:  |            |  Flyable |
 * SuperClass: | SuperHero  |          |
 * SubClass:   | SpiderMan  |          |
 *             |         IronMan       |
 *             |          Thor         |
 *
 * 1. "composition over inheritance"
 *      - prefer composition instead of inheritance since update superclass might cause error
 * 2. "interface over abstract classes"
 *      - prefer interface instead of abstract since no need to create superclass instance ('super()')
 *      - if you can use interface, choose it.
 * 3. "less coupling"
 *      - should less tight connection between superclass and subclass
 *      - so better to use interface
 */
public class Driver {
    public static void main(String[] args) {
        // creates instances with each class
        // = can cast down Flyable (interface) to IronMan and Thor
        // - since IronMan and Thor implement Flyable
        ArrayList<Flyable> characters1 = new ArrayList<>();
        IronMan ironMan1 = new IronMan(100, 199);
        Thor thor1 = new Thor(200, 299);

        characters1.add(ironMan1);
        characters1.add(thor1);

        // creates instances with group of interface
        // - since IronMan and Thor implement Flyable
        ArrayList<Flyable> characters3 = new ArrayList<>();
        Flyable ironMan3 = new IronMan(100, 199);
        Flyable thor3 = new Thor(200, 299);
        characters3.add(ironMan3);
        characters3.add(thor3);

        // ArrayList<SuperHero> is also okay
        // = cast down SuperHero (superclass) to subclasses
        // - since IronMan and Thor are subclass of SuperHero
        ArrayList<SuperHero> characters2 = new ArrayList<>();
        SuperHero ironMan2 = new IronMan(100, 199);
        SuperHero thor2 = new Thor(200, 299);
        characters2.add(ironMan2);
        characters2.add(thor2);

        // SuperHero cannot be added to Flyable
        // = can not cast SuperHero (superclass) to Flyable (interface)
        //  - since SuperHero does not implements Flyable. completely independent.
        //  - if SuperHero has to be Flyable, all subclasses of SuperHero (SpiderMan) has to be implements Flyable
        ArrayList<Flyable> characters4 = new ArrayList<>();
        SuperHero ironMan4 = new IronMan(100, 199);
        SuperHero thor4 = new Thor(200, 299);
//        characters4.add(ironMan4);
//        characters4.add(thor4);
    }
}
