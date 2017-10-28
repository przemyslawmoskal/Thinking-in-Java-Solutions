import java.io.*;
import java.util.*;

class A implements Serializable {
	int i;
	B objB;
	A(int i, int j) {
		this.i = i;
		objB = new B(j);
	}
	public String toString() {
		return "i: " + i + ", j: " + objB.j;
	}
}

class B implements Serializable {
	int j;
	B(int j) {
		this.j = j;
	}
}

public class Ch18ex27 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Random rand = new Random();
		A a = new A(rand.nextInt(100),rand.nextInt(100));
		System.out.println(a);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.out"));
		out.writeObject(a);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.out"));
		A a2 = (A)in.readObject();
		in.close();
		System.out.println(a2);
	}

}

/* Output:
i: 42, j: 11
i: 42, j: 11
*/
