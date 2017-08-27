package ch16ex09;
import java.util.*; 

class Banana {
	public String toString() { return "Banana"; }
}

class Peel<T> {
	private T t;
	Peel(T t) { this.t = t; }
	public String toString() { return "Peel" + t; } 
}

public class Ch16ex09 {

	public static void main(String[] args) {
		// Cannot create a generic array of Peel<Banana>:
		// Peel<Banana>[] pb = new Peel<Banana>[5];
		List<Peel<Banana>> lpb = new ArrayList<Peel<Banana>>();
		for(int i = 0; i < 5; i++)
			lpb.add(new Peel<Banana>(new Banana()));
		System.out.println(lpb);
		System.out.println(lpb.get(0).getClass().getSimpleName());
		
	}

}

/* Output:
[PeelBanana, PeelBanana, PeelBanana, PeelBanana, PeelBanana]
Peel
*/