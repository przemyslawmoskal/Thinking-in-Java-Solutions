import java.util.concurrent.*;
import java.util.*;
import net.mindview.util.*;

class MyClass {
	private final int id = counter++;
	private static int counter = 0;
	public String toString() {
		return this.getClass().getSimpleName() + " #" + id;
	}
}

class MyClassGenerator implements Generator<MyClass> {
	public MyClass next() {
		return new MyClass();
	}
}

class ExchangerProducer<T> implements Runnable {
	private Generator<T> generator;
	private Exchanger<List<T>> exchanger;
	private List<T> holder;

	ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
		exchanger = exchg;
		generator = gen;
		this.holder = holder;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				for (int i = 0; i < ExchangerDemo.size; i++)
					holder.add(generator.next());
				// Exchange full for empty:
				holder = exchanger.exchange(holder);
			}
		} catch (InterruptedException e) {
			// OK to terminate this way.
		}
	}
}

class ExchangerConsumer<T> implements Runnable {
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;

	ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
		exchanger = ex;
		this.holder = holder;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				holder = exchanger.exchange(holder);
				for (T x : holder) {
					value = x; // Fetch out value
					holder.remove(x); // OK for CopyOnWriteArrayList
				}
			}
		} catch (InterruptedException e) {
			// OK to terminate this way.
		}
		System.out.println("Final value: " + value);
	}
}

public class ExchangerDemo {
	static int size = 10;
	static int delay = 5; // Seconds

	public static void main(String[] args) throws Exception {
		if (args.length > 0)
			size = new Integer(args[0]);
		if (args.length > 1)
			delay = new Integer(args[1]);
		Generator<MyClass> generator = new MyClassGenerator();
		ExecutorService exec = Executors.newCachedThreadPool();
		Exchanger<List<MyClass>> xc = new Exchanger<List<MyClass>>();
		List<MyClass> producerList = new CopyOnWriteArrayList<MyClass>(), consumerList = new CopyOnWriteArrayList<MyClass>();
		exec.execute(new ExchangerProducer<MyClass>(xc, generator, producerList));
		exec.execute(new ExchangerConsumer<MyClass>(xc, consumerList));
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdownNow();
	}
} 

/* Output:
Final value: MyClass #19073519
*/
