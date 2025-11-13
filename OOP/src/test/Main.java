package test;


import box.Box;
import box.WeightBox;
import inheritance.Rect;
import inheritance.Triangle;


public class Main {

    public static void main(String[] args) {
        Rect rect = new Rect(10, 20);
        Triangle triangle = new Triangle(10, 10 ,10);
        rect.showPerimeter();
        triangle.showPerimeter();
    }
}
