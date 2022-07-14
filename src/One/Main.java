package One;

import One.HelloWorldThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of "+ Thread.currentThread().getName());

        HelloWorldThread helloWorldThread=new HelloWorldThread();
        helloWorldThread.run();

        try {
            helloWorldThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End of main()");
    }
}
