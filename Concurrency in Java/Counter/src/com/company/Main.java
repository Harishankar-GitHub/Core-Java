package com.company;

public class Main {

    public static void main(String[] args) {

        // The process of controlling threads when threads execute code and when they access heap, is called Synchronisation.

//        Countdown countdown = new Countdown();    // We can pass countdown object in both places and check how it works.
//        CountdownThread t1 = new CountdownThread(countdown);
//        t1.setName("Thread 1");
//        CountdownThread t2 = new CountdownThread(countdown);
//        t2.setName("Thread 2");

        // We are passing same object to two threads.
        // In this case, each thread won't have 2 different copies of objects.
        // They will share same object.
        // If some value in the object is changed, the change will reflect in another thread also.

        // Heap is the application's memory that all threads share.
        // Every thread has its own thread stack.
        // Thread 1 stack cannot be accessed by Thread 2 stack.

        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown1);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown2);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {

    private int i;
    // When we use private int i, the space for i is created in heap when the object is created.
    // So both thread has same object and hence share same variable i.
    // All threads share heap memory.

    public void doCountdown() {     // public synchronized void doCountdown() - This is used to synchronize a method.
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        // Not recommended to use local variable to Synchronise.

        synchronized(this)  // We can write code inside a synchronized block to make the statements synchronous.
        {
            for(i=10; i > 0; i--)
            {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }

        // If we had used int i in for loop instead of instance variable i,
        // Both thread will have separate copy of variable in its stack.
        // Local variables are stored in thread's stack.
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}