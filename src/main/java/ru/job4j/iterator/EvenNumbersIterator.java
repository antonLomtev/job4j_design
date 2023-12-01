package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    @Override
    public boolean hasNext() {
        return EvenNumbersIterator.this.findEven(this.index) >= 0;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = EvenNumbersIterator.this.findEven(this.index);
        return EvenNumbersIterator.this.data[this.index++];
    }

    private int findEven(int start) {
        int rsl = -1;
        for (int i = start; i != this.data.length; i++) {
            if (this.data[i] % 2 == 0) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
