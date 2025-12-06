package examples;

public class Dog {
    String name;
    String breed;
    int weight;
    int speed;

    String getInfo() {
        return ("The dog is called: " + name + " it is "
                + breed + " and it weighs " + weight + " kgs");
    }

    void run() {
        for (int i = 0; i < speed; i++) {
            System.out.println("Бегу");
        }
    }
}
