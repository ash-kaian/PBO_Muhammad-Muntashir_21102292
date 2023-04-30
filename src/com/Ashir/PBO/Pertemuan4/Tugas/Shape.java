package com.Ashir.PBO.Pertemuan4.Tugas;

public class Shape {
    protected int x;
    protected int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Drawing a shape at (" + x + ", " + y + ")");
    }
}
