package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Challenge 1 ***************************************************************

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        // Writing the above anonymous class using Lambda

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        // Challenge 1 ***************************************************************

        // Challenge 2 ***************************************************************

        // Writing a method which is given in the challenge using lambda expression.

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        // Challenge 2 ***************************************************************

        // Challenge 3 ***************************************************************

        // Using the lambda expression from challenge 2 to evaluate "1234567890" and print output.
        System.out.println("Challenge 3 : " + lambdaFunction.apply("1234567890"));

        // Challenge 3 ***************************************************************

        // Challenge 5 ***************************************************************

        // Calling the method that was created in challenge 4 and printing the output

        System.out.println("Challenge 4 : " + everySecondElement(lambdaFunction, "1234567890"));

        // Challenge 5 ***************************************************************

        // Challenge 6 ***************************************************************

        // Writing a lambda expression which matches the java.util.Supplier interface.
        // Lambda should return a string "I love Java!"
        // Assign it to a variable called iLoveJava.

        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava1 = () -> { return "I love Java!"; };
        // When using curly braces, return statement is must.
        // Semi colon is must for statements inside curly braces.

        // Challenge 6 ***************************************************************

        // Challenge 7 ***************************************************************

        // Use the Supplier from challenge 6 to assign "I love Java!" to a variable called supplierResult and print.

        String supplierResult = iLoveJava.get();
        System.out.println("Challenge 7 : " + supplierResult);

        // Challenge 7 ***************************************************************

        // Challenge 8 ***************************************************************

        // Refer video for challenge 8.

        // Challenge 8 ***************************************************************

        // Challenge 9 ***************************************************************

        // We have to print the names in the below list in sorted order and first letter of name in upper case
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();

        topNames2015.forEach(name -> {
            firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1));
        });

        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Challenge 9 ******************************");
        firstUpperCaseList.forEach(name -> System.out.println(name));

        // Challenge 9 ***************************************************************

        // Challenge 10 **************************************************************

        // Modify the sort and print code in challenge 9 to use method references.
        // Method reference example : Class::MethodName

        System.out.println("Challenge 10 *********************************");
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        // Challenge 10 **************************************************************

        // Challenge 11 **************************************************************

        // Do the same operation which was done in challenge 9 using Stream operations

        System.out.println("Challenge 11 **********************************");
        topNames2015
                .stream()
                .map(name->name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);

        // Challenge 11 **************************************************************

        // Challenge 12 **************************************************************

        // Modify challenge 11 - Instead of printing sorted names, print the count of names that start with "A"

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();   // We are using a long because, count() method returns a long.

        System.out.println("Number of names beginning with A : " + namesBeginningWithA);

        // Challenge 12 **************************************************************

        // Challenge 14 **************************************************************

        // Adding a terminal operation to stream so that peek() call will execute
        System.out.println("Challenge 14 *******************************************");

        System.out.println(".count() after .sorted()");
        topNames2015
                .stream()
                .map(name->name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .count();

        System.out.println(".collect() after .sorted()");
        topNames2015
                .stream()
                .map(name->name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        // Challenge 14 **************************************************************
    }

    // Challenge 4 ***************************************************************

    // Creating a method to accept the Function which was created in challenge 2

    private static String everySecondElement(Function<String, String> func, String s)
    {
        return func.apply(s);
    }

    // Challenge 4 ***************************************************************
}
