package collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. offer() vs add()
 * - preferred to use offer
 * - offer: returns false when queue's capacity is full
 * - add: calls offer internally and throw an Exception when the queue is full
 */
public class QueueExamples {
    public static void main(String[] args) {
        System.out.println("----- queue test -----");
        testQueue1();
        testQueue2();

        System.out.println("----- stutter -----");
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);

        System.out.println("Before stutter: " + q1);
        stutter(q1);
        System.out.println("After stutter: " + q1);


        System.out.println("----- combination of stack and queue -----");
        Queue<String> q2 = new LinkedList<>();
        q2.offer("a");
        q2.offer("b");
        q2.offer("c");
        System.out.println("Before mirror: " + q2);
        mirror(q2);
        System.out.println("After mirror: " + q2);
    }

    private static void testQueue1() {
        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            myQueue.add(i);
        }
        // when 'poll' from Queue, the size is getting smaller, so never reach to the last element.
        for (int i = 0; i < myQueue.size(); i++) {
            System.out.print(myQueue.poll() + " ");
        }
        System.out.println(myQueue + " size: " + myQueue.size());

    }

    private static void testQueue2() {
        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            myQueue.add(i);
        }
        // when 'poll' from Queue, the size is getting smaller, so never reach to the last element.
        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.poll() + " ");
        }
        System.out.println(myQueue + " size: " + myQueue.size());
    }

    /**
     * Write a function stutter that accepts a queue of integers
     * and replaces every element with two copies of itself.
     * <p>
     * [1, 2, 3] becomes [1, 1, 2, 2, 3, 3]
     */
    private static void stutter(Queue<Integer> q) {
        // if use 'isEmpty', never be end since offering
//        while (!q.isEmpty()) {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            Integer e = q.poll();
            q.offer(e);
            q.offer(e);
            System.out.printf("[%d]: %s%n", i, q);
        }
    }

    /**
     * Write a function mirror that accepts a queue of strings
     * and appends the queue’s contents to itself in reverse order.
     * <p>
     * [“a”, “b”, “c”] becomes [“a”, “b”, “c”, “c”, “b”, “a”]
     */
    private static void mirror(Queue<String> q) {
        // stack : reverse the order
        // queue : keep the original order
        Deque<String> stack = new ArrayDeque<>();
        int len = q.size();
        for (int i = 0; i < len; i++) {
            String e = q.poll();
            q.offer(e);
            stack.push(e);
            System.out.printf("[%d]: Queue: %s, Stack: %s%n", i, q, stack);
        }
        // add reversed elements to queue
        int i = 0;
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
            System.out.printf("[%d]: Queue: %s, Stack: %s%n", i, q, stack);
            i++;
        }
    }
}
