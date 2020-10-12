package extraweek.variables;

import java.util.Arrays;

import static extraweek.StringMethods.*;

public class YourSchedule {
    public static void main(String[] args) {
        int width = 52;
        String[][] str = new String[][] {
                {"course1", "teacher1"},
                {"123456789A123456789B123456", "123456789A12345"},
                {"123456789A123456789B1234567", "123456789A123456"},
                {"test"},
                {"English III", "Ms. Lapan"},
                {"Precalculus", "Mrs. Gideon"},
                {"Music Theory", "Mr. Davis"},
                {"Biotechnology", "Ms. Palmer"},
                {"Principles of Technology I", "Ms. Garcia"},
                {"Latin II", "Mrs. Barnett"},
                {"AP US History", "Ms. Johannessen"},
                {"Business Computer Infomation Systems", "Mr. James"},
        };
        int[] strLen = new int[] {26, 15};

        drawEdgeLine(width);
        drawDataLine(str, strLen);
        drawEdgeLine(width);
    }

    private static void drawEdgeLine(int width) {
        System.out.print("+");
        for (int i = 0; i < width - 2; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    private static void drawDataLine(String[][] data, int[] strLen){
        int maxLen = Math.min(data.length, 9);  // draw up to 9 lines
        for(int i = 0; i < maxLen; i++){
            if(data[i].length != strLen.length) {
                System.out.println("Invalid data: " + Arrays.toString(data[i]));
                continue;   // next index of loop
            }

            String result = "|";
            result += " " + (i + 1);
            result += " | ";

            for(int j = 0; j < data[i].length; j++){
                // Cut off data if the length reaches to max
                if(data[i][j].length() > strLen[j]){
                    data[i][j] = data[i][j].substring(0, strLen[j]);
                }
                result += padSpaceLeft(data[i][j], strLen[j]);
                result += " | ";
            }

            System.out.println(result);
        }
    }
}
