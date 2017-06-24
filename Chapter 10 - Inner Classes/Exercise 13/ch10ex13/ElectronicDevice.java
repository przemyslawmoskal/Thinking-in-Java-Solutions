package ch10ex13;
import static ptmoskal.Print.*;

public class ElectronicDevice {
	public MakesSounds sound(String r) {
		return new MakesSounds() {
			public void ring() { print("Smartphone makes sound: " + r); }
		};
	}

	public static void main(String[] args) {
		ElectronicDevice obj = new ElectronicDevice();
		obj.sound("Ring! Ring! Ring!").ring();
	}

}

/* Output:
Smartphone makes sound: Ring! Ring! Ring!
*/