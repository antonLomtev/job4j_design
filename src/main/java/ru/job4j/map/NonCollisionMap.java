package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    public static void main(String[] args) {
        NonCollisionMap<Integer, Integer> map = new NonCollisionMap<>();
        System.out.println("hash 0 = " + map.hash(0));
        System.out.println("hash 65535 = " + map.hash(65535));
        System.out.println("hash 65536 = " + map.hash(65536));
        System.out.println("indexFor 0 = " + map.indexFor(0));
        System.out.println("indexFor 7 = " + map.indexFor(7));
        System.out.println("indexFor 8 = " + map.indexFor(8));
        System.out.println((float) (map.count) / map.capacity >= LOAD_FACTOR);
        System.out.println(map.hash(Objects.hashCode(null)));
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] growTable = new MapEntry[capacity];
        for (MapEntry<K, V> key : table) {
            if (key != null) {
                int index = getIndex(key.key);
                if (growTable[index] == null) {
                    growTable[index] = new MapEntry<>(key.key, key.value);
                }
            }
        }
        table = growTable;
    }

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = getIndex(key);
        boolean result = table[index] == null;
        if (result) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return result;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        MapEntry<K, V> result = table[index];
        return check(key, index) ? result.value : null;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        boolean checkKey = check(key, index);
        if (checkKey) {
            table[index] = null;
            count--;
            modCount++;
        }
        return checkKey;
    }

    private boolean check(K key, int index) {
        MapEntry<K, V> result = table[index];
        return result != null && Objects.hashCode(key) == Objects.hashCode(result.key) && Objects.equals(key, result.key);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index = 0;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
