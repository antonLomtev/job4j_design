package ru.job4j.collection;

public interface SimpleList<T> extends Iterable<T> {
    void add(T value);
    T set(int index, T newValue);
    T remove(int index);
    T het(int index);
    int size();
}
