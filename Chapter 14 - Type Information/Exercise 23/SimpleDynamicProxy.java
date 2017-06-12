//: typeinfo/SimpleDynamicProxy.java
import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	 	// Printing proxy leads to infinite recursion causing StracOverflowError
		// System.out.println(proxy);
		System.out.println("**** proxy: " + proxy.getClass() +
				", method: " + method + ", args: " + args);
		if(args != null)
			for(Object arg : args)
				System.out.println("  " + arg);
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
Exception in thread "main" java.lang.StackOverflowError
	at java.lang.String.valueOf(Unknown Source)
	at java.io.PrintStream.println(Unknown Source)
	at DynamicProxyHandler.invoke(SimpleDynamicProxy.java:12)
	at $Proxy0.toString(Unknown Source)
	at java.lang.String.valueOf(Unknown Source)
	at java.io.PrintStream.println(Unknown Source)
	at DynamicProxyHandler.invoke(SimpleDynamicProxy.java:12)
*/
