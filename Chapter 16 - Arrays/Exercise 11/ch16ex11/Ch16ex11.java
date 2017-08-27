package ch16ex11;

public class Ch16ex11 {

	public static void main(String[] args) {
		int[] arrInt = new int[5];
		// Autoboxing to int works:
		arrInt[0] = new Integer(128);
		System.out.println(arrInt.getClass().getSimpleName());
		Integer[] arrInteger = new Integer[5];
		System.out.println(arrInteger.getClass().getSimpleName());
		// Autoboxing to Integer works;
		arrInteger[0] = (int)256;
		// Cannot convert from Integer[] to int[] and from int[] to Integer[]:
		// arrInteger = arrInt;
		// arrInt = arrInteger;
	}

}

/* Output:
int[]
Integer[]
*/