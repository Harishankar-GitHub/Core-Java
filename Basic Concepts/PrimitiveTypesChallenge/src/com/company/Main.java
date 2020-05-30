package com.company;

public class Main {

    public static void main(String[] args) {
        byte byteVar = 10;
        short shortVar = 20;
        int intVar = 50;
        long longVar = 50000L + (byteVar + shortVar + intVar) * 10L;
        System.out.println("longVar " + longVar);
        short shortTotal = (short) (1000 + 10 * byteVar + shortVar + intVar);
        // Using variables in an expression is considered as int even though it is byte or short etc.
        // So (short) casting is required.

        System.out.println("shortTotal " + shortTotal);


    }
}
