package ch13ex05;
import java.util.*;
import java.math.*;

public class Ch13ex05 {
	public static void main(String[] args) {
		Formatter f = new Formatter(System.out);
		boolean j = false;
		char a = 'a';
		double g = 345.678;
		float k = 345.6F;
		int i = 120;
		long m = (long)12345;
		short l = (short)12345;
		BigInteger p = new BigInteger("1234567891011");
		Ch13ex05 r = new Ch13ex05();
		System.out.println("boolean: " + j);
		f.format("%2$-5.1b\n%-5.1B\n%-5s\n%-5S\n%-5h\n%-5H\n\n", j, j, j, j, j, j);
		System.out.println("char: " + a);
		f.format("%2$-5c\n%-5C\n%-5.1b\n%-5.1B\n%-5s\n%-5S\n%-5h\n%-5H\n\n", a, a, a, a, a, a, a, a, a);
		System.out.println("double: " + g);
		f.format("%2$-5.1b\n%-5.1B\n%-5.2s\n%-5.2S\n%-5.2f\n%-5.2e\n%-5.2E\n%-5h\n%-5H\n\n" , g, g, g, g, g, g, g, g, g, g);
		System.out.println("float: " + k);
		f.format("%-5.2e\n%-5.2E\n%2$-5.1b\n%-5.1B\n%-5.2s\n%-5.2S\n%-5h\n%-5H\n\n", k, k, k, k, k, k, k, k);
		System.out.println("int: " + i);
		f.format("%2$-5d\n%-5c\n%-5C\n%-5.1b\n%-5.1B\n%-5s\n%-5x\n%-5h\n%-5H\n\n", i, i, i, i, i, i, i, i, i, i);
		System.out.println("long: " + m);
		f.format("%2$-5d\n%-5.1b\n%-5.1B\n%-5.2s\n%-5.2S\n%-5x\n%-5X\n%-5h\n%-5H\n\n", m, m, m, m, m, m, m, m, m, m);
		System.out.println("short: " + l);
		f.format("%2$-5d\n%-5.1b\n%-5.1B\n%-5.2s\n%-5.2S\n%-5x\n%-5X\n%-5h\n%-5H\n\n", l, l, l, l, l, l, l, l, l, l);
		System.out.println("BigInteger: " + p);
		f.format("%2$-15d\n%-5.1b\n%-5.1B\n%-15.10s\n%-15.10S\n%-15x\n%-15X\n%-15h\n%-15H\n\n", p, p, p, p, p, p, p, p, p, p);
		System.out.println("Ch13ex05 r = new Ch13ex05();");
		f.format("%2$-5.1b\n%-5.1B\n%-15s\n%-15S\n%-15h\n%-15H\n\n", r, r, r, r, r, r);
	}
}

/* Output:
boolean: false
f    
F    
false
FALSE
4d5  
4D5  

char: a
a    
A    
t    
T    
a    
A    
61   
61   

double: 345.678
t    
T    
34   
34   
345,68
3,46e+02
3,46E+02
56f2b1db
56F2B1DB

float: 345.6
3,46e+02
3,46E+02
t    
T    
34   
34   
43accccd
43ACCCCD

int: 120
120  
x    
X    
t    
T    
120  
78   
78   
78   

long: 12345
12345
t    
T    
12   
12   
3039 
3039 
3039 
3039 

short: 12345
12345
t    
T    
12   
12   
3039 
3039 
3039 
3039 

BigInteger: 1234567891011
1234567891011  
t    
T    
1234567891     
1234567891     
11f71fb0843    
11F71FB0843    
71fb2b04       
71FB2B04       

Ch13ex05 r = new Ch13ex05();
t    
T    
ch13ex05.Ch13ex05@a298b7
CH13EX05.CH13EX05@A298B7
a298b7         
A298B7               
*/