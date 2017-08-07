package ch15ex26;

public class Ch15ex26 {

	public static void main(String[] args) {
		Number[] numberArray = new Integer[5];
		numberArray[0] = new Integer(32);
		numberArray[1] = new Integer(64);
		// Abstract class, cannot instantiate:
		// numberArray[2] = new Number();
		try {
			// Compiles, but throws ArrayStoreException:
			numberArray[3] = new Float(1.0F);
		}catch(Exception e) {
			System.out.println(e);
		}
		for(Number n : numberArray)
			System.out.println(n + " ");
		// Runtime type - Integer: 
		System.out.println("numberArray[0].getClass().getSimpleName(): " +
				numberArray[0].getClass().getSimpleName());
		// Type mismatch: cannot convert from element type Number to Integer
		// for(Integer i : numberArray)
		//		System.out.println(i + " ");
		// cannot convert from Number[] to Integer[]
		// Integer[] integerArray = numberArray;\
	}

}

/* Output:
java.lang.ArrayStoreException: java.lang.Float
32 
64 
null 
null 
null 
numberArray[0].getClass().getSimpleName(): Integer
*/