import java.util.concurrent.*;
import java.util.*;

class SimplePrioritiesThreadFactory implements ThreadFactory {
	Random rand = new Random();
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		int i = rand.nextInt(3);
		switch(i) {
			case 0: t.setPriority(Thread.MIN_PRIORITY); break;
			case 1: t.setPriority(Thread.NORM_PRIORITY); break;
			case 2: t.setPriority(Thread.MAX_PRIORITY); break;
		}
		return t;
	}
}

public class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d; // No optimization
	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	public void run() {
		while (true) {
			// An expensive, interruptable operation:
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new SimplePrioritiesThreadFactory());
		for (int i = 0; i < 5; i++)
			exec.execute(new SimplePriorities());
		exec.execute(new SimplePriorities());
		exec.shutdown();
	}
}

/* Output:
Thread[Thread-0,1,main]: 5
Thread[Thread-4,10,main]: 5
Thread[Thread-5,1,main]: 5
Thread[Thread-1,10,main]: 5
Thread[Thread-3,10,main]: 5
Thread[Thread-4,10,main]: 4
Thread[Thread-1,10,main]: 4
Thread[Thread-0,1,main]: 4
Thread[Thread-5,1,main]: 4
Thread[Thread-4,10,main]: 3
Thread[Thread-1,10,main]: 3
Thread[Thread-0,1,main]: 3
Thread[Thread-5,1,main]: 3
Thread[Thread-4,10,main]: 2
Thread[Thread-1,10,main]: 2
Thread[Thread-0,1,main]: 2
Thread[Thread-5,1,main]: 2
Thread[Thread-4,10,main]: 1
Thread[Thread-1,10,main]: 1
Thread[Thread-0,1,main]: 1
Thread[Thread-5,1,main]: 1
Thread[Thread-3,10,main]: 4
Thread[Thread-3,10,main]: 3
Thread[Thread-2,1,main]: 5
Thread[Thread-3,10,main]: 2
Thread[Thread-2,1,main]: 4
Thread[Thread-3,10,main]: 1
Thread[Thread-2,1,main]: 3
Thread[Thread-2,1,main]: 2
Thread[Thread-2,1,main]: 1
*/
