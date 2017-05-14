
package ch03ex05;

class Dog{
	String name;
	String says;
	void setName(String n){
		name=n;
		}
	void setSays(String s){
		says=s;
		}
	void showDogName(){
		System.out.println(name);
		}
	void speak(){
		System.out.println(says);
		}
}

public class Ch03ex05 {

    public static void main(String[] args) {
       Dog spot = new Dog();
       spot.setName("Spot");
       spot.setSays("Ruff!");
       Dog scruffy = new Dog();
       scruffy.setName("Scruffy");
       scruffy.setSays("Wurf!");
       spot.showDogName();
       spot.speak();
       scruffy.showDogName();
       scruffy.speak();
    }
    
}

/* Output:
Spot
Ruff!
Scruffy
Wurf!
*/