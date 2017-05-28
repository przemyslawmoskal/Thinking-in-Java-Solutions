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

public class Shapes {
	public static void rotate(Shape s) {
		if(s instanceof Circle) {
			System.out.println("Don't have to rotate a circle !");
		}
		else {
			System.out.println("rotate(" + s + ")");
		}
	}
	public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
    for(Shape shape : shapeList)
    	shape.draw();
    for(Shape shape : shapeList)
        rotate(shape);
    }
}

/* Output:
Circle.draw()
Square.draw()
Triangle.draw()
Don't have to rotate a circle !
rotate(Square)
rotate(Triangle)
*/