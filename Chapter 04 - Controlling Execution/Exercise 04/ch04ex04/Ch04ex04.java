package ch04ex04;
import static ptmoskal.Print.*;

public class Ch04ex04 {

	public static void main(String[] args) {
		print("Prime numbers (0-100) :");
		for(int i = 1; i < 100; i++ ) {
			int factors = 0;
			for(int j = 1; j < (i + 2)/2; j++ ) {
				if((i % j) == 0) factors++; 			
			}
			if(factors < 2)
				print(i);
		}
	}

}

/* Output:
Prime numbers (0-100) :
1
2
3
5
7
11
13
17
19
23
29
31
37
41
43
47
53
59
61
67
71
73
79
83
89
97
*/