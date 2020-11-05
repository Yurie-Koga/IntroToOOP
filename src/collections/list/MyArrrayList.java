package collections.list;

import java.util.*;

/**
 * 1. size vs length :
 *  - size :
 *      - the number of elements.
 *      - not updated when grow elementData.
 *      - updated when add/remove an element from elementData.
 *  - length :
 *      - actual array's length.
 *      - updated when grow elementData.
 *      - counting the number of elements after grow size and before set value to elementData.
 *  - should return ArrayList with the number of size, not the number of length:
 *      - if the capacity = 5 and the number of elements = 2:
 *          size(): 2 -- [1, 2]
 *          length: 5 -- [1, 2, null, null, null]
 *          toArray(): [1, 2] <-- return only the actual elements
 * 2. Arrays.toString(array) :
 *  - return all elements with the length
 *  - so need to be 'Arrays.toString(ArrayList.toArray())' to output only the actual elements.
 */

// public class MyArrayList implements List, RandomAccess {
class MyArrayList implements List, RandomAccess {
    private static final int DEFAULT_SIZE = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public MyArrayList(Collection c) {
        elementData = c.toArray();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator iterator() {
        // no need to implement
        return null;
    }

    /**
     * Return as an array with the actual elements, not the length
     * @return
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        // no need to implement
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
//        System.out.printf("object: %s, object.toString: %s%n", o, o.toString());
//        System.out.printf("size: %d, length: %d%n", size, elementData.length);
//        System.out.println("elementData: " + Arrays.toString(elementData));
        if (size == elementData.length) {
            System.out.println("before grow length: " + Arrays.toString(elementData));
            System.out.println("before grow length toArray: " + Arrays.toString(toArray()));
            elementData = grow(size + 1);
            System.out.println("after grew length: " + Arrays.toString(elementData));
            System.out.println("after grew length toArray: " + Arrays.toString(toArray()));
        }
        elementData[size] = o;
//        System.out.println("added element: " +elementData[size].toString());
//        System.out.println("elementData: " + Arrays.toString(elementData));
        size++;
        return true;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, minCapacity + minCapacity / 2);
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
//        System.out.println("found index: " + index);

        Object[] newElement = new Object[size - 1];
        int i = 0;
        while (i < index) {
            newElement[i] = elementData[i];
            i++;
//            System.out.printf("[%d]: %s, next i: %d%n", i - 1, Arrays.toString(newElement), i);
        }
        while (i < size - 1) {
            newElement[i] = elementData[i + 1];
            i++;
//            System.out.printf("[%d]: %s, next i: %d%n", i - 1, Arrays.toString(newElement), i);
        }

        elementData = newElement;
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c.toArray()) {
            if (indexOf(o) < 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        int newLen = c.size();
        if (newLen == 0)
            return false;
        elementData = grow(size + newLen);
        System.arraycopy(c.toArray(), 0, elementData, size, newLen);
        size += newLen;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        int newLen = c.size();
        if (c.size() == 0) {
            return false;
        }
        // [1 2] <- add [3 4] = [1 3 4 2]   : 2+3=4
        // [1 2] <- add [3 4 5 6] = [1 3 4 5 6 2]: 2+4=6
//        int newLen = size + c.size();

        elementData = grow(size + newLen);
        System.out.println("grew size: " + Arrays.toString(elementData));
        Object[] newElementData = new Object[size + newLen];
        // move to insert elements
        //  - seems better to use new Object
        System.arraycopy(elementData, 0, newElementData, 0, size - index);
        System.out.println("moved1 : " + Arrays.toString(newElementData));
        // so here, should keep the resized size!!
        System.arraycopy(elementData, index, newElementData, index + newLen, size - index);
        System.out.println("moved2 : " + Arrays.toString(newElementData));
        // inside the array, should have null elements with actual resized size.
        // but when you print, no need to print out null elements

        // insert
        System.arraycopy(c.toArray(), 0, elementData, index, newLen);
        size += newLen;
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null)
            return false;
        for (Object o : c.toArray()) {
            if (contains(o)) {
                remove(o);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
