package com.company;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread1().start();
        new Thread2().start();


    }

    private static class Thread1 extends Thread
    {
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread 1 has lock 1");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {

                }
                System.out.println("Thread 1 waiting for lock 2");

                synchronized (lock2)
                {
                    System.out.println("Thread 1 has lock 1 and lock 2");
                }
                System.out.println("Thread 1 has released lock 2");
            }
            System.out.println("Thread 1 released lock 1. Exiting...");
        }
    }

    // Replace lock 1 instead of lock2 and lock 2 instead of lock 1 in Thread 2 to observe deadlock situation.
    // Change the sout statements accordingly.
    private static class Thread2 extends Thread
    {
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread 2 has lock 1");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {

                }
                System.out.println("Thread 2 waiting for lock 2");
                synchronized (lock2)
                {
                    System.out.println("Thread 2 has lock 1 and lock 2");
                }
                System.out.println("Thread 2 released lock 2");
            }
            System.out.println("Thread 2 released lock 1. Exiting...");
        }
    }
}