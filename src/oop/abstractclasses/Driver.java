package oop.abstractclasses;

import lab2.Province;

import java.util.Date;

/**
 * How to use 'abstract'
 * 1. create an abstract superclass
 * 2. create abstract methods in superclass w/o definitions (no implementation inside method)
 * 3. override those abstract methods in subclasses
 */

/**
 * Note
 * 1. An abstract class cannot be instantiated
 * 2. You must override abstract methods in subclasses
 * 3. abstract methods should be override in all subclasses (if there are 5 subclasses, override abstract methods in each subclass)
 *      - since 'abstract' is a concept/template that subclasses should follow
 * 4. Abstract class can contain both of abstract methods w/o definitions and non-abstract methods with full definitions
 * 5. An abstract method cannot be defined as 'final' or 'static'
 */

public class Driver {
    public static void main(String[] args) {
        // abstract class: cannot create an instance
//        Employee e = new Employee();
        myTest();
    }

    private static void myTest() {
        Employee[] fb = new Employee[5];    // facebook!!!! lol
        // can use '_' as a thousand separator
        fb[0] = new SoftwareDeveloper("swe1", 80_000, new Date(), "Java Backend");
        fb[1] = new ProductManager("pm1", 75_000, new Date(), "whatsapp123");
        fb[2] = new Designer("dsg1", 60_000, new Date(), true);
        fb[3] = new SoftwareDeveloper("swe2", 100_000, new Date(), "Java Backend");
        fb[4] = new DataScientist("ds1", 70_000, new Date(), "4rkg04");

        int total = 0;
        for (Employee e : fb) {
            total += e.getSalary();
        }
        System.out.println(total);


        // this calls 'getSalary' @ Employee class since declared as Employee object
        fb[0].getSalary();
        //fb[0].getSpecialty();   // can't access since it's not SoftwareDeveloper class
        // this calls 'getSalary' @ SoftwareDeveloper class since declared as SoftwareDeveloper
        SoftwareDeveloper s1 = new SoftwareDeveloper("swe1", 80_000, new Date(), "Java Backend");
        s1.getSalary();
        // this calls 'getSalary' @ SoftwareDeveloper class since down casted to SoftwareDeveloper
        ((SoftwareDeveloper) fb[0]).getSalary();
        ((SoftwareDeveloper) fb[0]).getSpecialty(); // can access after down-casting


        // can't cast to subclass to subclass
        ProductManager p1 = new ProductManager("pm1", 75_000, new Date(), "whatsapp123");
        //((SoftwareDeveloper) p1).getSpecialty();


        // 'work' methods are implemented at each subclass
        for (Employee e : fb) {
            e.work();
        }
    }
}

