package collections.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExamples {
    public static void main(String[] args) {
//        acronyms();
        testPerson();
    }

    private static void acronyms() {
        HashMap<String, String> acronyms = new HashMap<>();
        acronyms.put("LoL", "Laughing out loud 🤣");
        acronyms.put("Yolo", "You only live once");
        acronyms.put("Smh", "Shake my head 🤦");
        acronyms.put("Lmk", "Let me know");
        acronyms.put("brb", "Be right back");
        acronyms.put("LGTM", "Looks good to me");
        acronyms.put("wtf", "What the f***");
        acronyms.put("jk", "Just kidding");

        System.out.printf("acronyms: %n%s%n%n", acronyms);

        // get: O(1)
        System.out.printf("Yolo: %s%n%n", acronyms.get("Yolo"));

        // remove: O(1)
        acronyms.remove("Yolo");
        System.out.printf("removed 'Yolo': %n%s%n%n", acronyms);

        // containsKey
        System.out.println("containsKye 'brb': " + acronyms.containsKey("brb"));
        System.out.println("containsKye 'BRB': " + acronyms.containsKey("BRB"));
        System.out.println("containsKye 'GGG': " + acronyms.containsKey("GGG"));
        System.out.println();

        // values
        System.out.println("values: ");
        for (String v : acronyms.values()) {
            System.out.println(v);
        }
        System.out.println();

        // keys
        System.out.println("keys: ");
        for (String key : acronyms.keySet()) {
            System.out.println(key);
        }
        System.out.println();

        // entry (key, value)
        System.out.println("entry (key, value): ");
        for (Entry<String, String> entry : acronyms.entrySet()) {
            System.out.printf("(%s, %s)%n", entry.getKey(), entry.getValue());
//            System.out.printf("%s : %s%n", acronyms.get(entry.getKey()), entry.getValue());
        }
        System.out.println();

        // size
        System.out.println("size: " + acronyms.size());

    }

    private static void testPerson() {
        Person p1 = new Person("9123-456-789", "Person1", new Date());
        Person p2 = new Person("654321", "Person2", new Date());
        Person p3 = new Person("9123-456-789", "Person3", new Date());
        HashMap<Person, String> countries = new HashMap<>();
        countries.put(p1, "Brazil");
        countries.put(p2, "Canada");
        countries.put(p3, "Thai");

        System.out.printf("countries: %n%s%n%n", countries);
        System.out.println("hash code: ");
        System.out.println("p1: " + p1.hashCode());
        System.out.println("p2: " + p2.hashCode());
        System.out.println("p3: " + p3.hashCode());
    }
}
