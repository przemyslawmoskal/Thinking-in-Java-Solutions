import generics.coffee.*;
import java.util.*;

public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyLatte) {
		probablyLatte.add(new Cappuccino());
	}	
	public static void main(String[] args) {
		List<Latte> latte1 = new ArrayList<Latte>();
		oldStyleMethod(latte1); // Quietly accepts Cappuccino
		List<Latte> latte2 = Collections.checkedList(
				new ArrayList<Latte>(), Latte.class);
		try {
			oldStyleMethod(latte2); // Throws an exception
		} catch(Exception e) {
			System.out.println(e);
		}
		// Derived types work fine:
		List<Coffee> pets = Collections.checkedList(
				new ArrayList<Coffee>(), Coffee.class);
		pets.add(new Latte());
		pets.add(new Cappuccino());
	}
}

/* Output:
java.lang.ClassCastException: Attempt to insert class generics.coffee.Cappuccino element into collection with element type class generics.coffee.Latte
*/