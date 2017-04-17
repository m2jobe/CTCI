package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// Testing chapter 1 methods here

        //isUnique method
        System.out.println("True or false String 'Good'  is unqiue: " + isUnique("Good"));
        System.out.println("True or false String 'PeterPan'  is unqiue: " + isUnique("PeterPan"));
        System.out.println("True or false String 'works'  is unqiue: " + isUnique("works"));
        System.out.println(checkPermutation("Tfst", "Test"));
        System.out.println(urlify("Muhammed Jobe"));

    }


    public static boolean isUnique(String str)  {

        if(str.length() > 128)
            return false;


        boolean[] character_set = new boolean[128];

        for(int i =0; i<str.length(); i++) {
            int value = str.charAt(i);
            if(character_set[value])
                return false;
            character_set[value] = true;
        }

        return true;
    }


    public static boolean checkPermutation(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        if(new String(charArr1).equals(new String(charArr2)))
            return true;

        return false;
    }

    public static String urlify(String str) {
        String output= "";
        char[] charArray = str.toCharArray();

        for(int i =0; i< charArray.length; i++) {
            if(charArray[i] == ' ')
                output += "%20";
            else
                output += charArray[i];
        }
        return output;
    }

}
