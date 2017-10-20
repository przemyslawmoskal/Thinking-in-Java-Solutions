
package ch12ex10;
import static ptmoskal.Print.*;

class MyExceptionF extends Exception{
    MyExceptionF(String message) { super(message); }
}

class MyExceptionG extends Exception{
    MyExceptionG(String message) { super(message); }
}

public class Ch12ex10 {
    public static void f() throws MyExceptionF{
            try{
                g();
            }catch(MyExceptionG e){
                System.err.print("<< MyExceptionG caught from f function's try{ g() } >>");
                e.printStackTrace();
                MyExceptionF excf = new MyExceptionF("<< Exception thrown from catch section of f functions try{} >>");
                excf.initCause(e);
                throw excf;
            }
    }
    public static void g() throws MyExceptionG{
        print("g()");
        throw new MyExceptionG("< MyExceptionG thrown from g() >");
    }
    public static void main(String[] args) {
        try {
            f();
        }catch(MyExceptionF e){
            System.err.print("<< MyExceptionF caught in main function's try{} >>");
            e.printStackTrace();
        }
        
    }
    
}

/* Output:
g()
<< MyExceptionG caught from f function's try{ g() } >>cwiczenie01210.MyExceptionG: < MyExceptionG thrown from g() >
	at cwiczenie01210.Cwiczenie01210.g(Cwiczenie01210.java:27)
	at cwiczenie01210.Cwiczenie01210.f(Cwiczenie01210.java:16)
	at cwiczenie01210.Cwiczenie01210.main(Cwiczenie01210.java:31)
<< MyExceptionF caught in main function's try{} >>cwiczenie01210.MyExceptionF: << Exception thrown from catch section of f functions try{} >>
	at cwiczenie01210.Cwiczenie01210.f(Cwiczenie01210.java:20)
	at cwiczenie01210.Cwiczenie01210.main(Cwiczenie01210.java:31)
Caused by: cwiczenie01210.MyExceptionG: < MyExceptionG thrown from g() >
	at cwiczenie01210.Cwiczenie01210.g(Cwiczenie01210.java:27)
	at cwiczenie01210.Cwiczenie01210.f(Cwiczenie01210.java:16)
	... 1 more
*/