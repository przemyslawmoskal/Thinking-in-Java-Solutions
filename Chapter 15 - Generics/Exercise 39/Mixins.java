import java.util.*;

interface TimeStamped { long getStamp(); }

class TimeStampedImp implements TimeStamped {
	private final long timeStamp;
	public TimeStampedImp() {
		timeStamp = new Date().getTime();
	}
	public long getStamp() { return timeStamp; }
}

interface SerialNumbered { long getSerialNumber(); }

class SerialNumberedImp implements SerialNumbered {
	private static long counter = 1;
	private final long serialNumber = counter++;
	public long getSerialNumber() { return serialNumber; }
}

interface Colored {
	String getColor();
}

class ColoredImp implements Colored {
	private String color = "red";
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
}

interface Basic {
	public void set(String val);
	public String get();
}

class BasicImp implements Basic {
	private String value;
	public void set(String val) { value = val; }
	public String get() { return value; }
}

class Mixin extends BasicImp
implements TimeStamped, SerialNumbered, Colored {
	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumber =
		  new SerialNumberedImp();
	private Colored color = new ColoredImp();
	public long getStamp() { return timeStamp.getStamp(); }
	public long getSerialNumber() {
		return serialNumber.getSerialNumber();
	}
	public String getColor() {
		return color.getColor();
	}
}

public class Mixins {
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test string 1");
		mixin2.set("test string 2");
		System.out.println(mixin1.get() + " " +
				mixin1.getStamp() +  " " + mixin1.getSerialNumber() + " " + mixin1.getColor());
		System.out.println(mixin2.get() + " " +
				mixin2.getStamp() +  " " + mixin2.getSerialNumber() + " " + mixin2.getColor());
	}
}

/* Output (Sample) :
test string 1 1502965951097 1 red
test string 2 1502965951098 2 red
*/