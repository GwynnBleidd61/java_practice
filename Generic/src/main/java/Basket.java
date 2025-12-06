import java.util.ArrayList;
import java.util.List;

public class Basket <T extends Fruit> {

    private List<T> fruits;
    private double weight;

    public Basket() {
        fruits = new ArrayList<>();
    }

    public float getWeight() {
        float sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public int compare(Basket<?> another) {
        return Float.compare(getWeight(), another.getWeight());
    }

    public static <U extends Fruit> void transfer(Basket<? extends U> src, Basket<? super U> dst) {
        dst.fruits.addAll(src.fruits);
        src.fruits.clear();
    }
}
