Add a private rehash() method to SimpleHashMap that is invoked when the load factor
exceeds 0.75. During rehashing, double the number of buckets, then search for the
first prime number greater than that to determine the new number of buckets.

Chapter 17 Exercise 39