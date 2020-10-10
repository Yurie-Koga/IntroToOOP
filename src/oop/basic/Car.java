package oop.basic;
// way 1: no constructor in Car class + new Car() -> use JAVA's default constructor
// way 2: add default constructor w/o empty value + new Car() -> use this default constructor
// way 3: add constructor with values + new Car(value1, value2,..) -> use this constructor with values

public class Car {
    /////////////////////////////////
    // Instance variables (states) //
    // - data fields               //
    /////////////////////////////////
    // ('this' refers here)
    String color;
    String brand;
    int year;
    int hoursePower;
    int seats;



    //////////////////////////////////////////////////////////////////////////////////////
    // Constructor: to create a new instance(object), 'initialize' instance variables   //
    //////////////////////////////////////////////////////////////////////////////////////

    // (way1) if there is no constructors, JAVA gives a default constructor

    // (way2) specify default constructor: initialize instance variables
    // - if no parameters are passed when new Car(), these below values are set
    Car() {
        this.color = "Red";
        this.brand = "Ferrari";
        this.year = 2019;
        this.hoursePower = 540;
        this.seats = 2;
    }

    // (way3) constructor
//    Car(String c, String b, int y, int hp, int s) {   // parameters should be the same same as instance variables
//        color = c;
//        brand = b;
//        year = y;
//        hoursePower = hp;
//        seats = s;
//    }
    Car(String color, String brand, int year, int hoursePower, int seats) {
        // 'this' refers to the instance that's being used = above variables ^^
        this.color = color;
        this.brand = brand;
        this.year = year;
        this.hoursePower = hoursePower;
        this.seats = seats;
    }


    /////////////////////////
    // Methods (behaviors) //
    /////////////////////////

    // (method1)
    void drive() {
        System.out.println("Driving.." + this.brand);
    }

    // 'method overloading'
    // - create methods with the same name with different set of parameters
    // (method2)
    void drive(int speed) {
        System.out.println("Driving " + this.brand + " at " + speed + " km/h");
    }

    void stop() {
        System.out.println("Stopping..");
    }

    // return class objects as strings
    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", hoursePower=" + hoursePower +
                ", seats=" + seats +
                '}';
    }
}

