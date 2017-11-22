import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Count {
	private int count = 0;
	private Random rand = new Random(47);

	// Remove the synchronized keyword to see counting fail:
	public synchronized int increment() {
		int temp = count;
		if (rand.nextBoolean()) // Yield half the time
			Thread.yield();
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
}

class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	private int number = 0;
	// Doesn't need synchronization to read:
	private final int id;
	private static volatile boolean canceled = false;

	// Atomic operation on a volatile field:
	public static void cancel() {
		canceled = true;
	}

	public Entrance(int id) {
		this.id = id;
		// Keep this task in a list. Also prevents
		// garbage collection of dead tasks:
		entrances.add(this);
	}

	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			print(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				print("sleep interrupted");
				canceled = true; // this line is needed to end looping when interruption occurred;
			}
		}
		print("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances)
			sum += entrance.getValue();
		return sum;
	}
}

public class OrnamentalGarden {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new Entrance(i));
		// Run for a while, then stop and collect the data:
		TimeUnit.SECONDS.sleep(3);
		// Causing interruption without cancelling:
		exec.shutdownNow();
		// Entrance.cancel();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			print("Some tasks were not terminated!");
		print("Total: " + Entrance.getTotalCount());
		print("Sum of Entrances: " + Entrance.sumEntrances());
	}
}

/* Output: (Sample)
Entrance 2: 1 Total: 3
Entrance 1: 1 Total: 2
Entrance 3: 1 Total: 5
Entrance 0: 1 Total: 1
Entrance 4: 1 Total: 4
Entrance 1: 2 Total: 6
Entrance 2: 2 Total: 9
Entrance 3: 2 Total: 8
Entrance 0: 2 Total: 7
Entrance 4: 2 Total: 10
...
Entrance 2: 30 Total: 147
Entrance 4: 30 Total: 146
Entrance 0: 30 Total: 148
Entrance 3: 30 Total: 149
Entrance 1: 30 Total: 150
sleep interrupted
sleep interrupted
Stopping Entrance 3: 30
sleep interrupted
Stopping Entrance 0: 30
sleep interrupted
Stopping Entrance 4: 30
Stopping Entrance 1: 30
sleep interrupted
Stopping Entrance 2: 30
Total: 150
Sum of Entrances: 150
*/