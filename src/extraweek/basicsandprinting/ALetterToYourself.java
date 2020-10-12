package extraweek.basicsandprinting;

import static extraweek.StringMethods.*;

public class ALetterToYourself {
    public static void main(String[] args) {
        int width = 50;

        drawEdgeLine(width);
        drawDataLine(width, "####", width - 7);
        drawDataLine(width, "####", width - 7);
        drawDataLine(width, "####", width - 7);
        drawBlankLine(width, 2);
        drawDataLine(width, "Bill Gates", 26);
        drawDataLine(width, "1 Microsoft Way", 26);
        drawDataLine(width, "Redmond, WA 98104", 26);
        drawBlankLine(width, 2);
        drawEdgeLine(width);
    }

    private static void drawEdgeLine(int width) {
        System.out.print("+");
        for (int i = 0; i < width - 2; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    private static void drawBlankLine(int width, int repeat){
        for (int r = 0; r < repeat; r++){
            String result = "|";
            result += padSpaceLeft("", width - 2);
            result += "|";
            System.out.println(result);
        }
    }

    private static void drawDataLine(int width, String data, int startDataInd){
        // Cut off data if the length reaches to max
        if(startDataInd + data.length() > width - 2){
            data = data.substring(0, width - 2 - startDataInd);
        }

        String result = "|";
        result += padSpaceLeft("", startDataInd);
        result += padSpaceRight(data, width - 2 - startDataInd);
        result += "|";
        System.out.println(result);
    }
}
