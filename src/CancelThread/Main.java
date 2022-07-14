package CancelThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CanThread canThread = new CanThread();

        System.out.println("start() = " + canThread.start());
        System.out.println("join() = " + canThread.join(1000));
        //System.out.println("interrupt() = " + canThread.interrupt());
        System.out.println("stop() = " + canThread.stop());
    }
}
