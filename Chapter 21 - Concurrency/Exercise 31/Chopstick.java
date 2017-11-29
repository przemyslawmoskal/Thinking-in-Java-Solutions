//: concurrency/Chopstick.java
// Chopsticks for dining philosophers.

public class Chopstick {
	private boolean taken = false;
	private final int id;
	public int getID() {
		return id;
	}
	Chopstick(int i) {
		this.id = i;
	}

	public synchronized void take() throws InterruptedException {
		while (taken)
			wait();
		taken = true;
	}

	public synchronized void drop() {
		taken = false;
		notifyAll();
	}
	
} /// :~
