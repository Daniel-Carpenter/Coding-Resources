# Lab 7: A Hierarchy of Shapes

In this lab, we will practice writing derived classes by implementing the hierarchy shown in the following diagram:

![UML diagram](./uml.svg)

Note that this hierarchy includes abstract classes, concrete classes, and interfaces.
To identify each of these elements, recall the following UML notation:

* A solid line with a white arrow indicates inheritance.
The class touching the line extends the class touching the arrowhead.
Note: Since in several cases the parent and child are on the same level, "<< extends >>" is added to prevent confusion. There is no other meaning to it.
(See Section 10.1 of our textbook for details.)

* A solid line with an outline arrow indicates association (one-to-one aggregation).

* An arrow with a dashed line indicates that a class implements an interface.
(See Section 11.4.)

* Italicised words indicate abstract methods and classes.
(See Section 11.2.)

Below is some additional information about the program.

### Shape

* `Shape()`: The Shape constructor assigns the current value of `nextID` to `id` and then increments `nextID`.
This ensures that every Shape object has a unique ID number.

* `getType()`: This is an abstract method, which means that only the declaration appears in the Shape class.
Override the method in each concrete subclass so that it returns the class name corresponding to an object.

* `compareTo(Shape other)`: Compare this Shape with the given Shape to determine their relative order in a list.
Compare the Shapes first by type, then by perimeter, and then by area.
The Shape with the smaller value should appear first.
(For instance, if two Shapes are both Squares, the one with the smaller perimeter appears first.)
See the [Comparable interface API documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) for information on the appropriate return values.

### Circle

* `Circle(double radius)`: If the radius is negative, the constructor throws an IllegalArgumentException.

* `getType()`: Returns the String `"Circle"`.

### Polygon

* `Polygon(double[] sideLengths)`: The constructor is given an array with the length of each side of the Polygon. 
If any length is negative, the constructor throws an IllegalArgumentException.

### Triangle

* `checkLengths(double a, double b, double c)`: If the arguments do not satisfy the [triangle inequality](https://en.wikipedia.org/wiki/Triangle_inequality), throw an IllegalArgumentException.
Otherwise, return the values in an array.
Use this method when calling the parent constructor.
(Recall that `super` must appear on the first line of the child constructor.)

### ShapeIDComparator

* This class implements the [Comparator interface](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html).
Comparator objects can be used by methods like those in the [Collections class](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html) to define alternative orderings for objects.
The sort method, for instance, has two versions: one that takes only a List and one that takes a List and a Comparator.
The first method sorts objects in the List using their compareTo method, which defines the default ordering.
The second method sorts the objects using the compare method of the Comparator.
Write the compare method of this class so that it sorts Shapes by their ID number.

### Trapezoid

* `Trapezoid(double[] sideLengths)`: Initialize an object that represents an [isosceles trapezoid](https://en.wikipedia.org/wiki/Isosceles_trapezoid).
The input `sideLengths` should be an array of 4 doubles that contains the lengths of the top side, bottom side, left leg, and right leg (in this order).

  An isosceles trapezoid can be drawn as a rectangle and two right triangles, as shown in the figure below.

  ![isosceles trapezoid](https://mathworld.wolfram.com/images/eps-gif/IsoscelesTrapezoid_900.gif)

  After validating the side lengths, the constructor creates a Rectangle object and a RightTriangle object with these dimensions.

* `validateTrap(double[] sideLengths)`: Ensure that the side lengths form an isosceles trapezoid in the orientation shown above.
If the lengths are valid, return the input array.
Otherwise, throw an InvalidArgumentException.
(Note: Some definitions of an isosceles trapezoid include rectangles and squares as special cases.
For this assignment, we will use the exclusive definition, which does *not* include these shapes.)
