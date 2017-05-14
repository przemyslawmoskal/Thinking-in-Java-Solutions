package ch13ex07;

public class Ch13ex07 {
	
	public static void main(String[] args) {
		String s1 = "Hello world.";
		String s2 = "hello world.";
		String s3 = "Hello world!";
		String s4 = "Hello world...";
		String[] arr = new String[] {s1, s2, s3, s4};
		for(String s : arr) {
			System.out.print(s + "\nThis sentence begins with capital letter and ends with full stop: ");
			System.out.println(s.matches("^[A-Z].*[\\.]$"));
			System.out.println();
		}
	}

}

/* Output:
Hello world.
This sentence begins with capital letter and ends with full stop: true

hello world.
This sentence begins with capital letter and ends with full stop: false

Hello world!
This sentence begins with capital letter and ends with full stop: false

Hello world...
This sentence begins with capital letter and ends with full stop: true
*/