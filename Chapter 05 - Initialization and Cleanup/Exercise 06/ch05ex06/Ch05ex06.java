package ch05ex06;
import static ptmoskal.Print.*;

class Dog{
    void bark(){
        print("Dog is quiet...");
    }
    void bark(byte b) {
    	print("bbbbark !");
    }
    void bark(char c){
    	print("cccccc !");
    }
    void bark(double d){
    	print("dddddd !");
    }
    void bark(float f){
    	print("ffffff !");
    }
    void bark(int i){
    	print("iiiiiii !");
    }
    void bark(long l){
    	print("llllll !");
    }
    void bark(short s){
    	print("ssssss !");
    }
    void bark(char c, int i){
    	print("ccccc... iiiiii....");
    }
    void bark(int i, char c){
    	print("icicicic...");
    }
}

public class Ch05ex06 {

    public static void main(String[] args) {
       Dog dog1 = new Dog();
       byte b = 0;
       char c = 'x';
       short s = 0;
       dog1.bark();
       dog1.bark((byte)b);
       dog1.bark((char)c);
       dog1.bark(1.0);
       dog1.bark(100.0f);
       dog1.bark(100);
       dog1.bark(100L);
       dog1.bark((short)s);
       dog1.bark(c, 100);
       dog1.bark(100, c);
    }
}

/* Output:
Dog is quiet...
bbbbark !
cccccc !
dddddd !
ffffff !
iiiiiii !
llllll !
ssssss !
ccccc... iiiiii....
icicicic...
*/