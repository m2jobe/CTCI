package com.company;

import java.util.Arrays;

/**
 * Created by muhammedjobe on 2017-04-14.
 * StringBuilder implementation (mutable String)
 * Methods include: append
 */
public class MJStringBuilder {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private char[] stringBuilder;

    //Creates an empty string with intial capacity of 16
    public MJStringBuilder() {
        stringBuilder = new char[DEFAULT_CAPACITY];
    }

    public MJStringBuilder(String str) {
        size = str.length();
        stringBuilder = new char[size + DEFAULT_CAPACITY];
        str.getChars(0, size, stringBuilder, 0);
    }

    public MJStringBuilder(int length) {
        stringBuilder = new char[length];
    }

    public void ensureCapacity( int minLength) {
        if(minLength > stringBuilder.length) {
            int newSize = minLength * 2;
            stringBuilder = Arrays.copyOf(stringBuilder, newSize);
        }
    }

    //Overloading append method
    public void append(String str) {
        ensureCapacity(size + str.length());

        if(str != null)
            str.getChars(0, str.length(), stringBuilder, size);

        size = size+str.length();
    }


    public void append(int i) {
        String numberStr = String.valueOf(i);
        append(numberStr);
    }

    public void append(float f) {
        String numberStr = String.valueOf(f);
        append(numberStr);
    }

    public void append(double d) {
        String numberStr = String.valueOf(d);
        append(numberStr);
    }

    public void append(char c) {
        ensureCapacity(size + 1);
        stringBuilder[size++] = c;
    }

    public void append(boolean bool) {
        String boolStr = String.valueOf(bool);
        append(boolStr);
    }

    //Implementing insert methods, insert(int offset, String)
    //Also overloading insert method
    public void insert(int offset, String str) {

        ensureCapacity(size + str.length());

        if(str != null) {
            str.getChars(0,str.length(), stringBuilder, offset);
        }
        size = size + str.length();
    }

    public void insert(int offset, int i) {
        String str = String.valueOf(i);
        insert(offset, str);
    }

    public void insert(int offset, float f) {
        String str = String.valueOf(f);
        insert(offset, str);
    }

    public void insert(int offset, double d) {
        String str = String.valueOf(d);
        insert(offset, str);
    }

    public void insert(int offset, boolean bool) {
        String str = String.valueOf(bool);
        insert(offset, str);
    }

    public void insert(int offset, char c) {
        String str = String.valueOf(c);
        ensureCapacity(size + 1);

        stringBuilder[size++] = c;
    }

    public void replace(int startIndex, int endIndex, String str) {
        if(startIndex < 0 || startIndex > size || startIndex > endIndex)
            throw new StringIndexOutOfBoundsException(startIndex);

        if (endIndex > size)
            endIndex = size;

        int strLength = str.length();
        ensureCapacity(size + str.length());

        str.getChars(0, strLength, stringBuilder, startIndex);
    }

    public void delete(int startIndex, int endIndex) {
        if(startIndex < 0 || startIndex > size || startIndex > endIndex)
            throw new StringIndexOutOfBoundsException(startIndex);
        if (endIndex > size)
            endIndex = size;

        ensureCapacity(size);

        for(int i=startIndex; i<= endIndex; i++) {
            stringBuilder[i] = stringBuilder[i+1];
            size--;
        }


    }

    public MJStringBuilder reverse() {
        int count=0;
        char[] newStringBuilder = new char[size];

        for(int i = size-1; i >= 0; i--) {
            newStringBuilder[count] = stringBuilder[i];
            count++;
        }
        MJStringBuilder outputString = new MJStringBuilder(String.valueOf(newStringBuilder));
        return outputString;
    }

    public int capacity() {
        return stringBuilder.length;
    }

    public char charAt(int index) {
        return stringBuilder[index];
    }

    public int length() {
        return size;
    }

    public MJStringBuilder substring(int beginIndex) {
        char[] newStringBuilder = new char[size];

        for(int i=0; i< size; i ++) {
            newStringBuilder[i] = stringBuilder[beginIndex];
            beginIndex++;
        }

        MJStringBuilder outputString = new MJStringBuilder(String.valueOf(newStringBuilder));
        return outputString;
    }

    public MJStringBuilder substring(int beginIndex, int endIndex) {

        if(beginIndex < 0 || beginIndex > size || beginIndex > endIndex)
            throw new StringIndexOutOfBoundsException(beginIndex);

        char[] newStringBuilder = new char[size];

        for(int i=0; i< size; i ++) {
            if(beginIndex <= endIndex) {
                newStringBuilder[i] = stringBuilder[beginIndex];
                beginIndex++;
            }
        }

        MJStringBuilder outputString = new MJStringBuilder(String.valueOf(newStringBuilder));
        return outputString;

    }




    public void print() {
        System.out.println(stringBuilder);

    }




}
