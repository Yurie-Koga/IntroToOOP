package collections.list;

// inner class: need to create instance for MyLinkedList instance.
// it's unnecessary. just use static nested class.
//public class MyLinkedList {
//    class Node2 {
//        Object data;
//        Node2 next;
//    }
//}

/**
 * Singly Linked-List (Generic Type)
 * - <E> stands for Element
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node<E> head, tail;     // declared as null
    private int size;

    public MyLinkedList() {
    }

    // O(1)
    public void addFirst(E e) {
        final Node<E> h = head;
        final Node<E> newNode = new Node<>(e, h);
        head = newNode;
        if (h == null) {
            // adding a new node to the empty linked list
            tail = newNode;
        }
        size++;
    }

    // O(1)
    public void addLast(E e) {
        final Node<E> t = tail;
        final Node<E> newNode = new Node<>(e, null);
        tail = newNode;
        if (t == null) {
            // adding a new node to the empty linked list
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;
    }

    // O(n)
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = new Node<>(e, cur.next);
            size++;
        }
    }

    // O(1)
    public E removeFirst() {
        final Node<E> h = head;
        if (h == null) {
            // removing from the empty linked list
            throw new NoSuchElementException("list is empty");
        }

        E data = h.data;
        Node<E> temp = h.next;
        h.data = null;
        h.next = null;
        head = temp;
        if (temp == null) {
            // only one element is in the list
            tail = null;
        }
        size--;
        return data;
    }

    // O(1)
    public E removeLast() {
        final Node<E> t = tail;
        if (t == null) {
            // removing from the empty linked list
            throw new NoSuchElementException("list is empty");
        }

        E data = t.data;
        // get the node prior to tail
        tail = getNodeAt(size - 2);
        tail.next = null;
        size--;
//        System.out.println("size removeLast: " + size);
        return data;
    }

    // O(1)
    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("list is empty");
        }
        return head.data;
    }

    // O(1)
    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException("list is empty");
        }
        return tail.data;
    }

    private Node<E> getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
//        System.out.printf("getNodeAt(%d): %s%n", index, cur.data);
        return cur;
    }

    // O(n)
    public E get(int index) {
        return getNodeAt(index).data;
    }

    //O(n)
    public E set(int index, E e) {
        Node<E> cur = getNodeAt(index);
        E oldValue = cur.data;
        cur.data = e;
        return oldValue;
    }

    //O(n)
    public int indexOf(E e) {
        return indexOf(e, 0, false);
    }

    /**
     * @param e          target element which needs to be found
     * @param startIndex a number of index where to start searching in the list
     * @param toLast     boolean if to continue to search after an index found
     * @return
     */
    public int indexOf(E e, int startIndex, boolean toLast) {
        int index = 0;
        int found = -1;
        if (e == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.data == null && index >= startIndex) {
                    found = index;
                    if (!toLast || index == size - 1)
                        return found;
                }
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (e.equals(x.data) && index >= startIndex) {
                    found = index;
                    if (!toLast || index == size - 1)
                        return found;
                }
                index++;
            }
        }
        return found;
    }

    public int size() {
        return size;
    }

    /**
     * Remove the element e from the list
     *
     * @param e
     * @return
     */
    public boolean remove(E e) {
        int target = indexOf(e);
        remove(target);
        return true;
    }

    /**
     * Remove the element at index
     * O(N)
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        if (index < 0)
            return false;
        if (index == 0) {
            removeFirst();
//            System.out.println("called removeFirst()");
            return true;
        }
        if (index == size - 1) {
            removeLast();
//            System.out.println("called removeLast()");
            return true;
        }

        Node<E> before = getNodeAt(index - 1);
        Node<E> after = getNodeAt(index + 1);
        Node<E> n = getNodeAt(index);
        n = null;

        before.next = after;
        size--;
        return true;
    }

    /**
     * Returns the index of the last occurrence of element e
     * O(N)
     * <p>
     * ll = [1, 1, 2, 3, 1, 5, 1, 2]
     * ll.lastIndexOf(1) -> 6
     *
     * @param e
     * @return the index of the last occurrence of element e
     */
    public int lastIndexOf(E e) {
        return indexOf(e, 0, true);
    }

    /**
     * Reverses the current linked list
     * "A" -> "B" -> "C" -> null
     * should be
     * "C" -> "B" -> "A" -> null
     * <p>
     * Lists by steps
     * 1. the original elements                        : [a, b, c, d]
     * 2. add the reversed original elements to the end: [a, b, c, d, c, b, a]
     * 3. remove the original elements at the beginning:          [d, c, b, a]
     */
    public boolean reverse() {
        if (head == null || tail == null) {
            throw new NoSuchElementException("list is empty");
        }

        int orgSize = size;
//        System.out.println("size original elements: " + size);
//        System.out.printf("head = %s, tail = %s%n", head.data, tail.data);

        // add the reversed original elements to the end
        // - start from index = size-2: no need to add the last element, tail will be head
        for (int i = orgSize - 2; i >= 0; i--) {
            E data = getNodeAt(i).data;
            addLast(data);
        }
//        System.out.println("size added reversed elements: " + size);
//        System.out.println("added reversed elements: " + toString());
//        System.out.printf("head = %s, tail = %s%n", head.data, tail.data);

        // remove the original elements at the beginning
        // - end at index = size-2: no need to remove the last element, tail will be head
        for (int i = 0; i < orgSize - 1; i++) {
            removeFirst();
        }
//        System.out.println("size removed original elements: " + size);
//        System.out.printf("head = %s, tail = %s%n", head.data, tail.data);
        return false;
    }

    // O(N)
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    /**
     * Return LinkedList as string of array: e.g. [1, 2, 3]
     *
     * @return
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * Convert LinkedList to an array
     *
     * @return
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
//        System.out.println("size toArray: " + size);
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
//            System.out.println("index[" + i + "]");
            result[i++] = x.data;
        }
        return result;
    }

    // Nested class: which is used inside tha class
    // static nested class: no need to create instance, also can create instance.
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
