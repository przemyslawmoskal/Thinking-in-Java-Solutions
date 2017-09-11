import static net.mindview.util.Print.*;

class Game {
	Game(int i) {
		print("Game contructor");
		}
	}

class BoardGame extends Game {
	BoardGame(int i) {
		// Cannot put "print("BoardGame constructor")" here - "Constructor call must be the first statement in a constructor";
		// Cannot comment out "super(i)":
		// "Implicit super constructor Game() is undefined. Must explicitly invoke another constructor"
		super(i);
		print("BoardGame constructor");
	}
}

public class Chess extends BoardGame {
	Chess() {
		super(11);
		print("Chess constructor");
	}
	public static void main(String[] args) {
		Chess x = new Chess();
	}
    
}

/* Output:
Game contructor
BoardGame constructor
Chess constructor
*/