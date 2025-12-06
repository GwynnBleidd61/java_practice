package interfaces;

public class WaiterBob implements Waiter{
    @Override
    public void serveFood(String dish) {
        System.out.println("I brought your: " + dish);

    }
}
