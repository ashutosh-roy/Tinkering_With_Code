Decorator helps prevent something known as class explosion.

>This is a behavioral pattern

[Read more theory on Refactoring.guru](https://refactoring.guru/design-patterns/behavioral-patterns)
[Refer Code Base](src/main/java/com/hobbyprojects/tinkeringwithcode/designPatterns/decorator)

**Class Explosion**
```
Imagine there's a PIZZA 
Say there's a basePizza abstract class
Let's create 

* Class CheeseBasePizza - which adds cheese as toppings to BasePizza
* Class MushroomCheeseBasePizza - which adds cheese + Musas toppings to BasePizza
* Class JalapenosCheeseBasePizza - which adds cheese + jalapenos toppings to BasePizza

Now for every new topping that is introduced, all different types of combination is possible with already existing combination. For, e.g., in above example, we can also have simply Mushroom or simply Jalapenos pizza.
```

Now if we use a decorator pattern, 

- [ ] we can avoid the class explosion
- [ ] By using decorator, we create a is-a relation (inheritance) and a has-a relation (aggregation - since here toppings can exist without pizza and vice versa) with the parent class

If we look at this below diag, 
```
M : Margherita is a type of base pizza
EC : Extra Cheese Topping which is a Decorator which "has-a" Margherita object
MU : Mushroom Topping which is a Decorator which "has-a" Margherita object

So we can create a pizza with all these toppings! 
```


![[Pasted image 20241228091143.png]]