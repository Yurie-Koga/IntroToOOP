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
//        testRemoveObj();
//        testRemoveAll();
//        testContainsAll();
//        testAddAll();
//        testAddAllIndex();
//        testRetainAll();
//        testClear();
//        testGet();
//        testSet();
//        testAddIndex();
//        testRemoveIndex();
//        testIndexOf();
//        testLastIndexOf();
//        testSubList();
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
        arrList.add('t');
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
        myArrList.add('t');
        myArrList.add('j');
        System.out.println(myArrList);
        Object obj = 'h';
        myArrList.remove(obj);
        System.out.printf("removed : %s %s%n", obj.toString(), myArrList);
        obj = 'j';
        myArrList.remove(obj);
        System.out.printf("removed : %s %s%n", obj.toString(), myArrList);
        obj = 'k';
        myArrList.remove(obj);
        System.out.printf("removed : %s %s%n", obj.toString(), myArrList);
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
        arrList2.add('z');

        System.out.println("before:  " + arrList1);
        arrList1.removeAll(arrList2);
        System.out.println("removed: " + arrList2);
        System.out.println("after :  " + arrList1);


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
        myArrList2.add('z');

        System.out.println("before:  " + myArrList1);
        myArrList1.removeAll(myArrList2);
        System.out.println("removed: " + myArrList2);
        System.out.println("after :  " + myArrList1);
    }

    private static void testContainsAll() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        arrList1.add('e');
        System.out.printf("ArrayList1 : %s%n", arrList1);

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('d');  // no need to be the same order
        arrList2.add('b');
        System.out.printf("containsAll: %s --> %s%n", arrList2, arrList1.containsAll(arrList2));

        ArrayList<Character> arrList3 = new ArrayList<>();
        arrList3.add('a');
        arrList3.add('z');
        System.out.printf("containsAll: %s --> %s%n", arrList3, arrList1.containsAll(arrList3));

        ArrayList<Character> arrList4 = new ArrayList<>();
        System.out.printf("containsAll: %s --> %s%n", arrList4, arrList1.containsAll(arrList4));


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        myArrList1.add('e');
        System.out.println("ArrayList1: " + myArrList1);

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('d');
        myArrList2.add('b');
        System.out.printf("containsAll: %s --> %s%n", myArrList2, myArrList1.containsAll(myArrList2));

        MyArrayList myArrList3 = new MyArrayList();
        myArrList3.add('a');
        myArrList3.add('z');
        System.out.printf("containsAll: %s --> %s%n", myArrList3, myArrList1.containsAll(myArrList3));

        MyArrayList myArrList4 = new MyArrayList();
        System.out.printf("containsAll: %s --> %s%n", myArrList4, myArrList1.containsAll(myArrList4));
    }

    private static void testAddAll() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        System.out.println("ArrayList1:   " + arrList1);

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('c');
        arrList2.add('d');
        System.out.println("ArrayList2:   " + arrList2);
        arrList1.addAll(arrList2);
        System.out.println("added 2 to 1: " + arrList1);

        ArrayList<Character> arrList3 = new ArrayList<>();
        System.out.println("ArrayList2:   " + arrList3);
        arrList1.addAll(arrList3);
        System.out.println("added 2 to 1: " + arrList1);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        System.out.println("ArrayList1:   " + myArrList1);

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('c');
        myArrList2.add('d');
        System.out.println("ArrayList2:   " + myArrList2);
        myArrList1.addAll(myArrList2);
        System.out.println("added 2 to 1: " + myArrList1);
        myArrList2.add('d');
        myArrList2.add('d');
        myArrList2.add('d');
        myArrList2.add('d');
        myArrList2.add('d');
        myArrList2.add('d');
        myArrList2.add('d');
        System.out.println("ArrayList2:   " + myArrList2);
        myArrList1.addAll(myArrList2);
        System.out.println("added 2 to 1: " + myArrList1);

        MyArrayList myArrList3 = new MyArrayList();
        System.out.println("ArrayList2:   " + myArrList3);
        myArrList1.addAll(myArrList3);
        System.out.println("added 2 to 1: " + myArrList1);
    }

    private static void testAddAllIndex() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        System.out.println("ArrayList1:   " + arrList1);

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('c');
        arrList2.add('d');
        System.out.println("ArrayList2:   " + arrList2);
        arrList1.addAll(1, arrList2);
        System.out.println("added 2 to 1: " + arrList1);
        arrList2.add('d');
        arrList2.add('d');
        arrList2.add('y');
        System.out.println("ArrayList2:   " + arrList2);
        arrList1.addAll(4, arrList2);
        System.out.println("added 2 to 1: " + arrList1);

//        ArrayList<Character> arrList3 = new ArrayList<>();
//        arrList3.add('z');
//        System.out.println("ArrayList2:   " + arrList3);
        // throw exception if index > ArrayList.size()
//        arrList1.addAll(10, arrList3);
//        System.out.println("added 2 to 1: " + arrList1);

//        ArrayList<Character> arrList3 = new ArrayList<>();
//        arrList3.add('x');
//        System.out.println("ArrayList2:   " + arrList3);
//        arrList1.addAll(100, arrList3);
//        System.out.println("added 2 to 1: " + arrList1);

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        System.out.println("ArrayList1:   " + myArrList1);

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('c');
        myArrList2.add('d');
        System.out.println("ArrayList2:   " + myArrList2);
        myArrList1.addAll(1, myArrList2);
        System.out.println("added 2 to 1: " + myArrList1);
        myArrList2.add('d');
        myArrList2.add('d');
        myArrList2.add('y');
        System.out.println("ArrayList2:   " + myArrList2);
        myArrList1.addAll(4, myArrList2);
        System.out.println("added 2 to 1: " + myArrList1);

//        MyArrayList myArrList3 = new MyArrayList();
//        myArrList3.add('z');
//        System.out.println("ArrayList2:   " + myArrList3);
        // throw exception if index > ArrayList.size()
//        myArrList1.addAll(10, myArrList3);
//        System.out.println("added 2 to 1: " + myArrList1);

//        MyArrayList myArrList3 = new MyArrayList();
//        myArrList3.add('x');
//        System.out.println("ArrayList2:   " + myArrList3);
//        myArrList1.addAll(100, myArrList3);
//        System.out.println("added 2 to 1: " + myArrList1);
    }

    private static void testRetainAll() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');

        System.out.println("ArrayList1:   " + arrList1);

        ArrayList<Character> arrList2 = new ArrayList<>();
        arrList2.add('c');
        arrList2.add('a');
        arrList2.add('z');
        System.out.println("ArrayList2:   " + arrList2);

        arrList1.retainAll(arrList2);
        System.out.println("retain ArrayList2 of ArrayList1:" + arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        System.out.println("ArrayList1:   " + myArrList1);

        MyArrayList myArrList2 = new MyArrayList();
        myArrList2.add('c');
        myArrList2.add('a');
        myArrList2.add('z');
        System.out.println("ArrayList2:   " + myArrList2);

        myArrList1.retainAll(myArrList2);
        System.out.println("retain ArrayList2 of ArrayList1:" + myArrList1);
    }

    private static void testClear() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');

        System.out.println("ArrayList1:   " + arrList1);
        arrList1.clear();
        System.out.println("cleared   :   " + arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        System.out.println("ArrayList1:   " + myArrList1);

        myArrList1.clear();
        System.out.println("cleared   :   " + myArrList1);
    }

    private static void testGet() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        System.out.println("ArrayList1:   " + arrList1);
        System.out.printf("Index [%d]: %s%n", 2, arrList1.get(2));
        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 100 out of bounds for length 4
//        System.out.printf("Index [%d]: %s%n", 2, arrList1.get(100));


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        System.out.println("ArrayList1:   " + myArrList1);
        System.out.printf("Index [%d]: %s%n", 2, myArrList1.get(2));
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 10
//        System.out.printf("Index [%d]: %s%n", 2, myArrList1.get(100));
    }

    private static void testSet() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        System.out.println("ArrayList1:   " + arrList1);
        arrList1.set(2, 'z');
        System.out.printf("set [%d] '%s':  %s%n", 2, 'z', arrList1);
        arrList1.set(3, null);
        System.out.printf("set [%d] '%s':  %s%n", 3, null, arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        System.out.println("ArrayList1:   " + myArrList1);
        myArrList1.set(2, 'z');
        System.out.printf("set [%d] '%s':  %s%n", 2, 'z', myArrList1);
        myArrList1.set(3, null);
        System.out.printf("set [%d] '%s':  %s%n", 3, null, myArrList1);
    }

    private static void testAddIndex() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        System.out.println("ArrayList1:   " + arrList1);
        arrList1.add(3, 'z');
        System.out.printf("add [%d] '%s':  %s%n", 3, 'z', arrList1);
        arrList1.add(4, null);
        System.out.printf("add [%d] '%s':  %s%n", 4, null, arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        System.out.println("ArrayList1:   " + myArrList1);
        myArrList1.add(3, 'z');
        System.out.printf("set [%d] '%s':  %s%n", 3, 'z', myArrList1);
        myArrList1.add(4, null);
        System.out.printf("set [%d] '%s':  %s%n", 4, null, myArrList1);
    }

    private static void testRemoveIndex() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        System.out.println("ArrayList1:   " + arrList1);
        arrList1.remove(2);
        System.out.printf("remove [%d]:   %s%n", 2, arrList1);


        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        System.out.println("ArrayList1:   " + myArrList1);
        myArrList1.remove(2);
        System.out.printf("remove [%d]:   %s%n", 2, myArrList1);
    }

    private static void testIndexOf() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        System.out.println("ArrayList1:   " + arrList1);
        System.out.printf("index of '%s': %s%n", 'b', arrList1.indexOf('b'));

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        System.out.println("ArrayList1:   " + myArrList1);
        System.out.printf("index of '%s': %s%n", 'b', myArrList1.indexOf('b'));
    }

    private static void testLastIndexOf() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('b');
        arrList1.add('a');
        System.out.println("ArrayList1:   " + arrList1);
        System.out.printf("last index of '%s': %s%n", 'b', arrList1.lastIndexOf('b'));
        System.out.printf("last index of '%s': %s%n", 'c', arrList1.lastIndexOf('c'));
        System.out.printf("last index of '%s': %s%n", 'z', arrList1.lastIndexOf('z'));

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('b');
        myArrList1.add('a');
        System.out.println("ArrayList1:   " + myArrList1);
        System.out.printf("last index of '%s': %s%n", 'b', myArrList1.lastIndexOf('b'));
        System.out.printf("last index of '%s': %s%n", 'c', myArrList1.lastIndexOf('c'));
        System.out.printf("last index of '%s': %s%n", 'z', myArrList1.lastIndexOf('z'));
    }

    private static void testSubList() {
        System.out.println("----- ArrayList -----");
        ArrayList<Character> arrList1 = new ArrayList<>();
        arrList1.add('a');
        arrList1.add('b');
        arrList1.add('c');
        arrList1.add('d');
        arrList1.add('e');
        System.out.println("ArrayList1:   " + arrList1);
        System.out.printf("sublist %d to %d: %s%n", 2, 4, arrList1.subList(2, 4));
//        System.out.printf("sublist %d to %d: %s%n", 2, 100, arrList1.subList(2, 100));
//        System.out.printf("sublist %d to %d: %s%n", 3, 1, arrList1.subList(3, 1));

        System.out.println("----- MyArrayList -----");
        MyArrayList myArrList1 = new MyArrayList();
        myArrList1.add('a');
        myArrList1.add('b');
        myArrList1.add('c');
        myArrList1.add('d');
        myArrList1.add('e');
        System.out.println("ArrayList1:   " + myArrList1);
        System.out.printf("sublist %d to %d: %s%n", 2, 4, myArrList1.subList(2, 4));
//        System.out.printf("sublist %d to %d: %s%n", 2,100, myArrList1.subList(2, 100));
//        System.out.printf("sublist %d to %d: %s%n", 3, 1, myArrList1.subList(3, 1));
    }
}
