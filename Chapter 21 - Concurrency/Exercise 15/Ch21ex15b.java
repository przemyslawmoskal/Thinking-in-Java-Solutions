// Every method synchronized on another object:

class MyClassB {
	Object syncA = new Object();
	Object syncB = new Object();
	Object syncC = new Object();
	public void f() {
		synchronized(syncA) {
			for(int i = 0; i < 10; i++) {
				System.out.println("f()");
				Thread.yield();
			}
			
		}
	}
	public void g() {
		synchronized(syncB) {
			for(int i = 0; i < 10; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	public void h() {
		synchronized(syncC) {
			for(int i = 0; i < 10; i++) {
				System.out.println("h()");
				Thread.yield();
			}
		}
	}
}

public class Ch21ex15b {

	public static void main(String[] args) {
		MyClassB obj = new MyClassB();
		for(int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					obj.f();
				}
			}.start();
			new Thread() {
				public void run() {
					obj.g();
				}
			}.start();
			new Thread() {
				public void run() {
					obj.h();
				}
			}.start();
		}
	}

}

/* Output:
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
f()
h()
g()
g()
g()
g()
g()
g()
g()
g()
g()
g()
h()
h()
h()
h()
h()
h()
h()
h()
h()
h()
f()
f()
f()
f()
f()
f()
f()
f()
f()
f()
g()
h()
f()
h()
f()
g()
h()
f()
g()
h()
f()
g()
h()
f()
g()
h()
h()
h()
h()
h()
f()
f()
f()
f()
f()
g()
g()
g()
g()
g()
*/
