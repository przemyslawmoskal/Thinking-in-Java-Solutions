package annotations;
import net.mindview.atunit.Test;
import net.mindview.atunit.TestNote;
import net.mindview.util.OSExecute;

public class TestNoteCh20ex11 {
	public Integer firstMethod() {
		System.out.println("firstMethod()");
		return 16;
	}

	public String secondMethod() {
		return "secondMethod()";
	}
	
	@TestNote (note = "firstMethod note")
	@Test void _firstMethod() {
		assert firstMethod() == 16;
	}
	
	@TestNote (note = "secondMethod note")
	@Test void _secondMethod() {
		assert secondMethod().equals("secondMethod()");
	}

	public static void main(String[] args) {
		OSExecute.command("java net.mindview.atunit.AtUnitEx11 TestNoteCh20ex11");
	}

}
