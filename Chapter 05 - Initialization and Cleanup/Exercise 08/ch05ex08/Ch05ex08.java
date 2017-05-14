package ch05ex08;
import static ptmoskal.Print.*;

class MyClass {
    void f1(){
        print("In f1(), now calling f2()...");
        f2();
        print("Still in f1(), now calling this.f2()...");
        this.f2();
    }
    void f2(){
        print("f2()"); 
    }
}

public class Ch05ex08 {

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.f1();
    }
    
}

/* Output:
In f1(), now calling f2()...
f2()
Still in f1(), now calling this.f2()...
f2()
*/