import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Character, Long> map = new ConcurrentSkipListMap<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.merge(Thread.currentThread().getName().charAt(7), road("Preparing"), Long::sum);
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    map.merge(Thread.currentThread().getName().charAt(7), road("First road"), Long::sum);
                    try {
                        semaphore.acquire();
                        map.merge(Thread.currentThread().getName().charAt(7), road("tunnel"), Long::sum);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        semaphore.release();
                    }
                    map.merge(Thread.currentThread().getName().charAt(7),road("Second road"), Long::sum);
                    countDownLatch.countDown();

                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Map.Entry<Character, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
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

