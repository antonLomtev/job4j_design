package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean check = false;
        if (cursor.hasNext()) {
            check = true;
        } else if (data.hasNext()) {
                cursor = data.next();
                check = this.hasNext();
        }
        return check;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap flatMap = new FlatMap(data);
        while (flatMap.hasNext()) {
            System.out.println(flatMap.next());
        }
    }
}
