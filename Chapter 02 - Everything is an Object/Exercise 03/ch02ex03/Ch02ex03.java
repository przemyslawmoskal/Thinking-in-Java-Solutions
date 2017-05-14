package ch02ex03;

class ATypeName {
	int i;
	char c;
}

public class Ch02ex03 {

	public static void main(String[] args) {
		ATypeName obj = new ATypeName();
		System.out.println("int i = " + obj.i);
		System.out.println("int c = " + obj.c);
	}

}

/* Output:
int i = 0
int c = 
*/