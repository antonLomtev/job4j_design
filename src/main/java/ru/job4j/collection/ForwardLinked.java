package ru.job4j.collection;

public interface ForwardLinked<T> extends Iterable<T> {
    void add(T value);

    T get(int index);

    T deleteFirst();
}
