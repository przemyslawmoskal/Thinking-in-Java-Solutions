package ch02ex06;

public class Ch02ex06 {
	int storage(String s) {
		return s.length() * 2;
	}
	public static void main(String[] args) {
		Ch02ex06 obj = new Ch02ex06();
		System.out.println(obj.storage("four"));
	}
}

/* Output:
8
*/