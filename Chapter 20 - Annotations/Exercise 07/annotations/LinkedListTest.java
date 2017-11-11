package annotations;

import java.util.LinkedList;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class LinkedListTest extends LinkedList<String> {

	@Test
	void initialization() {
		assert this.isEmpty();
	}

	@Test
	void _contains() {
		this.add("one");
		assert this.contains("jeden");
	}

	@Test
	void _remove() {
		this.add("one");
		this.remove("one");
		assert this.isEmpty();
	}

	public static void main(String[] args) {
		OSExecute.command("java net.mindview.atunit.AtUnit LinkedListTest");
	}

}
