package ch10ex09;
import static ptmoskal.Print.*;

public class ElectronicDevice {
	public MakesSounds sound(String r) {
		class Smartphone implements MakesSounds {
			private String ringtone;
			private Smartphone(String rt) {
				this.ringtone = rt;
			}
			public void ring() { print("Smartphone makes sound: " + ringtone); }
		}
		return new Smartphone(r);
	}

	public static void main(String[] args) {
		ElectronicDevice obj = new ElectronicDevice();
		obj.sound("Ring! Ring! Ring!").ring();
	}

}

/* Output:
Smartphone makes sound: Ring! Ring! Ring!
*/