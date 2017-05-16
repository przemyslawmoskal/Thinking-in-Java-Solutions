
package ch05ex19;

public class Ch05ex19 {
    
    static void f(String... args){
        System.out.print("f()... ");
        for(String x : args){
            System.out.print(x + " ");
        }
        System.out.println(" ");
    }
    
    public static void main(String[] args) {
        f("Comma","separated","list");
        f(new String[]{"These","are","array","elements"});
    }   
}

/* Output:
f()... Comma separated list  
f()... These are array elements
*/