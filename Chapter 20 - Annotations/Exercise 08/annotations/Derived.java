package annotations;

import net.mindview.atunit.*;
import net.mindview.util.*;

class Base {
	private int m1() {
		System.out.println("Ch20ex08.m1()");
		return 1;
	}
	@TestProperty protected int invokeM1() {
		return this.m1();
	}
}

public class Derived extends Base {
	
	@Test void testM1() {
		assert invokeM1() == 1;
	}

	public static void main(String[] args) {
		OSExecute.command("java net.mindview.atunit.AtUnit Derived");
	}

}
