package ch02ex09;

public class Ch02ex09 {

	public static void main(String[] args) {
		boolean bln = true;
		byte bt = 6;
		char chrctr = 'a';
		double dbl = 0.123;
		float flt = 0.52f;
		int i = 3;
		long lng = 6540;
		short shrt = 1;
		Boolean bln2 = bln;
		System.out.println("boolean bln = " + bln + ", Boolean bln2 = " + bln2);
		System.out.println();
		Byte bt2 = bt;
		System.out.println("byte bt = " + bt + ", Byte bt2 = " + bt2);
		System.out.println();
		Character chrctr2 = chrctr;
		System.out.println("char chrctr = " + chrctr + ", Character chrctr2 = " + chrctr2);
		System.out.println();
		Double dbl2 = dbl;
		System.out.println("double dbl = " + dbl + ", Double dbl2 = " + dbl2);
		System.out.println();
		Float flt2 = flt;
		System.out.println("float flt = " + flt + ", Float flt2 = " + flt2);
		System.out.println();
		Integer i2 = i;
		System.out.println("int i = " + i + ", Integer i2 = " + i2);
		System.out.println();
		Long lng2 = lng;
		System.out.println("long lng = " + lng + ", Long lng2 = " + lng2);
		System.out.println();
		Short shrt2 = shrt;
		System.out.println("short shrt = " + shrt+ ", Short shrt2 = " + shrt2);
	}

}

/* Output:
boolean bln = true, Boolean bln2 = true

byte bt = 6, Byte bt2 = 6

char chrctr = a, Character chrctr2 = a

double dbl = 0.123, Double dbl2 = 0.123

float flt = 0.52, Float flt2 = 0.52

int i = 3, Integer i2 = 3

long lng = 6540, Long lng2 = 6540

short shrt = 1, Short shrt2 = 1
*/
