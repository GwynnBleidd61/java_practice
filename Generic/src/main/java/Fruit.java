public abstract class Fruit {

    private double weight = 0;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public Fruit() {
    }

    abstract float getWeight();
}
