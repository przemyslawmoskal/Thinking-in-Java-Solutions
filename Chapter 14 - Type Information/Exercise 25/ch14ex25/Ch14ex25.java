package ch14ex25;
import java.lang.reflect.*;
import myPackage.*;
import static ptmoskal.Print.*;

public class Ch14ex25 {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		A obj = Maker.makeHiddenClassObject();
		print("obj, class type: " + obj.getClass().getName() + "\n");
		for(Method method : obj.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			method.invoke(obj);
		}
	}
	
}

/* Output:
obj, class type: myPackage.HiddenClass

public B.j()
B.i() with package access
public B.f()
protected B.h()
private B.g()
*/