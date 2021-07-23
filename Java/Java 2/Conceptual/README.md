# Exam 1 Review

## Chapter 7 - Objects and Classes

### Definitions

|Term               | Definition                            | Example                       |
|-------------------|---------------------------------------|-------------------------------|
|**Overloading**    | Overloading is having two class constructors with the same name, but different arguments | - `public class Class (int argument)` *overloads* `public class Class()`|
|**Override**       | method that has the same name, parameters, and return type as a base class's method ||
|**Protected**      | Access in the same package, but not anyone else||
|**Reference**      | `Variable` that references an object      | `ArrayList<Class> objectArray = new ArrayList<Class>` |
|**Wrapper Class**  | `Class` *`reference`* that is a built into java. | E.g. Character, Integer, Double, Bolean, Long |
|**Packages**       | Grouping o classes, interfaces, types, etc. | `java.lang`, `.util`, `.io` `...` |


### Packages
|Package Name       |When to throw/include                  |
|-------------------|---------------------------------------|
|||

***

## I/O Streams

### Reading Files 

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public void readFile(String filename) throws IOException
{
    // Create Storage List
        ArrayList<String> container = new ArrayList<String>();

    // Create reader
        BufferedReader reader = new BufferedReader(new FileReader(filename));

    // Read first line of .txt file
        String line = reader.readLine();

    // Read lines until meets last line of .txt file (null)
        while (line != null)
        {
            container.add(line);
            line = reader.readLine();
        }

    // Close Reader
        reader.close();
}
```

### Writing Files

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

private Object whatever;

public void writeFile(String filename) throws IOException
{
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

    writer.write(this.toString());
    writer.close();
}
```


### Exceptions

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

***
## Links 

### Formatting
* [Link to formatting](https://learn.zybooks.com/zybook/OUCS2334JabrzemskiFall2020/chapter/9/section/2?content_resource_id=42397796)
* [DecimalFormat Class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/DecimalFormat.html)

### Parsing
* [Parse int from input](https://github.com/Daniel-Carpenter/CS-2334/blob/master/02%20-%20Homework/Zyante%207/src/StringInputStream.java)
* [Join input together and output](https://github.com/Daniel-Carpenter/CS-2334/blob/master/02%20-%20Homework/Zyante%207/src/StringStreamOutput.javax`)