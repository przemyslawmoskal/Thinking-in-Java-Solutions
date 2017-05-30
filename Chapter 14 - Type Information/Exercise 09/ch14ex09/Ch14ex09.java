package ch14ex09;
import java.lang.reflect.*;

class A {
	public String toString() {
		return "class A";
	}
}

class AA extends A {
	float ff;
	byte bb;
	public String toString() {
		return "class AA";
	}
}

class AAA extends AA {
	double dd;
	long ll;
	public String toString() {
		return "class AAA";
	}
}

public class Ch14ex09 {
	public static void showClasses(Object obj) {
		if(obj.getClass().getSuperclass() != null) {
			Class c = obj.getClass();
			System.out.println(c + ":");
			Field[] fields = c.getDeclaredFields();
			if(fields.length == 0) {
				System.out.print("Class has no declared fields");
			}
			if(fields.length > 0) {
				System.out.print("Fields: ");
				for(Field f : fields) {
					System.out.print(f.toString() + ", ");
				}
			}
			System.out.println("\nSuperclass: " + c.getSuperclass() + "\n");
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
class ch14ex09.AAA:
Fields: double ch14ex09.AAA.dd, long ch14ex09.AAA.ll, 
Superclass: class ch14ex09.AA

class ch14ex09.AA:
Fields: float ch14ex09.AA.ff, byte ch14ex09.AA.bb, 
Superclass: class ch14ex09.A

class ch14ex09.A:
Class has no declared fields
Superclass: class java.lang.Object
*/