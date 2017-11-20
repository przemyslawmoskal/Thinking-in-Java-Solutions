import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassA implements Runnable {
	private String fieldA;
	private String fieldB;
	public void manipulateFields() {
		for(int i = 0; i < 1000; i++) {
			fieldA = "incorrectA !!!!!!!!!!";
			fieldB = "incorrectB !!!!!!!!!!";
		}
		fieldA = "correctA";
		fieldB = "correctB";
	}
	public MyClassA() {
		fieldA = "correctA";
		fieldB = "correctB";
	}
	public String getA() {
		return fieldA;
	}
	public String getB() {
		return fieldB;
	}
	public void run() {
		manipulateFields();
		System.out.println("fieldA: " + getA());
		System.out.println("fieldB: " + getB());
	}
	
}


public class Ch21ex11a {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		MyClassA obj = new MyClassA();
		for(int i = 0; i < 10000; i++) {
			exec.execute(obj);
		}
		exec.shutdown();
	}

}

/* Output (When key word "synchonized" is not used - sometimes fields are in incorrect state):
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
fieldB: incorrectB !!!!!!!!!!
...
fieldA: incorrectA !!!!!!!!!!
...
*/