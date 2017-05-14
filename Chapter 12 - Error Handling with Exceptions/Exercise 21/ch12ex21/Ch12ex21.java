package ch12ex21;

class MyException extends Exception{};

class Base {
	Base() throws MyException{
		throw new MyException();
	}
}

class Derived extends Base{
	//! No way to catch exception thrown from class Base constructor;
			Derived() throws MyException{
				super();
	//! Can't catch without try
	//			catch(MyException e){}
	//! Calling super must be the first statement in constructor
	//			try{
	//				super();
	//			} catch(MyException e){}
			} 
}

public class Ch12ex21 {

	public static void main(String[] args) {
		try{
		Derived obj = new Derived();
		} catch(MyException e){
			System.err.println("<< MyException caught in main()>>");
			e.printStackTrace();
		}
	}

}

/* Output:
<< MyException caught in main()>>
ch12ex21.MyException
	at ch12ex21.Base.<init>(Ch12ex21.java:8)
	at ch12ex21.Derived.<init>(Ch12ex21.java:15)
	at ch12ex21.Ch12ex21.main(Ch12ex21.java:32)
*/