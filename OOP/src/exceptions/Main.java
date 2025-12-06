package exceptions;

public class Main {
    public static void main(String[] args) {
//        int a = 0;
//        try {
//            int b = 7 / a;
//            int c = Integer.parseInt("fasdad");
//        } catch (ArithmeticException e) {
//            System.out.println("Can't divide by zero");
//        } catch (Exception e) {
//            System.out.println("Caught an Exception " + e.getClass());
//        }
//        System.out.println("Hello");

        int[] numbers = {1, 2, 3, 4};
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(numbers[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of bounds.");
            }

        }
    }
}
