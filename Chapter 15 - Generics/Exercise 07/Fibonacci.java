import net.mindview.util.*;
import java.util.*;

public class Fibonacci implements Generator<Integer>, Iterable<Integer> {
	private int count = 0;
	private int size;
	public Integer next() { return fib(count++); }
	private int fib(int n) {
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}
	public Fibonacci() {};
	public Fibonacci(int size) { this.size = size; }
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() { return size > 0; }
			public Integer next() {
				size--;
				return Fibonacci.this.next();
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	public static void main(String[] args) {
		Fibonacci generator = new Fibonacci();
		for(int i = 0; i < 20; i++)
			System.out.print(generator.next() + " ");
		System.out.println();
		Fibonacci generator2 = new Fibonacci(20);
		Iterator iterator = generator2.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}

/* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 
*/
