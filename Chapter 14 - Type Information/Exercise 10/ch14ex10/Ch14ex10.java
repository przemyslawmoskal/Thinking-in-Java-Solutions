package ch14ex10;

public class Ch14ex10 {

	public static void main(String[] args) {
		char[] arr = new char[5];
		if(arr instanceof Object) {
			System.out.println("char[] arr instanceof Object = " + (arr instanceof Object));
			System.out.println("char[] arr is an Object, superclass: " + arr.getClass().getSuperclass());
		}else {
			System.out.println("char[] arr is not an Object");
		}
	}

}

/* Output:
char[] arr instanceof Object = true
char[] arr is an Object, superclass: class java.lang.Object
*/