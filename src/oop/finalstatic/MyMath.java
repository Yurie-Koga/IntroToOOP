package oop.finalstatic;

public class MyMath {
    //////////////// Static: access directly ////////////////
    // variable
    public static final double PI = 3.14;
    // method
    public static int max(int a, int b){
        return a > b ? a : b;
    }

    //////////////// Non-Static: need an instance ////////////////
    // variable
    public String name;
    // method
    public int min(int a, int b){
        return a > b ? b : a;
    }
}
