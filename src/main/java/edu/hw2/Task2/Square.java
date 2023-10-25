package edu.hw2.Task2;

public final class Square extends Rectangle {

    @Override
    public Rectangle setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
        return new Square();
    }

    @Override
    public Rectangle setHeight(int height) {
        super.setHeight(height);
        return new Square();
    }
}
