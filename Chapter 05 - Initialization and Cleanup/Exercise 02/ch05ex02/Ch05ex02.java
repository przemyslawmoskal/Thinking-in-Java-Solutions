package ch05ex02;
import static ptmoskal.Print.*;

class MyClass{
	String s1 = "xyz";
    String s2;
}

class MyClass2{
    String s1;
    String s2;
    MyClass2(){
        s1 = "xyz";
    }
}

public class Ch05ex02 {
	public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass2 obj2 = new MyClass2();
        print("obj1.s1 = " + obj1.s1);
        print("obj1.s2 = " + obj1.s2);
        print("obj2.s1 = " + obj2.s1);
        print("obj2.s2 = " + obj2.s2);
    }
}

/* Output:
obj1.s1 = xyz
obj1.s2 = null
obj2.s1 = xyz
obj2.s2 = null
*/