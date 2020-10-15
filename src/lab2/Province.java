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

    public Province(String province, String capital, long population) {
        if (isValidPopulation(population) && isValidProvince(province) && (isValidCapitalCity(capital))) {
            this.province = province;
            this.capital = capital;
            this.population = population;
        } else {
            this.province = DEFAULT_PROVINCE;
            this.capital = DEFAULT_CAPITAL;
            this.population = DEFAULT_POPULATION;
        }
    }


}
