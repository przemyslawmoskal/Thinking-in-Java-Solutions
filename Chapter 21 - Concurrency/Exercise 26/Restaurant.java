import java.util.concurrent.*;
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

class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null)
						wait(); // ... for the meal to be taken
				}
				if (++count == 10) {
					print("Out of food, closing");
					restaurant.exec.shutdownNow();
					return;
				}
				printnb("Order up! ");
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			print("Chef interrupted");
		}
	}
}

class WaitPerson implements Runnable {
	private Restaurant restaurant;
	protected boolean dishWashed = true;
	protected Meal m;
	public WaitPerson(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal == null)
						wait(); // ... for the chef to produce a meal
				}
				this.m = restaurant.meal;
				print("Waitperson got " + this.m);
				synchronized (restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll(); // Ready for another
				}
				synchronized (restaurant.busBoy) {
					dishWashed = false;
					restaurant.busBoy.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			print("WaitPerson interrupted");
		}
	}
}

class BusBoy implements Runnable {
	private Restaurant restaurant;

	public BusBoy(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.waitPerson.dishWashed == true)
						wait(); // ... for the waitPerson to get an information about dirty dishes
				}
				print("Busboy washes dishes after " + restaurant.waitPerson.m);
				restaurant.waitPerson.dishWashed = true;
			}
		} catch (InterruptedException e) {
			print("WaitPerson interrupted");
		}
	}
}

public class Restaurant {
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	BusBoy busBoy = new BusBoy(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
		exec.execute(busBoy);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}

/* Output:
Order up! Waitperson got Meal 1
Busboy washes dishes after Meal 1
Order up! Waitperson got Meal 2
Busboy washes dishes after Meal 2
Order up! Waitperson got Meal 3
Busboy washes dishes after Meal 3
Order up! Waitperson got Meal 4
Busboy washes dishes after Meal 4
Order up! Waitperson got Meal 5
Busboy washes dishes after Meal 5
Order up! Waitperson got Meal 6
Busboy washes dishes after Meal 6
Order up! Waitperson got Meal 7
Busboy washes dishes after Meal 7
Order up! Waitperson got Meal 8
Busboy washes dishes after Meal 8
Order up! Waitperson got Meal 9
Busboy washes dishes after Meal 9
Out of food, closing
WaitPerson interrupted
WaitPerson interrupted
*/