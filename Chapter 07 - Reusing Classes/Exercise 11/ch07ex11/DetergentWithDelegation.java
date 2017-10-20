package ch07ex11;

import static net.mindview.util.Print.*;

class Cleanser {
	private String s = "Cleanser";

	public void append(String a) {
		s += a;
	}

	public void dilute() {
		append(" dilute()");
	}

	public void apply() {
		append(" apply()");
	}

	public void scrub() {
		append(" scrub()");
	}

	public String toString() {
		return s;
	}

	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		print(x);
	}
}

public class DetergentWithDelegation {
	private String s = "DetergentWithDelegation";
	Cleanser c = new Cleanser();
	public void append(String a) {
		s += a;
	}
	public void dilute() {
		c.dilute();
	}
	public void apply() {
		c.apply();
	}
	public void scrub() {
		append(" DetergentWithDelegation.scrub()");
		c.scrub();
	}
	public void foam() {
		append(" foam()");
	}
	public String toString() {
		return s + " " + c;
	}
	public static void main(String[] args) {
		DetergentWithDelegation x = new DetergentWithDelegation();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		print(x);
		print("Testing base class:");
		Cleanser.main(args);
	}
}

/* Output:
DetergentWithDelegation DetergentWithDelegation.scrub() foam() Cleanser dilute() apply() scrub()
Testing base class:
Cleanser
*/