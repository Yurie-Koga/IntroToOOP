package oop.finalstatic;

public class TimeValidation {
    // validation does not need to be created instance each checking values, so must be 'static'
    public static void checkHour(int hour){
        if (hour < 0 || hour > 23){
            throw new IllegalArgumentException("Hour must be 0-23");
        }
    }

    public static void checkMinute(int minute){
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be 0-59");
        }
    }

    public static void checkSecond(int second){
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be 0-59");
        }
    }
}
