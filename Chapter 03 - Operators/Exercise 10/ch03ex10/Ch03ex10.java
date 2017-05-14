package ch03ex10;
import static ptmoskal.Print.*;

public class Ch03ex10 {

	public static void main(String[] args) {
		int i = 0xAAAA;
		int j = 0x5555;
		print("i     =     " + Integer.toBinaryString(i));
		print("j     =      " + Integer.toBinaryString(j));
		print("i & j =                    " + Integer.toBinaryString(i & j));
		print("i | j =     " + Integer.toBinaryString(i | j));
		print("i ^ j =     " + Integer.toBinaryString(i ^ j));
		print("~i    = " + Integer.toBinaryString(~i));
		print("~j    = " + Integer.toBinaryString(~j));

	}

}

/* Output:
i     =     1010101010101010
j     =      101010101010101
i & j =                    0
i | j =     1111111111111111
i ^ j =     1111111111111111
~i    = 11111111111111110101010101010101
~j    = 11111111111111111010101010101010
*/