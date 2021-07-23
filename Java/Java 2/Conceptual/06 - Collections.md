# Collections (Ch. 15)

## Intro

### Data Structures vs. Abstract Classes

* `Data Structures` are a way to organize data, like an `Array` or `ArrayList`

### Defining a `Collection`

* Pile of unsorted objects
* Common provisions from `Collection`s
    + `add()`
    + `remove()`
    + `contains()`

### Collections Interface

* Know these: Deque, Queue, List Set

## 15.1 Enhanced For Loop using ArrayList

### Generally

```java
for (type var1 : list) {
}
```

### Example

Code:

```java
ArrayList<String> teamRoster = new ArrayList<String>();

// Adding player names
teamRoster.add("Mike");
teamRoster.add("Scottie");
teamRoster.add("Toni");

System.out.println("Current roster:");

for (String playerName : teamRoster) {
   System.out.println(playerName);
```

Output:

```txt
Current roster:
Mike
Toni
Scottie

```

## 15.2 `LinkedList`s

* Same funtionality as an `ArrayList<T>`, but has `hasNext()` and `hasPrevious` functionality for easy `while` loops.

```java
LinkedList<String> authorsList = new LinkedList<String>();  
String authorName;

// Create LinkedList
    ListIterator<String> listIterator;

// Add Elements
    authorsList.add("Gamow");  
    authorsList.add("Greene");  
    authorsList.add("Penrose");

// Create List Iterator
    listIterator = authorsList.listIterator();

// Has Next Example
    while (listIterator.hasNext()) {
    authorName = listIterator.next();
    System.out.println(authorName);  
    }
```

## 15.3 Map: `HashMap`

### Declaration

```java
// Generally
    HashMap<inputType, outputType> hashMap = new HashMap<inputType, outputType>()

// -----------------------------------------------------------------

// Practically - Declation
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>()
```

### Adding and getting elements (based on first type value)

```java
// Add Elements
    hashMap.put("string1", 1234);
    hashMap.put("string2", 5678);

// Retrieve based on First Type (String Value)
    System.out.println(hashMap.get(string1));
```

Output:

```txt
1234
```

### Common `HashMap` Methods

```java
put(key, value);
putIfAbsent(key, value);    // if absent,then add
containsKey(key);           // first type
containsValue(value);       // second type
clear();                    // removes everything
keySet();                   // returns all keys in list
values();                   // returns all values
```

## 15.4 Set: `HashSet`

* Used to tell user if there if `element` exists in list when adding/removing
* Commonly returns `true` or `false` if not in the `Set`

### Common `HashSet` Methods

* `boolean`: add(`element`)     // adds and returns true if in the list
* `boolean`: remove(`element`)  // removes and returns true if in list
* `boolean`: contains(`element`) // true if in list, false if not 

## 15.5 `Queue` interface

* List function that throws exception if attemtped removal but bothinf there

```java
Queue<String> waitList = new LinkedList<String>();

waitList.add("Neumann party of 1");
waitList.add("Amdahl party of 2");
waitList.add("Flynn party of 4");

System.out.println("Serving: " + waitList.remove());
System.out.println("Serving: " + waitList.remove());
System.out.println("Serving: " + waitList.remove());
```

```txt
Serving: Neumann party of 1
Serving: Amdahl party of 2
Serving: Flynn party of 4
```

## 15.6 Deque interface

### Declaration

```java
Deque<Type> deque = new LinkedList<Type>();
```

* Has common methods like `getFirst()` and `getLast()`
