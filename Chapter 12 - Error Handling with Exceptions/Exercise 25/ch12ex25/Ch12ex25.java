package ch12ex25;
import static ptmoskal.Print.*;

class FirstLevelException extends Exception {}
class SecondLevelException extends FirstLevelException {}
class ThirdLevelException extends SecondLevelException {}

class A {
	public void f() throws FirstLevelException {
		print("f() from class A");
		throw new FirstLevelException();
	}
}

class B extends A {
	public void f() throws SecondLevelException {
		print ("f() from class B");
		throw new SecondLevelException();
	}
}

class C extends B {
	public void f() throws ThirdLevelException {
		print ("f() from class C");
		throw new ThirdLevelException();
	}
}

public class Ch12ex25 {

	public static void main(String[] args) {
		A obj = new C();
		try {
			obj.f();
		} catch(ThirdLevelException e) {
			System.err.print("<< ThirdLevelException caught >>");
			e.printStackTrace();
		} catch(SecondLevelException e) {
			System.err.print("<< SecondLevelException caught >>");
			e.printStackTrace();
		} catch(FirstLevelException e) {
			System.err.print("<< FirstLevelException caught >>");
			e.printStackTrace();
		}	
	}

}

/* Output:
f() from class C
<< ThirdLevelException caught >>ch12ex25.ThirdLevelException
	at ch12ex25.C.f(Ch12ex25.java:25)
	at ch12ex25.Ch12ex25.main(Ch12ex25.java:34)
*/
