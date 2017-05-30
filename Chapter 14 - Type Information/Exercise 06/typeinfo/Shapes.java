package typeinfo;
import java.util.*;

abstract class Shape {
	void draw() { System.out.println(this + ".draw()"); }
	abstract public String toString();
}

class Circle extends Shape {
	boolean flag = false;
	public String toString() { return "Circle, flag: " + (flag ? "Highlighted" : "Unhighlighted"); }
}

class Square extends Shape {
	boolean flag = false;
	public String toString() { return "Square, flag: " + (flag ? "Highlighted" : "Unhighlighted"); }
}

class Triangle extends Shape {
	boolean flag = false;
	public String toString() { return "Triangle, flag: " + (flag ? "Highlighted" : "Unhighlighted"); }
}	

public class Shapes {
	public static void setCircleFlag(Shape s) {
		if(s instanceof Circle) {
			((Circle)s).flag = true;
		}
	}
	public static void setSquareFlag(Shape s) {
		if(s instanceof Square) {
			((Square)s).flag = true;
		}
	}
	public static void setTriangleFlag(Shape s) {
		if(s instanceof Triangle) {
			((Triangle)s).flag = true;
		}
	}
	public static void resetFlag(Shape s) {
		if(s instanceof Circle) {
			((Circle)s).flag = false;
			System.out.println("Circle flag reset.");
		}if(s instanceof Square) {
			((Square)s).flag = false;
			System.out.println("Square flag reset.");
		}if(s instanceof Triangle) {
			((Triangle)s).flag = false;
			System.out.println("Triangle flag reset.");
		}
	}
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
		System.out.println("Setting flag for Square:");
		for(Shape shape : shapeList) {
			setSquareFlag(shape);
			System.out.println(shape);
		}
		System.out.println();
		for(Shape shape : shapeList) {
			resetFlag(shape);
		}
		System.out.println();
		System.out.println("Setting flag for Triangle:");
		for(Shape shape : shapeList) {
			setTriangleFlag(shape);
			System.out.println(shape);
		}
		System.out.println();
		for(Shape shape : shapeList) {
			resetFlag(shape);
		}
		System.out.println();
		System.out.println("Setting flag for Circle:");
		for(Shape shape : shapeList) {
			setCircleFlag(shape);
			System.out.println(shape);
		}
		System.out.println();
		for(Shape shape : shapeList) {
			resetFlag(shape);
		}
	}
}

/* Output:
Setting flag for Square:
Circle, flag: Unhighlighted
Square, flag: Highlighted
Triangle, flag: Unhighlighted

Circle flag reset.
Square flag reset.
Triangle flag reset.

Setting flag for Triangle:
Circle, flag: Unhighlighted
Square, flag: Unhighlighted
Triangle, flag: Highlighted

Circle flag reset.
Square flag reset.
Triangle flag reset.

Setting flag for Circle:
Circle, flag: Highlighted
Square, flag: Unhighlighted
Triangle, flag: Unhighlighted

Circle flag reset.
Square flag reset.
Triangle flag reset.
*/