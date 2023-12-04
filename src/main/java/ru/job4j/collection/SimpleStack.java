package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinkedList<T> linked = new ForwardLinkedList<>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
