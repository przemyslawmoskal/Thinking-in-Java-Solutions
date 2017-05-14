package ch04ex09;
import static ptmoskal.Print.*;

public class Fibonacci {
	int showFibonacciNumber(int n) {
		if(n < 2) return 1;
		return (showFibonacciNumber(n - 2) + showFibonacciNumber(n - 1));
	}
	public static void main(String[] args) {
		Fibonacci obj = new Fibonacci();
		int num = Integer.parseInt(args[0]);
		print(num + " Fibonacci number(s) to show: ");
		for(int i = 0; i < num; i++)
			print(obj.showFibonacciNumber(i));
	}

}

/* Output (example with "java Fibonacci 10" in command line):
10 Fibonacci number(s) to show: 
1
1
2
3
5
8
13
21
34
55
*/