Solve a single-producer, single consumer problem using wait() and notifyAll(). The producer must not
overflow the receiver's buffer, which can happen if the producer is faster than the consumer. If the consumer
is faster than the producer, then it must not read the same data more than once. Do not assume anything about
the relative speeds of the producer or consumer.

Chapter 21 Exercise 24