package ch15ex25;

public class Ch15ex25 {
	public <T extends InterfaceA> void f(T t) { System.out.println("f(" + t + ")"); }
	public <T extends InterfaceB> void g(T t) {System.out.println("g(" + t + ")");}
	public static void main(String[] args) {
		ClassA a = new ClassA();
		Ch15ex25 obj = new Ch15ex25();
		obj.f(a);
		obj.g(a);
	}

}
