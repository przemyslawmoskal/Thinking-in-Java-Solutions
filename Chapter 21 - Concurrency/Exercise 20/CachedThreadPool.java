import java.util.concurrent.*;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)  {
			Future<?> f = exec.submit(new LiftOff());
			try {
				TimeUnit.SECONDS.sleep(i + 1);
			} catch (InterruptedException e) {
				System.out.println("Interrupted exception in main()");
			}
			f.cancel(true);
		}
		exec.shutdown();
	}
}

/* Output: (Sample)
#0(9), #1(9), #0(8), 
Interrupted #0
#1(8), #1(7), #2(9), 
Interrupted #1
#2(8), #2(7), #2(6), #3(9), 
Interrupted #2
#3(8), #3(7), #3(6), #3(5), #4(9), 
Interrupted #3
#4(8), #4(7), #4(6), #4(5), #4(4), 
Interrupted #4
*/