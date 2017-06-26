package ch15ex02;
import static ptmoskal.Print.*;

class Animal {
	private String name;
	Animal(String name) { this.name = name;}
	public String toString() { return name; }
}

public class Holder<T> {
	private T a, b, c;
	public Holder(T a, T b, T c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public T getA() { return a; }
	public T getB() { return b; }
	public T getC() { return c; }
	public void setA(T a) { print("setA() : " + a); this.a = a; }
	public void setB(T b) { print("setB() : " + b); this.b = b; }
	public void setC(T c) { print("setC() : " + c); this.c = c; }
	public String toString() { return "{ " + a + ", " + b + ", " + c + " }"; }
	public static void main(String[] args) {
		Holder<Animal> animals = new Holder<Animal>(new Animal("DogA"), new Animal("CatB"), new Animal("RatC"));
		print(animals);
		print(animals.getA());
		print(animals.getB());
		print(animals.getC());
		animals.setA(new Animal("Bird"));
		animals.setB(new Animal("Elephant"));
		animals.setC(new Animal("Monkey"));
		print(animals);
	}
}

/* Output:
{ DogA, CatB, RatC }
DogA
CatB
RatC
setA() : Bird
setB() : Elephant
setC() : Monkey
{ Bird, Elephant, Monkey }
*/
