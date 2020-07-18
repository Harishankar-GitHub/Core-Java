package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {

//    Reference link : https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Lock.html
//    Reference link : https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html

    public static final String EOF = "EOF";

    public static void main(String[] args) {

//        List<String> buffer = new ArrayList<>();
        // Instead of the above arrayList, we are creating ArrayBlockingQueue.
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        // We have to define the capacity. It won't expand dynamically like list.
        // Now that we have created ArrayBlockingQueue, we don't need bufferLock.
        // So commenting that and removing bufferLock object while creating Producer and Consumer objects.
        // ArrayBlockingQueue is a FIFO (First In First Out) Queue.

//        ReentrantLock bufferLock = new ReentrantLock();

//        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
//        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
//        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);  // Defining number of threads it can execute at a time.
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the callable class");
                return "This is the callable result";
            }
        });

        try
        {
            System.out.println(future.get());
        }
        catch (ExecutionException e)
        {
            System.out.println("Something went wrong");
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

// Remove the synchronized block and keep only the statements in it and observe the output.
// If synchronized is not used, it leads to thread interference.

class MyProducer implements Runnable
{
//    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
//    private ReentrantLock bufferLock;

    MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
//        this.bufferLock = bufferLock;
    }

    public void run()
    {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums)
        {
            try
            {
                System.out.println(color + "Adding... " + num);
//                synchronized (this.buffer)    // When using bufferLock, synchronized block can be removed and vice versa.
//                {
//                    this.bufferLock.lock();
//                    try
//                    {
                        this.buffer.add(num);
//                    }
//                    finally     // We can remove this inner try & finally block.
                                // The reason for using this is, if the statement inside try block throws exception, then the unlock()
                                // which is present after the statement won't be executed.
                                // That is the reason we put unlock() inside finally block.
                                // Now, after the statement in try is executed, unlock will be executed definitely.
//                    {
//                        this.bufferLock.unlock();
//                    }
//                }

                Thread.sleep(random.nextInt(1000));
            }
            catch(InterruptedException e)
            {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
//        synchronized (this.buffer)         // When using bufferLock, synchronized block can be removed and vice versa.
//        {
//            this.bufferLock.lock();
            try
            {
//                this.buffer.add("EOF");
                // Instead of add, we use put in ArrayBlockingQueue.
                this.buffer.put("EOF");
                // put will automatically block if the thread is locked.
                // When ArrayBlockingQueue is full or empty, add and remove methods will throw exception where as put and take will block.
            }
//            finally
//            {
//                this.bufferLock.unlock();
//            }
        catch(InterruptedException e)
        {

        }
//        }
    }
}

class MyConsumer implements Runnable
{
//    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
//    private ReentrantLock bufferLock;

    MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
//        this.bufferLock = bufferLock;
    }

    public void run()
    {
//        int counter = 0;
        while(true)
        {
            synchronized (this.buffer)        // When using bufferLock, synchronized block can be removed and vice versa.
            {
//                this.bufferLock.lock();     // Instead of this line, we are using tryLock()
//            if(this.bufferLock.tryLock())
//            {
                try
                {
                    if(this.buffer.isEmpty())
                    {
//                        this.bufferLock.unlock();   // Commenting this because, we are using this in finally block.
                        // If we put lock and unlock only at the beginning and end of while loop, the unlock is not executed.
                        // It is because, when it comes to while, it locks and checks if empty.
                        // If empty, it continues -> again comes into while loop, again locks and so on.
                        // That is the reason we put unlock inside these 2 if blocks.
                        continue;
                    }
//                    System.out.println(color + "The counter = " + counter);
//                    counter = 0;
//                    if(this.buffer.get(0).equals(EOF))
                    if(this.buffer.peek().equals(EOF))
                    {
                        System.out.println(color + "Exiting");
//                        this.bufferLock.unlock();       // Commenting this because, we are using this in finally block.
                        break;
                    }
                    else
                    {
//                        System.out.println(color + "Removed " + this.buffer.remove(0));
                        System.out.println(color + "Removed " + this.buffer.take());
                    }
                }
//                finally
//                {
//                    this.bufferLock.unlock();
//                }
                catch (InterruptedException e)
                {

                }
            }
//            else
//            {
//                counter++;
//            }

//            }
        }
    }
}