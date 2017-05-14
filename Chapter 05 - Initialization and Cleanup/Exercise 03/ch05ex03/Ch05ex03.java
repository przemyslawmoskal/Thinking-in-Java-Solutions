package ch05ex03;
import static ptmoskal.Print.*;

class MyClass{
    MyClass(){
        print("Default constructor is working...");
    }
}

public class Ch05ex03 {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
	}   
}

/* Output:
Default constructor is working...
*/