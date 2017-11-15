import java.util.concurrent.*;
import static net.mindview.util.Print.*;

class Daemon implements Runnable {
	private Thread[] t = new Thread[10];

	public void run() {
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch(InterruptedException e) {
				System.out.println("Interrupted!");
			}
			printnb("DaemonSpawn " + i + " started, ");
		}
		for (int i = 0; i < t.length; i++)
			printnb("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
		while (true)
			Thread.yield();
	}
}

class DaemonSpawn implements Runnable {
	public void run() {
		while (true)
			Thread.yield();
	}
}

public class Daemons {
	public static void main(String[] args) throws Exception {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		printnb("d.isDaemon() = " + d.isDaemon() + ", ");
		// Now daemons are not allowed to finish their startup processses:
		// TimeUnit.SECONDS.sleep(1);
	}
}

/* Output:
DaemonSpawn 0 started, d.isDaemon() = true, DaemonSpawn 1 started, 
*/