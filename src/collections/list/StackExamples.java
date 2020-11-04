package collections.list;

import java.lang.reflect.Array;
import java.util.*;

public class StackExamples {
    public static void main(String[] args) {
        System.out.println("----- stack test -----");
        testStack();

        System.out.println("----- is balanced? -----");
        // returns -1
        System.out.println(checkBalance("if (a(4) > 9) { foo(a(2)); }"));
        // returns 14
        System.out.println(checkBalance("for  (i=0;i<(3};i++) { foo{)); )"));
        // returns 7
        System.out.println(checkBalance("if (x) {"));

    }

    private static void testStack() {
        // can create in those ways
        Stack<String> s1 = new Stack<>();
        Vector<String> s2 = new Stack<>();
        List<String> s3 = new Stack<>();

        // better stack
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("1. NeverEnding Story");
        stack.push("2. My Neighbor Totoro");
        stack.push("3. Back to the future");
        stack.push("4. Catch me if you can");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static int checkBalance(String src) {
        // open braces: push
        // close braces: if it's same-> pop, otherwise-> imbalanced
        // if stack is empty, balanced
        // if stack is not empty, imbalanced

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');

        // 'Deque' is interface and 'ArrayDeque' implements it so can be written in either way
//        ArrayDeque<Character> stack = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();
        // '==' is for primitive type
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (map.containsValue(ch)) {
                Character open = stack.peek();
                if (ch == map.get(open)) {
                    stack.pop();
                } else {
                    return i;
                }
            }
        }

        return (stack.isEmpty()) ? -1 : (src.length() - 1);
    }
}
