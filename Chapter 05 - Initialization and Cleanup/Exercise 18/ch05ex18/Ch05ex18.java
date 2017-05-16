package ch05ex18;
import static ptmoskal.Print.*;

class Car{
    Car(String s) {
        print("String sent: " + s);
    }
}


public class Ch05ex18 {

    public static void main(String[] args) {
        Car[] arr = new Car[]{new Car("Porsche"),new Car("Lamborghini"),};
    }
}

/* Output:
String sent: Porsche
String sent: Lamborghini
*/