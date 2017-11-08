package annotations;

@ExtractInterface("IDivider")
public class Divider {
	public int divide(int x, int y) {
		if(y == 0) {
			throw new ArithmeticException("Dividing by zero");
		}
		int difference = subtract(x, y);
		if(difference < 0) {
			return 0;
		}
		if(difference == 0) {
			return 1;
		}
		int result = 0;
		while(difference >= 0) {
			result++;
			difference = subtract(difference,y);
		}
		return result;
	}

	private int subtract(int x, int y) {
		return x - y;
	}

	public static void main(String[] args) {
		Divider d = new Divider();
		try {
			System.out.println("10:2 = " + d.divide(10, 2));	
		}catch(Exception e) {
			System.err.print(e);
		}
		
	}
}