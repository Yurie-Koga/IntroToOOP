package collections.list;

import java.util.*;
import java.util.stream.Collectors;

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
        if (size == elementData.length) {
            elementData = grow(size + 1);
        }
        elementData[size] = o;
//        System.out.println(elementData[size].toString());
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
        if (newLen == 0)
            return false;

        elementData = grow(size + index + newLen);
        System.out.println("grew size: " + Arrays.toString(elementData));
        // move to insert elements
        //  - seems better to use new Object
        System.arraycopy(elementData, index, elementData, index+ newLen, size);
        System.out.println("moved : " + Arrays.toString(elementData));
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
