Instead of using a ListIterator for each bucket, modify MapEntry so that it is
a self-contained singly linked list (each MapEntry should have a forward link
to the next MapEntry). Modify the rest of the code in SimpleHashMap.java so that
this new approach works correctly.

Chapter 17 Exercise 25