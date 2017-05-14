package ch05ex12;
import static ptmoskal.Print.*;

class Tank{
    boolean full = false;
    Tank(boolean status){
        full = status;
    }
    void fill(){
        full = true;
    }
    void empty(){
        full = false;
    }
    protected void finalize(){
            if(full)
                print("Tank level: full");
            else
                print("Tank level: empty");
    }                
          
            
}

/* Output:
Tank level: full
*/



public class Ch05ex12 {

    public static void main(String[] args) {
        Tank tank1 = new Tank(true);
        Tank tank2 = new Tank(true);
        tank1.empty();
        new Tank(true);
        System.gc();   
    }
}