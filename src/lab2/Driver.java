package lab2;

import static lab2.ProvinceValidation.*;

public class Driver {
    public static void main(String[] args) {
//        System.out.println(isValidProvince("British"));
//        System.out.println(isValidCapitalCity("Victoria"));

//        System.out.println("----- edge/invalid -----");
//        System.out.println(isValidPopulation(29999));
//        System.out.println(isValidPopulation(30000));
//        System.out.println(isValidPopulation(15000000));
//        System.out.println(isValidPopulation(15000001));

//        Province p = new Province();
//        System.out.println(p.getDetails());


        Canada c = new Canada();
        c.displayAllProvinces();
        System.out.println("between 4-10 million: " + c.getNumOfProvincesBetween(4, 10));
    }
}
