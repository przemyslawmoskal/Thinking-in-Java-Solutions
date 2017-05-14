package ch03ex13;

public class Ch03ex13 {
	public static void showBinaryForm(char character) {
		System.out.println(character + " = " + Integer.toBinaryString(character));
	}
	public static void main(String[] args) {
        showBinaryForm('B');
        showBinaryForm('a');
        showBinaryForm('z');
        showBinaryForm('X');
	}

}

/* Output:
B = 1000010
a = 1100001
z = 1111010
X = 1011000
*/