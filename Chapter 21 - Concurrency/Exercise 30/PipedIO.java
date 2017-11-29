import java.util.concurrent.*;
import java.io.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Sender implements Runnable {
	private Random rand = new Random(47);
	private LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
	public LinkedBlockingQueue<Character> getQueue() {
		return queue;
	}
	public void run() {
		try {
			while (true)
				for (char c = 'A'; c <= 'z'; c++) {
					queue.put(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
		} catch (InterruptedException e) {
			print(e + " Sender sleep interrupted");
		}
	}
}

class Receiver implements Runnable {
	private LinkedBlockingQueue<Character> queue;

	public Receiver(Sender sender) throws IOException {
		queue = sender.getQueue();
	}

	public void run() {
		try {
			while (true) {
				// Blocks until characters are there:
				printnb("Read: " + queue.take() + ", ");
			}
		} catch (InterruptedException e) {
			print(e + " Receiver interrupted");
		}
	}
}

public class PipedIO {
	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	}
}

/* Output: (Sample)
Read: A, Read: B, Read: C, Read: D, Read: E, Read: F, Read: G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M, Read: N, Read: O, Read: P, Read: Q, java.lang.InterruptedException Receiver interrupted
java.lang.InterruptedException: sleep interrupted Sender sleep interrupted
*/