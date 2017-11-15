import java.util.Random;
import java.util.concurrent.*;

// Args: {15}

class MyTask implements Runnable {
	Random rand = new Random();
	public void run() {
		int time = 1 + rand.nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(time);
			System.out.println("Sleep time: " + time + " second(s)");
			return;
		} catch(InterruptedException e) {
			System.out.println("Interrupted!");
		}
		
	}
}

public class Ch21ex06 {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: Enter number of tasks");
			System.exit(1);
		}
		Integer numberOfTasks = Integer.parseInt(args[0]);
		System.out.println("Number of tasks: " + numberOfTasks);
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < numberOfTasks; i++) {
			exec.execute(new MyTask());
		}
		exec.shutdown();
	}

}

/* Output:
Number of tasks: 15
Sleep time: 1 second(s)
Sleep time: 2 second(s)
Sleep time: 2 second(s)
Sleep time: 3 second(s)
Sleep time: 3 second(s)
Sleep time: 4 second(s)
Sleep time: 4 second(s)
Sleep time: 6 second(s)
Sleep time: 6 second(s)
Sleep time: 6 second(s)
Sleep time: 7 second(s)
Sleep time: 9 second(s)
Sleep time: 10 second(s)
Sleep time: 10 second(s)
Sleep time: 10 second(s)
*/