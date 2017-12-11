
//: concurrency/ActiveObjectDemo.java
// Can only pass constants, immutables, "disconnected
// objects," or other active objects as arguments
// to asynch methods.
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class ActiveObjectDemo {
	private ExecutorService ex = Executors.newSingleThreadExecutor();
	private Random rand = new Random(47);

	// Insert a random delay to produce the effect
	// of a calculation time:
	private void pause(int factor) {
		try {
			TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
		} catch (InterruptedException e) {
			print("sleep() interrupted");
		}
	}

	public Future<Integer> calculateInt(final int x, final int y) {
		return ex.submit(new Callable<Integer>() {
			public Integer call() {
				print("starting " + x + " + " + y);
				pause(1500);
				return x + y;
			}
		});
	}
	
	public void test(String s) {
		ex.execute(new Runnable() {
			public void run() {
				System.out.println("Starting test(" + s + ")");
				Thread.yield();
				pause(1500);
				System.out.println("Finished test(" + s + ")");
			}
		});
	}

	public Future<Float> calculateFloat(final float x, final float y) {
		return ex.submit(new Callable<Float>() {
			public Float call() {
				print("starting " + x + " + " + y);
				pause(1000);
				return x + y;
			}
		});
	}

	public void shutdown() {
		ex.shutdown();
	}

	public static void main(String[] args) {
		ActiveObjectDemo d1 = new ActiveObjectDemo();
		// Prevents ConcurrentModificationException:
		List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();
		for (float f = 0.0f; f < 1.0f; f += 0.2f) {
			results.add(d1.calculateFloat(f, f));
			d1.test(Float.toString(f));
		}
		for (int i = 0; i < 5; i++) {
			results.add(d1.calculateInt(i, i));
		}
		print("All asynch calls made");
		while (results.size() > 0) {
			for (Future<?> f : results)
				if (f.isDone()) {
					try {
						print(f.get());
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					results.remove(f);
				}
		}
		d1.shutdown();
	}
}

/* Output: (Sample)
starting 0.0 + 0.0
All asynch calls made
0.0
Starting test(0.0)
Finished test(0.0)
starting 0.2 + 0.2
Starting test(0.2)
0.4
Finished test(0.2)
starting 0.4 + 0.4
0.8
Starting test(0.4)
Finished test(0.4)
starting 0.6 + 0.6
1.2
Starting test(0.6)
Finished test(0.6)
starting 0.8 + 0.8
1.6
Starting test(0.8)
Finished test(0.8)
starting 0 + 0
starting 1 + 1
0
2
starting 2 + 2
4
starting 3 + 3
6
starting 4 + 4
8
*/