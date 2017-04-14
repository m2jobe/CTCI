package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MJArrayList<Integer> testList = new MJArrayList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.print();
        testList.remove(4);
        testList.print();
        testList.add(500);
        testList.print();
    }
}
