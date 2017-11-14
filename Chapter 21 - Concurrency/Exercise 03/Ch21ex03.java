import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassA implements Runnable {
	MyClassA() {
		System.out.println("Creation of MyClassA");
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyClassA.run()");
			Thread.yield();
		}
		System.out.println("Task from MyClassA completed");
		return;
	}
}

class MyClassB implements Runnable {
	MyClassB() {
		System.out.println("Creation of MyClassB");
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyClassB.run()");
			Thread.yield();
		}
		System.out.println("Task from MyClassB completed");
		return;
	}
}

class MyClassC implements Runnable {
	MyClassC() {
		System.out.println("Creation of MyClassC");
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyClassC.run()");
			Thread.yield();
		}
		System.out.println("Task from MyClassC completed");
		return;
	}
}




public class Ch21ex03 {

	public static void main(String[] args) {
		System.out.println("********* Beginning of main() *********");
		
		ExecutorService execCached = Executors.newCachedThreadPool();
		execCached.execute(new MyClassA());
		execCached.execute(new MyClassB());
		execCached.execute(new MyClassC());
		execCached.shutdown();
		ExecutorService execFixed = Executors.newFixedThreadPool(3);
		execFixed.execute(new MyClassA());
		execFixed.execute(new MyClassB());
		execFixed.execute(new MyClassC());
		execFixed.shutdown();
		ExecutorService execSingle = Executors.newSingleThreadExecutor();
		execSingle.execute(new MyClassA());
		execSingle.execute(new MyClassB());
		execSingle.execute(new MyClassC());
		execSingle.shutdown();
		System.out.println("********* End of main() *********");
	}

}

/* Output:
********* Beginning of main() *********
Creation of MyClassA
MyClassA.run()
MyClassA.run()
MyClassA.run()
Task from MyClassA completed
Creation of MyClassB
MyClassB.run()
MyClassB.run()
MyClassB.run()
Task from MyClassB completed
Creation of MyClassC
MyClassC.run()
MyClassC.run()
MyClassC.run()
Task from MyClassC completed
Creation of MyClassA
Creation of MyClassB
MyClassA.run()
MyClassA.run()
Creation of MyClassC
MyClassA.run()
MyClassB.run()
Task from MyClassA completed
MyClassB.run()
MyClassB.run()
Task from MyClassB completed
Creation of MyClassA
MyClassC.run()
MyClassC.run()
Creation of MyClassB
MyClassA.run()
MyClassC.run()
Creation of MyClassC
********* End of main() *********
Task from MyClassC completed
MyClassA.run()
MyClassA.run()
Task from MyClassA completed
MyClassB.run()
MyClassB.run()
MyClassB.run()
Task from MyClassB completed
MyClassC.run()
MyClassC.run()
MyClassC.run()
Task from MyClassC completed
*/