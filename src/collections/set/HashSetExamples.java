package collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetExamples {
    public static void main(String[] args) {
        Set<String> diet1 = new HashSet<>();
        // if you want a hash set need to be in order, can just change to LinkedHashSet
//        Set<String> diet = new LinkedHashSet<>();

        diet1.add("Egg");
        diet1.add("Orange Juice");
        diet1.add("French Toast");
        diet1.add("French Fries");
        diet1.add("Coffee");

        // size
        System.out.println("size: " + diet1.size());


        Set<String> diet2 = new HashSet<>();
        diet2.add("Bacon");
        diet2.add("Salad");
        diet2.add("Coffee");
        diet2.add("Egg");

        // retainAll
        System.out.println("diet1: " + diet1);
        System.out.println("diet2: " + diet2);
        diet1.retainAll(diet2);
        System.out.println("retained: " + diet1);

        // used to remove duplicates
        ArrayList<String> food = new ArrayList<>();
        food.add("Egg");
        food.add("Egg");
        food.add("Egg");
        food.add("Coffee");
        food.add("Salad");
        food.add("Coffee");
        System.out.println("ArrayList: " + food);
        HashSet<String> unique = new HashSet<>(food);
        System.out.println("HashSet: "+ unique);
    }
}
