// All methods are synchronized on (this):

class MyClassA {
	public void f() {
		synchronized(this) {
			for(int i = 0; i < 10; i++) {
				System.out.println("f()");
				Thread.yield();
			}
			
		}
	}
	public void g() {
		synchronized(this) {
			for(int i = 0; i < 10; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	public void h() {
		synchronized(this) {
			for(int i = 0; i < 10; i++) {
				System.out.println("h()");
				Thread.yield();
			}
		}
	}
}

public class Ch21ex15a {

	public static void main(String[] args) {
		MyClassA obj = new MyClassA();
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
*/
