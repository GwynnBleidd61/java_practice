public class ATM {

    private int cash;
    private Object monitor = new Object();

    public ATM(int cash) {
        this.cash = cash;
    }

    public void withdraw(String name, int toWithdraw) {
        synchronized (monitor) {
            System.out.println(String.format("%s подошёл к банкомату", name));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (toWithdraw <= cash) {
                cash -= toWithdraw;
                System.out.println(String.format("%s вывел %s рублей", name, toWithdraw));
                System.out.println(String.format("Осталось: %s", this.cash));
            } else {
                System.out.println(String.format("В банкомате недостаточно денег для %s", name));
            }
        }
    }

    public int getCash() {
        return cash;
    }
}
