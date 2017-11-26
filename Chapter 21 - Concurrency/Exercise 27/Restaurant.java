// The producer-consumer approach to task cooperation.
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.*;

class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable {
	protected Lock lock = new ReentrantLock();
	protected Condition condition = lock.newCondition();
	private Restaurant restaurant;

	public WaitPerson(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				lock.lock();
				try {
					while (restaurant.meal == null)
						condition.await(); // ... for the chef to produce a meal
					print("Waitperson got " + restaurant.meal);
					try {
						restaurant.chef.lock.lock();
						restaurant.meal = null;
						restaurant.chef.condition.signalAll(); // Ready for another
					} finally {
						restaurant.chef.lock.unlock();
					}
					
				} finally {
					lock.unlock();
				}
				
			}
		} catch (InterruptedException e) {
			print("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable {
	protected Lock lock = new ReentrantLock();
	protected Condition condition = lock.newCondition();
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				try {
					lock.lock();
						while (restaurant.meal != null)
							condition.await(); // ... for the meal to be taken
					if (++count == 10) {
						print("Out of food, closing");
						restaurant.exec.shutdownNow();
						return;
					}
					printnb("Order up! ");
					try {
						restaurant.waitPerson.lock.lock();
						restaurant.meal = new Meal(count);
						restaurant.waitPerson.condition.signalAll();
					} finally {
						restaurant.waitPerson.lock.unlock();
					}
					TimeUnit.MILLISECONDS.sleep(100);
				} finally {
					lock.unlock();
				}

				
			}
		} catch (InterruptedException e) {
			print("Chef interrupted");
		}
	}
}

public class Restaurant {
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
} /*
	 * Output: Order up! Waitperson got Meal 1 Order up! Waitperson got Meal 2
	 * Order up! Waitperson got Meal 3 Order up! Waitperson got Meal 4 Order up!
	 * Waitperson got Meal 5 Order up! Waitperson got Meal 6 Order up!
	 * Waitperson got Meal 7 Order up! Waitperson got Meal 8 Order up!
	 * Waitperson got Meal 9 Out of food, closing WaitPerson interrupted Order
	 * up! Chef interrupted
	 */// :~
