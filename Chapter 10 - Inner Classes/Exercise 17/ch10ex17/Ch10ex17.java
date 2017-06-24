package ch10ex17;
import java.util.*;
import static ptmoskal.Print.*;

interface Game { void play(); }

interface GameFactory { Game getGame(); }

class TossACoin implements Game {
	private TossACoin() { print("TossACoin()"); }
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
	public static GameFactory factory = new GameFactory() {
		public Game getGame() {
			return new TossACoin();
		}
	};
}

class ThrowADice implements Game {
	private ThrowADice() { print("ThrowADice()"); }
	public void play() {
		print("Game: " + getClass().getSimpleName());
		Random rand = new Random();
		int remaining = 10;
		for(int i = 0; i < 10; i++) {
			print("Remaining: " + remaining--);
			print("It's " + (rand.nextInt(6)+1) + "!");
		}
	}
	public static GameFactory factory = new GameFactory() {
		public Game getGame() {
			return new ThrowADice();
		}
	};
}

public class Ch10ex17 {
	public static void playGame(GameFactory factory) {
		Game s = factory.getGame();
		s.play();
	}

	public static void main(String[] args) {
		playGame(TossACoin.factory);
		print();
		playGame(ThrowADice.factory);
	}

}

/* Output:
TossACoin()
Game: TossACoin
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

ThrowADice()
Game: ThrowADice
Remaining: 10
It's 6!
Remaining: 9
It's 1!
Remaining: 8
It's 4!
Remaining: 7
It's 4!
Remaining: 6
It's 3!
Remaining: 5
It's 5!
Remaining: 4
It's 2!
Remaining: 3
It's 3!
Remaining: 2
It's 2!
Remaining: 1
It's 1!
*/
