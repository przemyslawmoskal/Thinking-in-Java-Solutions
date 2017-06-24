package ch09ex18;
import static ptmoskal.Print.*;

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    @Override public void ride(){print("Unicycle.ride()");}
}

class Bicycle implements Cycle {
    @Override public void ride(){print("Bicycle.ride()");}
}

class Tricycle implements Cycle {
    @Override public void ride(){print("Tricycle.ride()");}
}

class UnicycleFactory implements CycleFactory {
    @Override public Cycle getCycle() { return new Unicycle(); }
}

class BicycleFactory implements CycleFactory {
    @Override public Cycle getCycle() { return new Bicycle(); }
}

class TricycleFactory implements CycleFactory {
    @Override public Cycle getCycle() { return new Tricycle(); }
}

public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
    
}

/* Output:
Unicycle.ride()
Bicycle.ride()
Tricycle.ride()
*/