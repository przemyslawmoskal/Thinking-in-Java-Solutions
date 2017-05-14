package ch12ex28;
import static ptmoskal.Print.*;

class MyException extends RuntimeException {
    private String message;
    MyException(String msg){
        super(msg);
        this.message = msg;
    }
    public void ShowMessage(){
        print("Message: " + message);
    }
    
}

public class Ch12ex28 {
    public static void f() throws MyException{
        print("f()");
        throw new MyException("Throwing exception from f() with String argument");
    }
    public static void main(String[] args) {     
            f();
    }
    
}

/* Output:
f()
Exception in thread "main" ch12ex28.MyException: Throwing exception from f() with String argument
	at ch12ex28.Ch12ex28.f(Ch12ex28.java:18)
	at ch12ex28.Ch12ex28.main(Ch12ex28.java:22)
*/