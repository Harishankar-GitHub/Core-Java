package com.company;

public class Main {

    public static void main(String[] args) {

        // Single precision occupies 32 bits
        // Double precision occupies 64 bits
        
	    float myMinFloatValue = Float.MIN_VALUE;
	    float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value : " + myMinFloatValue);
        System.out.println("Float maximum value : " + myMaxFloatValue);
        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value : " + myMinDoubleValue);
        System.out.println("Double maximum value : " + myMaxDoubleValue);

        int intValue = 5 / 3;
        float floatValue = 5f / 3f;
        double doubleValue = 5.00 / 3.00;
        // Good practice to put f & d for Float & Double.
        // Using Double is preferred.

        System.out.println("MyIntValue : " + intValue);
        System.out.println("MyFloatValue : " + floatValue);
        System.out.println("DoubleValue : " + doubleValue);

        double noOfPounds = 200d;
        double convertedKilograms = noOfPounds * 0.45359237d; // 1 pound = 0.45359237d kilogram
        System.out.println("Converted Kilograms : " + convertedKilograms);

        double pi = 3.1415927d;
        double anotherNumber = 3_000_000.4_567_890d;
        System.out.println(pi);
        System.out.println(anotherNumber);




    }
}
