package LD.Scribble.model;

import java.util.Objects;

public abstract class Shape {
    protected int id; // Unique ID for the shape
    protected int x1, y1, x2, y2; // Bounding box coordinates
    protected String color; // Example: "#RRGGBB"
    protected String type; // "RECTANGLE", "CIRCLE", etc.

    // Using a counter for simple ID generation within this scope
    private static int idCounter = 0;
    // Method to assign a simple unique ID for demonstration
    protected static synchronized int getNextId() {
        return ++idCounter;
    }

    public Shape(int x1, int y1, int x2, int y2, String color, String type) {
        this.id = getNextId(); // Assign ID upon creation
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.type = type;
    }

    // Getters
    public int getId() { return id; }
    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public String getColor() { return color; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return type + "[id=" + id + ", x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", color=" + color + "]";
    }

    // hashCode and equals are important if you store shapes in HashSets/Maps
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return id == shape.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
