package ch12ex09;
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

public class Ch12ex09 {
    public static void f(int i) throws MyException1, MyException2, MyException3{
        if(i==0)
            throw new MyException1("i==0");
        if(i<0)
            throw new MyException2("i<0");
        if(i>0)
            throw new MyException3("i>0");
    }
    public static void main(String[] args) {
        for(int i = -1; i < 2; i++){
            try{
            f(i);
        }catch(Exception e){
            System.err.print("Exception caught...");
            e.printStackTrace();
        }
        }
        
    }
    
}
/*
Output:
Exception caught...ch12ex09.MyException2: i<0
	at ch12ex09.Ch12ex09.f(Ch12ex09.java:25)
	at ch12ex09.Ch12ex09.main(Ch12ex09.java:32)
Exception caught...ch12ex09.MyException1: i==0
	at ch12ex09.Ch12ex09.f(Ch12ex09.java:23)
	at ch12ex09.Ch12ex09.main(Ch12ex09.java:32)
Exception caught...ch12ex09.MyException3: i>0
	at ch12ex09.Ch12ex09.f(Ch12ex09.java:27)
	at ch12ex09.Ch12ex09.main(Ch12ex09.java:32)
*/