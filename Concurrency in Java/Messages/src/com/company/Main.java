package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();

        (new Thread(new Reader(message))).start();
        (new Thread(new Writer(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while(empty) {

            // We could have used an if to check if empty and wait.
            // But we are using wait() in a loop because, when a thread is notified to wake up,
            // there's no guarantee that it woke up because the condition is satisfied.
            // The reason for a thread to wake up can be anything.
            // It could be because of an InterruptedException also. Or Operating System might wake up
            // or any other reason.

            try {
                wait();     // If we don't use wait, it will lead to DeadLock Situation.
            } catch(InterruptedException e) {

            }

        }
        empty = true;
        notifyAll();
        // If there's not many threads, we can use notifyAll().
        // If too many threads are there, then using notifyAll() can wake up too many threads which may lead to performance issue.
        // Thread can be suspended at any time.
        // Thread can be suspended on 1 line also.
        // But there are few Atomic Operations in Java.
        // During Atomic Operations, thread cannot be suspended.
        // For example while reading/writing a reference variable - myObj1 = myObj2 will be Atomic Operation.
        // Another example is while reading primitive types - int a = 10.
        // But thread can be suspended during the following - Reading/Writing long and double.
        // This is because, JVM might require 2 operations to read/write long and double.
        // Some collections are not thread safe - Example - ArrayList
        return message;
    }

    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException e) {

            }

        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for(int i=0; i<messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000)); // Thread will sleep anytime upto 2 seconds.
            } catch(InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read())
        {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch(InterruptedException e) {

            }
        }
    }
}