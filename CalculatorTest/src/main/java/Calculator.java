public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(String a, String  b) {
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        return numA + numB;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }
}
