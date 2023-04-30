package com.Ashir.PBO.Pertemuan4.Tugas;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing a circle at (" + x + ", " + y + ") with radius " + radius);
    }

    public void shrink(int amount) {
        radius -= amount;
        if (radius < 0) {
            radius = 0;
        }
    }

    public void expand(int amount) {
        radius += amount;
    }
}
