package ch07ex01;

class Hand {
	public String toString() {
		return "Hand constructed";
	}
}

class Leg {
	public String toString() {
		return "Leg constructed";
	}
}

class Robot {
	Hand h;
	Leg l;
	public String toString() {
		if(h == null)
			h = new Hand();
		if(l == null)
			l = new Leg();
		return "Robot parts: \n" + h + ", " + l;
	}
}

public class Ch07ex01 {

	public static void main(String[] args) {
		Robot r = new Robot();
		System.out.println(r);
	}

}

/* Output:
Robot parts: 
Hand constructed, Leg constructed
*/