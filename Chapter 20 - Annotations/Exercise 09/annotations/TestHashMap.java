package annotations;

import java.util.*;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class TestHashMap extends HashMap<String,Integer>{
	
	@Test void initialization() {
		assert this.isEmpty();
	}
	
	@Test void _clear() {
		this.put("A", 1);
		this.put("B", 2);
		this.clear();
		assert this.isEmpty();
		
	}
	
	@Test void _get() {
		this.put("A", 1);
		assert this.get(0) == 1;
	}
	
	@Test void _containsKey() {
		this.put("B", 2);
		assert this.containsKey("B");
	}
	
	@Test void _containsValue() {
		this.put("C", 3);
		assert this.containsValue(3);
	}

	public static void main(String[] args) {
		OSExecute.command("java net.mindview.atunit.AtUnit TestHashMap");
	}

}
