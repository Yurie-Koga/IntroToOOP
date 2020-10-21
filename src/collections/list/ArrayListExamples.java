package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExamples {
    public static void main(String[] args) {
//        List<String> strList = new List<>();  // this does not work because..? check source code

        // <E> stands for 'element': generic = any type
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Vancouver");
        cities.add(1, "Ontario");
        System.out.println(cities.size());
        System.out.println(cities.get(0));
        System.out.println(cities.indexOf("Ontario"));
        System.out.println(cities.contains("Vancouver"));

//        cities.remove("Vancouver");
//        cities.remove(2);
//        cities.clear();

        // add with list
        List<String> usa = Arrays.asList("New York", "Seattle");
        System.out.println(usa);
//        List<String> aa = new ArrayList<>();
        ArrayList<String> citiesUSA = new ArrayList<>(usa);
        System.out.println(citiesUSA);
//        ArrayList<String> strArr = new ArrayList<>(new List<String>() {
//        }


        // can't use primitive types. only class type (Integer, String, etc.)
//        ArrayList<int> intArr1 = new ArrayList<int>();
        ArrayList<Integer> intArr2 = new ArrayList<>();
    }
}
