package typeinfo;
import java.util.*;

abstract class Shape {
  void draw() { System.out.println(this + ".draw()"); }
  abstract public String toString();
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}	

class Rhomboid extends Shape {
	public String toString() { return "Rhomboid"; }
}

public class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(
      new Circle(), new Square(), new Triangle(), new Rhomboid()
    );
    for(Shape shape : shapeList)
      shape.draw();
    Rhomboid obj = new Rhomboid();
    ((Shape)obj).draw();
    // Cannot cast from Rhomboid to Circle
    // ((Circle)obj).draw();
  }
}

/* Output:
Circle.draw()
Square.draw()
Triangle.draw()
Rhomboid.draw()
Rhomboid.draw()
*/