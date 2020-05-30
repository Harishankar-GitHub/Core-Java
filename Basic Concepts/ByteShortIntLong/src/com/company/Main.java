package com.company;

public class Main {

    public static void main(String[] args) {
	int myValue = 10000;

	int myMinVIntValue = Integer.MIN_VALUE;
	// Integer is a Wrapper Class
	// Java uses the concept of Wrapper Class for all 8 Primitive types.
	// For int, we can use Integer. By doing that, it gives ways to perform operations on an int.

	int myMaxIntValue = Integer.MAX_VALUE;

	int a = 2_147_483_647;
	// We can write a number with underscore as well.

	System.out.println("Integer Minimum Value : " + myMinVIntValue);
	System.out.println("Integer Maximum Value : " + myMaxIntValue);

	System.out.println("Max Value + 1 : " + (myMaxIntValue + 1));
	// The above line causes Overflow because we are trying to print Max Value + 1.
	System.out.println("Min Value 1 1 : " + (myMinVIntValue - 1));
	// The above line causes Underflow because we are trying to print Min Value - 1.

		// byte consumes	- 8 bits
		// short consumes 	- 16 bits
		// int consumes		- 32 bits
		// long consumes	- 64 bits


	byte myMinByteValue = Byte.MIN_VALUE;
	byte myMaxByteValue = Byte.MAX_VALUE;
	System.out.println("Byte Minimum Value : " + myMinByteValue);
	System.out.println("Byte Maximum Value : " + myMaxByteValue);

	short myMinShortValue = Short.MIN_VALUE;
	short myMaxShortValue = Short.MAX_VALUE;
	System.out.println("Short Minimum Value : " + myMinShortValue);
	System.out.println("Short Maximum Value : " + myMaxShortValue);

	Long myLongValue = 100L;
	// If we don't put 'L', it's fine. But it will be considered as int only.
    // So without 'L', we can put numbers within the range of integer.
    // If we put some number which is not present within the range of an integer, it will throw error.
    // In that case, we have to put 'L'.

	long myMinLongValue = Long.MIN_VALUE;
	long myMaxLongValue = Long.MAX_VALUE;
	System.out.println("Long Minimum Value : " + myMinLongValue);
	System.out.println("Long Maximum Value : " + myMaxLongValue);

	long bigLongLiteralValue = 2_147_483_647_234L;
	System.out.println("bigLongLiteralValue " + bigLongLiteralValue);

	short bigShortLiteralValue = 32767;

	int myTotal = (myMinVIntValue / 2);

	byte myNewByteValue = (byte) (myMinByteValue / 2);
	// In the above line, Java considers myMinByteValue as an int. So we get error if (byte) is not put.
    // If we directly put numbers instead of using variable name, casting is not required.
	short myNewShortValue = (short) (myMinShortValue / 2);
	// In the above line, Java considers myMinShortValue as an int. So we get error if (short) is not put.
    // If we directly put numbers instead of using variable name, casting is not required.

    }
}
