package ch14ex08;

class A {
	public String toString() {
		return "class A";
	}
}

class AA extends A {
	public String toString() {
		return "class AA";
	}
}

class AAA extends AA {
	public String toString() {
		return "class AAA";
	}
}

public class Ch14ex08 {
	public static void showClasses(Object obj) {
		if(obj.getClass().getSuperclass() != null) {
			System.out.println(obj.getClass() + ", superclass: " + obj.getClass().getSuperclass());
			try {
				showClasses(obj.getClass().getSuperclass().newInstance());
			}catch(IllegalAccessException e) {
				System.out.println("Unable to access...");
			}catch(InstantiationException e) {
				System.out.println("Unable to instantiate...");
			}
		}
	}

	public static void main(String[] args) {
		showClasses(new AAA());
	}
}

/* Output:
class ch14ex08.AAA, superclass: class ch14ex08.AA
class ch14ex08.AA, superclass: class ch14ex08.A
class ch14ex08.A, superclass: class java.lang.Object
*/