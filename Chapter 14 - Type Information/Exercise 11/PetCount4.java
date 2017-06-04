//: typeinfo/PetCount4.java
import typeinfo.pets.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class PetCount4 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Pet.class);
    for(Pet pet : Pets.createArray(20)) {
      printnb(pet.getClass().getSimpleName() + " ");
      counter.count(pet);
    }
    print();
    print(counter);
  }
}

/* Output: (Sample)
EgyptianMau Gerbil Cymric EgyptianMau Cymric EgyptianMau Pug Rat Mutt Cymric Manx Manx Manx Cymric EgyptianMau Pug Hamster Cymric Gerbil Pug 
{EgyptianMau=4, Gerbil=2, Rodent=4, Pet=20, Rat=1, Mutt=1, Hamster=1, Pug=3, Manx=8, Cat=12, Dog=4, Cymric=5}
*/
