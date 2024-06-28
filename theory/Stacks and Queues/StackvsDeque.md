## Stack vs Deque

### Stack 
###### LIFO Principle (Last In, First Out):
Elements are added (pushed) and removed (popped) from the top of the stack.
The last element pushed onto the stack is the first one to be popped off.
###### Operations:

Push: Adds an element to the top of the stack.
Pop: Removes and returns the top element from the stack.
Peek: Returns the top element without removing it.

###### Use Cases:
- Function call stack in programming languages.
- Undo mechanisms in text editors and applications.
- Expression evaluation (e.g., infix to postfix conversion).


### Deque

###### FIFO and LIFO Operations:
- A deque supports operations at both ends, allowing elements to be added or removed from either the front or the back.
- Can function as a queue (FIFO) or a stack (LIFO) depending on the type of operation used.
  FIFO and LIFO 

###### Operations:
- Add to Front/Back: Adds an element to the front or back of the deque.
- Remove from Front/Back: Removes and returns an element from the front or back of the deque.
- Peek Front/Back: Returns the front or back element without removing it.

###### Use Cases:
- Implementing queues and stacks where elements may need to be added or removed from both ends.
- Sliding window algorithms.
- Managing a collection where access and manipulation from both ends are required.