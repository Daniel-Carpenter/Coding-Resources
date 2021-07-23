## Exceptions

### Basics
* `Exceptions` handle errors

### `try`, `throw`, and `catch` exceptions

```java
try {
   ...
   // If error detected
      throw objectOfExceptionType;
   ...
}
catch (exceptionType excptObj) {
   // Handle exception, e.g., print message
}
finally {
   // Clean up resources, e.g., close file
}
```

* `try` - like IFERROR(`try` , `catch`)
* `throw`
	+ If reached `throw` in `try` block, then go to end of try blocl
	+ Similar to break in `for loops`

***

### Checked vs. Unchecked Exceptions
* **Checked Exception**: exception that a programmer should be able to anticipate and appropriately handle
* **Unchecked Exceptions**: errors from logic that are not anticipated

#### Common Checked Exceptions:

| Unchecked exception | Notes |
|:-:|:-:|
| NullPointerException | Indicates a null reference. |
| IndexOutOfBoundsException | Indicates that an index (e.g., an index for an array) is outside the appropriate range. |
| ArithmeticException | Indicates the occurrence of an exceptional arithmetic condition (e.g., integer division by zero). |
| IOError | Indicates the failure of an I/O operation. |
| ClassCastException | Indicates an invalid attempt to cast an object to type of which the object is not an instance (e.g., casting a Double to a String). |
| IllegalArgumentException | Thrown by a method to indicate an illegal or inappropriate argument. |


***

### Handle Multiple Errors
`catch(Throwable thrwObj)`: catch-all handler for any error or exception derived from the Throwable class;