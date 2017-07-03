public class GenericMethods {
  public <T,U,V> void f(T x, U y, V z) {
    System.out.println(x.getClass().getName() + ", " +
    		y.getClass().getName() + ", " +
    		z.getClass().getName());
  }
  public static void main(String[] args) {
    GenericMethods gm = new GenericMethods();
    gm.f("", "", "");
    gm.f(1, "", 1.0F);
    gm.f('c', "dd", 'f');
  }
}

/* Output:
java.lang.String, java.lang.String, java.lang.String
java.lang.Integer, java.lang.String, java.lang.Float
java.lang.Character, java.lang.String, java.lang.Character
*/
