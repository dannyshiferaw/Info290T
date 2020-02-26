package edu.berkeley.aep;

public class Rectangle {
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int area() {
        return this.width * this.length;
    }
}
