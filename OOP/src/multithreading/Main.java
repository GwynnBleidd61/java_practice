package multithreading;

import java.util.Random;

public class Main {
    static boolean isGuessed = false;

    public static void main(String[] args) {
        int bound = 1_000_000_001;
        Random random = new Random();
        int endgame = random.nextInt(bound);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int num = random.nextInt(bound);
                    if (num == endgame) {
                        System.out.println(String.format("Победа число: %s", num));
                        isGuessed = true;
                        break;
                    }
                }
            }
        });
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isGuessed) {
                    i++;
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread2.start();
    }
}
