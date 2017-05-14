package ch04ex08;

public class Ch04ex08 {

	public static void main(String[] args) {
		System.out.println("With break:");
		for(int i = 0; i < 8; i++){
			switch(i){
                case 0: System.out.println("zero"); break;
                case 1: System.out.println("one"); break;
                case 2: System.out.println("two"); break;
                case 3: System.out.println("three"); break;
                case 4: System.out.println("four"); break;    
                case 5: System.out.println("five"); break;
                case 6: System.out.println("six");break;
                default: System.out.println("default...");
			}
		}
		System.out.println();
		System.out.println("Without break:");
		for(int i = 0; i < 8; i++){
			switch(i){
                case 0: System.out.println("zero");
                case 1: System.out.println("one");
                case 2: System.out.println("two");
                case 3: System.out.println("three");
                case 4: System.out.println("four");    
                case 5: System.out.println("five");
                case 6: System.out.println("six");
                default: System.out.println("default...");
			}
		}
	}
}

/* Output:
With break:
zero
one
two
three
four
five
six
default...

Without break:
zero
one
two
three
four
five
six
default...
one
two
three
four
five
six
default...
two
three
four
five
six
default...
three
four
five
six
default...
four
five
six
default...
five
six
default...
six
default...
default...
*/