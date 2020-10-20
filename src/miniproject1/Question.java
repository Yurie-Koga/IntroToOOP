package miniproject1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static miniproject1.QuestionValidation.*;

public class Question {
    ///////////////////////////////////////////////////
    // String: immutable.
    // StringBuilder: mutable, w/o thread-safety, faster than StringBuffer
    // StringBuffer: mutable, with thread-safety
    ///////////////////////////////////////////////////
    private List<String> cities;        // List of city names
    private String city;                // Target city name
    private StringBuilder unRevealed;   // Ust to show input status. Set a character if match is found
    private List<Character> inputLog;   // List of input characters
    private List<Character> wrongLog;   // List of wrong input characters

    public Question(List<String> cities) {
        this(cities, "");
    }

    public Question(List<String> cities, String city) {
        setCities(cities);
        setCity(city);
        setUnRevealed(this.city);
        setInputLog(new ArrayList<Character>());
        setWrongLog(new ArrayList<Character>());
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

    public List<Character> getInputLog() {
        return inputLog;
    }

    public void setInputLog(List<Character> inputLog) {
        this.inputLog = inputLog;
    }

    public List<Character> getWrongLog() {
        return wrongLog;
    }

    public void setWrongLog(List<Character> wrongLog) {
        this.wrongLog = wrongLog;
    }

    public String getRandomCity() {
        int r = new Random().nextInt(cities.size() - 1);
        return cities.get(r - 1);
    }

    /**
     * Initialize unRevealed text with '_'. Spaces are filled with spaces.
     * @param word
     * @return
     */
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

    public boolean isContains(char inpChar) {
        return (inputLog.contains(inpChar));
    }

    public boolean isReveal(char inpChar) {
        // Valid input: set to inputLog
        inputLog.add(inpChar);

        boolean isReveal = false;
        int ind = -1;
        while (true) {
            ind = city.toLowerCase().indexOf(Character.toLowerCase(inpChar), ind + 1);
            if (ind < 0)
                break;
//            System.out.println("found index: " + ind);
            unRevealed.setCharAt(ind, inpChar);
            isReveal = true;
        }
        return isReveal;
    }

    public String inputLogToString() {
        return inputLog.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public String wrongLogToString() {
        return wrongLog.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
