import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ch21ex22b {
	public static volatile boolean flag = false;
	public static int counter = 0;
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						System.out.println("InterruptedException in r1");
						return;
					}
					synchronized(this) {
						notify();
					}
				}
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						synchronized(r1) {
							r1.wait();
						}
					} catch(InterruptedException e) {
						System.out.println("InterruptedException in r2");
						return;
					}
					System.out.println("Flag changed " + ++counter + " times");
				}

			}
		};
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(r1);
		exec.execute(r2);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in main()");
		}
		exec.shutdownNow();
	}

}

/* Output:
Flag changed 1 times
Flag changed 2 times
Flag changed 3 times
Flag changed 4 times
Flag changed 5 times
Flag changed 6 times
Flag changed 7 times
Flag changed 8 times
Flag changed 9 times
Flag changed 10 times
InterruptedException in r2
InterruptedException in r1
*/