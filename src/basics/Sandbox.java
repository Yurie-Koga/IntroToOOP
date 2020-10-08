package basics;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sandbox {
    public static void main(String[] args) {
        System.out.println(inchesToMeters(1000));
        System.out.println(addDigits(565));
        System.out.println(minsToYearsDays(76320));
        System.out.println(bmi(70, 1.75));
        System.out.println(speed(2500, 5, 56, 23));
        System.out.println(powers(5));
        System.out.println(powersLoop(5));
        System.out.println(arithmetic(25, -5));
    }

    public static String inchesToMeters(int inches) {
        // 1 inch = 0.0254 meter
        double meters = inches * 0.0254;
        double in = (double) inches;
        String result = String.format("%.1f inches is %.1f meters", in, meters);
        // "1000.0 inches is 25.4 meters"
        return result;
    }

    public static String addDigits(int number) {
        int target = number;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        String result = String.format("The sum of all digits in %d is %d", target, sum);
        return result;
    }

    public static String minsToYearsDays(int mins) {
        int days = mins / (60 * 24);
        int years = days / 365;
        days -= years * 365;
        String result = String.format("%d minutes is approximately %d years and %d days", mins, years, days);
        return result;
    }

    public static String bmi(int kgs, double meters) {
        double bmi = kgs / (meters * meters);
        String result = String.format("Body Mass Index is %.3f", bmi);
        return result;
    }

    public static String speed(int meters, int hours, int minutes, int seconds) {
        int totalSec = hours * 60 * 60 + minutes * 60 + seconds;
//        System.out.println(totalSec);
//        double totalHour = hours + (double) minutes / 60 + (double) seconds / (60 * 60);
        double totalHour = (double) totalSec / (60 * 60);
//        System.out.println("totalHour : " + totalHour);

        double mPerSec = (double) meters / totalSec;
        double kmPerHour = roundDown((double) meters / 1000 / totalHour, 4);

        double miles = (double) meters / 1609;
        double milePerHour = roundDown(miles / totalHour, 4);

        String result = "";
        result += String.format("Your speed in meters/second is %.4f\n", mPerSec);
        result += String.format("Your speed in km/h is %.4f\n", kmPerHour);
        result += String.format("Your speed in miles/h is %.4f", milePerHour);
        return result;
    }

    /**
     * Round down to desired decimal places.
     * @param value
     * @param places
     * @return rounded down double
     */
    private static double roundDown(double value, int places) {
        BigDecimal bd = new BigDecimal(String.valueOf(value));
        BigDecimal bd1 = bd.setScale(places, RoundingMode.DOWN);
        return bd1.doubleValue();
    }

    public static String powers(int number) {
        String result = "";
        result += String.format("Square: %d\n", (int) Math.pow(number, 2));
        result += String.format("Cube: %d\n", (int) Math.pow(number, 3));
        result += String.format("Fourth: %d", (int) Math.pow(number, 4));
        return result;
    }

    public static String powersLoop(int number) {
        int[] arr = new int[3];
        int num = number;
        for (int i = 0; i < 3; i ++) {
            num *= number;
            arr[i] = num;
        }

        String result = "";
        result += String.format("Square: %d\n", arr[0]);
        result += String.format("Cube: %d\n", arr[1]);
        result += String.format("Fourth: %d", arr[2]);
        return result;
    }

    public static String arithmetic(int a, int b) {
        String result = "";
        result += String.format("Sum of two integers: %d\n", Math.addExact(a, b));
        result += String.format("Difference of two integers: %d\n", Math.subtractExact(a, b));
        result += String.format("Product of two integers: %d\n", Math.multiplyExact(a, b));
        result += String.format("Average of two integers: %.2f\n", (double) Math.addExact(a, b) / 2);
        result += String.format("Distance of two integers: %d\n", Math.abs(a - b));
        result += String.format("Max integer: %d\n", Math.max(a, b));
        result += String.format("Min integer: %d\n", Math.min(a, b));
        return result;
    }
}