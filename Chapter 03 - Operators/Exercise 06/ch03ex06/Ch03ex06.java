
package ch03ex06;

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

public class Ch03ex06 {

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
       Dog butch=new Dog();
       butch.setName("Butch");
       butch.setSays("Hello!");
       butch.showDogName();
       butch.speak();
       System.out.println("");
       System.out.println("Comparing:");
       System.out.println("spot == butch : " + (spot == butch));
       System.out.println("spot.equals(butch) : " + (spot.equals(butch)));
       System.out.println("butch.equals(spot) : " + (butch.equals(spot)));
       System.out.println();
       System.out.println("Assigning: spot = butch");
       spot = butch;
       System.out.println("Comparing again: ");
       System.out.println("spot == butch : " + (spot == butch));
       System.out.println("spot.equals(butch) : " + (spot.equals(butch)));
       System.out.println("butch.equals(spot) : " + (butch.equals(spot)));
       System.out.println();
       System.out.println("Spot: ");
       spot.showDogName();
       spot.speak();
       System.out.println();
       System.out.println("Butch: ");
       butch.showDogName();
       butch.speak();
    }
    
}

/* Output:
Spot
Ruff!
Scruffy
Wurf!
Butch
Hello!

Comparing:
spot == butch : false
spot.equals(butch) : false
butch.equals(spot) : false

Assigning: spot = butch
Comparing again: 
spot == butch : true
spot.equals(butch) : true
butch.equals(spot) : true

Spot: 
Butch
Hello!

Butch: 
Butch
Hello!
*/