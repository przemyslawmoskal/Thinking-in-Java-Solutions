package ch12ex24;
import static ptmoskal.Print.print;

class FailingConstructor{
	public static int counter = 0;
	private int id = counter++;
	FailingConstructor(int i){
		Integer[] arr = new Integer[3];
		arr[i] = 128;
		print("arr[" + i + "] = " + arr[i]);
	}
	public void dispose() { print("disposing obj(" + id + ") ..."); }
}

public class Ch12ex24 {

	public static void main(String[] args) {
		try {
			print("Creating obj0...");
			FailingConstructor obj0 = new FailingConstructor(0);
			try {
				print("Creating obj1...");
				FailingConstructor obj1 = new FailingConstructor(1);
				try {
					print("Creating obj2...");
					FailingConstructor obj2 = new FailingConstructor(2);
					try {
						print("Creating obj3...");
						FailingConstructor obj3 = new FailingConstructor(3);
					} catch(Exception e) {
						System.err.print("<< Failed to create obj3 >>");
						e.printStackTrace();
					} finally {
						obj2.dispose();
					}
				} catch(Exception e) {
					System.err.print("<< Failed to create obj1 >>");
					e.printStackTrace();
				} finally {
					obj1.dispose();
				}
			} catch(Exception e) {
				System.err.print("<< Failed to create obj1 >>");
				e.printStackTrace();
			} finally {
				obj0.dispose();
			}
		} catch(Exception e) {
			System.err.print("<< Failed to create obj0 >>");
			e.printStackTrace();
		}
	}
}

/* Output:
Creating obj0...
arr[0] = 128
Creating obj1...
arr[1] = 128
Creating obj2...
arr[2] = 128
Creating obj3...
disposing obj(2) ...
disposing obj(1) ...
disposing obj(0) ...
<< Failed to create obj3 >>java.lang.ArrayIndexOutOfBoundsException: 3
	at ch12ex24.FailingConstructor.<init>(Ch12ex24.java:9)
	at ch12ex24.Ch12ex24.main(Ch12ex24.java:29)
*/