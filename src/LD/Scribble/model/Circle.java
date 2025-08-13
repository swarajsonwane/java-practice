package LD.Scribble.model;

public class Circle extends Shape {
    public Circle(int x1, int y1, int x2, int y2, String color) {
        // For a circle, x1,y1 could be top-left of bounding box, x2,y2 bottom-right
        super(x1, y1, x2, y2, color, "CIRCLE");
    }
}
