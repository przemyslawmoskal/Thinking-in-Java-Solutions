import static net.mindview.util.Print.*;

class Art {
	Art() { print("Art constructor"); }
}

class Drawing extends Art {
	Drawing() { print("Drawing constructor"); }
}

public class Cartoon extends Drawing {
	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}
}

/* Output:
Art constructor
Drawing constructor
*/
