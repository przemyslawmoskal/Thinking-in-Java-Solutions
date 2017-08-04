interface FactoryI<T> {
	T create(Integer i);
}

class Foo2<T> {
	private T x;
	public <F extends FactoryI<T>> Foo2(F factory, Integer i) {
		x = factory.create(i);
	}
	public void show() {
		System.out.println(x);
	}
}

class IntegerFactory implements FactoryI<Integer> {
	public Integer create(Integer i) {
		return new Integer(i);
	}
}	

class Widget {
	int i;
	public static class Factory implements FactoryI<Widget> {
		public Widget create(Integer i) {
			Widget w = new Widget();
			w.i = i;
			return w;
		}
	}
	public String toString() {
		return "Widget(" + i + ")";
	}
}

public class FactoryConstraint {
	public static void main(String[] args) {
		Foo2 foo1 = new Foo2<Integer>(new IntegerFactory(), 128);
		Foo2 foo2 = new Foo2<Widget>(new Widget.Factory(), 256);
		foo1.show();
		foo2.show();
	}
}

/* Output:
128
Widget(256)
*/