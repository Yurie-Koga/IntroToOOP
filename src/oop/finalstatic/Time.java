package oop.finalstatic;

import static oop.finalstatic.TimeValidation.*;

public class Time {
    private static int instanceCount;   // counter of how many instance is created.
    private int hour;
    private int minute;
    private int second;

    // designated constructor: should be one constructor to initialize all instance variables.
    // other constructors MUST call this constructor, so that easy to control variables.
    public Time(int hour, int minute, int second) throws IllegalArgumentException {
        checkHour(hour);
        checkMinute(minute);
        checkSecond(second);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        instanceCount++;    // all other constructors call this, so just count here.
    }

    public Time(){
        this(0, 0, 0);  // this calls above constructor^^
    }

    public Time(int hour) {
        this(hour, 0, 0);
    }

    public Time(int hour, int minute){
        this(hour, minute, 0);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws IllegalArgumentException {
        checkHour(hour);
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws IllegalArgumentException  {
        checkMinute(minute);
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) throws IllegalArgumentException  {
        checkSecond(second);
        this.second = second;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public static void setInstanceCount(int instanceCount) {
        Time.instanceCount = instanceCount;
    }

    public String toUniversalForm(){
        // hh:mm:ss (24-hour)
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toStandardForm(){
        // hh:mm:ss PM (12-hour)
        hour = (hour == 0 || hour == 12) ? 12 : hour % 12;
        String unit = hour > 12 ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", hour, minute, second, unit);
    }
}
