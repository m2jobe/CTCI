package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MJStringBuilder testString = new MJStringBuilder(2);
        testString.append("Hello");
        testString.print();
        testString.append(12);
        testString.append(0.54);
        testString.append(true);
        testString.append('d');
        testString.append('-');

        testString.print();
        testString.insert(1,"lol");
        testString.print();

        testString.replace(1 , 3, "tst");
        testString.print();

        testString = testString.substring(2, 6);
        testString.print();

        testString = testString.reverse();

        testString.print();
    }
}

