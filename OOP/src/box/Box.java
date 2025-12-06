package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box() {
        this(10);
    }

    public Box(Box another) {
        this(another.length, another.width, another.height);
    }

    public Box copy() {
        return new Box(this.length, this.width, this.height);
    }

    public Box increase() {
        return new Box(length * 2, width * 2, height * 2);
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = length;
        this.height = length;
    }

    public Box(double size) {
        this(size, size, size);
    }

    public void showInfo() {
        System.out.println("Width: " + width + "\nLength: " + length + "\nHeight: " + height);
    }

    public void setDimens(double length, double width, double height) {
        this.length = length;
        this.width = length;
        this.height = length;
    }

    public int Compare(Box another) {
        double currentVolume = getVolume();
        double anotherVolume = another.getVolume();
        if (currentVolume > anotherVolume) {
            return 1;
        } else if (currentVolume < anotherVolume) {
            return -1;
        } else {
            return 0;
        }
    }

    private double getVolume() {
        return length * width * height;
    }

    public void showVolume() {
        System.out.println(getVolume());
    }

}
