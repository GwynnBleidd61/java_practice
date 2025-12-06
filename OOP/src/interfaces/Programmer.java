package interfaces;

public class Programmer implements Worker, Driver {
    @Override
    public void work() {
        System.out.println("Программист работает");
    }

    @Override
    public void drive() {
        System.out.println("Программист едет");
    }
}
