package com.company;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // Reference link : https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
    // Reference link : https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

    public static void main(String[] args) {

        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G"))
            {
                gNumbers.add(number);
                System.out.println(number);
            }
        });

        System.out.println("After sorting : ");
        gNumbers.sort((s1, s2) -> s1.compareTo(s2));// We can use a Lambda Expression instead of a Comparator.
        gNumbers.forEach(number -> System.out.println(number));

        // In the above code, we are creating a list, adding elements, sorting and printing.
        // This requires 4 lines (line 21,26,32,33)
        // This can be done 1 line using Streams.

        // Streams
        System.out.println("Doing the above operations using Stream in 1 line code");
        System.out.println("******************************************************");
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)       // toUpperCase
                .filter(s->s.startsWith("G"))   // startsWith("G")
                .sorted()                       // Sorting
                .forEach(System.out::println);  // Printing

        // instead of .map(String::toUpperCase), we can also use like this - .map(s -> s.toUpperCase)
        // Note : filter method needs a predicate. Not a function.
        // Note : the above forEach and the forEach which we used in the streams are different.
        // forEach accepts a consumer. The consumer accepts an argument and doesn't return a value.
        // That's why we have used sout in forEach.

        // In stream, after forEach method, there's nothing to do.
        // It is the end.
        // Hence it is called as Terminal Operation.
        // Operations that return a stream are called as Intermediate Operations.

        // Stream syntax :
        // Part 1 : stream
        // Part 2 : 0 or more Intermediate Operations
        // Part 3 : 1 Terminal Operation

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("-----------------------");
        System.out.println(concatStream
                .distinct()
                // distinct() uses equals method to determine the duplicates.
                .peek(System.out::println)
                // peek() is used to print the contents in between the stream.
                // We can't use a forEach to print because, it is a Terminal Operation.
                .count());


        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        System.out.println("Employees of all departments");
        System.out.println("----------------------------");
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                // We use .stream() in above line to extract the list (employees in this case) from department object
                // and create a stream and pass it to next method or process.
                .forEach(System.out::println);

        // It is called as FlatMap because it is often used to flatten nested lists.
        // Now in this case, the list of employees nested within the department list.

        // Using Collect Method
        System.out.println("Collect method example");
        System.out.println("----------------------");
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        // collect() is used to collect the data and store it in a variable.
        // collect() is a terminal operation.

        sortedGNumbers.forEach(s -> System.out.println(s));

        // There are 2 types of collect() method we can use.
        // 1st type is implemented above.
        // 2nd type is below.

        List<String> sortedGNumbers1 = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        // In the above collect method, 1st argument is the supplier.
        // Supplier will create an object. So we pass ArrayList::new to create new ArrayList.
        // 2nd argument is the accumulator.
        // So, it is an ArrayList.add method.
        // 3rd argument is the combiner.
        // Accumulator is used to add single item to the ArrayList.
        // Combiner is used to improve the efficiency of the operation.
        // It is up to the java runtime if and when it wants to improve the efficiency.

        // There are many APIs that we can map to Supplier, Accumulator and Combiner and this allows us to
        // do all sort of things.

        Map<Integer, List<Employee>> groupedByAge = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        // ifPresent() is a terminal operation.
        // ifPresent() is not a part of stream operation.

        // Points to note :
        // We can't reuse a stream.
        // It will throw illegal state exception.
        // Operations in streams are lazily evaluated.
        // That means, intermediate operations are not performed until there's a terminal operation.
        // We can use specific stream interfaces when we are working with lists of numbers
        // such as IntStream, LongStream, DoubleStream for example.
        // Now these interfaces have additional methods like min, max, sum and a few others

        // There's also parallel streams.
        // We can use those when we want to increase performance by executing streams in parallel.

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();

        // filter accepts a predicate and returns True or False.


    }
}
