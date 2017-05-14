package ch04ex10;
import static ptmoskal.Print.*;

public class Ch04ex10 {	
	static int a(int i) {
		return i/1000;
	}
	static int b(int i) {
		return (i%1000)/100;
	}
	static int c(int i) {
		return ((i%1000)%100)/10;
	}
	static int d(int i) {
		return ((i%1000)%100)%10;
	}
	static int com(int i, int j) {
		return (i * 10) + j;
	}
	static void testVampireNumber (int i, int m, int n) {
		if(m * n == i)
			print(i + " = " + m + " * " + n);
	}	
	public static void main(String[] args) {
		print("All 4-digit vampire numbers: ");
		for(int i = 1000; i < 10000; i++) {			
			testVampireNumber(i, com(a(i), b(i)), com(c(i), d(i)));
			testVampireNumber(i, com(a(i), b(i)), com(d(i), c(i)));
			testVampireNumber(i, com(a(i), c(i)), com(b(i), d(i)));
			testVampireNumber(i, com(a(i), c(i)), com(d(i), b(i)));
			testVampireNumber(i, com(a(i), d(i)), com(b(i), c(i)));
			testVampireNumber(i, com(a(i), d(i)), com(c(i), b(i)));
			testVampireNumber(i, com(b(i), a(i)), com(c(i), d(i)));
			testVampireNumber(i, com(b(i), a(i)), com(d(i), c(i)));
			testVampireNumber(i, com(b(i), c(i)), com(d(i), a(i)));
			testVampireNumber(i, com(b(i), d(i)), com(c(i), a(i)));
			testVampireNumber(i, com(c(i), a(i)), com(d(i), b(i)));
			testVampireNumber(i, com(c(i), b(i)), com(d(i), a(i)));
		}			
	}
}

/* Output:
All 4-digit vampire numbers: 
1260 = 21 * 60
1395 = 15 * 93
1435 = 41 * 35
1530 = 51 * 30
1827 = 87 * 21
2187 = 27 * 81
6880 = 86 * 80
6880 = 80 * 86
*/