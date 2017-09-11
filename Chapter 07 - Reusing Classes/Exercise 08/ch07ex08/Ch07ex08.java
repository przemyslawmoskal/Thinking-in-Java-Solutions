package ch07ex08;
import static ptmoskal.Print.*;

class Base {
	Base(int i) { print("Base(" + i + ")"); }
}

class Derived extends Base {
	Derived() {
		super(0);
		print("Derived()"); }
	Derived(int i) {
		super(i);
		print("Derived(" + i + ")"); }
}

public class Ch07ex08 {

	public static void main(String[] args) {
		Derived def = new Derived();
		Derived nondef = new Derived(128);
	}

}

/* Output:
Base(0)
Derived()
Base(128)
Derived(128)
*/