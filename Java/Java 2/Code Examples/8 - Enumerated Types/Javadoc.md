# Special Topic: Javadoc

## Motivation
* Example of professional Java documentation.
* The rest of our projects will be documented this way.

## Generating a Template 
* Javadoc comments are a more structured form of a multi-line comment. To indicate that it is Javadoc, an extra asterisk (*) is added to the first line.
```java
/**
 *
 *
 */
```

## Generating Javadoc (HTML Export)
* Actual Javadoc is viewable on a webpage, so it is possible to automatically export your comments to the webpage format. Note that this will be required to receive full credit for documentation.
### Instructions
1. Right-click on the project in the "Package Explorer"
2. Select the "Export.." option
3. Open the folder "Java" and select the option "Javadoc".
4. Under "Javadoc command", make sure that a full path to your JDK's Javadoc executable is listed.<br />
e.g. `C:\Program Files\Java\jdk1.8.0_251\bin\javadoc.exe`
5. In the window for project selection, make sure that only the project you want to export is selected.
6. Choose "Private" for member visibility.
7. The standard doclet destination should be the project directory + `\doc`.<br />Default for Windows users: `C:\Users\username\eclipse-workspace\ProjectName\doc`
8. Select "Finish"
9. If prompted to update the Javadoc location for the project, select "Yes To All".
10. Verify that your documentation was actually created by opening your project's doc folder. You should see two folders and many .html files, including one for each class and one called "index.html".
11. Open "index.html" to view the Javadoc.

## Outline
* Summary - the first line of documentation should summarize the purpose of the method/class in a sentence. If the method is particularly complicated, you may need additional description on the next few lines, but this section should not be very long.
* An empty line should separate the summary from the tags.
* Any required tags should be listed, one on each line.

## Tag List (first 5 from [Oracle's official list](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html#orderoftags))
*Listed in expected order (i.e. @author is listed first, @exception is last)*
* @author (classes and interfaces only, required)
* @version (classes and interfaces only, required)
* @param (methods and constructors only)
* @return (methods only)
* @exception (@throws is a synonym added in Javadoc 1.2)

## Tag Descriptions
* Author Name - the name of the person who originally authored the file
* Version Number - the most recent release that this file was associated with. Newly modified code is more likely to have bugs, so this is very useful for bug tracing. For our course, version numbers should be `PROJECT#.COMMIT#`. Since we are starting with project 3, version numbers should start at `2.0` and increase after each commit (only the files being committed should have their version numbers increased)
* Parameter descriptions (*@param paramName description*) - show a brief description of each parameter for this method. It is worth noting that the data type is not included, although it can be mentioned if the data type is not clear.
* Return value description (*@return description*) - offers an explanation of the returned value. This is frequently redundant, and is addressed by Oracle as such: "The @return tag is required for every method that returns something other than void, even if it is redundant with the method description."
* Exception description (*@throws ExceptionType description*) - explains why an exception could happen. This may relate to a throws clause (i.e. *void f() throws E*), but could also be a warning for an unlisted exception that may occur.

## Notes
* eclipse will do most of this work for you if you type the first line and press "enter".
* intellisense is the menu that comes up from Ctrl+Space
### @deprecated 
* This is a tag you will see frequently if you browse any common Java libraries (e.g. Collections). This indicates that the method is no longer being supported by the Java development team. It has almost certainly been replaced by a different method, which will likely be listed in the Javadoc for this method.


## Reference
```java
/**
 * Synopsis
 *
 * @author Author Name
 * @version 0.1
 */
public class ClassName {

    /**
    * Summary sentence.
    * 
    * @param p1 describe parameter, include edge cases
    * @param p2 describe parameter, include edge cases
    * @return describe returned value. will likely be redundant
    * @throws UnlistedException warn why this could happen
    * @throws ExplicitException explain why this might happen
    */
    protected Type sampleMethod(Type p1, Type p2) throws ExplicitException {
        ...
        if(..){
            throw new UnlistedException();
        }
        ...
    }
}
```

## Example
```java
/**
 * Utility methods used for detection of duplicate values in arrays.
 * 
 * @author Cameron
 * @version 0.1.1
 */
public class DuplicateUtils<T> {
    /**
    * Finds and returns any duplicates found over a range of indices.
    * 
    * @param arr        Array to be searched. Must have length > 0.
    * @param startIdx   Index to start searching at. Must be a valid index for 
    *                   arr.
    * @param endIdx     Index to stop searching at. Must be >= startIdx and a 
    *                   valid index for arr.
    * @return Linked list containing any duplicate values found
    * @throws NullPointerException if arr is null
    */
    public LinkedList<T> findDuplicatesFromTo(T[] arr, int startIdx, int endIdx);
}
```