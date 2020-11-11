package collections.list;

import java.util.*;

/**
 * 1. size vs length :
 * - size :
 * -- the number of elements.
 * -- not updated when grow elementData.
 * -- updated when add/remove an element from elementData.
 * <p>
 * - length :
 * -- actual array's length.
 * -- updated when grow elementData.
 * -- counting the number of elements after grow size and before set value to elementData.
 * <p>
 * - should return ArrayList with the number of size, not the number of length:
 * -- if the capacity = 5 and the number of elements = 2:
 * >>size(): 2 -- [1, 2]
 * >>length: 5 -- [1, 2, null, null, null]
 * >>toArray(): [1, 2] <-- return only the actual elements
 * <p>
 * 2. Arrays.toString(array) :
 * - return all elements with the length
 * - so need to be 'Arrays.toString(ArrayList.toArray())' to output only the actual elements.
 */
public class MyArrayList implements List, RandomAccess {
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

    /**
     * Return elements in a format of '[1, 2, 3, 4]'
     * Override toString() in Object class which returns in a format 'collections.list.MyArrayList@3e3abc88'
     *
     * @return
     */
    @Override
    public String toString() {
        return toString(toArray());
    }

    public String toString(Object[] o) {
        return Arrays.toString(o);
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
     *
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
//            System.out.println("before grow length: " + Arrays.toString(elementData));
//            System.out.println("before grow length toArray: " + Arrays.toString(toArray()));
            elementData = grow(size + 1);
//            System.out.println("after grew length: " + Arrays.toString(elementData));
//            System.out.println("after grew length toArray: " + Arrays.toString(toArray()));
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

    /**
     * Remove an element
     * even multiple same elements are found, remove only the first one
     * Ues remove(index) since the logic is exactly the same.
     *
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
//        System.out.println("found index: " + index);

        remove(index);
        return true;
    }

    /**
     * Return 'true' if Collection c is null.
     *
     * @param c
     * @return
     */
    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c.toArray()) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        int newLen = c.size();
        if (newLen == 0)
            return false;
        if (size + newLen > elementData.length) {
//            System.out.printf("before grow: length: %d %s%n", elementData.length, Arrays.toString(elementData));
            elementData = grow(size + newLen);
//            System.out.printf("after grow : length: %d %s%n", elementData.length, Arrays.toString(elementData));
        }
        System.arraycopy(c.toArray(), 0, elementData, size, newLen);
        size += newLen;
        return true;
    }

    /**
     * The original ArrayList: throw exception if index > ArrayList.size()
     * Better to implement a code to check range first
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, Collection c) {
        int newLen = c.size();
        if (newLen == 0) {
            return false;
        }
//        System.out.println("newLen: " + newLen);

        if (size + newLen > elementData.length) {
//            System.out.printf("before grow: length: %d %s%n", elementData.length, Arrays.toString(elementData));
            elementData = grow(size + newLen + index);
//            System.out.printf("after grow : length: %d %s%n", elementData.length, Arrays.toString(elementData));
        }

        Object[] newElementData = new Object[elementData.length];
        // copy elements before index
        System.arraycopy(elementData, 0, newElementData, 0, index);
//        System.out.println("copy1 : " + Arrays.toString(newElementData));

        // copy elements after index
//        if (size > index) {   // temporally if index > size, error will happen here
        System.arraycopy(elementData, index, newElementData, index + newLen, size - index);
//            System.out.println("copy2 : " + Arrays.toString(newElementData));
//        }
        // insert new elements
        System.arraycopy(c.toArray(), 0, newElementData, index, newLen);
//        System.out.println("insert: " + Arrays.toString(newElementData));

        elementData = newElementData;
        size += newLen;
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null)
            return false;
        for (Object o : c.toArray()) {
            remove(o);
        }
        return true;
    }

    /**
     * Remove all elements that are not contained the collection passes as parameter.
     * --> retain elements if it is included in both collections.
     *
     * @param c
     * @return
     */
    @Override
    public boolean retainAll(Collection c) {
        if (c == null)
            return false;

        boolean found;
        for (int i = 0; i < size; i++) {
            found = false;
            for (Object o : c.toArray()) {
                if (elementData[i].equals(o)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                remove(i);
        }
        return true;
    }

    /**
     * Do not change the length of elementData.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Did not add index range check, but Exception is being thrown as same as ArrayList class.
     *
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elementData[index];
    }

    /**
     * Replace the element at the specific index.
     * Set null if 'element' is null.
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elementData[index] = element;
    }

    /**
     * Use addAll(index, Collection) since the logic is exactly the same.
     * Call addAll even when 'element' is null since ArrayList class add 'null'.
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Object element) {
        addAll(index, Arrays.asList(element));
    }

    /**
     * @param index
     * @return the element that was removed.
     */
    @Override
    public Object remove(int index) {
        if (index == -1)
            return null;
//        System.out.println("found index: " + index);

        Object removedElement = get(index);
        Object[] newElement = new Object[elementData.length - 1];
//        System.out.printf("original: length: %d %s%n", elementData.length, Arrays.toString(elementData));
//        System.out.printf("new     : length: %d %s%n", newElement.length, Arrays.toString(newElement));

        // copy elements before found index
        System.arraycopy(elementData, 0, newElement, 0, index);
//        System.out.printf("original: length: %d %s%n", elementData.length, Arrays.toString(elementData));
//        System.out.printf("new     : length: %d %s%n", newElement.length, Arrays.toString(newElement));

        // copy elements after found index
        System.arraycopy(elementData, index + 1, newElement, index, newElement.length - index);
//        System.out.printf("original: length: %d %s%n", elementData.length, Arrays.toString(elementData));
//        System.out.printf("new     : length: %d %s%n", newElement.length, Arrays.toString(newElement));

        elementData = newElement;
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        return indexOf(o, 0, false);
    }

    /**
     * Return index of element.
     *
     * @param o          target element which needs to be found
     * @param startIndex a number of index where to start searching in the list
     * @param toLast     boolean if to continue to search after an index found
     * @return
     */
    public int indexOf(Object o, int startIndex, boolean toLast) {
        int found = -1;
        for (int i = startIndex; i < size; i++) {
            if (o.equals(elementData[i])) {
                if (!toLast)
                    return i;
                else
                    found = i;
            }
        }
        return found;
    }

    @Override
    public int lastIndexOf(Object o) {
        return indexOf(o, 0, true);
    }

    @Override
    public ListIterator listIterator() {
        // No need to implement
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        // No need to implement
        return null;
    }

    /**
     * Better to add range check first.
     * --> currently, arraycopy throws exceptions
     *
     * @param fromIndex
     * @param toIndex
     * @return
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        int len = toIndex - fromIndex;
        Object[] obj = new Object[len];
        System.arraycopy(elementData, fromIndex, obj, 0, len);
        return Arrays.asList(obj);
    }
}
