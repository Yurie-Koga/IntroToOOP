package midtermexam.multiplechoices;

import java.util.ArrayList;
import java.util.Arrays;

public class MidtermExamQuestions {
    public static void main(String[] args) {
        question3();
        question4();

    }

    /**
     * Question: which list will fail to remove the word?
     * Answer: list3
     * Reason: the word "cat" is listed in a row <"cat", "cat"> and when removed the first one,
     * the second one's index slides to the first one,
     * but the removing for loop is continue to increase index, so the second one won't be removed.
     */
    static void question3() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("The", "cat", "sat", "on", "the", "mat"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("The", "cat", "cat", "sat", "on", "the", "mat", "mat"));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("The", "cat", "sat", "on", "the", "cat"));
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("cat"));
        ArrayList<String> list5 = new ArrayList<>(Arrays.asList("The", "cow", "sat", "on", "the", "mat"));
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);

        for (ArrayList<String> l : lists) {
            removeWord(l, "cat");
            if (l.contains("cat"))
                System.out.print("fail: ");
            else
                System.out.print("success: ");
            System.out.println(l.toString());
        }
    }

    static void removeWord(ArrayList<String> wordlist, String word) {
        for (int i = 0; i < wordlist.size(); i++)
            if ((wordlist.get(i)).equals(word))
                wordlist.remove(i);

    }

    /**
     * Question: which line in the for loop causes an error?
     * Answer: Line3 (this is a logical error, not a complie error)
     * Reason: assigning a new object to an elements of array, it is equal to create a local valuable and set to it.
     *  - it means nothing is applied to an elements of array.
     */
    static void question4() {
        Clock[][] allClocks = new Clock[][]{
            {
                new Clock(0, 0, 0),
                new Clock(1, 2, 3),
            },
            {
                new Clock(4, 5, 6),
                new Clock(7, 2, 3),
            },
        };

        for (Clock[] row : allClocks) {
            for (Clock c : row) {
//                System.out.println(c);    // Line1
//                c.setTime(0, 0, 0);       // Line2
                c = new Clock(0, 0, 0); // Line3
            }
        }
    }

    /**
     * Question: what will the value of 'cnt'
     * Answer: No value returned. The method is in an infinite loop.
     * Reason: when look for the next next index, did not slide the start index, so loop infinitely
     */
    static void question5() {
        String s1 = "a carrot and car";
        int p = s1.indexOf("car");
        int cnt = 0;
        while (p >= 0) {
            System.out.println(p);
            s1 = s1.substring(p);
            System.out.println(s1);
            p = s1.indexOf("car");
            cnt++;
        }
    }
}

class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setTime(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
    @Override
    public String toString() {
        return "Clock{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}