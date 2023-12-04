package ru.job4j.collection;


import java.util.*;

public class ForwardLinkedList<T> implements ForwardLinked<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    @Override
    public void add(T value) {
        if (size == 0) {
            head = new Node<>(value, null);
        } else {
            Node next = getNodeByIndex(size - 1);
            next.next = new Node(value, null);
        }
        size++;
        modCount++;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).item;
    }

    @Override
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> element = head;
        head = head.next;
        T forDeletion = element.item;
        element.next = null;
        element.item = null;
        modCount++;
        size--;
        return forDeletion;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> next = head;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T node = next.item;
                next = next.next;
                return node;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
