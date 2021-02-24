import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private String threadName;
    private Counter counter;

    public MyRunnable(String threadName, Counter counter) {
        logger.info("Thread by name " + threadName + " is creating.");
        this.threadName = threadName;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (counter.getCounter() < 100) {
                counter.increase();
                logger.info(threadName + " value = " + counter.getCounter());
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception with work thread by name " + threadName);
        }
    }
}
