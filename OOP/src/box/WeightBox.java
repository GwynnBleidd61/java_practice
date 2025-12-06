package box;

public class WeightBox extends Box{
    private double weight;

    public WeightBox() {
        super();
        this.weight = 10;
    }

    public WeightBox(Box another, double weight) {
        super(another);
        this.weight = weight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Weight: " + weight);
    }

    public WeightBox(double length, double width, double height, double weight) {
        super(length, width, height);
        this.weight = weight;
    }

    public WeightBox(double size, double weight) {
        super(size);
        this.weight = weight;
    }

}
