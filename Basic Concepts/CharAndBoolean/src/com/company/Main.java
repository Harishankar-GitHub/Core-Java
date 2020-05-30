package com.company;

public class Main {

    public static void main(String[] args) {

        char myChar = 'D';
        // char occupies 16 bits.
        // It allows us to store unicode characters.

        char myUnicodeChar = '\u0044';
        // https://unicode-table.com/en/
        // In the above link, we can get the unicode characters.
        // A char can hold a regular character or a unicode character.

        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;
    }
}
