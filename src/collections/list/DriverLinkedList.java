package collections.list;

import java.util.LinkedList;

public class DriverLinkedList {
    public static void main(String[] args) {

//        testAddFirst();
//        testAddLast();
//        testAdd();
//        testRemoveFirst();
//        testRemoveLast();
//        testRemoveObj();
//        testRemoveIndex();
    }

    private static void testAddFirst() {
        System.out.println("----- LinkedList -----");
        LinkedList<Character> ll = new LinkedList<>();
        ll.addFirst('a');
        System.out.println("LinkedList: " + ll);
        ll.addFirst('b');
        ll.addFirst('c');
        System.out.println("LinkedList: " + ll);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Character> myll = new MyLinkedList<>();
        myll.addFirst('a');
        System.out.println("LinkedList: " + myll);
        myll.addFirst('b');
        myll.addFirst('c');
        System.out.println("LinkedList: " + myll);
    }

    private static void testAddLast() {
        System.out.println("----- LinkedList -----");
        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('a');
        System.out.println("LinkedList: " + ll);
        ll.addLast('b');
        ll.addLast('c');
        System.out.println("LinkedList: " + ll);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Character> myll = new MyLinkedList<>();
        myll.addLast('a');
        System.out.println("LinkedList: " + myll);
        myll.addLast('b');
        myll.addLast('c');
        System.out.println("LinkedList: " + myll);
    }

    private static void testAdd() {
        // 'add' of LinkedList class is exactly the same as 'addLast'
//        System.out.println("----- LinkedList -----");
//        LinkedList<Character> ll = new LinkedList<>();
//        ll.add('a');
//        System.out.println("LinkedList: " + ll);
//        ll.add('b');
//        ll.add('c');
//        System.out.println("LinkedList: " + ll);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Character> myll = new MyLinkedList<>();
        myll.add(0, 'a');
        System.out.println("LinkedList: " + myll);
        myll.add(1, 'b');
        myll.add(2, 'c');
        myll.add(2, 'd');   // 'c' will shift to right
        System.out.println("LinkedList: " + myll);
    }

    private static void testRemoveFirst() {
        System.out.println("----- LinkedList -----");
        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('a');
        ll.addLast('b');
        ll.addLast('c');
        System.out.println("LinkedList  : " + ll);
        ll.removeFirst();
        System.out.println("remove first: " + ll);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Character> myll = new MyLinkedList<>();
        myll.addLast('a');
        myll.addLast('b');
        myll.addLast('c');
        System.out.println("LinkedList  : " + myll);
        myll.removeFirst();
        System.out.println("remove first: " + myll);
    }

    private static void testRemoveLast() {
        System.out.println("----- LinkedList -----");
        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('a');
        ll.addLast('b');
        ll.addLast('c');
        System.out.println("LinkedList  : " + ll);
        ll.removeLast();
        System.out.println("remove last : " + ll);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Character> myll = new MyLinkedList<>();
        myll.addLast('a');
        myll.addLast('b');
        myll.addLast('c');
        System.out.println("LinkedList  : " + myll);
        myll.removeLast();
        System.out.println("remove last : " + myll);
    }

    private static void testRemoveObj() {
        // No remove(element) method in LinkedList class
//        System.out.println("----- LinkedList -----");
//        LinkedList<Character> ll = new LinkedList<>();
//        ll.addLast('a');
//        ll.addLast('b');
//        ll.addLast('c');
//        System.out.println("LinkedList  : " + ll);
//        ll.remove('a');
//        System.out.println("remove last : " + ll);

        // Character was treated as digits (ASCII) and called remove(index)
        // -> used String
        System.out.println("----- MyLinkedList -----");
        MyLinkedList<String> myll = new MyLinkedList<>();
        myll.addLast("a");
        myll.addLast("b");
        myll.addLast("c");
        System.out.println("LinkedList  : " + myll);
        myll.remove("b");
        System.out.printf("remove '%s' : %s%n", 'b', myll);
    }

    private static void testRemoveIndex() {
        System.out.println("----- LinkedList -----");
        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('a');
        ll.addLast('b');
        ll.addLast('c');
        System.out.println("LinkedList  : " + ll);
        ll.remove(2);
        System.out.printf("remove at [%d] : %s%n", 2, ll);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Character> myll = new MyLinkedList<>();
        myll.addLast('a');
        myll.addLast('b');
        myll.addLast('c');
        System.out.println("LinkedList  : " + myll);
        myll.remove(2);
        System.out.printf("remove at [%d] : %s%n", 2, myll);
        myll.remove(0);
        System.out.printf("remove at [%d] : %s%n", 0, myll);
        myll.addLast('x');
        myll.addLast('y');
        myll.addLast('z');
        myll.addLast('w');
        System.out.println("LinkedList  : " + myll);
        myll.remove(1);
        System.out.printf("remove at [%d] : %s%n", 1, myll);
    }
}
