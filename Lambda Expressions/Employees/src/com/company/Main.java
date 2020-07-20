package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    // Reference link : https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

    public static void main(String[] args) {

        Employee john = new Employee("John Jack", 31);
        Employee tim = new Employee("Tim John", 20);
        Employee jack = new Employee("Jack Jill", 23);
        Employee snow = new Employee("Snow Hill", 28);
        Employee red = new Employee("Red Bull", 35);
        Employee charming = new Employee("Prince charming", 32);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        System.out.println("Employees over 30");
        System.out.println("=================");
//        for(Employee e : employees)
//        {
//            if(e.getAge() > 30)
//            {
//                System.out.println(e.getName());
//            }
//        }

        // The above is without a lambda expression
        // The below  is with a lambda expression

        employees.forEach(employee -> {
            if(employee.getAge() > 30)
            {
                System.out.println(employee.getName());
            }
        });

        System.out.println("Employees 30 and younger");
        System.out.println("========================");

        employees.forEach(employee -> {
            if(employee.getAge() <= 30)
            {
                System.out.println(employee.getName());
            }
        });


        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees under 30", employee -> employee.getAge() <= 30);
        // The above 2 statements are examples of passing a predicate.

        // The below is an example to pass an anonymous predicate.
        printEmployeesByAge(employees, "Employees under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println("IntPredicate : " + greaterThan15.test(10));
        int a = 20;
        System.out.println("Reusing a predicate : " + greaterThan15.test(a + 5));

        System.out.println("Chaining predicates : " + greaterThan15.and(lessThan100).test(50));
        System.out.println("Chaining predicates : " + greaterThan15.and(lessThan100).test(15));

        Random random = new Random();
//        for(int i=0; i<10; i++)
//        {
//            System.out.println(random.nextInt(1000));
//            // random.nextInt()         - Will print any random number.
//            // random.nextInt(1000)     - Will print any number less than 1000.
//        }

        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++)
        {
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(" ")+1);
            System.out.println("Last name : " + lastName);
        });

        // Note :
        // Consumer doesn't return a value
        // Supplier doesn't accept any parameters
        // Predicate only returns True or False

        Function<Employee, String> getLastName = (employee) -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };  // Function to get last name.

        Function<Employee, String> getFirstName = (employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(" "));
        };  // Function to get first name.

        String lastName = getLastName.apply(employees.get(1));
        System.out.println("Last name of 2nd Employee : " + lastName);

        Random random1 = new Random();

        System.out.println("=======================================");
        for(Employee employee : employees)
        {
            if(random1.nextBoolean())
            {
                System.out.println("First name of " + employee.getName() + " is " + getAName(getFirstName, employee));
            }
            else
            {
                System.out.println("Last name of " + employee.getName() + " is " + getAName(getLastName, employee));
            }

        }


        // Chaining Functions
        Function<Employee, String> upperCase = (employee -> employee.getName().toUpperCase());
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));

        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println("Chained Function Example : " + chainedFunction.apply(employees.get(0)));

        // Syntax Explanation :
        // function1.andThen(function2)
        // Here, function1 is executed and the result is passed to function2.

        // There's another method called compose.
        // function1.compose(function2)
        // Here, function2 is executed first and the result is passed to function1.

        // BiFunction Concept
        BiFunction<String, Employee, String> concatAge = (name, employee) -> {
            return name.concat(" " + employee.getAge());
        };
        // BiFunction will get 2 parameters.
        // This cannot be done using normal Function.

        String upperName = upperCase.apply(employees.get(0));
        System.out.println("BiFunction Example : " + concatAge.apply(upperName, employees.get(0)));

        // IntUnaryOperator
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println("IntUnaryOperator example : " + incBy5.applyAsInt(5));

        // Different types of usages of Lambda
        // 1. When we want to use a Lambda Expression that tests a value and returns True or False, we can use a Predicate.
        // 2. When we want to use a Lambda Expression in place of a method that accepts an argument and returns
        //    a value, , we can use a Function.

        // Consumer chaining
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);

        c1.andThen(c2).accept("Hello World");

        // Consumer doesn't return any value.
        // So the value of c1 (i.e., toUpperCase()) is lost and the text is just printed on the console.


    }

    private static String getAName(Function<Employee, String> getName, Employee employee)
    {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition)
    {
//        System.out.println("Employees over 30");
        System.out.println(ageText);
        System.out.println("=================");

        for(Employee e : employees)
        {
            if(ageCondition.test(e))
            {
                System.out.println(e.getName());
            }
        };

    }
}
