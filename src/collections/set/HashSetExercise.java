package collections.set;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetExercise {
    public static void main(String[] args) {

        // Instant - only the fist time to call each method returns proper time.
//        Instant s1 = Instant.now();
//        Instant e1 = Instant.now();
//        long timeElapsed = Duration.between(s1, e1).toMillis();
//        System.out.println("time: " + timeElapsed);


        // max time diff: loop=11 vs stream=1
        // min time diff: loop=8  vs stream=2
        System.out.println("----- loop -----");
        long s1 = System.nanoTime();
        System.out.println(distinctYear(1987));
        long e1 = System.nanoTime();
        long timeElapsed1 = (e1 - s1) / 1_000_000;
        System.out.println("time diff: " + timeElapsed1);

        System.out.println("----- stream -----");
        long s2 = System.nanoTime();
        System.out.println(distinctYearStream(1987));
        long e2 = System.nanoTime();
        long timeElapsed2 = (e2 - s2) / 1_000_000;
        System.out.println("time diff: " + timeElapsed2);
        System.out.println();

        // nanoTime() - only the fist time to call each method returns proper time.
        System.out.println("----- loop -----");
        long s3 = System.nanoTime();
        System.out.println(distinctYear(999));
        long e3 = System.nanoTime();
        long timeElapsed3 = (e3 - s3) / 1_000_000;
        System.out.println("time diff: " + timeElapsed3);

        System.out.println("----- stream -----");
        long s4 = System.nanoTime();
        System.out.println(distinctYearStream(999));
        long e4 = System.nanoTime();
        long timeElapsed4 = (e4 - s4) / 1_000_000;
        System.out.println("time diff: " + timeElapsed4);
    }

    /**
     * Returns the next year with distinct digits
     *
     * @param year int 0 <= year <= 10_000
     * @return the next year with distinct digits
     */
    private static int distinctYear(int year) {
        int steps = 0;
        // input will up to 10_000: possible max distinct year is 10_234
        for (int y = year + 1; y <= 10_234; y++) {
            HashSet<Character> digits = new HashSet<>();
            for (char i : String.valueOf(y).toCharArray()) {
                steps++;
                // returns false if the value exists in HashSet
                if (!digits.add(i)) {
//                    System.out.printf("year=%d, current set=%s, did not add: %s%n", y, digits, i);
                    break;
                }
            }
            if (digits.size() == String.valueOf(y).length()) {
                System.out.println("steps: " + steps);
                return y;
            }
        }
        return -1;
    }

    private static int distinctYearStream(int year) {
        int steps = 0;
        for (int y = year + 1; y <= 10_234; y++) {
            steps++;
            Set<Character> set = String.valueOf(y).chars().mapToObj(x -> (char) x).collect(Collectors.toSet());
            if (set.size() == String.valueOf(y).length()) {
                System.out.println("steps: " + steps);
                return y;
            }
        }
        return -1;
    }
}
