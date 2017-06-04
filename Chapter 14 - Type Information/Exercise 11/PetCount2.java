//: typeinfo/PetCount2.java
import typeinfo.pets.*;

public class PetCount2 {
  public static void main(String[] args) {
    PetCount.countPets(Pets.creator);
  }
}

/* Output:
EgyptianMau Gerbil Cymric EgyptianMau Cymric EgyptianMau Pug Rat Mutt Cymric Manx Manx Manx Cymric EgyptianMau Pug Hamster Cymric Gerbil Pug 
{EgyptianMau=8, Pug=3, Cymric=8, Rat=1, Cat=12, Manx=8, Rodent=4, Mutt=1, Gerbil=2, Dog=4, Pet=20, Hamster=1}
*/
