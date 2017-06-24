package ch10ex23;
import static ptmoskal.Print.*;

interface U {
	void first();
	void second();
	void third();
	String toString();
}

class A {
	U createU() {
		return new U() {
			public void first() { print ("first()"); };
			public void second() { print ("second()"); };
			public void third() { print ("third()"); };
			public String toString() { return "It's U"; }
		};
	}
}

class B {
	private U[] arr;
	B(int i) { arr = new U[i]; }
	void addToArr(U u, int index) {
		arr[index] = u;
	}
	void setToNull(int index) {
		arr[index] = null;
	}
	void checkMethods() {
		for(U u : arr) {
			u.first();
			u.second();
			u.third();
			print(u.toString());
		}
		print();
	}
	void printArray() {
		for(U u : arr) {
			if(u == null)
				print("Null");
			else
				print(u.toString());
		}
		print();
	}
}

public class Ch10ex23 {

	public static void main(String[] args) {
		A a0 = new A();
		A a1 = new A();
		A a2 = new A();
		B b = new B(3);
		b.addToArr(a0.createU(), 0);
		b.addToArr(a1.createU(), 1);
		b.addToArr(a2.createU(), 2);
		b.printArray();
		b.checkMethods();
		b.setToNull(2);
		b.printArray();
		b.setToNull(0);
		b.printArray();
	}

}

/* Output:
It's U
It's U
It's U

first()
second()
third()
It's U
first()
second()
third()
It's U
first()
second()
third()
It's U

It's U
It's U
Null

Null
It's U
Null
*/