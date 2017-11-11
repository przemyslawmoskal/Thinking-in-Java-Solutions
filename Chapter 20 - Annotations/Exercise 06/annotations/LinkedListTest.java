package annotations;

import java.util.LinkedList;

import net.mindview.atunit.*;
import net.mindview.util.*;

public class LinkedListTest {
	LinkedList<String> testObject = new LinkedList<String>();

	@Test
	void initialization() {
		assert testObject.isEmpty();
	}

	@Test
	void _contains() {
		testObject.add("one");
		assert testObject.contains("jeden");
	}

	@Test
	void _remove() {
		testObject.add("one");
		testObject.remove("one");
		assert testObject.isEmpty();
	}

	public static void main(String[] args) {
		OSExecute.command("java net.mindview.atunit.AtUnit LinkedListTest");
	}

}
