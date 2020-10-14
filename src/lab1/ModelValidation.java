package lab1;

public class ModelValidation {
    public static final int NAME_MIN_LEN = 3;
    public static final int NAME_MAX_LEN = 20;
    public static final int HEIGHT_MIN_VAL = 24;
    public static final int HEIGHT_MAX_VAL = 84;
    public static final double WIGHT_MIN_VAL = 80;
    public static final double WIGHT_MAX_VAL = 280;

    public static void checkName(String name) {
        if (name.length() < NAME_MIN_LEN || name.length() > NAME_MAX_LEN) {
            throw new IllegalArgumentException(String.format("Name length should be %d-%d", NAME_MIN_LEN, NAME_MAX_LEN));
        }
    }

    public static void checkHeight(int height) {
        if (height < HEIGHT_MIN_VAL || height > HEIGHT_MAX_VAL) {
            throw new IllegalArgumentException(String.format("Height value should be %d-%d", HEIGHT_MIN_VAL, HEIGHT_MIN_VAL));
        }
    }

    public static void checkWeight(double weight) {
        if (weight < WIGHT_MIN_VAL || weight > WIGHT_MAX_VAL) {
            throw new IllegalArgumentException(String.format("weight value should be %f-%f", WIGHT_MIN_VAL, WIGHT_MAX_VAL));
        }
    }
}
