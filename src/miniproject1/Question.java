package miniproject1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static week1.InputMethods.getChar;

public class Question {
    private List<String> cities;
    private String city;
    private StringBuilder unRevealed;
//    private List<Character> inputLog;
//    private List<Character> worngLog;

    public Question(List<String> cities) {
        this(cities, "");
    }

    public Question(List<String> cities, String city) {
        setCities(cities);
        setCity(city);
        setUnRevealed(city);
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() == 0)
            this.city = getRandomCity();
        else
            this.city = city;
    }

    public StringBuilder getUnRevealed() {
        return unRevealed;
    }

    public void setUnRevealed(StringBuilder unRevealed) {
        this.unRevealed = unRevealed;
    }

    public void setUnRevealed(String city) {
        this.unRevealed = initializeUnRevealed(city);
    }

    public String getRandomCity() {
        int r = new Random().nextInt(cities.size() - 1);
        return cities.get(r - 1);
    }

    public StringBuilder initializeUnRevealed(String word) {
        StringBuilder sb = new StringBuilder();

        if (word.trim().length() == 0)
            return sb;

        String[] words = word.trim().split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(initializeSB('_', words[i].length()));
            if (i < words.length - 1)
                sb.append(' ');
        }
        return sb;
    }

    public StringBuilder initializeSB(char fillChar, int len) {
        char[] c = new char[len];
        Arrays.fill(c, fillChar);
        return new StringBuilder(String.valueOf(c));
    }

    public boolean isReveal(char inpChar) {
        boolean isReveal = false;
        int ind = -1;
        while (true) {
            ind = city.toLowerCase().indexOf(inpChar, ind + 1);
            if (ind < 0)
                break;
//                    System.out.println("found index: " + ind);
            unRevealed.setCharAt(ind, inpChar);
            isReveal = true;
        }
        return isReveal;
    }

}
