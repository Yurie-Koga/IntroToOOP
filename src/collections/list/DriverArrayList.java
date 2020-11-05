package collections.list;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverArrayList {
    public static void main(String[] args) {
//        diffArrayListVsMyArrayList();

//        testSize();
//        testIsEmpty();
//        testAdd();
//        testContains();
//        testToArray();

        testRemoveObj();

//        testRemoveAll();
//        testContainsAll();
//        testAddAll();
//        testAddAllIndex();
    }

    private static void diffArrayListVsMyArrayList() {
        System.out.println("========== toString() ==========");
        System.out.println("----- ArrayList -----");
        ArrayList<String> a = new ArrayList<>();
        a.add("teest");
        a.add("teest");
        a.add("teest");
        // return: [teest, teest, teest]
        // toString() is in AbstractCollection class
        //  - ArrayList extends AbstractList<E> --> toString() using Iterator<E>
        //  - ArrayList has nested class 'Iterator<E>'
//        System.out.println(a.toString());
        System.out.println(a);

        System.out.println("----- MyArrayList -----");
        MyArrayList b = new MyArrayList();
        b.add("test");
        b.add("test");
        b.add("test");
        // return: collections.list.MyArrayList@3e3abc88
        // toString() is in Object class
//        System.out.println(b.toString());
        // need to access w/ 'toArray()'
//        for (Object c : b.toArray()) {
//            System.out.print(c + " ");
//        }

//        for (int i = 0; i < b.size(); i++) {
//            System.out.print(b.get(i) + " ");
//        }
        System.out.println(b);  // overrode toString() in MyArrayList class
    }


    private static void testSize() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList = new ArrayList<>();
        System.out.println("size: " + arrList.size());
        System.out.println(arrList);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList = new MyArrayList();
        System.out.println("size: " + myArrList.size());
        System.out.println(myArrList);
    }

    private static void testIsEmpty() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList = new ArrayList<>();
        System.out.println("isEmpty: " + arrList.isEmpty());
        System.out.println(arrList);
        arrList.add('a');
        System.out.println("isEmpty: " + arrList.isEmpty());
        System.out.println(arrList);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList = new MyArrayList();
        System.out.println("isEmpty: " + myArrList.isEmpty());
        System.out.println(myArrList);
        myArrList.add('a');
        System.out.println("isEmpty: " + myArrList.isEmpty());
        System.out.println(myArrList);
    }

    private static void testAdd() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList = new ArrayList<>();
        arrList.add('a');
        arrList.add('b');
        System.out.println("size: " + arrList.size());
        System.out.println(arrList);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList = new MyArrayList();
        myArrList.add('a');
        myArrList.add('b');
        System.out.println("size: " + myArrList.size());
        System.out.println(myArrList);
        myArrList.add('c');
        myArrList.add('d');
        myArrList.add('e');
        myArrList.add('f');
        myArrList.add('g');
        myArrList.add('h');
        myArrList.add('i');
        myArrList.add('j');
        myArrList.add('k');
        System.out.println("size: " + myArrList.size());
        System.out.println(myArrList);
    }

    private static void testContains() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList = new ArrayList<>();
        arrList.add('a');
        arrList.add('b');
        arrList.add('c');
        System.out.println("contains 'a': " + arrList.contains('a'));
        System.out.println("contains 'f': " + arrList.contains('f'));
        System.out.println(arrList);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList = new MyArrayList();
        myArrList.add('d');
        myArrList.add('e');
        myArrList.add('f');
        System.out.println("contains 'e': " + myArrList.contains('e'));
        System.out.println("contains 'a': " + myArrList.contains('a'));
        System.out.println(myArrList);
    }

    private static void testToArray() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList = new ArrayList<>();
        arrList.add('a');
        arrList.add('b');
        arrList.add('c');
        arrList.add('d');
        arrList.add('e');
        System.out.println("ArrayList print as Array: " + arrList);
        Object[] arr = arrList.toArray();
        System.out.println("Array: " + arr);
        System.out.println("Arrays.toString(): " + Arrays.toString(arr));

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList = new MyArrayList();
        myArrList.add('f');
        myArrList.add('g');
        myArrList.add('h');
        myArrList.add('i');
        myArrList.add('j');
        System.out.println("ArrayList print as Array: " + myArrList);
        Object[] myArr = myArrList.toArray();
        System.out.println("Array: " + myArr);
        System.out.println("Arrays.toString(): " + Arrays.toString(myArr));
    }

    private static void testRemoveObj() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList = new ArrayList<>();
        arrList.add('a');
        arrList.add('b');
        arrList.add('c');
        arrList.add('d');
        arrList.add('e');
        System.out.println(arrList);
        Character c = 'c';
        arrList.remove(c);
        System.out.printf("removed : %s %s%n", c.toString(), arrList);
        c = 'e';
        arrList.remove(c);
        System.out.printf("removed : %s %s%n", c.toString(), arrList);
        c = 'z';
        arrList.remove(c);
        System.out.printf("removed : %s %s%n", c.toString(), arrList);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList = new MyArrayList();
        myArrList.add('f');
        myArrList.add('g');
        myArrList.add('h');
        myArrList.add('i');
        myArrList.add('j');
        System.out.println(myArrList);
        Object obj = 'h';
        myArrList.remove(obj);
//        System.out.printf("removed : %s %s%n", obj.toString(), myArrList);
//        obj = 'j';
//        myArrList.remove(obj);
//        System.out.printf("removed : %s %s%n", obj.toString(), myArrList);
//        obj = 'k';
//        myArrList.remove(obj);
//        System.out.printf("removed : %s %s%n", obj.toString(), myArrList);
    }

    private static void testRemoveAll() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        arrList1.add('e');

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('d');  // no need to be the same order
        arrList2.add('b');

        System.out.println(arrList1);
        arrList1.removeAll(arrList2);
        System.out.println(arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        myArrList1.add('e');

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('d');
        myArrList2.add('b');

        System.out.println(Arrays.toString(myArrList1.toArray()));
        myArrList1.removeAll(myArrList2);
        System.out.println(Arrays.toString(myArrList1.toArray()));
    }

    private static void testContainsAll() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        arrList1.add('e');

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('d');  // no need to be the same order
        arrList2.add('b');

        System.out.println("ArrayList1: " + arrList1);
        System.out.println("ArrayList2: " + arrList2);
        System.out.println("contains all: " + arrList1.containsAll(arrList2));

        ArrayList<Character> arrList3 = new ArrayList<>();
        arrList3.add('t');
        arrList3.add('z');

        System.out.println("ArrayList1: " + arrList1);
        System.out.println("ArrayList3: " + arrList3);
        System.out.println("contains all: " + arrList1.containsAll(arrList3));

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        myArrList1.add('e');

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('d');
        myArrList2.add('b');

        System.out.println("ArrayList1: " + Arrays.toString(myArrList1.toArray()));
        System.out.println("ArrayList2: " + Arrays.toString(myArrList2.toArray()));
        System.out.println("contains all: " + myArrList1.containsAll(myArrList2));

        MyArrayList myArrList3 = new MyArrayList();
        myArrList3.add('t');
        myArrList3.add('z');

        System.out.println("ArrayList1: " + Arrays.toString(myArrList1.toArray()));
        System.out.println("ArrayList3: " + Arrays.toString(myArrList3.toArray()));
        System.out.println("contains all: " + myArrList1.containsAll(myArrList3));
    }

    private static void testAddAll() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('c');
        arrList2.add('d');

        System.out.println("ArrayList1: " + arrList1);
        System.out.println("ArrayList2: " + arrList2);
        arrList1.addAll(arrList2);
        System.out.println("added 2 to 1: " + arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('c');
        myArrList2.add('d');

        System.out.println("ArrayList1: " + Arrays.toString(myArrList1.toArray()));
        System.out.println("ArrayList2: " + Arrays.toString(myArrList2.toArray()));
        myArrList1.addAll(myArrList2);
        System.out.println("added 2 to 1: " + Arrays.toString(myArrList1.toArray()));
    }

    private static void testAddAllIndex() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('c');
        arrList2.add('d');

        System.out.println("ArrayList1: " + arrList1);
        System.out.println("ArrayList2: " + arrList2);
        arrList1.addAll(1, arrList2);
        System.out.println("added 2 to 1: " + arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('c');
        myArrList2.add('d');

        System.out.println("ArrayList1: " + Arrays.toString(myArrList1.toArray()));
        System.out.println("ArrayList2: " + Arrays.toString(myArrList2.toArray()));
        myArrList1.addAll(1, myArrList2);
        System.out.println("added 2 to 1: " + Arrays.toString(myArrList1.toArray()));
    }
}
