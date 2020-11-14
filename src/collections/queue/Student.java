package collections.queue;

/**
 * implements Comparable -> override compareTo()
 */
public class Student implements Comparable<Student> {
    private String name;
    private int score;      // priority of value.

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    /**
     * Return value when compare the score to know which is higher priority.
     * pos (1) : 'this' is greater than 'o'
     * 0 : 'this' is equal to 'o'
     * neg (-1) : 'this' is less than 'o'
     */
    @Override
    public int compareTo(Student o) {
//        return o.score - this.score;    // descending order
        return this.score - o.score;    // ascending order
    }
}
