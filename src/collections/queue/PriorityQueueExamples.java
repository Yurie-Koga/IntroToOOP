package collections.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

//PriorityQueue is very useful and fast
// e.g.
// 1. one ArrayList not sorted
// 2. add all to priority queue with priority value or w/o?
//   -> implements Comparable compare value as ASCII value = integer
//   -> default: dequeue from smaller
//   -> can override to dequeue from bigger value
// 3. then dequeue from priority queue = sorted queue = Heap sort O(nlogn)
public class PriorityQueueExamples {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        // offer is same as add
        pq.offer("Java");
        pq.offer("Python");
        pq.offer("PHP");
        pq.offer("JavaScript");
        pq.offer("Ruby");

        // size
        System.out.println("size: " + pq.size());
        System.out.println(Arrays.toString(pq.toArray()));


        // poll: dequeue
//        System.out.println("poll: ");
//        while (!pq.isEmpty())
//            System.out.println(pq.poll());

//        System.out.println("size: " + pq.size());

        System.out.println("for each: ");
        for (Object s : pq.toArray()) {
            System.out.println(s);
        }
        System.out.println();

        // Queue Comparable and compareTo
        Student s1 = new Student("Steve Jobs", (int)(Math.random() * 50) + 50);
        Student s2 = new Student("Bill Gates", (int)(Math.random() * 50) + 50);
        Student s3 = new Student("Sergey Brin", (int)(Math.random() * 50) + 50);
        Student s4 = new Student("Larry Page", (int)(Math.random() * 50) + 50);
        Student s5 = new Student("Jeff Bezos", (int)(Math.random() * 50) + 50);
        Student s6 = new Student("Mark Zuckerberg", (int)(Math.random() * 50) + 50);

        // MERGE SORT: O(nlogn)
        // QUICK SORT: O(nlogn)
        // HEAP SORT : O(nlogn)
        PriorityQueue<Student> topStudents = new PriorityQueue<>();
        topStudents.offer(s1);
        topStudents.offer(s2);
        topStudents.offer(s3);
        topStudents.offer(s4);
        topStudents.offer(s5);
        topStudents.offer(s6);

        // when poll from Queue, automatically returned descending or ascending order by 'compareTo'
        System.out.println("-- poll by order --");
        while (!topStudents.isEmpty()) {
            System.out.println(topStudents.poll());
        }
    }
}
