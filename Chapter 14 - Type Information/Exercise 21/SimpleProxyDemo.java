import static net.mindview.util.Print.*;
import java.util.*;

interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() { print("doSomething"); }
	public void somethingElse(String arg) {
		print("somethingElse " + arg);
	}
}	

class SimpleProxy implements Interface {
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	public void doSomething() {
		long callTime = new Date().getTime();
		print("SimpleProxy doSomething:\nCalling time: " + callTime + " miliseconds");
		proxied.doSomething();
		print("Time from call to return = " + ((new Date().getTime())-callTime) + " miliseconds\n");
	}
	public void somethingElse(String arg) {
		long callTime = new Date().getTime();
		print("SimpleProxy somethingElse " + arg + " :\nCalling time: " + callTime + " miliseconds");
		proxied.somethingElse(arg);
		print("Time from call to return = " + ((new Date().getTime())-callTime) + " miliseconds\n");
	}
}	

class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		print();
		consumer(new SimpleProxy(new RealObject()));
	}
}

/* Output:
doSomething
somethingElse bonobo

SimpleProxy doSomething:
Calling time: 1496838241580 miliseconds
doSomething
Time from call to return = 0 miliseconds

SimpleProxy somethingElse bonobo :
Calling time: 1496838241580 miliseconds
somethingElse bonobo
Time from call to return = 1 miliseconds
*/
