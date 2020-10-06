package basics;

import org.w3c.dom.css.CSSStyleSheet;

public class Hello {
    // psvm + [tab]
    public static void main(String[] args) {
        System.out.println("basics.Hello");    // sout + [tab]
        System.out.print("this is");
        System.out.print(" a line without break\n");

        // %s: string
        // %02d: int(digit) with padding 2 zeros
        // %f: float
        System.out.printf("%s class starts at %d:%02d pm\n", "Java", 1, 0);
        // commit testing
    }
}
