Modify SlowMap so that instead of two ArrayLists, it holds a single ArrayList
of MapEntry objects. Verify that the modified version works correctly. Using
MapPerformance.java, test the speed of your new Map. Now change the put() method so that
if performs a sort() after each pair is entered, and modify get() to use
Collections.binarySearch() to look up the key. Compare the performance of the new
version with the old ones.

Chapter 17 Exercise 36