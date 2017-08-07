package ch15ex25;

public class ClassA implements InterfaceA, InterfaceB {
	public void a() {}
	public void b() {}
	public String toString() { return getClass().getSimpleName(); }
}
