# Trivium stream cipher

## The problem:
Write an implementation of the Trivium stream cipher, as
illustrated below. The symbol ⊕ denotes binary XOR, while ⊙ denotes binary
AND. The device is initialized as described in the lecture slides, that is:

 * _the 80-bit key is loaded into the first 80 bits of the 84-degree LFSR (the 
   “first” bits here refers to the left-most 80 bits);_
 * _the 80-bit initialization vector is loaded into the first 80 bits of the 93-
   degree LFSR;_
 * _the right-most 3 bits of the 111-degree LFSR are set to 1;_
 * _all remaining bits are set to 0._
 
Recall that the cipher performs 1152 “warm-up” steps before beginning to produce output.

Use your implementation with key *K* = (1, 0, 1, 0, . . . , 1, 0) (80 alternating
ones and zeros) and *IV* = (0, 1, . . . , 0, 1) (80 alternating zeros and ones) to
generate 1000 bits of key-stream.

![Trivium Visualization](./src/documents/TriviumVisualization.png)

## The stream cipher
To get more specific information about how this stream cipher works you can take visit to wikipedia through [this link](https://en.wikipedia.org/wiki/Trivium_(cipher))

## The project
The project is an assignment for the course "Applied Cryptography" INF 143A at the University of Bergen.