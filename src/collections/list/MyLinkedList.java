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

import java.util.NoSuchElementException;

/**
 * Draw diagram to make sure what is going on!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * @param <E>
 */
public class MyLinkedList<E> {
    private Node<E> head, tail;     // declared as null
    private int size;

    public MyLinkedList() {
    }

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

    public E removeLast(){
        return null;
    }

    // O(1)
    public E getFirst(){
        return null;
    }
    // O(1)
    public E getLast(){
return null;
    }
    // O(n)
    public E get(int index){
return null;
    }
    //O(n)
    public E set(int index, E e){
return null;
    }
    //O(n)
    public int indexOf(E e){
        if(e==null){
//            return -1;
            for(Node<E> x = head;x!=null;x=x.next){
                if(x.equals(null)){

                }
            }
        }
        Node<E> cur = head;
        for(int i = 0;i<size;i++){

//            if(e.equals(head.data))
        }
        return 0;
    }

    public int size(){
        return size;
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
