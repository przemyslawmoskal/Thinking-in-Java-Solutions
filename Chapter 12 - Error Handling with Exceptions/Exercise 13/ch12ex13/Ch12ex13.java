
package ch12ex13;
import static ptmoskal.Print.*;

class MyException1 extends Exception{
   MyException1(String message){
       super(message);
   }
}
class MyException2 extends Exception{
    MyException2(String message){
       super(message);
   }
}
class MyException3 extends Exception{
    MyException3(String message){
       super(message);
    }
}

public class Ch12ex13 {
	private static Integer[] tablica = new Integer[10];
    public static void f(int i) throws MyException1, MyException2, MyException3{
        if(i==0)
            throw new MyException1("i==0");
        if(i<0)
            throw new MyException2("i<0");
        if(i>0)
            throw new MyException3("i>0");
    }
    public static void main(String[] args){
    	try {
    		f(tablica[0]);
    	}catch(Exception e) {
    		System.err.print("Exception caught from f()");
    		e.printStackTrace();
    	}finally{
    		print("finally section{...}");
    	}
    	
    }
}

/* Output:
Exception caught from f()java.lang.NullPointerException
	at ch12ex13.Ch12ex13.main(Ch12ex13.java:33)
finally section{...}
*/

