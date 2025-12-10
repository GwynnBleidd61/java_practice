import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) {
        TreeMap<Character, Long> treeMap = new TreeMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    treeMap.put(Thread.currentThread().getName().charAt(7), road("Preparing"));
                    countDownLatch.countDown();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    treeMap.put(Thread.currentThread().getName().charAt(7), road("First road"));
                    try {
                        semaphore.acquire();
                        treeMap.put(Thread.currentThread().getName().charAt(7), road("tunnel"));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        semaphore.release();
                    }
                    treeMap.put(Thread.currentThread().getName().charAt(7), road("Second road"));
                    for (Map.Entry<Character, Long> entry : treeMap.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }

                }
            }).start();
        }
    }

    private static long road(String roadName) {
        long millis = (long) (Math.random() * 5000 + 1000);
        char name = Thread.currentThread().getName().charAt(7);
        System.out.println(name + " started " + roadName);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " finished " + roadName);
        return millis;
    }


}

