public class Main {

    // Reference Link : https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html

    public static void main(String[] args) {

        System.out.println(ThreadColor.ANSI_PURPLE+"Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        // We can set a name to the thread.
        // We can call anotherThread.run() to see the thread name as Main.
        // When we use anotherThread.start(), we can get the thread name which we set.

        anotherThread.start();
//        anotherThread.run();
        // We should not call anotherThread.run().
        // To execute run(), we should use anotherThread.start().
        // If we use anotherThread.run(), it will execute in main thread only.
        // If we use anotherThread.start(), it will execute in a thread.
        // Once a thread is started, we cannot start again.

        System.out.println("SOUT 1");


        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();
        // This is an example of using Anonymous thread class.


        System.out.println("SOUT 2");

        Thread myRunnableThread = new Thread(new MyRunnable()
        {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try
                {
                    anotherThread.join(2000);
                    //anotherThread.join(); - We can join without specifying the time.
                    // Here, we try to demonstrate - If another thread completes within 2000, it's fine.
                    // If it didn't complete within the time given (2000), this thread won't wait and it wil go to
                    // next statement.

                    System.out.println(ThreadColor.ANSI_RED + "Another thread terminated or timed out, So I'm running again.");
                }
                catch(InterruptedException e)
                {
                    System.out.println(ThreadColor.ANSI_RED + "I couldn't' wait, I was interrupted.");
                }
            }
        });
        // Mostly developers use Runnable way of doing things.
        // Because, Runnable is more flexible and has more methods.

        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE+"Hello again from the main thread.");
        System.out.println("SOUT 3");


    }
}