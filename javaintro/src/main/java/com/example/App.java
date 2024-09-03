package com.example;

import java.util.ArrayList;

public class App {
    // Variables and Types
    /*
     * This is a variable declaration. The variable is called
     * and output is shown below
     */
    static int secretOfLife = 10;
    static short moneyInBalance = 100;
    static long distanceToSun = 149600000L;
    static float pi = 3.14f;
    static String name = "John Doe";
    static char grade = 'A';
    static boolean alwaysTrue = true;
    static double distanceToMoon = 238855.0;

    // Arrays
    /*
     * Arrays can only store a finite amount of values
     * aka elements. The size of the array is fixed
     * It can only store one datatype and the indexing
     * starts from 0
     */
    static int[] numbers = { 1, 2, 3 };

    // ArrayList
    static ArrayList<Integer> numbersList = new ArrayList<Integer>();

    public static void main(String[] args) {
        // Variables and Types
        System.out.println("Hello World!");
        System.out.println("int = " + secretOfLife);
        System.out.println("short = " + moneyInBalance);
        System.out.println("long = " + distanceToSun);
        System.out.println("float = " + pi);
        System.out.println("String = " + name);
        System.out.println("char = " + grade);
        System.out.println("boolean = " + alwaysTrue);
        System.out.println("double = " + distanceToMoon);

        // Calling the array
        System.out.println("numbers = " + numbers);
        System.out.println("numbers[0] = " + numbers[0]);
        System.out.println("numbers[1] = " + numbers[1]);
        System.out.println("numbers[2] = " + numbers[2]);

        // Accessing the ArrayList
        numbersList.add(111);
        numbersList.add(222);
        numbersList.add(333);
        System.out.println("numbersList = " + numbersList);
        System.out.println("numbersList get first element = " + numbersList.get(0));
        System.out.println("numbersList get second element = " + numbersList.get(1));
        System.out.println("numbersList get third element = " + numbersList.get(2));

        // Referencing a method
        System.out.println("isTrue() = " + isTrue());
        System.out.println("isFalse() = " + isFalse());

    }

    public static boolean isTrue() {
        return true;
    }

    public static boolean isFalse() {
        return false;
    }
}
