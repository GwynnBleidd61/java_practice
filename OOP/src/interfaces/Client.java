package interfaces;

public class Client {
    void makeOrder(Waiter waiter, String dish) {
        waiter.serveFood(dish);
    }
}
