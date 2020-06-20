package com.company;

class Car
{
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String startEngine()
    {
        return "Car -> startEngine()";
    }

    public String accelerate()
    {
        return "Car -> accelerate()";
    }

    public String brake()
    {
        return "Car -> brake()";
    }
}

class Jazz extends Car
{
    public Jazz(String name, int cylinders)
    {
        super(name,cylinders);
    }

    @Override
    public String startEngine() {
        return "Jazz -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Jazz -> accelerate()";
    }

    @Override
    public String brake() {
        return "Jazz -> brake()";
    }
}

class Ford extends Car
{
    public Ford(String name, int cylinders)
    {
        super(name,cylinders);
    }

    @Override
    public String startEngine() {
        return "Ford -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Ford -> accelerate()";
    }

    @Override
    public String brake() {
        return "Ford -> brake()";
    }
}

class Holden extends Car
{
    public Holden(String name, int cylinders)
    {
        super(name,cylinders);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here

        Car car = new Car("Base car",8);
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Jazz jazz = new Jazz("Jazz",5);
        System.out.println(jazz.startEngine());
        System.out.println(jazz.accelerate());
        System.out.println(jazz.brake());

        Ford ford = new Ford("Ford",5);
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden("Holden",5);
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
}
