#### **Single Responsibility** 
>A class should have only one reason to change 

Example : to be added
___
#### **Open Closed** 
>A class should be open for extension and closed for modification 

Example : to be added
___
#### **Liskov Substitution** 
>1) If Class B is a subtype of class A, then the object of class B should replace the object of class A. 
>2) A subclass should add to the capabilities of the class and not trim it down 

Example : to be added

____

#### **Interface Segregation**
> Interfaces should be such that client shouldnot implement unnecessary functions which they dont need! 

Example : to be added

___
#### **Dependency Inversion Principle** 
> Class should depend on interfaces rather than concrete classes! 

E.g., :- 
>Not Following Dependency Injection Principle 
```java

class Macbook {
	public WiredMouse mouse;
	public WiredKeyboard keyboard;
	Macbook(WiredMouse mouse, WiredKeyboard keyboard) {
		this.mouse = mouse;
		this.keyboard = keyboard;	
	}
}
```

>Problems 
- [ ] The dependent classes in Macbook i.e., WiredMouse and WiredKeyboard are CONCRETE classes. So in future if we try to support Wireless peripherals (keyboard and mouse). We'll have to change the dependency in the class.

- [ ] Tight Coupling since Macbook class relies on the concrete class

>Following Dependency Injection Principle

```java
interface Keyboard {
	void connect() ;
}

class WiredKeyboard implements Keyboard {
	void connect() {
		log.info("Supports wired connection");
	}
}

class WirelessKeyboard implements Keyboard {
	void connect() {
		log.info("Supports wireless connection");
	}
}


interface Mouse {
	void connect() ;
}

class WiredMouse implements Mouse {
	void connect() {
		log.info("Supports wired connection");
	}
}

class WirelessMouse implements Mouse {
	void connect() {
		log.info("Supports wireless connection");
	}
}


class Macbook {
	public Mouse mouse;
	public Keyboard keyboard;
	Macbook(Mouse mouse, Keyboard keyboard) {
		this.mouse = mouse;
		this.keyboard = keyboard;	
	}
}
```

Over here, if we want to support **"wireless"** connections later. We just havee to pass the dependencies correctly inside this class.

___

**Advantages of following SOLID principles** 
Helps us write better code 
- [ ] Avoid duplicate code 
- [ ] Easy to maintain 
- [ ] Easy to understand 
- [ ] Reduce complexity 
