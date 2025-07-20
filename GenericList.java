package com.hocineferradj.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class GenericList<T extends Comparable<T>> implements Iterable<T>, Comparable<GenericList<T>> {
    private int length;
    private T[] items;
    private T[] newItems;
    private int count;

    public GenericList(){
        length = 10;
        items = (T[]) new Comparable[this.length];
    }

    public void add(T item){
        if(count < length)
            items[count++] = item;
        else{
            int oldlength = length;
            length = length * 2;
            newItems = (T[]) new Comparable[length];
            for(int i = 0; i < oldlength; i++){
                if(items[i] != null)
                    newItems[i]  = items[i];
            }
            newItems[count++] = item;
            items = newItems;
        }
    }

    public T get(int index){
        if( index < length ){
            return items[index];
        }else{
            throw new IndexOutOfBoundsException("index bigger than GenericList size!");
        }
        
    }

    public int size(){
        return count;
    }

    public int length(){
        return length;
    }

    public void clear() {
        items = (T[]) new Comparable[10];
        count = 0;
        length = 10;
    }

    public Stream<T> stream(){
        return Arrays.stream(items, 0, count).filter(Objects::nonNull);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {
        private GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list){ // because of 'this'
            this.list = list; 
        }
        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
        
    }

    public List<T> toList(){ // O(n)
        List<T> newList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            newList.add(items[i]);
        }
        return newList;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < count; i++){
            if (i != count - 1)
                sb.append(items[i]).append(", ");
            else
                sb.append(items[i]); 
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(GenericList<T> otherList) {
        // Compare the lists element by element
        int minSize = Math.min(this.size(), otherList.size());
        for (int i = 0; i < minSize; i++) {
            int comparison = this.get(i).compareTo(otherList.get(i));
            if (comparison != 0) {
                return comparison;
            }
        }
        // If all elements are equal up to minSize, the shorter list comes first
        return Integer.compare(this.size(), otherList.size());
    }

}
