package ThreadMonitor;

public class ThreadMon {
    static int x;

    public static void main(String[] args) throws InterruptedException {

        Object monitor = new Object();

        Runnable runner = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (monitor) {
                    x++;
                }
            }
        };

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runner);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("x = " + x);
    }
}
