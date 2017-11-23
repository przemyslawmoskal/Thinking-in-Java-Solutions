import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ch21ex22a {
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
					flag = true;
				}
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				while(true) {
					while(!flag && !Thread.currentThread().isInterrupted()) {
						System.out.println("Flag changed " + ++counter + " times");
					}
					flag = false;
					if(Thread.interrupted()) {
						return;
					}
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
...
Flag changed 105763 times
Flag changed 105764 times
Flag changed 105765 times
Flag changed 105766 times
Flag changed 105767 times
Flag changed 105768 times
Flag changed 105769 times
Flag changed 105770 times
Flag changed 105771 times
Flag changed 105772 times
InterruptedException in r1
*/