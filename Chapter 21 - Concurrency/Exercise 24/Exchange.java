import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Item {
	private final int id;

	public Item(int number) {
		this.id = number;
	}

	public String toString() {
		return "Item #" + id;
	}
}

class Producer implements Runnable {
	private Exchange exchange;
	private int count = 0;

	public Producer(Exchange ex) {
		exchange = ex;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (exchange.item != null) {
						wait();
					}
				}
				synchronized (exchange.cons) {
					exchange.item = new Item(++count);
					System.out.println(exchange.item + " produced!");
					exchange.cons.notifyAll();
				}

			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted producer task");
		}

	}
}

class Consumer implements Runnable {
	private Exchange exchange;

	public Consumer(Exchange ex) {
		exchange = ex;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized (this) {
					while (exchange.item == null) {
						wait();
					}
				}
				System.out.println(exchange.item + " received by consumer");
				synchronized(exchange.prod) {
					exchange.item = null;
					exchange.prod.notifyAll();
				}
			}
		} catch(InterruptedException e) {
			System.out.println("Interrupted consumer task");
		}
	}
}

public class Exchange {
	Item item;
	Producer prod = new Producer(this);
	Consumer cons = new Consumer(this);
	ExecutorService exec = Executors.newCachedThreadPool();
	public Exchange() {
		exec.execute(prod);
		exec.execute(cons);
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in Exchange");
		}
		exec.shutdownNow();
	}
	public static void main(String[] args) {
		new Exchange();
	}
}

/* Output:
Item #1 produced!
Item #1 received by consumer
Item #2 produced!
Item #2 received by consumer
Item #3 produced!
Item #3 received by consumer
...
Item #26 produced!
Item #26 received by consumer
Item #27 produced!
Item #27 received by consumer
Item #28 produced!
Item #28 received by consumer
Item #29 produced!
Interrupted consumer task
*/