public class Numbers {

    public static void main(String[] args) {
        int[] numbers = new int[100];
        int number = 100;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 100;
        }

        for (int num : numbers) {
            System.out.println(num);
        }

    }
}
