package ch15ex11;
import net.mindview.util.*;
import java.util.*;

class MyClassA {
	public String toString() { return "MyClassA"; }
}

class MyClassB {
	public String toString() { return "MyClassB"; }
}

class MyClassC {
	public String toString() { return "MyClassC"; }
}

class MyClassD {
	public String toString() { return "MyClassD"; }
}

public class Ch15ex11 {

	public static void main(String[] args) {
		List<MyClassA> la = New.list();
		List<MyClassB> llb = New.lList();
		Set<MyClassC> sc = New.set();
		Queue<MyClassD> qd = New.queue();
		Map<MyClassA,MyClassB> mab = New.map();
		la.add(new MyClassA());
		System.out.println("List<MyClassA>: " + la);
		llb.add(new MyClassB());
		System.out.println("LinkedList<MyClassB>: " + llb);
		sc.add(new MyClassC());
		System.out.println("Set<MyClassC>: " + sc);
		qd.add(new MyClassD());
		System.out.println("Queue<MyClassD>: " + qd);
		mab.put(new MyClassA(), new MyClassB());
		System.out.println("Map<MyClassA,MyClassB>: " + mab);
	}

}

/* Output:
List<MyClassA>: [MyClassA]
LinkedList<MyClassB>: [MyClassB]
Set<MyClassC>: [MyClassC]
Queue<MyClassD>: [MyClassD]
Map<MyClassA,MyClassB>: {MyClassA=MyClassB}
*/
