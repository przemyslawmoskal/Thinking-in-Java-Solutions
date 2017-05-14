package ch02ex08;

class StaticTest {
	static int i = 47;
}

class StaticFun {
	static void incr() { StaticTest.i++; }
}

public class Ch02ex08 {

	public static void main(String[] args) {
		System.out.println("StaticTest.i = " + StaticTest.i);
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		System.out.println("StaticFun.incr() :");
		StaticFun.incr();
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		System.out.println("st1.i++ :");
		st1.i++;
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		StaticFun statFun = new StaticFun();
		System.out.println("statFun.incr() :");
		statFun.incr();
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		StaticTest st3 = new StaticTest();
		System.out.println("st3.i = 5 : ");
		st3.i = 5;
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		System.out.println("st3.i = " + st3.i);

	}

}

/* Output:
StaticTest.i = 47
st1.i = 47
st2.i = 47
StaticFun.incr() :
st1.i = 48
st2.i = 48
st1.i++ :
st1.i = 49
st2.i = 49
statFun.incr() :
st1.i = 50
st2.i = 50
st3.i = 5 : 
st1.i = 5
st2.i = 5
st3.i = 5
*/
