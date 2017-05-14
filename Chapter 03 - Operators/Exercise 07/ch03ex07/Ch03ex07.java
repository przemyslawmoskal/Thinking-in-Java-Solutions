package ch03ex07;
import java.util.*;
import static slavvv1011.Print.*;

public class Ch03ex07 {

	public static void main(String[] args) {
		Random rand = new Random();
		int coin = rand.nextInt();
		if(coin % 2 == 0)
			print("Heads !");
		else
			print("Tails !");

	}

}

/* Output:
Tails !+
*/