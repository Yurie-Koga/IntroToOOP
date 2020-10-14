package oop.finalstatic;

public class Driver {
    public static void main(String[] args) {
        //////////////////////////////////
        //Math m = new Math();          // 'Math' class is private and cannot create an instance
        //Math.PI = 3.99999;            // cannot modify value since PI is static final in Math class
        System.out.println(Math.PI);    // and can access directly
        //////////////////////////////////

        // static : it belongs to a class itself. use same memory address.
        //      <-> instance valuable use different memory in each created instance
        // final : constant (a situation or state of affairs that does not change.) = cannot modify
        //      <-> magic number (hard coded value). in java, set static final values in a class.
        //          do not hard code any values in code

        //////////////// Static: access directly ////////////////
        // variable
        System.out.println(MyMath.PI);
        // method
        System.out.println(MyMath.max(10, 20));

        //////////////// Non-Static: need an instance ////////////////
        MyMath m = new MyMath();
        // variable
        m.name = "Math Library";
        // method
        System.out.println(m.min(10, 20));

        try {
            Time t1 = new Time(15, 29, 9);
            Time t2 = new Time(5, 29, 9);
            Time t3 = new Time(20, 29, 9);
            Time t4 = new Time(10, 29, 9);
            System.out.println("instance count: " + Time.getInstanceCount());

            Time[] times = {t1, t2, t3, t4};
            for (Time t : times) {
                System.out.println(t.toUniversalForm());
                System.out.println(t.toStandardForm());
            }

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}
