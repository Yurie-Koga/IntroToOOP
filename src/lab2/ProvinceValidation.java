package lab2;

import java.util.Arrays;

public class ProvinceValidation {
    /////////////////////////////////////////////////////////////////////
    private static final String[] PROVINCES = new String[] {
            "Alberta",
            "British Columbia",
            "Manitoba",
            "New Brunswick",
            "Newfoundland and Labrador",
            "Nova Scotia",
            "Ontario",
            "Prince Edward Island",
            "Quebec",
            "Saskatchewan",
    };
    private static final String[] PROVINCE_CAPITAL_CITIES = new String[] {
            "Edmonton",
            "Victoria",
            "Winnipeg",
            "Fredericton",
            "St. John's",
            "Halifax",
            "Toronto",
            "Charlottetown",
            "Quebec City",
            "Regina",
    };
    private static final long POPULATION_MIN_VAL = 30000;
    private static final long POPULATION_MAX_VAL = 15000000;
    /////////////////////////////////////////////////////////////////////

    public static boolean isValidProvince(String province) {
//        System.out.println("province count: " + PROVINCES.length);
        return Arrays.asList(PROVINCES).contains(province);
    }

    public static boolean isValidCapitalCity(String capital) {
//        System.out.println("capital count: " + PROVINCE_CAPITAL_CITIES.length);
        return Arrays.asList(PROVINCE_CAPITAL_CITIES).contains(capital);
    }

    public static boolean isValidPopulation(long population) {
        return population >= POPULATION_MIN_VAL && population <= POPULATION_MAX_VAL;
    }
}
