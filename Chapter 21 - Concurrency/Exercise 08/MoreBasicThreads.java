//: concurrency/MoreBasicThreads.java
// Adding more threads.

public class MoreBasicThreads {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 5; i++) {
				Thread t = new Thread(new LiftOff());
				t.setDaemon(true);
				t.start();
			}
		} finally {
			System.out.println("NOT waiting for LiftOff, program ends with the end of main()");
		}
	}
}

/* Output:
#0(9), #4(9), #3(9), NOT waiting for LiftOff, program ends with end of main()
#2(9), #1(9), #2(8), #3(8), #1(8), #4(8), #0(8), #1(7), #2(7), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), 
*/
