package ch15ex28;
import typeinfo.pets.*;

public class Ch15ex28 {
	
	class Generic<T> {
		T t;
		public void argT(T t) { this.t = t; }
	}
	class Generic2<T> {
		T t;
		public T retT() { return t; }
	}
	public <T> void contravariant(Generic<? super T> genT, T t) {
		genT.argT(t);
	}
	public <T> T covariant(Generic2<? extends T> gen2T) {
		return gen2T.retT();
	}
	public static void main(String[] args) {
		Ch15ex28 obj = new Ch15ex28();
		obj.contravariant(obj.new Generic<Pet>(), new Cymric());
		obj.covariant(obj.new Generic2<Pet>());
	}

}

/* Output:
*/