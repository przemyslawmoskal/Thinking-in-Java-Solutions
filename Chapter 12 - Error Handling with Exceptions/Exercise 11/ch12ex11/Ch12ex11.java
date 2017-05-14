
package ch12ex11;
import static ptmoskal.Print.*;

class MyExceptionG extends Exception{
    MyExceptionG(String message) { super(message); }
}

public class Ch12ex11 {
    public static void f() {
            try{
                g();
            }catch(MyExceptionG e){
                System.err.print("<< MyExceptionG caught from f function's try{ g() } >>");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
    }
    public static void g() throws MyExceptionG{
        print("g()");
        throw new MyExceptionG("< MyExceptionG thrown from g() >");
    }
    public static void main(String[] args) {
        try {
            f();
        }catch(RuntimeException e){
            System.err.print("<< RuntimeException caught in main function's try{} >>");
            e.printStackTrace();
        }
        
    }
    
}

/* Output:
g()
<< MyExceptionG caught from f function's try{ g() } >>ch12ex11.MyExceptionG: < MyExceptionG thrown from g() >
	at ch12ex11.Ch12ex11.g(Ch12ex11.java:25)
	at ch12ex11.Ch12ex11.f(Ch12ex11.java:16)
	at ch12ex11.Ch12ex11.main(Ch12ex11.java:29)
<< RuntimeException caught in main function's try{} >>java.lang.RuntimeException: ch12ex11.MyExceptionG: < MyExceptionG thrown from g() >
	at ch12ex11.Ch12ex11.f(Ch12ex11.java:20)
	at ch12ex11.Ch12ex11.main(Ch12ex11.java:29)
Caused by: ch12ex11.MyExceptionG: < MyExceptionG thrown from g() >
	at ch12ex11.Ch12ex11.g(Ch12ex11.java:25)
	at ch12ex11.Ch12ex11.f(Ch12ex11.java:16)
	... 1 more
*/