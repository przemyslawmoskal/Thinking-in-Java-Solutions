Study the JDK documentation for EnumSet. You'll see that there's a clone() method defined.
However, you cannot clone() from the reference to the Set interface passed in Sets.java.
Can you modify Sets.java to handle both the general case of a Set interface as shown,
and the special case of an EnumSet, using clone() instead of creating a new HashSet?

Chapter 15 Exercise 17