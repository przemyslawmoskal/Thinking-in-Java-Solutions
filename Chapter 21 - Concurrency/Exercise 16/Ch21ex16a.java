import java.util.concurrent.locks.*;

class MyClassA {
	private Lock lock = new ReentrantLock();
	public void f() {
		lock.lock();
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("f()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
		
	}
	public void g() {
		lock.lock();
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
		
	}
	public void h() {
		lock.lock();
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("h()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
		
	}
}

public class Ch21ex16a {

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
