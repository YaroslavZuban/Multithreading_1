package RunThread;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Monitor mon = new Monitor();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("1 - " + i);

                    if (i >= 50) {
                        synchronized (mon) {
                            mon.x=i;
                            mon.notify();
                        }
                    }
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (mon) {

                        while (mon.x < 50) {

                            mon.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                for (int i = 0; i < 100; i++) {
                    System.out.println("2 - " + i);
                }

            }
        });

        thread1.start();
        Thread.sleep(5);
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class Monitor {
    int x;
}
