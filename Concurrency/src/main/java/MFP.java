public class MFP {

    private final Object printMonitor = new Object();
    private final Object scanMonitor = new Object();

    public void print(int pages) {
        synchronized (printMonitor) {
            try {
                for (int i = 1; i <= pages; i++) {
                    Thread.sleep(1000);
                    System.out.printf("Отпечатано %s стр%n", i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void scan(int pages) {
        synchronized (scanMonitor) {
            try {
                for (int i = 1; i <= pages; i++) {
                    Thread.sleep(1000);
                    System.out.printf("Отсканировано %s стр%n", i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
