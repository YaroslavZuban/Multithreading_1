package One;

public class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName() + "!");
    }
}
