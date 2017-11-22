import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Count {
	private int count = 0;
	private Random rand = new Random(47);
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

class Sensor implements Runnable {
	private static Random rand = new Random(64);
	private static Count count = new Count();
	private static List<Sensor> sensors = new ArrayList<Sensor>();
	private int number = 0;
	// Doesn't need synchronization to read:
	private final int id;
	private static volatile boolean canceled = false;

	// Atomic operation on a volatile field:
	public static void cancel() {
		canceled = true;
	}

	public Sensor(int id) {
		this.id = id;
		// Keep this task in a list. Also prevents
		// garbage collection of dead tasks:
		sensors.add(this);
	}

	public void run() {
		while (!canceled) {
			if(rand.nextInt(4) == 0) {
				synchronized (this) {
					++number;
				}
				print(this + " Total: " + count.increment());
			}
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				print("sleep interrupted");
			}
		}
		print("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Sensor " + id + ": " + getValue();
	}

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumSensors() {
		int sum = 0;
		for (Sensor sensor : sensors)
			sum += sensor.getValue();
		return sum;
	}
}

public class Ch21ex17 {
	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		System.out.println("How many sensors do you want to check radiation with?\n" + 
				"(Hint: Type \'0\' to exit program)");
		boolean isCorrectValue = false;
		int howManySensors = 0;
		while(!isCorrectValue) {
			sc = new Scanner(System.in);
			if(!sc.hasNextInt()) {
				System.out.println("Incorrect value, type positive integer or \'0\' to exit program:");
			}else {
				int value = sc.nextInt();
				if(value < 0) {
					System.out.println("Incorrect value, type positive integer or \'0\' to exit program:");
				} else if(value == 0) {
					System.out.println("Good bye!");
					System.exit(0);
				} else {
					howManySensors = value;
					isCorrectValue = true;
				}
			}
		}
		for (int i = 0; i < howManySensors; i++)
			exec.execute(new Sensor(i));
		// Run for a while, then stop and collect the data:
		TimeUnit.SECONDS.sleep(5);
		Sensor.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			print("Some tasks were not terminated!");
		print("Total: " + Sensor.getTotalCount());
		print("Sum of Sensors: " + Sensor.sumSensors());
	}
}

/* Output:
How many sensors do you want to check radiation with?
(Hint: Type '0' to exit program)
a  <-- USER INPUT
Incorrect value, type positive integer or '0' to exit program:
-2 <-- USER INPUT
Incorrect value, type positive integer or '0' to exit program:
4 <-- USER INPUT
Sensor 2: 1 Total: 1
Sensor 1: 1 Total: 2
Sensor 0: 1 Total: 3
Sensor 1: 2 Total: 4
Sensor 0: 2 Total: 5
...
Sensor 1: 15 Total: 49
Sensor 2: 14 Total: 50
Sensor 0: 15 Total: 51
Sensor 3: 8 Total: 52
Sensor 0: 16 Total: 53
Sensor 2: 15 Total: 54
Sensor 0: 17 Total: 55
Stopping Sensor 0: 17
Stopping Sensor 3: 8
Stopping Sensor 1: 15
Stopping Sensor 2: 15
Total: 55
Sum of Sensors: 55
*/
