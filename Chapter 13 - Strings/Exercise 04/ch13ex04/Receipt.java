package ch13ex04;
import java.util.*;

public class Receipt {
  private double total = 0;
  private Formatter f = new Formatter(System.out);
  private static int value1 = 15;
  private static int value2 = 5;
  private static int value3 = 10;
  private String str1 = "%-" + value1 + "s %" + value2 + "s %" + value3 + "s\n";
  private String str2 = "%-" + value1 + ".15s %" + value2 + "d %" + value3 + ".2f\n";
  private String str3 = "%-" + value1 + "s %" + value2 + "s %" + value3 + ".2f\n";
  public void printTitle() {
    f.format(str1, "Item", "Qty", "Price");
    f.format(str1, "----", "---", "-----");
  }
  public void print(String name, int qty, double price) {
    f.format(str2, name, qty, price);
    total += price;
  }
  public void printTotal() {
    f.format(str3, "Tax", "", total*0.06);
    f.format(str1, "", "", "-----");
    f.format(str3, "Total", "",
      total * 1.06);
  }
  public static void main(String[] args) {
    Receipt receipt = new Receipt();
    receipt.printTitle();
    receipt.print("Jack's Magic Beans", 4, 4.25);
    receipt.print("Princess Peas", 3, 5.1);
    receipt.print("Three Bears Porrid ge", 1, 14.29);
    receipt.printTotal();
  }
}

/* Output:
Item              Qty      Price
----              ---      -----
Jack's Magic Be     4       4,25
Princess Peas       3       5,10
Three Bears Por     1      14,29
Tax                         1,42
                           -----
Total                      25,06
*/
