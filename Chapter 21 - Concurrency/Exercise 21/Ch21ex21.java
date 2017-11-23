import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyClass1 implements Runnable {
	private volatile boolean action = false;
	@Override
	public void run() {
		while(action == false) {
			System.out.println("MyClass1.run()");
			synchronized(this) {
				try {
					System.out.println("wait() in MyClass1()");
					wait();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException in MyClass1");
				}
			}
			
		}
		System.out.println("***** Message after waiting in MyClass1 *****");
	}
	
	public synchronized void setActionTrue() {
		this.action = true;
	}
	
	public synchronized boolean showAction() {
		return this.action;
	}
	
}

class MyClass2 implements Runnable {
	MyClass1 mc1;
	MyClass2(MyClass1 mc1) {
		this.mc1 = mc1;
	}
	@Override
	public void run() {
		try {
			System.out.println("MyClass2.run()");
			System.out.println("MyClass2 sleeping for 3 seconds");
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in MyClass2");
		}
		while(!this.mc1.showAction()) {
			System.out.println("Entering synchronized block in MyClass2");
			synchronized(mc1) {
				System.out.println("mc1.setActionTrue()");
				mc1.setActionTrue();
				System.out.println("mc1.notifyAll() in MyClass2");
				mc1.notifyAll();
			}
			
		}
	}
}

public class Ch21ex21 {

	public static void main(String[] args) {
		MyClass1 mc1obj = new MyClass1();
		MyClass2 mc2obj = new MyClass2(mc1obj);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(mc1obj);
		exec.execute(mc2obj);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdown();
	}

}

/* Output:
MyClass1.run()
wait() in MyClass1()
MyClass2.run()
MyClass2 sleeping for 3 seconds
Entering synchronized block in MyClass2
mc1.setActionTrue()
mc1.notifyAll() in MyClass2
***** Message after waiting in MyClass1 *****
*/
