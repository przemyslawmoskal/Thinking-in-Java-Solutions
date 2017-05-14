package ch03ex04;
import static ptmoskal.Print.*;

class Velocity {
	static float count(float s, float t) {
		float v = s/t;
		return v;
	}
}

public class Ch03ex04 {
	
	public static void main(String[] args) {
		float s = 150;
		float t = 30;
		float v = Velocity.count(s, t);
		print("s = " + s + ", t = " + t + ", v = " + v);
		s = 152.15f;
		t = 8.3f;
		v = Velocity.count(s, t);
		print("s = " + s + ", t = " + t + ", v = " + v);
	}

}

/* Output:
s = 150.0, t = 30.0, v = 5.0
s = 152.15, t = 8.3, v = 18.331324
*/
