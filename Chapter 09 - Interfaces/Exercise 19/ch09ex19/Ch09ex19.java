package ch09ex19;
import java.util.*;
import static ptmoskal.Print.*;

interface Game { void play(); }

interface GameFactory { Game getGame(); }

class TossACoin implements Game {
	Random rand = new Random(128);
	public void play() {
		print("Game: " + getClass().getSimpleName());
		Random rand = new Random(128);
		int remaining = 10;
		for(int i = 0; i < 10; i++) {
			print("Remaining: " + remaining--);
			switch(rand.nextInt(9)) {
				case 0: 
				case 1: 
				case 2: 
				case 3: print("Heads!"); break;
				case 4:
				case 5:
				case 6:
				case 7: print("Tails!"); break;
				default: print("Edge!");
			}
		}
	}
}

class ThrowADice implements Game {
	public void play() {
		print("Game: " + getClass().getSimpleName());
		Random rand = new Random();
		int remaining = 10;
		for(int i = 0; i < 10; i++) {
			print("Remaining: " + remaining--);
			print("It's " + (rand.nextInt(6)+1) + "!");
		}
	}
}

class TossACoinFactory implements GameFactory {
	public Game getGame() {
		return new TossACoin();
	}
}

class ThrowADiceFactory implements GameFactory {
	public Game getGame() {
		return new ThrowADice();
	}
}

public class Ch09ex19 {
	public static void playGame(GameFactory factory) {
		Game s = factory.getGame();
		s.play();
	}

	public static void main(String[] args) {
		playGame(new TossACoinFactory());
		print();
		playGame(new ThrowADiceFactory());
	}

}

/* Output:
 * Game: TossACoin
Remaining: 10
Tails!
Remaining: 9
Tails!
Remaining: 8
Heads!
Remaining: 7
Heads!
Remaining: 6
Edge!
Remaining: 5
Tails!
Remaining: 4
Heads!
Remaining: 3
Tails!
Remaining: 2
Tails!
Remaining: 1
Tails!

Game: ThrowADice
Remaining: 10
It's 6!
Remaining: 9
It's 4!
Remaining: 8
It's 3!
Remaining: 7
It's 5!
Remaining: 6
It's 6!
Remaining: 5
It's 3!
Remaining: 4
It's 1!
Remaining: 3
It's 4!
Remaining: 2
It's 6!
Remaining: 1
It's 6!
*/
