package extraweek.ifstatements;

import static extraweek.StringMethods.*;

public class ModulusAnimation {
    public static void main(String[] args) throws InterruptedException {
        String name = "Pizza Fans";
        String s = "Hellow " + name;
        s =  padSpaceLeft(s, s.length() * 2);
        for(int i = 0; i < 80; i++){
            s = s.substring(1) + s.charAt(0);
            String out = s.substring(0, s.length() / 2);
            System.out.print(out + "\r");   // print + "\r": print out to a same line
            Thread.sleep(400);
        }
    }
}
