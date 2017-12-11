
//: concurrency/CarBuilder.java
// A complex example of tasks working together.
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Car {
	private final int id;
	private boolean engine = false,
			driveTrain = false,
			wheels = false,
			exhaust = false,
			bumpers = false,
			lights = false;

	public Car(int idn) {
		id = idn;
	}

	// Empty Car object:
	public Car() {
		id = -1;
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void addEngine() {
		engine = true;
	}

	public synchronized void addDriveTrain() {
		driveTrain = true;
	}

	public synchronized void addWheels() {
		wheels = true;
	}
	
	public synchronized void addExhaust() {
		exhaust = true;
	}
	
	public synchronized void addBumpers() {
		bumpers = true;
	}
	
	public synchronized void addLights() {
		lights = true;
	}

	public synchronized String toString() {
		return "Car " + id + " [" + " engine: " + engine
				+ " driveTrain: " + driveTrain
				+ " wheels: " + wheels
				+ " exhaust: " + exhaust
				+ " bumpers: " + bumpers
				+ " lights: " + lights
				+ " ]";
	}
}

class CarQueue extends LinkedBlockingQueue<Car> {
}

class ChassisBuilder implements Runnable {
	private CarQueue carQueue;
	private int counter = 0;

	public ChassisBuilder(CarQueue cq) {
		carQueue = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(500);
				// Make chassis:
				Car c = new Car(counter++);
				print("ChassisBuilder created " + c);
				// Insert into queue
				carQueue.put(c);
			}
		} catch (InterruptedException e) {
			print("Interrupted: ChassisBuilder");
		}
		print("ChassisBuilder off");
	}
}

class Assembler implements Runnable {
	private CarQueue chassisQueue, finishingQueue;
	private Car car;
	private CyclicBarrier barrier = new CyclicBarrier(7);
	private RobotPool robotPool;

	public Assembler(CarQueue cq, CarQueue fq, RobotPool rp) {
		chassisQueue = cq;
		finishingQueue = fq;
		robotPool = rp;
	}

	public Car car() {
		return car;
	}

	public CyclicBarrier barrier() {
		return barrier;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				car = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(EngineRobot.class, this);
				robotPool.hire(DriveTrainRobot.class, this);
				robotPool.hire(WheelRobot.class, this);
				robotPool.hire(ExhaustRobot.class, this);
				robotPool.hire(BumpersRobot.class, this);
				robotPool.hire(LightsRobot.class, this);
				barrier.await(); // Until the robots finish
				// Put car into finishingQueue for further work
				finishingQueue.put(car);
			}
		} catch (InterruptedException e) {
			print("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		print("Assembler off");
	}
}

class Reporter implements Runnable {
	private CarQueue carQueue;

	public Reporter(CarQueue cq) {
		carQueue = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				print(carQueue.take());
			}
		} catch (InterruptedException e) {
			print("Exiting Reporter via interrupt");
		}
		print("Reporter off");
	}
}

abstract class Robot implements Runnable {
	private RobotPool pool;

	public Robot(RobotPool p) {
		pool = p;
	}

	protected Assembler assembler;

	public Robot assignAssembler(Assembler assembler) {
		this.assembler = assembler;
		return this;
	}

	private boolean engage = false;

	public synchronized void engage() {
		engage = true;
		notifyAll();
	}

	// The part of run() that's different for each robot:
	abstract protected void performService();

	public void run() {
		try {
			powerDown(); // Wait until needed
			while (!Thread.interrupted()) {
				performService();
				assembler.barrier().await(); // Synchronize
				// We're done with that job...
				powerDown();
			}
		} catch (InterruptedException e) {
			print("Exiting " + this + " via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		print(this + " off");
	}

	private synchronized void powerDown() throws InterruptedException {
		engage = false;
		assembler = null; // Disconnect from the Assembler
		// Put ourselves back in the available pool:
		pool.release(this);
		while (engage == false) // Power down
			wait();
	}

	public String toString() {
		return getClass().getName();
	}
}

class EngineRobot extends Robot {
	public EngineRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		print(this + " installing engine");
		assembler.car().addEngine();
	}
}

class DriveTrainRobot extends Robot {
	public DriveTrainRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		print(this + " installing DriveTrain");
		assembler.car().addDriveTrain();
	}
}

class WheelRobot extends Robot {
	public WheelRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		print(this + " installing Wheels");
		assembler.car().addWheels();
	}
}

class ExhaustRobot extends Robot {
	public ExhaustRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		print(this + " installing Exhaust");
		assembler.car().addExhaust();
	}
}

class BumpersRobot extends Robot {
	public BumpersRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		print(this + " installing Bumpers");
		assembler.car().addBumpers();
	}
}

class LightsRobot extends Robot {
	public LightsRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		print(this + " installing Lights");
		assembler.car().addLights();
	}
}

class RobotPool {
	// Quietly prevents identical entries:
	private Set<Robot> pool = new HashSet<Robot>();

	public synchronized void add(Robot r) {
		pool.add(r);
		notifyAll();
	}

	public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
		for (Robot r : pool)
			if (r.getClass().equals(robotType)) {
				pool.remove(r);
				r.assignAssembler(d);
				r.engage(); // Power it up to do the task
				return;
			}
		wait(); // None available
		hire(robotType, d); // Try again, recursively
	}

	public synchronized void release(Robot r) {
		add(r);
	}
}

public class CarBuilder {
	public static void main(String[] args) throws Exception {
		CarQueue chassisQueue = new CarQueue(), finishingQueue = new CarQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		RobotPool robotPool = new RobotPool();
		exec.execute(new EngineRobot(robotPool));
		exec.execute(new DriveTrainRobot(robotPool));
		exec.execute(new WheelRobot(robotPool));
		exec.execute(new ExhaustRobot(robotPool));
		exec.execute(new BumpersRobot(robotPool));
		exec.execute(new LightsRobot(robotPool));
		exec.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
		exec.execute(new Reporter(finishingQueue));
		// Start everything running by producing chassis:
		exec.execute(new ChassisBuilder(chassisQueue));
		TimeUnit.SECONDS.sleep(7);
		exec.shutdownNow();
	}
}

/* Output:
ChassisBuilder created Car 0 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
LightsRobot installing Lights
WheelRobot installing Wheels
BumpersRobot installing Bumpers
ExhaustRobot installing Exhaust
DriveTrainRobot installing DriveTrain
Car 0 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 1 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
ExhaustRobot installing Exhaust
DriveTrainRobot installing DriveTrain
LightsRobot installing Lights
BumpersRobot installing Bumpers
WheelRobot installing Wheels
Car 1 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 2 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
ExhaustRobot installing Exhaust
LightsRobot installing Lights
DriveTrainRobot installing DriveTrain
BumpersRobot installing Bumpers
WheelRobot installing Wheels
Car 2 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 3 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
DriveTrainRobot installing DriveTrain
ExhaustRobot installing Exhaust
LightsRobot installing Lights
EngineRobot installing engine
WheelRobot installing Wheels
BumpersRobot installing Bumpers
Car 3 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 4 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
WheelRobot installing Wheels
BumpersRobot installing Bumpers
DriveTrainRobot installing DriveTrain
LightsRobot installing Lights
ExhaustRobot installing Exhaust
Car 4 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 5 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
DriveTrainRobot installing DriveTrain
ExhaustRobot installing Exhaust
LightsRobot installing Lights
WheelRobot installing Wheels
BumpersRobot installing Bumpers
EngineRobot installing engine
Car 5 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 6 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
DriveTrainRobot installing DriveTrain
BumpersRobot installing Bumpers
LightsRobot installing Lights
WheelRobot installing Wheels
ExhaustRobot installing Exhaust
Car 6 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 7 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
DriveTrainRobot installing DriveTrain
ExhaustRobot installing Exhaust
LightsRobot installing Lights
EngineRobot installing engine
WheelRobot installing Wheels
BumpersRobot installing Bumpers
Car 7 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 8 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
BumpersRobot installing Bumpers
WheelRobot installing Wheels
DriveTrainRobot installing DriveTrain
ExhaustRobot installing Exhaust
LightsRobot installing Lights
Car 8 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 9 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
DriveTrainRobot installing DriveTrain
ExhaustRobot installing Exhaust
LightsRobot installing Lights
EngineRobot installing engine
BumpersRobot installing Bumpers
WheelRobot installing Wheels
Car 9 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 10 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
EngineRobot installing engine
BumpersRobot installing Bumpers
WheelRobot installing Wheels
DriveTrainRobot installing DriveTrain
LightsRobot installing Lights
ExhaustRobot installing Exhaust
Car 10 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 11 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
DriveTrainRobot installing DriveTrain
ExhaustRobot installing Exhaust
WheelRobot installing Wheels
LightsRobot installing Lights
BumpersRobot installing Bumpers
EngineRobot installing engine
Car 11 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
ChassisBuilder created Car 12 [ engine: false driveTrain: false wheels: false exhaust: false bumpers: false lights: false ]
DriveTrainRobot installing DriveTrain
WheelRobot installing Wheels
EngineRobot installing engine
LightsRobot installing Lights
BumpersRobot installing Bumpers
ExhaustRobot installing Exhaust
Car 12 [ engine: true driveTrain: true wheels: true exhaust: true bumpers: true lights: true ]
Exiting WheelRobot via interrupt
WheelRobot off
Exiting DriveTrainRobot via interrupt
DriveTrainRobot off
Exiting ExhaustRobot via interrupt
ExhaustRobot off
Interrupted: ChassisBuilder
ChassisBuilder off
Exiting LightsRobot via interrupt
Exiting Assembler via interrupt
Assembler off
LightsRobot off
Exiting EngineRobot via interrupt
EngineRobot off
Exiting Reporter via interrupt
Exiting BumpersRobot via interrupt
BumpersRobot off
Reporter off
*/
