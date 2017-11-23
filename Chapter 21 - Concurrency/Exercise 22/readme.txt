Create an example of a busy wait. One task sleeps for a while and then sets a flag to true. The second task
watches that flag inside a while loop (this is the busy wait) and when the flag becomes true, sets it back
to false and reports the change to the console. Note how much wasted time the program spends inside the busy wait,
and create a second version of the program that uses wait() instead of the busy wait.

Chapter 21 Exercise 22