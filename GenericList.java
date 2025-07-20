package com.hocineferradj.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * A generic resizable list implementation for elements that are Comparable.
 * 
 * @param <T> the type of elements in this list
 */
public class GenericList<T extends Comparable<T>> implements Iterable<T>, Comparable<GenericList<T>> {
    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private T[] items;
    private int count;

    /**
     * Constructs an empty list with the default initial capacity.
     */
    @SuppressWarnings("unchecked")
    public GenericList() {
        capacity = DEFAULT_CAPACITY;
        items = (T[]) new Comparable[capacity];
        count = 0;
    }

    /**
     * Adds an item to the list, resizing if necessary.
     * @param item the item to add
     */
    @SuppressWarnings("unchecked")
    public void add(T item) {
        if (count == capacity) {
            capacity *= 2;
            T[] newItems = (T[]) new Comparable[capacity];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        items[count++] = item;
    }

    /**
     * Gets the item at the specified index.
     * @param index the index
     * @return the item
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return items[index];
    }

    /**
     * Returns the number of elements in the list.
     * @return the size
     */
    public int size() {
        return count;
    }

    /**
     * Returns the current capacity of the internal array.
     * @return the capacity
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Removes all elements from the list.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        items = (T[]) new Comparable[DEFAULT_CAPACITY];
        count = 0;
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Returns a Stream of the elements in the list.
     * @return a Stream of elements
     */
    public Stream<T> stream() {
        return Arrays.stream(items, 0, count).filter(Objects::nonNull);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Converts this list to a standard Java List.
     * @return a new List containing the elements
     */
    public List<T> toList() {
        List<T> newList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            newList.add(items[i]);
        }
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(items[i]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(GenericList<T> otherList) {
        int minSize = Math.min(this.size(), otherList.size());
        for (int i = 0; i < minSize; i++) {
            int comparison = this.get(i).compareTo(otherList.get(i));
            if (comparison != 0) return comparison;
        }
        return Integer.compare(this.size(), otherList.size());
    }

    private class ListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public T next() {
            return items[index++];
        }
    }
}
