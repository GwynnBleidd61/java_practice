package interfaces;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        client.makeOrder(new Waiter() {
            @Override
            public void serveFood(String dish) {
                System.out.println("I brought your: " + dish);
            }
        }, "Pizza");
    }
}
