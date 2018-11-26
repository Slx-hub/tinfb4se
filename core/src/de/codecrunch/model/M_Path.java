package de.codecrunch.model;

public class M_Path<T> {

    private Node head;
    private Node tail;

    public Node head() {
        return head;
    }

    public Node tail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node addFront(T d) {
        Node h = new Node(d);
        Node old = head;
        head = h;
        if (old != null) {
            head.prev = old;
            old.next = head;
        } else
            tail = h;
        return h;
    }

    public Node addBack(T d) {
        Node t = new Node(d);
        Node old = tail;
        tail = t;
        if (old != null) {
            tail.next = old;
            old.prev = tail;
        } else {
            head = t;
        }
        return t;
    }

    public class Node {
        private T data;
        private Node prev;
        private Node next;

        private Node(T d) {
            data = d;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }

        public T get() {
            return data;
        }

        public Node prev() {
            return prev;
        }

        public Node next() {
            return next;
        }

        public String toString(){
            return data.toString();
        }
    }
}
