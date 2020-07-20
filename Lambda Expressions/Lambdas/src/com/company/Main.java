package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        new Thread(new CodeToRun()).start(); // Calling CodeToRun
//
//        new Thread(new Runnable() {     // Anonymous runnable
//            @Override
//            public void run() {
//                System.out.println("Printing from the anonymous runnable");
//            }
//        }).start();


        // Lambda Expression Introduction ************************************************************
//        new Thread(()-> System.out.println("Printing from runnable using Lambda Expression")).start();
//        // If body contains 1 statement, the above is the syntax.
//
//        new Thread(()-> {
//            System.out.println("Printing from runnable using Lambda Expression, Line 1");
//            System.out.println("Line 2");
//            System.out.format("This is line %d", 3);
//        }).start();
//        // If body contains more than 1 statement, the above is the syntax.
//
//        // The above is an example of Lambda Expression.
//        // Explanation : new Thread() accepts a runnable as an argument.
//        // It has just run() method which accepts no arguments.
//        // So, we are just using empty () and arrow token (->) and body (sout in this case)
//
//
//        // Every Lambda Expression has 3 parts.
//        // 1. Argument list
//        // 2. Arrow token (->)
//        // 3. Body
//
//        // Lambda Expressions can only be used with Interfaces that contain only 1 method.
//        // These interfaces are also referred to functional interfaces.

        // Lambda Expression Introduction ************************************************************


        Employee john = new Employee("John", 21);
        Employee tim = new Employee("Tim", 30);
        Employee jack = new Employee("Jack", 26);
        Employee snow = new Employee("Snow", 28);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        // Sorting without Lambda Expression
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        // Sorting with Lambda Expression
//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName()));

//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
        // In the above line, we have removed the type of argument that we are passing.
        // If there's only 1 argument that is passed to the lambda, then we can remove braces.
        // Compiler will know what is the type based in the 1st parameter in the Collections.sort() method.

//        for(Employee employee : employees)
//        {
//            System.out.println(employee.getName());
//        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println("SillyString " + sillyString);

        // The above code is without using lambda.
        // The below code is with lambda.

//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();   // Creating a Lambda Expression

//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//
//        // In the above lambda, if there are more than 1 statement, return keyword is a must.
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println("SillyString " + sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);


//        for(Employee employee : employees)
//        {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

        // We are using a variable which is declared outside lambda, which has to be final but it is not,
        // but we didn't get error.
        // The reason is in every iteration, the object is stored in a local variable and which is by default final.
        // This applies to above and below for loop.
//        System.out.println("******************");
//
//        Employee employee;
//
//        for(int i=0; i<employees.size(); i++) {
//            Employee employeeObj = employees.get(i);
//            System.out.println(employeeObj.getName());
//            new Thread(() -> System.out.println(employeeObj.getAge())).start();
//        }

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1, s2);
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}

class Employee
{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat
{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass
{
    public String doSomething()
    {

//        System.out.println("The AnotherClass class name is : " + this.getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class name is : " + this.getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");





//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda expression's class is : " + this.getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        System.out.println("The AnotherClass class name is : " + this.getClass().getSimpleName());
//        return Main.doStringStuff(uc, "String1", "String2");
        // The lambda expression's class name is same as Another class name.
        // A lambda expression is not a class.
        // A lambda is treated like a nested block of code and has the same scope as a nested block.



        int i = 0;
//        i++;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is : " + this.getClass().getSimpleName());
            System.out.println("i in the lambda expression : " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class name is : " + this.getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");






//        {   // This is anonymous block
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//
//            System.out.println("The AnotherClass class name is : " + this.getClass().getSimpleName());
//            i++;
//            System.out.println("i = " + i);
//            return Main.doStringStuff(uc, "String1", "String2");
//        }



    }

    public void printValue() {

        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}
