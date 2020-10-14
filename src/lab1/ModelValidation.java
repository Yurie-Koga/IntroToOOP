package lab1;

public class ModelValidation {
    public static final int nameMinLen = 3;
    public static final int nameMaxLen = 20;
    public static final int heightMinVal = 24;
    public static final int heightMaxVal = 84;
    public static final double wightMinVal = 80;
    public static final double wightMaxVal = 280;

    public static void checkName(String name) {
        if (name.length() < nameMinLen || name.length() > nameMaxLen) {
            throw new IllegalArgumentException(String.format("Name length should be %d-%d", nameMinLen, nameMaxLen));
        }
    }

    public static void checkHeight(int height) {
        if (height < heightMinVal || height > heightMaxVal) {
            throw new IllegalArgumentException(String.format("Height value should be %d-%d", heightMinVal, heightMinVal));
        }
    }

    public static void checkWeight(double weight) {
        if (weight < wightMinVal || weight > wightMaxVal) {
            throw new IllegalArgumentException(String.format("weight value should be %f-%f", wightMinVal, wightMaxVal));
        }
    }
}
