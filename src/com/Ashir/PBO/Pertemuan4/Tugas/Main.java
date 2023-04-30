package com.Ashir.PBO.Pertemuan4.Tugas;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(10, 10, 5);
        shapes[1] = new Rectangle(20, 20, 10, 5);

        for (Shape shape : shapes) {
            shape.draw();
            if (shape instanceof Circle) {
                ((Circle) shape).shrink(2);
                ((Circle) shape).expand(4);
            } else if (shape instanceof Rectangle) {
                ((Rectangle) shape).shrink(1);
                ((Rectangle) shape).expand(2);
            }
            shape.draw();
        }
    }
}
