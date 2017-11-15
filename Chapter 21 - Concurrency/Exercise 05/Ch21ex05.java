import java.util.*;
import java.util.concurrent.*;


class Fibonacci implements Callable<Integer> {
	int howMany = 0;

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}
	
	Fibonacci(int howMany) {
		this.howMany = howMany;
	}
	
	public Integer call() {
		int sum = 0;
		for (int i = 0; i < howMany; i++) {
			sum += fib(i);
		}
		return sum;
	}
}

public class Ch21ex05 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> sums = new ArrayList<Future<Integer>>();
		for(int i = 1; i < 15; i++) {
			sums.add(exec.submit(new Fibonacci(i)));
		}
		try {
			for(Future<Integer> fi : sums) {
				System.out.println(fi.get());
			}
		} catch(InterruptedException e) {
			System.out.println(e);
		} catch (ExecutionException e) {
			System.out.println(e);
		} finally {
			exec.shutdown();
		}
	}
}

/* Output:
1
2
4
7
12
20
33
54
88
143
232
376
609
986
*/