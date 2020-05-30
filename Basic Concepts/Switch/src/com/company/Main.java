package com.company;

public class Main {

    public static void main(String[] args) {

//	int value = 1;
//	if (value == 1)
//    {
//        System.out.println("1");
//    }
//	else if (value == 2)
//    {
//        System.out.println("2");
//    }
//	else
//    {
//        System.out.println("Neither");
//    }

	int switchValue = 5;

	switch (switchValue)
    {
        case 1:
            System.out.println("1");
            break;

        case 2:
            System.out.println("2");
            break;

        case 3: case 4: case 5:
        System.out.println("3 or 4 or 5");
        System.out.println("Actually it was a " + switchValue);
        break;

        default:
            System.out.println("Neither");
            break;
    }

    char variable = 'D';

	switch (variable)
    {
        case 'A':
            System.out.println("A");
            break;

        case 'B':
            System.out.println("B");
            break;

        case 'C':
            System.out.println("C");
            break;

        case 'D': case 'E':
            System.out.println(variable + " was found");
            break;

        default:
            System.out.println("Not found");
            break;
    }

    String month = "JAnUaRy";

	switch (month.toLowerCase())
    {
        case "january":
            System.out.println("Jan");
            break;

        case "june":
            System.out.println("Jun");
            break;

        default:
            System.out.println("Not sure");
            break;
    }

    }
}
