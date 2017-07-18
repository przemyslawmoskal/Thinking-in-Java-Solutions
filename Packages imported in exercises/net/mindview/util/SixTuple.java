package net.mindview.util;

public class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {
	public final F sixth;
	public SixTuple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		sixth = f;
	}
	public String toString() {
		return "(" + first + ", " + second + ", " +
				third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
	}
}

