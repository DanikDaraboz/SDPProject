package prototype;

interface Shape {
    Shape clone();
    void draw();
    void setColor(String color);
}

class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

public class Prototype {
    public static void main(String[] args) {
        Shape firstShape = new Circle("green");
        Shape secondShape = firstShape.clone();

        firstShape.draw();
        secondShape.draw();

        secondShape.setColor("blue");

        firstShape.draw();
        secondShape.draw();
    }
}
