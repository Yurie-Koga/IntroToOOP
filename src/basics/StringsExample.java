package basics;

import java.util.Arrays;

// Java has garbege collector
// heap: "new", dinamic memory
// stack: when calls function
// data:
// code:

// Strings, which are widely used in Java programming, are a sequence of characters.
// In Java programming language, strings are treated as OBJECTS.
public class StringsExample {
    public static void main(String[] args) {
        // stores reference to the memory address, then in that address actual value is stored.
        // if same values are declared, return same memory address (e.g. name1 and nam3 have same address)
        String name1 = "Derrick";   // stores in data segment (always read only=immutable)
        String name2 = new String("Derrick");   // another way to declare String using Heap
        String name3 = "Derrick";   // reference is stored and the actual value is in name1 address
        // comparing the memory address
        System.out.println(name1 == name2);     // false: in different address
        System.out.println(name1 == name3);     // true:  in same address

        // comparing strings the right way (compare as string values)
        System.out.println(name1.equals(name2));    // true: string values are same "Derrick"
        System.out.println(!name1.equals(name2));    // not equals

        System.out.println("name1 len: " + name1.length());

        String cafe = "Starbucks";
        System.out.println("0 to 3 of "+ cafe + ": " + cafe.substring(0, 4));   // 0 <= < 4
        System.out.println("index of 'bucks': " + cafe.indexOf("bucks"));

        // Exercise
        // print every cahr in a String
        String brand = "Panasonic";
        for (int i = 0; i < brand.length(); i++){
            System.out.print(brand.charAt(i) + " ");    // return char
            System.out.println(brand.substring(i, i+1));    // return String
        }
        System.out.println();
        // using for each: convert to Array, and access to each char
        for (char c : brand.toCharArray()){
            System.out.print(c + " ");
        }
        System.out.println();

        // this is interesting. String is a sequence of characters.
        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
        String helloString = new String(helloArray);
        System.out.println(helloString);

        // no way to change cases of char. seems need to use String
        char[] c = {'a'};
        String s = new String(c);
        System.out.println(s.toUpperCase());
    }
}
