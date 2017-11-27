// A toaster that uses queues.
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Toast {
	public enum Status {
		DRY, BUTTERED, JAMMED
	}

	private Status status = Status.DRY;
	private final int id;

	public Toast(int idn) {
		id = idn;
	}

	public void butter() {
		status = Status.BUTTERED;
	}

	public void jam() {
		status = Status.JAMMED;
	}

	public Status getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Toast " + id + ": " + status;
	}
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random rand = new Random(47);

	public Toaster(ToastQueue tq) {
		toastQueue = tq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				// Make toast
				Toast t = new Toast(count++);
				print(t);
				// Insert into queue
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			print("Toaster interrupted");
		}
		print("Toaster off");
	}
}

// Apply butter to toast:
class Butterer implements Runnable {
	private ToastQueue dryQueue, butteredQueue;

	public Butterer(ToastQueue dry, ToastQueue buttered) {
		dryQueue = dry;
		butteredQueue = buttered;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t = dryQueue.take();
				t.butter();
				print(t);
				butteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			print("Butterer interrupted");
		}
		print("Butterer off");
	}
}

// Apply jam to dry toast:
class Jammer implements Runnable {
	private ToastQueue dryQueue, jammedQueue;

	public Jammer(ToastQueue dry, ToastQueue jammed) {
		dryQueue = dry;
		jammedQueue = jammed;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t = dryQueue.take();
				t.jam();
				print(t);
				jammedQueue.put(t);
			}
		} catch (InterruptedException e) {
			print("Jammer interrupted");
		}
		print("Jammer off");
	}
}

class Sandwich {
	Toast t1, t2;
	private final int id;
	Sandwich(Toast t1, Toast t2, int id) {
		this.t1 = t1;
		this.t2 = t2;
		this.id = id;
	}
	public int getID() {
		return id;
	}
	public String toString() {
		return "Sandwich #" + id + ", bottom toast: " + t1 + ", top: " + t2;
	}
}

// Makes a sandwich out of two available toasts (one buttered and one jammed)
class Mixer implements Runnable {
	private ToastQueue butteredQueue, jammedQueue;
	private MixedQueue mixedQueue;
	private int count = 0;
	
	public Mixer(ToastQueue buttered, ToastQueue jammed, MixedQueue mixed) {
		this.butteredQueue = buttered;
		this.jammedQueue = jammed;
		this.mixedQueue = mixed;
	}
	
	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t = butteredQueue.take();
				Toast t2 = jammedQueue.take();
				Sandwich s = new Sandwich(t, t2, count++);
				print(s);
				mixedQueue.put(s);
			}
		} catch (InterruptedException e) {
			print("Mixer interrupted");
		}
		print("Mixer off");
	}
}

class MixedQueue extends LinkedBlockingQueue<Sandwich> {
}

// Consume the toast:
class Eater implements Runnable {
	private MixedQueue mixedQueue;
	private int counter = 0;

	public Eater(MixedQueue mixed) {
		mixedQueue = mixed;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next sandwich is available:
				Sandwich s = mixedQueue.take();
				// Verify that the sandwich is coming in order,
				// and that all pieces are getting jammed and buttered:
				if (s.getID() != counter++ || s.t1.getStatus() != Toast.Status.BUTTERED || s.t2.getStatus() != Toast.Status.JAMMED) {
					print(">>>> Error: " + s);
					System.exit(1);
				} else
					print("Chomp! " + s);
			}
		} catch (InterruptedException e) {
			print("Eater interrupted");
		}
		print("Eater off");
	}
}

public class ToastOMatic {
	public static void main(String[] args) throws Exception {
		ToastQueue dryQueue = new ToastQueue(), butteredQueue = new ToastQueue(), jammedQueue = new ToastQueue();
		MixedQueue mixedQueue = new MixedQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(dryQueue, jammedQueue));
		exec.execute(new Mixer(butteredQueue, jammedQueue, mixedQueue));
		exec.execute(new Eater(mixedQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}

/* Output:
Toast 0: DRY
Toast 0: BUTTERED
Toast 1: DRY
Toast 1: JAMMED
Sandwich #0, bottom toast: Toast 0: BUTTERED, top: Toast 1: JAMMED
Chomp! Sandwich #0, bottom toast: Toast 0: BUTTERED, top: Toast 1: JAMMED
Toast 2: DRY
Toast 2: BUTTERED
Toast 3: DRY
Toast 3: JAMMED
Sandwich #1, bottom toast: Toast 2: BUTTERED, top: Toast 3: JAMMED
Chomp! Sandwich #1, bottom toast: Toast 2: BUTTERED, top: Toast 3: JAMMED
Toast 4: DRY
Toast 4: BUTTERED
Toast 5: DRY
Toast 5: JAMMED
Sandwich #2, bottom toast: Toast 4: BUTTERED, top: Toast 5: JAMMED
Chomp! Sandwich #2, bottom toast: Toast 4: BUTTERED, top: Toast 5: JAMMED
Toast 6: DRY
Toast 6: BUTTERED
Toast 7: DRY
Toast 7: JAMMED
Sandwich #3, bottom toast: Toast 6: BUTTERED, top: Toast 7: JAMMED
Chomp! Sandwich #3, bottom toast: Toast 6: BUTTERED, top: Toast 7: JAMMED
Toast 8: DRY
Toast 8: BUTTERED
Toast 9: DRY
Toast 9: JAMMED
Sandwich #4, bottom toast: Toast 8: BUTTERED, top: Toast 9: JAMMED
Chomp! Sandwich #4, bottom toast: Toast 8: BUTTERED, top: Toast 9: JAMMED
Toast 10: DRY
Toast 10: BUTTERED
Toast 11: DRY
Toast 11: JAMMED
Sandwich #5, bottom toast: Toast 10: BUTTERED, top: Toast 11: JAMMED
Chomp! Sandwich #5, bottom toast: Toast 10: BUTTERED, top: Toast 11: JAMMED
Toast 12: DRY
Toast 12: BUTTERED
Toast 13: DRY
Toast 13: JAMMED
Sandwich #6, bottom toast: Toast 12: BUTTERED, top: Toast 13: JAMMED
Chomp! Sandwich #6, bottom toast: Toast 12: BUTTERED, top: Toast 13: JAMMED
Toast 14: DRY
Toast 14: BUTTERED
Jammer interrupted
Jammer off
Toaster interrupted
Mixer interrupted
Mixer off
Toaster off
Butterer interrupted
Eater interrupted
Butterer off
Eater off
*/