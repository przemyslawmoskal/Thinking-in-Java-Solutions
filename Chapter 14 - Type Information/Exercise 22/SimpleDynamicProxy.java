import static net.mindview.util.Print.print;
import java.lang.reflect.*;
import java.util.*;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long callTime = new Date().getTime();
		System.out.println("**** proxy: " + proxy.getClass() +
				", method: " + method + ", args: " + args + ",\n invoked at: " + callTime + " miliseconds");
		if(args != null)
			for(Object arg : args)
				System.out.println("  " + arg);
		print("Time from call to return = " + ((new Date().getTime()) - callTime) + " miliseconds");
		return method.invoke(proxied, args);
	}
}	

class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		// Insert a proxy and call again:
		Interface proxy = (Interface)Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[]{ Interface.class },
				new DynamicProxyHandler(real));
		consumer(proxy);
	}
}

/* Output:
doSomething
somethingElse bonobo
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null,
 invoked at: 1496840601672 miliseconds
Time from call to return = 1 miliseconds
doSomething
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@12204a1,
 invoked at: 1496840601673 miliseconds
  bonobo
Time from call to return = 0 miliseconds
somethingElse bonobo
*/
