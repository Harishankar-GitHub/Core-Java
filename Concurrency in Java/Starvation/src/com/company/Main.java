package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

//    private static Object lock = new Object();
//    Commenting above lock and using Reentrant Lock
        private static ReentrantLock lock = new ReentrantLock(true);    // true is to define that we are using a fair lock.
    // Fair Lock means First Come First Served
    // Only fairness in acquiring the lock is guaranteed, not fairness in thread scheduling.
    // If there are too many threads, performance might be impacted.
    // Because, it requires an extra layer of processing.


    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);     // Setting priority is just a suggestion to the Operating System.
        t2.setPriority(8);      // The output can be in any order irrespective of setting the priority.
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t3.start();
        t2.start();
        t5.start();
        t4.start();
        t1.start();

    }

    private static class Worker implements Runnable
    {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor)
        {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i = 0; i<100; i++)
            {
                lock.lock();
                try
                {
//                    synchronized (lock)
//                    {
                    System.out.format(threadColor + "%s : runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
//                    }
                }
                finally
                {
                    lock.unlock();
                }

            }
        }
    }
}
