public class AnotherThread extends Thread {
    // We have to extend Thread Class and implement the run() method.

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(5000);     // 5000 milliseconds.
        } catch(InterruptedException e) {
            System.out.println(ThreadColor.ANSI_BLUE +  "Another thread woke me up");
            return;
            // We use return here because, once the thread is interrupted,
            // if we want it to terminate and return, we can use return here.
        }

        System.out.println(ThreadColor.ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}