## Abstract Classes and Interfaces

### Previously. . .
* `Classes` - object with data in it

* `Inheritance` -  extends a class

***

### Regulating code with `Absract classes` and `Interfaces`

* `Abstract class` - regulates subclasses
	+ `Triangle` subclass must include `computeArea()`, etc.
	+ Cannot be instantiated as an object, but is the superclass for a subclass and specifies how the subclass must be implemented. 
	+ Abstract class is denoted by the keyword abstract in front of the class definition.

* `Concrete class` is a class that is not abstract, and hence can be instantiated

***

* `Interface`
	+ Another regulation mexhanism
	+ Does not need the abstract keyword in front of the method signature.
	+ Example:
	```java
	import java.awt.Graphics2D;
	
	public interface Drawable 
	{
		public void draw(Graphics2D graphicsObject);
	}
	```
	+ **Reguirements of `interfaces`**:
		+ List the interface name after the keyword implements
		+ Override and implement the interface's abstract methods
	