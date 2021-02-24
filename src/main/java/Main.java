public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread myThread = new MyThread("Thread 1", counter);
        MyRunnable myRunnable = new MyRunnable("Thread 2", counter);
        new Thread(myRunnable).start();
        myThread.start();
    }
}
