package ch05ex11;
import static ptmoskal.Print.*;

class Item{
    boolean out = false;
    Item(boolean status){
        out = status;
    }    
    void fromClient(){
        out = false;
    }
    void toClient(){
        out = true;
    }
    protected void finalize(){
        if(out)
        	print("Error: item out !!!");    
    }
}

public class Ch05ex11 {

    public static void main(String[] args) {
    	Item bread = new Item(true);
    	Item cake = new Item(true);
    	bread.fromClient();
        new Item(true);
        System.runFinalization();
        Runtime.getRuntime().runFinalization();
        System.gc();
        System.runFinalizersOnExit(true);       
    }
}

/* Output:
Error: item out !!!
Error: item out !!!
*/