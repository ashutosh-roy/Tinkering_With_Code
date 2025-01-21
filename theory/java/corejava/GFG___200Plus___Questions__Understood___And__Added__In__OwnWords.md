#### Important ShortListed Questions
_____________________________________
PREP For FICO_Java Questions asked
> OOPs
* What is polymorphism and its types & examples
* What is inheritance and its types & examples
* OOPs Concepts along with example

> Java DataStructure Questions
* Hashmap vs hashset
* Arraylist vs hashmap
* When to use hashmap and hashtable?
* [Hashmap working](https://www.youtube.com/watch?v=NCx_ABybp2o&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=12i)
* Difference between hash code and equals?
* hash map we have (key and value ) pair, can we store inside a value =(key, value ) again ??

> Misc
* In public static void main(String arr[])… what if we replace public with private, remove static, replace void with string?
* What is variable scope in java (in class, in method, in static block)
* What is difference between .equals() , (==) and compare-to()?
* What are singleton classes ? Write a program so that whenever you create an object, you get to know how many objects you have created?
* Use of the collection, when we use it?
* Why is string immutable in java?
* What is a red black tree ? 
* You want to do encryption of a file. How would you do and what will be your Objects in the class.
* What is the default package in java?
* We have 2 interfaces both have the print method, in my class, I have implemented the print method, how you will get to know that I have implemented the first interface and how you will use it.
what is synchronization, how it is achieved?

> Interface vs Abstract
* Why we use interface why not abstract class?
* What if we implement the same method in the interface and abstract.
* Difference between Abstract class and Interface.
* Why we use interface why not abstract class?
* What if we implement the same method in the interface and abstract.

> LLD
* [Singleton class](https://www.youtube.com/watch?v=SqDbZOjW1uM&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=15) 
```programming with explanation of each and every word on the program.```
* Design Elevator System


> Java 8 Concepts & Coding 
* [Collections](https://www.youtube.com/watch?v=NCx_ABybp2o&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=12)
* [Generics](https://www.youtube.com/watch?v=NCx_ABybp2o&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=12)

* MultiThreading - 
  * Read on CompletableFuture a) supplyAsync() b) thenReturn() c) exceptionally()

* Functional Programming
  * [Lambda Expressions](https://www.youtube.com/watch?v=YXRBBOjgrFU&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=17)
  * [Streams](https://www.youtube.com/watch?v=nEno48RpDR4&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=29)

> Memory Management in Java


Let's get some context only on the Table Of Contents 
[Refer Shreyansh Video](https://www.youtube.com/watch?v=vz6vSZRuS2M&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=10)

* Thread Dump analysis
* OOM analysis
* Questions on java memory handling, GC clean up
_____________________________________
1. Is Java Platform Independent if then how?
2. What are the top Java Features?
3. What is JVM?
4. What is JIT?
5. What are Memory storages available with JVM?
```
Say Employee Register is a class.
Class (Method) area : its getter and setter methods and the class level details
Stack :  Stores the output of the method to be returned 
Heap : Stores the details related to the object and the data structures
PC Register : stores the address of instructions to be executed  
Native Method Stack :  stores all the built in methods say for e.g., String / Getter / Setter methods

```
6. What is a classloader?

7. Difference between JVM, JRE, and JDK.

Let's compare **JVM**, **JRE**, and **JDK** to parts of a **coffee-making system**:

###### 1. JVM (Java Virtual Machine): The Coffee Drinker
- **Role**: The person who drinks the coffee (runs the program).
    - The JVM doesn’t make the coffee; it just consumes what is already prepared (compiled Java bytecode).
- **Key takeaway**: **JVM runs Java bytecode**, ensuring it's platform-independent.

---

###### 2. JRE (Java Runtime Environment): The Coffee Machine
- **Role**: The coffee machine that brews the coffee.
    - It includes everything needed to prepare the coffee (libraries, runtime), but not the beans or tools to grind them (development tools).
- **Key takeaway**: **JRE is for running Java applications** but doesn’t include tools for writing or compiling code.

---

###### 3. JDK (Java Development Kit): The Coffee Shop
- **Role**: The entire coffee shop!
    - It has the coffee machine (JRE), the coffee beans, grinders, and barista tools (compilers, debuggers, etc.) to brew and serve coffee.
- **Key takeaway**: **JDK is for developers**, providing everything needed to write, compile, and run Java applications.

---

###### Quick Analogy Recap
- **JVM**: The person drinking coffee (runs the Java bytecode).
- **JRE**: The coffee machine (provides the environment to brew and serve the coffee).
- **JDK**: The whole coffee shop (all the tools needed to create, brew, and serve the coffee).


8. Non-Primitive Data Type: Reference Data types will contain a memory address of the variable’s values because it is not able to directly store the values in the memory. Types of Non-Primitive are mentioned below:

   - Strings
   - Array
   - Class
   - Object
   - Interface

9. What is the Wrapper class in Java?
>Wrapper classes enable primitive data types to behave as objects.

10. Why do we need wrapper classes?

- Primitive data types cannot be used along with Collections framework. Wrapper classes enable the primitive types to be used as objects.
- Wrapper classes support null values unlike primitive data types
```
String str = "42";
int value = Integer.parseInt(str); // Converts String to int
System.out.println(value * 2); // Output: 84
```
- Wrapper classes provide useful methods for type conversion and parsing, making it easier to work with data.
```
String str = "42";
int value = Integer.parseInt(str); // Converts String to int
System.out.println(value * 2); // Output: 84
```

- Java automatically converts between primitives and their corresponding wrapper classes, simplifying the coding process.
```
Integer wrappedInt = 5; // Autoboxing: int to Integer
int primitiveInt = wrappedInt; // Unboxing: Integer to int

System.out.println(primitiveInt); // Output: 5
```

11. Why does Java allow only wrapper classes to be used in Collections framework?

ASK gpt 

12. What is covariant return type?

13. What is the transient keyword?

14. What are the differences between String and StringBuffer?
15. What are the differences between StringBuffer and StringBuilder?
16. Which among String or String Buffer should be preferred when there are a lot of updates required to be done in the data?
17. Why is StringBuffer called mutable?
18. How is the creation of a String using new() different from that of a literal?
19. What is the constructor?



____
**Abstract vs Interface**
Abstract is used when there's a common functionality to be implemented by a set of classes.
It is *extend*ed

Interface is used when there's a contract defined and multiple classes need to adhere to it.
It is *implement*ed

So there's a car which can be an interface (to define behaviour which will serve like a contract) and an abstract method.

