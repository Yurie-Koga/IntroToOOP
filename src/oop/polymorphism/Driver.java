package oop.polymorphism;

import lab2.Province;

import java.util.Date;

/**
 * Polymorphism:
 * - Same Type, Different Behaviours by Overridden Methods
 * <p>
 * 1. create a base class : Super class
 * 2. create classes 'extends' the base class : Sub class
 * 3. implements override methods to accommodate functionalities for each class
 * <p>
 * Creating instances:
 * 1. Super class ... = new Super class();      --> access to Super class
 * 2. Super class ... = new Sub class();        --> access to Sub class
 * 3. Sub class ... = new Sub class();          --> access to Sub class
 * 4. Arrays of Super class ... = Sub classes   --> access to Sub class
 */
public class Driver {
    public static void main(String[] args) {
//        testPolymorphism();
        testAccess();
    }

    private static void testPolymorphism() {
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
    }

    private static void testAccess() {
        // 1. Super class ... = new Super class(); --> access to Super class
        Employee e = new Employee("e", 100, new Date());
        System.out.print("1: ");
        System.out.println(e.getSalary());  // access to Employee class

        // 2. Super class ... = new Sub class(); --> access to Sub class
        Employee es = new SoftwareDeveloper("es", 100, new Date(), "UX");
        System.out.print("2: ");
        System.out.println(es.getSalary()); // access to SoftwareDeveloper class

        // 3. Sub class ... = new Sub class(); --> access to Sub class
        SoftwareDeveloper ss = new SoftwareDeveloper("ss", 70_000, new Date(), "Swift");
        System.out.print("3: ");
        System.out.println(ss.getSalary()); // access to SoftwareDeveloper class

        // 4. Arrays of Super class ... = Sub classes --> access to Sub class
        Designer d = new Designer("d", 60_000, new Date(), true);
        ProductManager pm = new ProductManager("pm", 50_000, new Date(), "prod1");
        DataScientist ds = new DataScientist("ds", 40_000, new Date(), "Oracle");

        Employee[] employees = {d, pm, ds};
        // no need to add 'new Employee[]' when initialize values
//        Employee[] employees = new Employee[]{d, pm, ds};
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%d: ", i);
            System.out.println(employees[i].getSalary());
        }
    }
}

