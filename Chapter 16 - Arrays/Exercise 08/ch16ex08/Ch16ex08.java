package ch16ex08;

class A {}

public class Ch16ex08<T> {
	// Compilator generates warning: unchecked cast:
	@SuppressWarnings("unchecked")
	T[] tarr = (T[])new Object[5]; 

	public static void main(String[] args) {
		String[] sarr = new String[5];
		// Ok:
		sarr[0] = "First";
		// Type mismatch, cannot convert from Integer to String:
		// sarr[1] = new Integer(5);
		Object[] oarr = new Object[5];
		oarr[0] = "First";
		oarr[1] = new Integer(1);
		int third = 3;
		// Autoboxing works, there is Integer in oarr, not int:
		oarr[2] = third;
		System.out.println ("oarr[2].getClass().getSimpleName(): " + oarr[2].getClass().getSimpleName());
		// Assignment possible, but putting Integer to oarr causes ArrayStoreException:
		oarr = sarr;
		oarr[3] = 4;
	}

}

/* Output:
oarr[2].getClass().getSimpleName(): Integer
Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
	at ch16ex08.Ch16ex08.main(Ch16ex08.java:24)
*/
