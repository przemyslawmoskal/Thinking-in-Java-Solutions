package ch10ex16;
import static ptmoskal.Print.*;

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
	private Unicycle() { print("Unicycle()"); }
    @Override public void ride(){ print("Unicycle.ride()"); }
    public static CycleFactory factory = new CycleFactory() {
    	public Cycle getCycle() {
    		return new Unicycle();
    	}
    };
}

class Bicycle implements Cycle {
	private Bicycle() { print("Bicycle()"); }
    @Override public void ride(){ print("Bicycle.ride()"); }
    public static CycleFactory factory = new CycleFactory() {
    	public Cycle getCycle() {
    		return new Bicycle();
    	}
    };
}

class Tricycle implements Cycle {
	private Tricycle() { print("Tricycle()"); }
    @Override public void ride(){ print("Tricycle.ride()"); }
    public static CycleFactory factory = new CycleFactory() {
    	public Cycle getCycle() {
    		return new Tricycle();
    	}
    };
}

public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
    	rideCycle(Unicycle.factory);
    	rideCycle(Bicycle.factory);
    	rideCycle(Tricycle.factory);
    }
    
}

/* Output:
Unicycle()
Unicycle.ride()
Bicycle()
Bicycle.ride()
Tricycle()
Tricycle.ride()
*/