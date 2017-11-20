import java.util.*;
import java.util.concurrent.TimeUnit;

public class Ch21ex14 {

	public static void main(String[] args) {
		Random rand = new Random();
		for(int i = 0; i < 20000; i++) {
			Timer t = new Timer();
				t.schedule(new TimerTask() {
					public void run() {
						System.out.println(System.nanoTime());
					}
				}, 1000 + rand.nextInt(5000));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}

/* Output:
5373941385937
5373942385307
5373942399550
5373942389926
5373944382892
5373944385587
5373945395351
5373946400111
...
*/