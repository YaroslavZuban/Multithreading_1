package CancelThread;

public class CanThread implements Runnable {
    static private int count = 0;
    private int counter=0;
    private Thread self; //поток в котором будет исполняться логика нашелго класса

    private volatile boolean canWork;

    public CanThread() {
        self = new Thread(this, "Run Vasa " + count);
        count++;

       // self.start();
    }

    public int start(){
        canWork=true;
        self.start();
        return counter;
    }
    public int stop(){
        System.out.println("sending stop!");
        canWork=false;
        return counter;
    }

    public int interrupt(){
        System.out.println("Sending interrupt!");
        self.interrupt();
        return counter;
    }

    public int join(int ms) throws InterruptedException {
        self.join(ms);
        return counter;
    }

    @Override
    public void run() {
        /*while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("You will not stop me!!");
                break;
            }

            counter++;
        }*/

        while (canWork){
            counter++;
        }
    }
}
