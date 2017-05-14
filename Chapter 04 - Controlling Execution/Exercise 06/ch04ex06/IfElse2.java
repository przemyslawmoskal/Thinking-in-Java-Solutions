package ch04ex06;
import static net.mindview.util.Print.*;

public class IfElse2 {
  static int test(int testval, int begin, int end) {
	  if(end < begin) {
		  printnb("End < begin !! ");
		  return 0;
	  }
	  if((testval >= begin) && (testval <= end))
		  return +1;
	  if((testval < begin) || (testval > end))
		  return -1;
	  return 100;
  }
  public static void main(String[] args) {
	  print(test(10, 5, 12));
	  print(test(5, 10, 5));
	  print(test(2, 5, 10));
  }
}

/* Output:
1
End < begin !!
0
-1
*/
