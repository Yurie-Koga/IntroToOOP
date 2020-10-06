package basics;

public class FlowControl {
    public static void main(String[] args) {
        // {} : curly brace
        // [] : square brackets
        // () : parenthesis
        // "" : double quotes
        // '' : single quotes
        // &  : ampersand
        // *  : star, asterisk
        // |  : vertical bar
        // `  : back tick
        // ~  : tilde
        // ^  : caret

        // if-else
        int age = 21;
        if (age < 10) {

        } else if (10 < age && age < 50) {

        } else {

        }

        // switch
        int salary = 1_000_000;     // use "_" as comma
        switch (salary){
            case 1_000_000:
                break;
            case 100_00:
                break;
            default:
                break;
        }

        // Ternary Operator
        boolean b = age < 10 ? true:false;
        System.out.println(b);
    }
}
