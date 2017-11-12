package annotations;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCreate;
import net.mindview.util.*;

public class Groundhog {
	protected int number;

	public Groundhog(int n) {
		number = n;
	}

	public String toString() {
		return "Groundhog #" + number;
	}
	
	@TestObjectCreate static Groundhog create() {
		return new Groundhog(16);
	}
	
	@Test void testToString() {
		Groundhog testObject = new Groundhog(16);
		assert testObject.toString().equals("Groundhog #" + 16);
	}
	
	public static void main(String[] args) throws Exception {
		OSExecute.command(
			"java net.mindview.atunit.AtUnit Groundhog");
	}
}
