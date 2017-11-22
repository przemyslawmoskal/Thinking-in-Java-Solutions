import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NotATask {
	public void makeItSleep() {
		try {
			System.out.println("NotATask.makeItSleep()");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		} finally {
			System.out.println("finally {}");
		}
	}
}

class IsATask implements Runnable {
	NotATask nat = new NotATask();
	public void run() {
		nat.makeItSleep();
	}
}

public class Ch21ex18 {

	public static void main(String[] args) {
		Thread t = new Thread(new IsATask());
		t.start();
		t.interrupt();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new IsATask());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Interrupted in main()");
		}
		exec.shutdownNow();
		ExecutorService exec2 = Executors.newCachedThreadPool();
		Future<?> f = exec2.submit(new IsATask());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Interrupted in main()");
		}
		f.cancel(true);
		exec2.shutdown();
	}

}

/* Output:
NotATask.makeItSleep()
Interrupted
finally {}
NotATask.makeItSleep()
Interrupted
finally {}
NotATask.makeItSleep()
Interrupted
finally {}
*/
