package ch14ex15;
import typeinfo.pets.PetFactory;

public class Ch14ex15 {

	public static void main(String[] args) {
		for(int i = 0; i < 15; i++)
			System.out.println(PetFactory.createRandom());
	}

}

/* Output:
Cymric
Rat
Dog
Rodent
Rodent
Rodent
Mouse
Pug
Hamster
Dog
EgyptianMau
Pug
Cat
Rat
Cymric
*/