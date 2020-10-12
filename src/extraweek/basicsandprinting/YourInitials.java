package extraweek.basicsandprinting;

import java.util.*;

public class YourInitials {
    public static void main(String[] args) {
        System.out.println(drawInitials(new char[] {'a', 'C', 'B'}));
    }

    private static String drawInitials(char[] c){
        String str = "";
        for(int i = 0; i < 7; i++){
            for (char value : c) {
                str += getCharLine(value, i);
                str += "  ";
            }
            str = str.replaceAll("\\s*$", "");  // remove extra spaces at the end
            str += "\n";
        }
        return str;
    }

    private static String getCharLine(char c, int line){
        HashMap<Character, String[]> dic = new HashMap<>();
        dic.put('A', new String[] {
                "  A  ",
                " A A ",
                "A   A",
                "AAAAA",
                "A   A",
                "A   A",
                "A   A",
        });
        dic.put('B', new String[] {
                "BBBB ",
                "B   B",
                "B   B",
                "BBBB ",
                "B   B",
                "B   B",
                "BBBB",
        });

        c = Character.toUpperCase(c);   // Character class provides methods for char.
        String[] s = dic.get(c);
        return s == null ? "": s[line];
    }
}
