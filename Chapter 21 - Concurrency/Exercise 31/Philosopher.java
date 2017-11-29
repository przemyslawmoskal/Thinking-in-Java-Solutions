
//: concurrency/Philosopher.java
// A dining philosopher
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class Philosopher implements Runnable {
	private Chopsticks chopsticks = new Chopsticks();
	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);

	private void pause() throws InterruptedException {
		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
	}

	public Philosopher(Chopsticks chopsticks, int ident, int ponder) {
		this.chopsticks = chopsticks;
		id = ident;
		ponderFactor = ponder;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				print(this + " " + "thinking");
				pause();
				// Philosopher becomes hungry
				Chopstick c1 = chopsticks.take();
				print(this + " " + "grabbed right (number " + c1.getID() + ")");
				Chopstick c2 = chopsticks.take();
				print(this + " " + "grabbed left (number " + c1.getID() + ")");
				print(this + " " + "eating");
				pause();
				print(this + " returns chopsticks: " + c1.getID() + " and " + c2.getID() + " after meal");
				chopsticks.put(c1);
				chopsticks.put(c2);
			}
		} catch (InterruptedException e) {
			print(this + " " + "exiting via interrupt");
		}
	}

	public String toString() {
		return "Philosopher " + id;
	}
} /// :~
