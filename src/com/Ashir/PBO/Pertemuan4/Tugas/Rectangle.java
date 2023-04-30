package com.Ashir.PBO.Pertemuan4.Tugas;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("Drawing a rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }

    public void shrink(int amount) {
        width -= amount;
        height -= amount;
        if (width < 0) {
            width = 0;
        }
        if (height < 0) {
            height = 0;
        }
    }

    public void expand(int amount) {
        width += amount;
        height += amount;
    }
}
