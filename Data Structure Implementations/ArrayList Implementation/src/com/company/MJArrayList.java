package com.company;

import java.util.Arrays;

/**
 * Created by muhammedjobe on 2017-04-14.
 * Implementing a resizeable Array capable of adding, removing, retrieving items in an array
 * Using generics to ensure that the arraylist works for any and all types
 */
public class MJArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPAITY = 10;
    private Object arrayList[];

    public MJArrayList() {
        arrayList = new Object[DEFAULT_CAPAITY];
    }

    public void add(E e) {
        if(size == arrayList.length)
            increaseCapacity();
        arrayList[size] = e;
        size++;
    }

    public void increaseCapacity() {
        int newSize = arrayList.length * 2;
        arrayList = Arrays.copyOf(arrayList, newSize);
    }

    public E get(int i ) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds, you are trying to retreive index " + i );
        }
        return (E) arrayList[i];
    }

    public void remove (int i) {
        if (i < 0 || i >= size )
            throw new IndexOutOfBoundsException("Index is out of bounds");
        arrayList[i] = null;
        int tempIndex = i;
        while (tempIndex < size) {
            arrayList[tempIndex] = arrayList[i+1];
            arrayList[tempIndex+1] = null;
            tempIndex++;
        }
        size--;
    }

    public void print() {
        for(int i = 0; i < size; i ++) {
            System.out.println(arrayList[i]);
        }
    }
}
