package ch02ex16;
import static net.mindview.util.Print.*;

/** that class creates type Tree
 */
class Tree {
	/** field storing height of the tree
	*/
  int height;
  /** constructor with no arguments
   */
  Tree() {
    print("Planting a seedling");
    height = 0;
  }
  /** constructor taking an int argument
   * which is assigned to height
   */
  Tree(int initialHeight) {
    height = initialHeight;
    print("Creating new Tree that is " +
      height + " feet tall");
  }
  /** method printing height of the tree
   */
  void info() {
    print("Tree is " + height + " feet tall");
  }
  /** method printing string argument and height of the tree
   */
  void info(String s) {
    print(s + ": Tree is " + height + " feet tall");
  
  }
}

/** Class creating and testing if tree objects are constructed properly
 */
public class Overloading {
  public static void main(String[] args) {
    for(int i = 0; i < 5; i++) {
      Tree t = new Tree(i);
      t.info();
      t.info("overloaded method");
    }
    // Overloaded constructor:
    new Tree();
  }	
} /* Output:
Creating new Tree that is 0 feet tall
Tree is 0 feet tall
overloaded method: Tree is 0 feet tall
Creating new Tree that is 1 feet tall
Tree is 1 feet tall
overloaded method: Tree is 1 feet tall
Creating new Tree that is 2 feet tall
Tree is 2 feet tall
overloaded method: Tree is 2 feet tall
Creating new Tree that is 3 feet tall
Tree is 3 feet tall
overloaded method: Tree is 3 feet tall
Creating new Tree that is 4 feet tall
Tree is 4 feet tall
overloaded method: Tree is 4 feet tall
Planting a seedling
*///:~
