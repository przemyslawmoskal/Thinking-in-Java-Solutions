package ch03ex08;
import static ptmoskal.Print.*;

public class Ch03ex08 {

	public static void main(String[] args) {
		long value1 = 0xabcd; // hex
		long value2 = 012345; // oct
		print("long value1 (hex) = " + Long.toBinaryString(value1));
		print("long value2 (oct) = " + Long.toBinaryString(value2));
	}

}

/* Output:
long value1 (hex) = 1010101111001101
long value2 (oct) = 1010011100101
*/
