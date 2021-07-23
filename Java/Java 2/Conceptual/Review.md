# Exam 1 Review

## Coverage

|Assn|Topic|Status|
|-|-|-|
|Lab 6|Inheritance|Good|
|Lab 7|Abstract and Interfaces|Check interfaces|
|Lab 8|Collections|Review Lecture|
|Project 2|Abstraction|Good|
|Project 3|HashMap|Good|

***

## `Git` and `.cmd`

### Create Java Project

```cmd
git init
```

## Code

### Binary Search

```txt
Less than 0         -> less than
Greater than 0      -> Greater than
Equal to than 0     -> equal to
```

### Collections Interface

* Know these: Deque, Queue, List Set
* Make a cheat sheet that has abstract lists
    + AbstractSet
    + ArraySet
    + ArrayList
    + Hashmap
    + LinkedList
    + TreeSet
    + Vetor?
    + Stack
        + First in last out
    + Sets
        + Abstract
        + 

### What list to use

* If you do not need to change the size, then `ArrayList`
* If you need to change at beginning and end, then `LinkedList`

### `enum`

```java
public enum DeptTeam
{
	PETTY_VILLIAN("Petty Villian"),
	PROTAGONIST("Protagonist"),
	MAIN_BOSS("Main Boss"),
	SILLY_COMPANION("Silly Companion");
	
	
	private String symbol;
	private DeptTeam(String symbol) {
		this.symbol = symbol;
	}	
	
	public String toString() {
		return symbol;
	}
}
```

### `abstract`

#### Abstract Class

```java
public abstract class EmployeeAbstract {
	public abstract void setBaseSalary(int salary);
	public abstract void setStatus(EmployeeStatus status);
}
```

#### The Actual Class

```java
public class Employee extends EmployeeAbstract {

    public Employee() {
        // constructs
    }

	@Override
    public abstract void setBaseSalary(int salary) {
        // FIXME
    }

	@Override
	public abstract void setStatus(EmployeeStatus status) {
        // FIXME
    }
}
```
