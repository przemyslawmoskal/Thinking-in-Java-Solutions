package ch13ex02;
import java.util.*;

public class InfiniteRecursion {
  public String toString() {
    return " InfiniteRecursion address: " + super.toString() + "\n";
  }
  public static void main(String[] args) {
    List<InfiniteRecursion> v =
      new ArrayList<InfiniteRecursion>();
    for(int i = 0; i < 10; i++)
      v.add(new InfiniteRecursion());
    System.out.println(v);
  }
}

/* Output:
[ InfiniteRecursion address: ch13ex02.InfiniteRecursion@1db9742
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@106d69c
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@52e922
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@25154f
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@10dea4e
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@647e05
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@1909752
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@1f96302
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@14eac69
,  InfiniteRecursion address: ch13ex02.InfiniteRecursion@a57993
]
*/