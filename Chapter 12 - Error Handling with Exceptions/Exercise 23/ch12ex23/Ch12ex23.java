package ch12ex23;
import static ptmoskal.Print.print;

class FailingConstructor{
	Disp disp1;
	Disp disp2;
	FailingConstructor(int i, int j, int k){
		try {
			disp1 = new Disp(j);
			try {
				Integer[] arr = new Integer[3];
				arr[i] = 128;
				print("arr[" + i + "] = " + arr[i]);
				try {
					disp2 = new Disp(k);
					disp2.dispose();
				} catch(Exception e) {
					System.err.print("<< Failed to create disp2, exception caught in inner try{} >>");
					e.printStackTrace();
				}
			} catch(Exception e) {
				System.err.print("<< Exception caught in middle try{} >>");
				e.printStackTrace();
			} finally {
				disp1.dispose();
			}
		}catch(Exception e) {
			System.err.print("<< Failed to create disp1, exception caught in outer try{} >>");
			e.printStackTrace();
		}
	}
}

class Disp {
	Disp(int i) {
		print("Disp(" + i + ")");
		Integer[] arrInDisp = new Integer[3];
		arrInDisp[i] = 128;
		print("arrInDisp[" + i + "] = " + arrInDisp[i]);
	}
	public void dispose() { print("dispose()"); }
}

public class Ch12ex23 {
	public static void main(String[] args) {
		
		// 1st possibility - everything works fine:
		try {
			FailingConstructor obj1 = new FailingConstructor(1,1,1);
			print("***********");
		} catch(Exception e) {
			System.err.print("<< Failed to create FailingConstructor class object, exception caught in main() try{} >>");
			e.printStackTrace();
		}
		
		// 2nd possibility - Exception in outer try:
		try {
			FailingConstructor obj1 = new FailingConstructor(1,15,1);
			print("***********");
		} catch(Exception e) {
			System.err.print("<< Failed to create FailingConstructor class object, exception caught in main() try{} >>");
			e.printStackTrace();
		}
		
		// 3rd possibility - Exception in middle try:
		try {
			FailingConstructor obj1 = new FailingConstructor(15,1,1);
			print("***********");
		} catch(Exception e) {
			System.err.print("<< Failed to create FailingConstructor class object, exception caught in main() try{} >>");
			e.printStackTrace();
		}
		
		// 4th possibility - Exception in inner try:
		try {
			FailingConstructor obj1 = new FailingConstructor(1,1,15);
			print("***********");
		} catch(Exception e) {
			System.err.print("<< Failed to create FailingConstructor class object, exception caught in main() try{} >>");
			e.printStackTrace();
		}
		
		// 5th possibility - Exception in main() while creating FailingConstructor object:
		try {
			FailingConstructor obj1 = new FailingConstructor(1,1,1);
			print("***********");
			throw new Exception();
		} catch(Exception e) {
			System.err.print("<< Failed to create FailingConstructor class object, exception caught in main() try{} >>");
			e.printStackTrace();
		}
	}
}

/* Output:
Disp(1)
arrInDisp[1] = 128
arr[1] = 128
Disp(1)
arrInDisp[1] = 128
dispose()
dispose()
***********
Disp(15)
***********
Disp(1)
arrInDisp[1] = 128
dispose()
***********
Disp(1)
arrInDisp[1] = 128
arr[1] = 128
Disp(15)
dispose()
***********
Disp(1)
arrInDisp[1] = 128
arr[1] = 128
Disp(1)
arrInDisp[1] = 128
dispose()
dispose()
***********
<< Failed to create disp1, exception caught in outer try{} >>java.lang.ArrayIndexOutOfBoundsException: 15
	at ch12ex23.Disp.<init>(Ch12ex23.java:38)
	at ch12ex23.FailingConstructor.<init>(Ch12ex23.java:9)
	at ch12ex23.Ch12ex23.main(Ch12ex23.java:58)
<< Exception caught in middle try{} >>java.lang.ArrayIndexOutOfBoundsException: 15
	at ch12ex23.FailingConstructor.<init>(Ch12ex23.java:12)
	at ch12ex23.Ch12ex23.main(Ch12ex23.java:67)
<< Failed to create disp2, exception caught in inner try{} >>java.lang.ArrayIndexOutOfBoundsException: 15
	at ch12ex23.Disp.<init>(Ch12ex23.java:38)
	at ch12ex23.FailingConstructor.<init>(Ch12ex23.java:15)
	at ch12ex23.Ch12ex23.main(Ch12ex23.java:76)
<< Failed to create FailingConstructor class object, exception caught in main() try{} >>java.lang.Exception
	at ch12ex23.Ch12ex23.main(Ch12ex23.java:87)
*/