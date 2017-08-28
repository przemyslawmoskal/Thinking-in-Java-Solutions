package ch16ex16;

public class SkipGen {
	public static class Boolean implements SkipGenerator<java.lang.Boolean> {
		private boolean value = false;
		private int i;
		public Boolean(int i) { this.i = i; }
		public java.lang.Boolean next() {
			value = !value; // Just flips back and forth
			return value;
		}
		public java.lang.Boolean next(int i) {
			value = i % 2 == 0 ? true : false;
			return value;
		}
	}
	public static class Byte implements SkipGenerator<java.lang.Byte> {
		private byte value = 0;
		private int i;
		public Byte(int i) { this.i = i; }
		public java.lang.Byte next() { return value++; }
		public java.lang.Byte next(int i) { return value += i; }
	}
	static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	public static class Character implements SkipGenerator<java.lang.Character> {
		int index = -1;
		int i;
		public Character() { index = -1; }
		public Character(int i) { this.i = i; }
		public java.lang.Character next() {
			index = (index + 1) % chars.length;
			return chars[index];
		}
		public java.lang.Character next(int i) {
			index = (index + 1 + i) % chars.length;
			return chars[index];
		}
	}
	public static class String implements SkipGenerator<java.lang.String> {
		private int length = 7;
		SkipGenerator<java.lang.Character> cg = new Character();
		public String() {}
		public String(int length) { this.length = length; }
		public java.lang.String next() {
			char[] buf = new char[length];
			for(int i = 0; i < length; i++)
				buf[i] = cg.next();
			return new java.lang.String(buf);
		}
		public java.lang.String next(int j) {
			char[] buf = new char[length];
			for(int i = 0; i < length; i++)
				buf[i] = cg.next(j);
			return new java.lang.String(buf);
		}
	}	
	public static class Short implements SkipGenerator<java.lang.Short> {
		private short value = 0;
		private int i;
		public Short(int i) { this.i = i; } 
		public java.lang.Short next() { return value++; }
		public java.lang.Short next(int i) { return value += i; }
	}
	public static class Integer implements SkipGenerator<java.lang.Integer> {
		private int value = 0;
		private int i;
		public Integer(int i) { this.i = i; }
		public java.lang.Integer next() { return value++; }
		public java.lang.Integer next(int i) { return value += i; }
	}
	public static class Long implements SkipGenerator<java.lang.Long> {
		private long value = 0;
		private int i;
		public Long(int i) { this.i = i; }
		public java.lang.Long next() { return value += i; }
		public java.lang.Long next(int i) { return value += i; }
	}
	public static class Float implements SkipGenerator<java.lang.Float> {
		private float value = 0;
		private int i;
		public Float(int i) { this.i = i; }
		public java.lang.Float next() {
			float result = value;
			value += 1.0;
			return result;
		}
		public java.lang.Float next(int i) {
			float result = value;
			value += (1.0 * i);
			return result;
		}	
	}
	public static class Double implements SkipGenerator<java.lang.Double> {
		private double value = 0.0;
		private int i;
		public Double(int i) { this.i = i; }
		public java.lang.Double next() {
			double result = value;
			value += 1.0;
			return result;
		}
		public java.lang.Double next(int i) {
			double result = value;
			value += (1.0 * i);
			return result;
		}
	}
}
