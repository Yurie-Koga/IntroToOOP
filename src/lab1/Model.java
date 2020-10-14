package lab1;

import extraweek.StringMethods;

import static lab1.ModelValidation.*;

/**
 * @author Yurie Koga
 */
public class Model {
    ////////////////////////////////////////////////////////////////////////
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
    ////////////////////////////////////////////////////////////////////////
    private String firstName;
    private String lastName;
    private int height;         // in inches
    private double weight;      // in pounds
    private boolean canTravel;
    private boolean smokes;

    /**
     * @param
     */
    public Model() {

    }

    /**
     * Constructor with full variables
     * @param firstName A string of first name
     * @param lastName  A string of last name
     * @param height    An integer of height
     * @param weight    A double of weight
     * @param canTravel A boolean if can travel
     * @param smokes    A boolean if smoke
     * @throws IllegalArgumentException
     */
    public Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(canTravel);
        setSmokes(smokes);
    }

    /**
     * Constructor without some of thr variables
     * @param firstName A string of first name
     * @param lastName  A string of last name
     * @param height    An integer of height
     * @param weight    A double of weight
     */
    public Model(String firstName, String lastName, int height, double weight) {
        this(firstName, lastName, height, weight, true, false);
    }

    /**
     * Return first name
     * @return  A string of first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name
     * @param firstName A string of first name
     * @throws IllegalArgumentException
     */
    public void setFirstName(String firstName) throws IllegalArgumentException {
        checkName(firstName);
        this.firstName = firstName;
    }

    /**
     * Return last name
     * @return  A string of lase name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name
     * @param lastName  A string of last name
     * @throws IllegalArgumentException
     */
    public void setLastName(String lastName) throws IllegalArgumentException  {
        checkName(lastName);
        this.lastName = lastName;
    }

    /**
     * Return height
     * @return  height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height
     * @param inches    An integer of height
     * @throws IllegalArgumentException
     */
    public void setHeight(int inches) throws IllegalArgumentException  {
        checkHeight(inches);
        this.height = inches;
    }
    public void setHeight(int feet, int inches) {
        inches += getHeightInInches(feet);
        setHeight(inches);
    }
    public int getHeightInInches(int feet){
        return feet * INCHES_PER_FOOT;
    }

    /**
     * Return weight
     * @return  weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight in pounds
     * @param pounds    a double of weight
     * @throws IllegalArgumentException
     */
    public void setWeight(double pounds) throws IllegalArgumentException {
        checkWeight(pounds);
        this.weight = pounds;
    }

    /**
     * Convert the weight in kilograms to pounds and set to the weight
     * @param kilograms A long of weight
     */
    public void setWeight(long kilograms) {
        double p = getWeightPounds(kilograms);
        setWeight(p);
    }

    public boolean isCanTravel() {
        return canTravel;
    }

    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    public boolean isSmokes() {
        return smokes;
    }

    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }


    /**
     * Return height in feet and inches
     * @return A string of feet and inches
     */
    public String getHeightInFeetAndInches() {
        int feet = height / INCHES_PER_FOOT;
        int inches = height % INCHES_PER_FOOT;
        if (inches == 0)
            return String.format("%d feet", feet);
        else if (inches == 1)
            return String.format("%d and %d inch", feet, inches);
        else
            return String.format("%d and %d inches", feet, inches);
    }

    /**
     * Return weight in kilograms
     * @param pounds    A double of weight
     * @return  weight in kilograms
     */
    public long getWeightKg(double pounds) {
        return Math.round(pounds / POUNDS_PER_KG);
    }

    /**
     * Return weight in pounds
     * @param kilograms A long of weight
     * @return  weight in pounds
     */
    public long getWeightPounds(long kilograms) {
        return Math.round(kilograms * POUNDS_PER_KG);
    }

    /**
     * Print instance variable values
     */
    public void printDetails() {
        String result = "";
        result += String.format("Name: %s %s\n", getFirstName(), getLastName());
        result += String.format("Height: %d inches\n", getHeight());
        result += String.format("Weight: %.0f pounds\n", getWeight());
        if (isCanTravel()) {
            result += "Does travel\n";
        }else{
            result += "Does not travel\n";
        }
        if (isSmokes()) {
            result += "Does smoke";
        }else{
            result += "Does not smoke";
        }
        System.out.println(result);
    }

    /**
     * Calculate pay amount per hour
     * @return  An integer of pay amount per hour
     */
    public int calculatePayDollarsPerHour() {
        int salary = BASE_RATE_DOLLARS_PER_HOUR;

        if (isTall() && isThin())
            salary += TALL_THIN_BONUS_DOLLARS_PER_HOUR;

        if (isCanTravel())
            salary += TRAVEL_BONUS_DOLLARS_PER_HOUR;

        if (isSmokes())
            salary -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;

        return salary;
    }

    private boolean isTall() {
        return height >= TALL_INCHES;
    }

    private boolean isThin() {
        return weight < THIN_POUNDS;
    }

    public void displayModelDetails() {
        String result = "";
        result += String.format("Name: %s %s\n", getFirstName(), getLastName());
        result += String.format("Height: %s\n", getHeightInFeetAndInches());
        result += String.format("Weight: %.1f pounds\n", getWeight());
        if (isCanTravel()) {
            result += "Travels: yep\n";
        }else{
            result += "Travels: nope\n";
        }
        if (isSmokes()) {
            result += "Smokes: yep\n";
        }else{
            result += "Smokes: nope\n";
        }
        result += String.format("Hourly rate: $%d", calculatePayDollarsPerHour());
        System.out.println(result);
    }
}
