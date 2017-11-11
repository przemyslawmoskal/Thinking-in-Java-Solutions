package annotations;

import java.util.*;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class HashSetTest extends HashSet<String> {
	
	@Test
	void initialization() {
		assert this.isEmpty();
	}

	@Test
	void _contains() {
		this.add("one");
		assert this.contains("one");
	}

	@Test
	void _remove() {
		this.add("one");
		this.remove("one");
		assert this.isEmpty();
	}

	public static void main(String[] args) throws Exception {
		OSExecute.command("java net.mindview.atunit.AtUnit HashSetTest");
	}
}
