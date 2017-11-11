package annotations;

import net.mindview.atunit.*;
import net.mindview.util.*;

public class AtUnitExample1 {
	public int id = ++counter;
	public static int counter = 0;
	public AtUnitExample1() {
		System.out.println("AtUnitExample nr: " + id);
	}
	
	public String methodOne() {
		return "This is methodOne of nr " + id;
	}

	public int methodTwo() {
		System.out.println("This is methodTwo of nr " + id);
		return 2;
	}

	@Test
	boolean methodOneTest() {
		return methodOne().equals("This is methodOne");
	}

	@Test
	boolean m2() {
		return methodTwo() == 2;
	}

	@Test
	private boolean m3() {
		return true;
	}

	// Shows output for failure:
	@Test
	boolean failureTest() {
		return false;
	}

	@Test
	boolean anotherDisappointment() {
		return false;
	}

	public static void main(String[] args) throws Exception {
		OSExecute.command("java net.mindview.atunit.AtUnit AtUnitExample1");
	}
}
