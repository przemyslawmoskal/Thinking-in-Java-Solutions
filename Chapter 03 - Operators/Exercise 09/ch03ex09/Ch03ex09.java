package ch03ex09;
import static ptmoskal.Print.*;

public class Ch03ex09 {

	public static void main(String[] args) {
		float largestFloat = java.lang.Float.MAX_VALUE;
		float smallestFloat = java.lang.Float.MIN_VALUE;
		double largestDouble = java.lang.Double.MAX_VALUE;
		double smallestDouble = java.lang.Double.MIN_VALUE;
		print("Largest float = " + largestFloat);
		print("Smallest float = " + smallestFloat);
		print("Largest double = " + largestDouble);
		print("Smallest double = " + smallestDouble);

	}

}

/* Output:
Largest float = 3.4028235E38
Smallest float = 1.4E-45
Largest double = 1.7976931348623157E308
Smallest double = 4.9E-324
*/
