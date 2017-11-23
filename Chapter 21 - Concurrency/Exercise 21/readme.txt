Create two Runnables, one with a run() that starts and calls wait(). The second class should capture
the reference of the first Runnable object. Its run() should call notifyAll() for the first task after
some number of seconds have passed so that the first task can display a message. Test your classes using an Executor.

Chapter 21 Exercise 21