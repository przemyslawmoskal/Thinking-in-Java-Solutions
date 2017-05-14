package ch12ex30;
import static ptmoskal.Print.*;

class Annoyance extends RuntimeException {}
class Sneeze extends Annoyance {}

class WrapCheckedExceptions {
	void throwRuntimeException(int type) {
		try {
			switch(type) {
			case(0): throw new Annoyance();
			case(1): throw new Sneeze();
			case(2): throw new RuntimeException("<< case(2) RuntimeException thrown >>");
			default: return;
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

public class Human {
  public static void main(String[] args) {
	  WrapCheckedExceptions wce = new WrapCheckedExceptions();
	  for(int i = 0; i < 3; i++)  
		  try {
			  if(i < 3)
				  wce.throwRuntimeException(i);
			  else
				  throw new RuntimeException();
		  }catch(RuntimeException re) {
			  try {
				  throw re.getCause();
			  } catch(Sneeze e) {
				  print("Sneeze: " + e);
			  } catch(Annoyance e) {
				  print("Annoyance: " + e);
			  } catch(Throwable e) {
				  print("Throwable: " + e);
			  }
		  }
  }
}

/* Output:
Annoyance: ch12ex30.Annoyance
Sneeze: ch12ex30.Sneeze
Throwable: java.lang.RuntimeException: << case(2) RuntimeException thrown >>
*/