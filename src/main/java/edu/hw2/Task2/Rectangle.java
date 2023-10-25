package edu.hw2.Task2;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle setWidth(int width) {
        this.width = width;
        return new Rectangle();
    }

    public Rectangle setHeight(int height) {
        this.height = height;
        return new Rectangle();
    }

    public double area() {
        return width * height;
    }
}
