public class GenericMethods {
  public <T,V> void f(T x, Character y, V z) {
    System.out.println(x.getClass().getName() + ", " +
    		y.getClass().getName() + ", " +
    		z.getClass().getName());
  }
  public static void main(String[] args) {
    GenericMethods gm = new GenericMethods();
    gm.f("", 'a', "");
    gm.f(1, 'b', 1.0F);
    gm.f('c', 'c', 'f');
  }
}

/* Output:
java.lang.String, java.lang.Character, java.lang.String
java.lang.Integer, java.lang.Character, java.lang.Float
java.lang.Character, java.lang.Character, java.lang.Character
*/
