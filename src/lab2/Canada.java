package lab2;

import java.lang.reflect.Array;

public class Canada {
    private Province[] provinces;

    /**
     * Set Provinces
     */
    public Canada() {
        provinces = new Province[10];
        Array.set(provinces, 0, new Province("Alberta", "Edmonton", 4067175));
        Array.set(provinces, 1, new Province("British Columbia", "Victoria", 4648055));
        Array.set(provinces, 2, new Province("Manitoba", "Winnipeg", 1278365));
        Array.set(provinces, 3, new Province("New Brunswick", "Fredericton",747101));
        Array.set(provinces, 4, new Province("Newfoundland and Labrador", "St. John's", 519716));
        Array.set(provinces, 5, new Province("Nova Scotia", "Halifax", 923598));
        Array.set(provinces, 6, new Province("Ontario", "Toronto", 13448494));
        Array.set(provinces, 7, new Province("Prince Edward Island",	"Charlottetown",	142907));
        Array.set(provinces, 8, new Province("Quebec", "Quebec City",	8164361));
        Array.set(provinces, 9, new Province("Saskatchewan", "Regina", 1098352));
//        Array.set(provinces, 0, new Province("Northwest Territories", "Yellowknife",	41786));
    }

    /**
     * Print out Provinces details
     */
    public void displayAllProvinces() {
        for (Province p : provinces) {
            System.out.println(p.getDetails());
        }
    }

    /**
     * Return the number of provinces which is in the range of desired population
     * parameter integers will be set to million
     * @param min   a minimum integer of desired population
     * @param max   a maximum integer of desired population
     * @return
     */
    public int getNumOfProvincesBetween(int min, int max) {
        int cnt = 0;
        for (Province p : provinces) {
            long pop =  p.getPopulation();
            if (toMillion(min) <= pop && pop <= toMillion(max))
                cnt++;
        }
        return cnt;
    }

    private long toMillion(int i) {
        // million : 1,000,000
        return i * 1000000;
    }
}
