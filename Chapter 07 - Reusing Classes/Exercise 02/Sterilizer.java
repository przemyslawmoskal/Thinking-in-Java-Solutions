import static net.mindview.util.Print.print;

public class Sterilizer extends Detergent{
	public void scrub() {
	    append(" Sterilizer.scrub()");
	}
	public void sterilize() {
		append(" sterilize()");
	}
	public static void main(String[] args) {
		Sterilizer x = new Sterilizer();
	    x.dilute();
	    x.apply();
	    x.scrub();
	    x.foam();
	    x.sterilize();
	    print(x);
	    print("Testing base class:");
	    Detergent.main(args);
	}

}

/* Output:
Cleanser dilute() apply() Sterilizer.scrub() foam() sterilize()
Testing base class:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*/
