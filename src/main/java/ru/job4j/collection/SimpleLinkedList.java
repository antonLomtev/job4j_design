package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements SimpleLinked<E> {
    private int size;
    private int modCount;
    private Node<E> head;

    @Override
    public void add(E value) {
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
    public E get(int index) {
        return getNodeByIndex(index).item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> next = head;
            final int expectedModCount = modCount;
            int index;
            @Override
            public boolean hasNext() {
                if ( expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E node = next.item;
                next = next.next;
                index++;
                return node;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private Node<E> getNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
