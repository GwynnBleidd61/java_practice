public class ConditionalOperator {

    public static void main(String[] args) {
        int temp = 25;
        boolean hot = temp >= 25;
        boolean cold = temp <= 22;
        int time = 20;
        boolean isNight = time > 22 || time < 6;
        if (hot && !isNight) {
            System.out.println("Кондиционер включен");
        } else if (cold) {
            System.out.println("Кондиционер выключен");
        } else {
            System.out.println("Кондиционер ничего не делает");
        }
    }
}

