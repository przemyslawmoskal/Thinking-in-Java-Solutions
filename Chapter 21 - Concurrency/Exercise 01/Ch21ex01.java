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




public class Ch21ex01 {

	public static void main(String[] args) {
		System.out.println("********* Beginning of main() *********");
		for(int i = 0; i < 2; i++) {
			new Thread(new MyClassA()).start();
			new Thread(new MyClassB()).start();
			new Thread(new MyClassC()).start();
		}
		System.out.println("********* End of main() *********");
	}

}

/* Output:
********* Beginning of main() *********
Creation of MyClassA
Creation of MyClassB
Creation of MyClassC
Creation of MyClassA
Creation of MyClassB
Creation of MyClassC
********* End of main() *********
MyClassB.run()
MyClassA.run()
MyClassC.run()
MyClassB.run()
MyClassA.run()
MyClassC.run()
MyClassB.run()
MyClassA.run()
MyClassC.run()
Task from MyClassB completed
Task from MyClassA completed
Task from MyClassC completed
MyClassA.run()
MyClassA.run()
MyClassA.run()
Task from MyClassA completed
MyClassC.run()
MyClassC.run()
MyClassC.run()
Task from MyClassC completed
MyClassB.run()
MyClassB.run()
MyClassB.run()
Task from MyClassB completed

*/