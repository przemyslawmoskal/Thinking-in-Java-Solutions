package ch04ex05;
import static ptmoskal.Print.*;

public class Ch04ex05 {
	static void integerToBinary (int a) {
		if(a == 0) printnb(0);
		else {
			int b = Integer.numberOfLeadingZeros(a); 
			a <<= b;
			for(int p = 0; p < 32 - b; p++) {
				int n = (Integer.numberOfLeadingZeros(a) == 0) ? 1 : 0;
				printnb(n);		
				a <<= 1;
			}		
		}
		print("");
	}

	public static void main(String[] args) {
		int i = 0xAAAA;
		int j = 0x5555;
		printnb("i     = ");
		integerToBinary(i);
		printnb("j     =  ");
		integerToBinary(j);
		printnb("i & j =                ");
		integerToBinary(i & j);
		printnb("i | j = ");
		integerToBinary(i | j);
		printnb("i ^ j = ");
		integerToBinary(i ^ j);
		printnb("~i    = ");
		integerToBinary(~i);
		printnb("~j    = ");
		integerToBinary(~j);
	}

}

/* Output:
i     = 1010101010101010
j     =  101010101010101
i & j =                0
i | j = 1111111111111111
i ^ j = 1111111111111111
~i    = 11111111111111110101010101010101
~j    = 11111111111111111010101010101010
*/