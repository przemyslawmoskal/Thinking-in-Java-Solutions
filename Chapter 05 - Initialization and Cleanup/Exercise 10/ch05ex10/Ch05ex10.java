package ch05ex10;
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

public class Ch05ex10 {

    public static void main(String[] args) {
    	Item bread = new Item(true);
    	Item cake = new Item(true);
    	bread.fromClient();
        new Item(true);
        System.gc();
       
    }
}

/* Output:
Error: item out !!!
*/