import static net.mindview.util.Print.*;

class Candy {
	static { print("Loading Candy"); }
}

class Gum {
	static { print("Loading Gum"); }
}

class Cookie {
	static { print("Loading Cookie"); }
}

public class SweetShop {
	public static void main(String[] args) {
	  if(args.length < 1) {
			System.out.println("Usage: java Sweetshop file");
			System.exit(0);
		}
    Class c = null;
    try {
      c = Class.forName(args[0]);
      print(args[0] + " loaded!");
    } catch(ClassNotFoundException e) {
      print("Couldn't find " + args[0]);
    }
  }
}

/* Output:
Loading Gum
Gum loaded!
*/