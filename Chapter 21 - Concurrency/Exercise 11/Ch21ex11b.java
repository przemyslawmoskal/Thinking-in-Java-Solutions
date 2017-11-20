import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassB implements Runnable {
	private String fieldA;
	private String fieldB;
	public synchronized void manipulateFields() {
		for(int i = 0; i < 1000; i++) {
			fieldA = "incorrectA !!!!!!!!!!";
			fieldB = "incorrectB !!!!!!!!!!";
		}
		fieldA = "correctA";
		fieldB = "correctB";
	}
	public MyClassB() {
		fieldA = "correctA";
		fieldB = "correctB";
	}
	public synchronized String getA() {
		return fieldA;
	}
	public synchronized String getB() {
		return fieldB;
	}
	public void run() {
		manipulateFields();
		System.out.println("fieldA: " + getA());
		System.out.println("fieldB: " + getB());
	}
	
}


public class Ch21ex11b {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		MyClassB obj = new MyClassB();
		for(int i = 0; i < 10000; i++) {
			exec.execute(obj);
		}
		exec.shutdown();
	}

}

/* Output (When key word "synchronized" is used - fields are always in correct state):
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
...
*/