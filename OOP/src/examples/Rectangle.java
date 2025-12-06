package examples;

public class Rectangle {
    double width;
    double length;

    void setDimens(double width, double length) {
        this.width = width;
        this.length = length;
    }

    double getArea() {
        return width * length;
    }
}
