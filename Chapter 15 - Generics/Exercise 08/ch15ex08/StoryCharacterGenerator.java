package ch15ex08;
import java.util.*;
import ptmoskal.*;

public class StoryCharacterGenerator
implements Generator<StoryCharacter>, Iterable<StoryCharacter> {
	private Class[] characters = { Alfred.class, Batman.class, Joker.class,
			Robin.class, ThePenguin.class, TwoFace.class };
	private static Random rand = new Random(128);
	public StoryCharacterGenerator() {}
	private int size = 0;
	public StoryCharacterGenerator (int sz) { size = sz; }
	public StoryCharacter next() {
		try {
			return (StoryCharacter)characters[rand.nextInt(characters.length)].newInstance();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	class StoryCharacterIterator implements Iterator<StoryCharacter> {
		int count = size;
		public boolean hasNext() { return count > 0; }
		public StoryCharacter next() {
			count--;
			return StoryCharacterGenerator.this.next();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	public Iterator<StoryCharacter> iterator() { return new StoryCharacterIterator(); }
	public static void main(String[] args) {
		StoryCharacterGenerator generator = new StoryCharacterGenerator();
		for(int i = 0; i < 10; i++) {
			System.out.println(generator.next());
		}
		System.out.println();
		for(StoryCharacter s : new StoryCharacterGenerator(10)) {
			System.out.println(s);
		}
	}
}

/* Output:
Batman 0
ThePenguin 1
Joker 2
TwoFace 3
TwoFace 4
TwoFace 5
Alfred 6
Robin 7
ThePenguin 8
Joker 9

Robin 10
Robin 11
Alfred 12
ThePenguin 13
Batman 14
Joker 15
Batman 16
Batman 17
Joker 18
ThePenguin 19
*/