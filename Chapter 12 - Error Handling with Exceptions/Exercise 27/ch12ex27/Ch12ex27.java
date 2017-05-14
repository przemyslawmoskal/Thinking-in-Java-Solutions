package ch12ex27;
import static ptmoskal.Print.*;

public class Ch12ex27 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        try{
        	for(int i=0; i<6; i++){
        		arr[i] = i;
        	}
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("<< Exception caught >>");
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }finally{
            print("End of the program...");
        }
    }
}

/* Output:
<< Exception caught >>
Exception in thread "main" java.lang.RuntimeException: java.lang.ArrayIndexOutOfBoundsException: 5
	at ch12ex27.Ch12ex27.main(Ch12ex27.java:15)
Caused by: java.lang.ArrayIndexOutOfBoundsException: 5
	at ch12ex27.Ch12ex27.main(Ch12ex27.java:10)
java.lang.ArrayIndexOutOfBoundsException: 5
	at ch12ex27.Ch12ex27.main(Ch12ex27.java:10)
End of the program...
*/