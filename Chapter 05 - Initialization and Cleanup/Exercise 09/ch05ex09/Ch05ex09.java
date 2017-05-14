package ch05ex09;
import static ptmoskal.Print.*;

class MyClass{
    String first = "String0";
    int number;
    MyClass(String second) {
        first = second;
        print("Constructor with only String argument is working, String: " + first + ", int number = " + number);
    }
    MyClass(String third,int i) {
        this(third);
        number = i;
        print("Constructor with String and int arguments is working, String: " + third + ", int number = " + i);
    }
    
}

public class Ch05ex09 {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass("String1");
        print("************************************************************************************");
        MyClass obj2 = new MyClass("String2", 100);
    }
    
}

/* Output:
Constructor with only String argument is working, String: String1, int number = 0
************************************************************************************
Constructor with only String argument is working, String: String2, int number = 0
Constructor with String and int arguments is working, String: String2, int number = 100
*/