package ch02ex11;

public class Ch02ex11 {
	public static void main(String[] args) {
		AllTheColorsOfTheRainbow rainbow = new AllTheColorsOfTheRainbow();
		System.out.println("rainbow.ColorNumber = " + rainbow.ColorNumber);
		rainbow.changeColor(64);
		rainbow.changeHue(32);
		System.out.println("Color changed: rainbow.ColorNumber = " + rainbow.ColorNumber);
		System.out.println("Hue = " + rainbow.hue);	
	}
}

class AllTheColorsOfTheRainbow {
	int ColorNumber = 0;
	int hue = 0;
	void changeHue(int h) {
		hue = h;
	}
	int changeColor(int c) {
		return ColorNumber = c;		
	}
}

/* Output:
rainbow.ColorNumber = 0
Color changed: rainbow.ColorNumber = 64
Hue = 32
*/