public class Variable {

    public static void main(String[] args) {
        int input = 10000;
        int years = input / 365;
        int month = (input % 365) / 30;
        int days = ((input % 365) % 30);

        System.out.println(years);
        System.out.println(month);
        System.out.println(days);
    }
}
