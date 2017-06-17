package ch10ex10;
import static ptmoskal.Print.*;

public class ElectronicDevice {
	public MakesSounds sound(String r, boolean b) {
		if(b) {
			class Smartphone implements MakesSounds {
				private String ringtone;
				private Smartphone(String rt) {
					this.ringtone = rt;
				}
				public void ring() { print("Smartphone makes sound: " + ringtone); }
			}
			return new Smartphone(r);
		}
		return null;
	}

	public static void main(String[] args) {
		ElectronicDevice obj = new ElectronicDevice();
		obj.sound("Ring! Ring! Ring!", true).ring();
	}

}

/* Output:
Smartphone makes sound: Ring! Ring! Ring!
*/