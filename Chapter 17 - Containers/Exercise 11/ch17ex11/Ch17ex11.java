package ch17ex11;

import java.util.*;
import static ptmoskal.Print.*;

class Comp implements Comparable<Comp> {
	Random rand = new Random();
	Integer i = rand.nextInt(100);
	public int compareTo(Comp c) {
		return this.i < c.i ? -1 : (this.i == c.i ? 0 : 1);
	}
	public String toString() { return Integer.toString(i); }
}

public class Ch17ex11 {

	public static void main(String[] args) {
		Queue<Comp> queue = new PriorityQueue<Comp>();
		for(int i = 0; i < 15; i++)
			queue.offer(new Comp());
		while(!(queue.peek() == null))
			printnb(queue.poll() + ", ");
	}

}

/* Output (Sample):
0, 1, 4, 10, 20, 31, 45, 53, 56, 68, 71, 82, 82, 91, 97, 
*/