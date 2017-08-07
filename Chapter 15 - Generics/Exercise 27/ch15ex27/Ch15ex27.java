package ch15ex27;
import java.util.*;

public class Ch15ex27 {

	public static void main(String[] args) {
		// cannot convert from ArrayList<Integer> to List<Number>
		// List<Number> numberList = new ArrayList<Integer>();
		List<? extends Number> numberList2 = new ArrayList<Integer>();
		// Error while compiling addition of Integer:
		// numberList2.add(new Integer(128));
		// Can't add Number - abstract class:
		// numberList2.add(new Number());
		// Possible to add null to ArrayList:
		numberList2.add(null);
		Number n = numberList2.get(0);
		System.out.println("n = " + n);
		System.out.println("numberList2: " + numberList2);
	}

}

/* Output:
n = null
numberList2: [null]
*/