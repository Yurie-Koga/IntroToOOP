package basics;

public class DataTypes {
    public static void main(String[] args) {
        // Primitive Types: types already in Java (only 8 types)
        // - the value(itself) gets stored in memory directly

        byte day = 127;         // byte : 8 bits    (-128 <= <= 127)
        short year = 2020;      // short: 16 bits   (-2^15 <= <= 2^15 - 1)
        int age = 26;           // int  : 32 bits   (-2^31 <= <= 2^31 - 1)
        long sin = 123456789L;  // long : 64 bits   (-2^63 <= <= 2^63 - 1)
        // put 'L' for long

        char gender = 'M';      // char : 1byte (8bits). use single quotes.
        // data is converted to ascii
        char character = 65;
        System.out.printf("'65' is %c\n", character);  // return 'A' since 65 is A of ascii number

        boolean flag = true;

        float weight = 170.56f;         // float: 32 bits - floating point numbers
        // put 'f' for float
        double hight = 180.23;           // double: 64 bits - (double-precision) floating point numbers
        // usually use float to save memory, but when need to be more aculate, use double


        // Operators
        // Arithmetic: +, -, *, /, %
        // Assignment: =
        // Comparison: >, <, >=, <=, ==, !=
        // Increment(Decrement): ++, --, +=, -=
        // Logical: && (and), || (or), ! (not)
        int x = 10;
        x++;
        System.out.printf("x is %d\n", x);
        // ++x is faster than x += 1

        // Java does not have // (get only int part) because, the result should be set in a type and it decide if the result have int or under "."
        int w = 10;
        int y = 3;
        int z = w / y;  // 3
        double d = w / y;   // 3.000 (int / int = integer)
        System.out.println(String.format("%.3f", d));
        double d2 = (double) w / y;   // 3.333 (double / int = double)
        System.out.println(String.format("%.3f", d2));
        // int c = (int) x / y;  // cast x to int
        // int d = (int) (x / y);   // cast the result of division to int

        double numerator = 10;
        double denominator = 3;
        System.out.println(String.format("%.3f", numerator / denominator)); // 3.333 (double / double = double)
        int intDenom = 3;
        System.out.println(String.format("%.3f", numerator / intDenom)); // 3.333 (double / int = double)


        // other types are custom types and stored as different value with address!!!!!
    }
}
