import java.util.*;

class Fibonacci implements Runnable {
	int howMany = 0;

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public void run() {
		int[] arr = new int[howMany];
		for (int i = 0; i < howMany; i++) {
			arr[i] = fib(i);
		}
		System.out.println(Arrays.toString(arr));
	}

	Fibonacci(int howMany) {
		this.howMany = howMany;
	}
}

public class Ch21ex02 {
	public static void main(String[] args) {
		Thread f1 = new Thread(new Fibonacci(5));
		Thread f2 = new Thread(new Fibonacci(10));
		Thread f3 = new Thread(new Fibonacci(15));
		Thread f4 = new Thread(new Fibonacci(20));
		Thread f5 = new Thread(new Fibonacci(25));
		Thread f6 = new Thread(new Fibonacci(30));
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
		f6.start();
	}
}

/* Output:
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765]
[1, 1, 2, 3, 5]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040]
*/