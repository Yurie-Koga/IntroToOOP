package lab2;

import static lab2.ProvinceValidation.*;

public class Province {
    //////////////////////////////////////////////////////////
    private static final String DEFAULT_PROVINCE = "British Columbia";
    private static final String DEFAULT_CAPITAL = "Victoria";
    private static final long DEFAULT_POPULATION = 4648055;
    //////////////////////////////////////////////////////////
    private String province;    // e.g. “British Columbia”
    private String capital;     // e.g. “Victoria”
    private long population;    // e.g. 2264823

    public Province() {
        setDefault();
    }

    /**
     * Constructor : if invalid values are found, set with default values
     * @param province
     * @param capital
     * @param population
     */
    public Province(String province, String capital, long population) {
        if (isValidPopulation(population) && isValidProvince(province) && (isValidCapitalCity(capital))) {
            this.province = province;
            this.capital = capital;
            this.population = population;
        } else {
            setDefault();
        }
    }

    private void setDefault() {
        this.province = DEFAULT_PROVINCE;
        this.capital = DEFAULT_CAPITAL;
        this.population = DEFAULT_POPULATION;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getDetails() {
        return String.format("The capital of %s (population. %d) is %s.", province, population, capital);
    }
}
