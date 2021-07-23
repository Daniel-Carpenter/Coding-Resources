# Special Topic: Javadoc

## Motivation
* Example of professional Java documentation.
* The rest of our projects will be documented this way.

## Getting Started 
* Javadoc comments are multi-line comments with an extra asterisk (*) on the first line.
```java
/**
 *
 *
 */
```

## Overview
* Javadoc is required before every class, constructor, and method. Each block is separated into two parts: summary and tags.
* Summary - the first line of documentation should summarize the purpose of the method/class in a sentence. If the method is particularly complicated, it may need additional description on the next few lines, but this section should not be very long.
* An empty line should separate the summary from the tags.
* After the empty line any required tags should be listed, one on each line.

```java
/**
 * Summary
 *
 * Tags
 */
```

## Class-Level Tags
*The following two tags are required in any class-level Javadoc (this includes enums & interfaces).*
### @author
* Name of the person who originally authored the file. In this case, probably the reader.

### @version
*These guidelines are for our purposes. In industry, versioning will always be automatic.*
* Our version numbers will be two values separated by a period.
* The first digit should be either the lab # or the *preceding* project #. So if I am starting on lab 8 my first version number is 8.0, but if I'm starting on project 3 then my first version number is 2.1 (since I'm building on version 2.0).
* The second digit should be the current commit number for the repository (i.e. how many commits have been done on this assignment).
* Before each commit, take care to update the version of any files that were changed to the new commit number (this may result in commit # changing by more than one, which is expected).

## Method-Level Tags
*The following tags apply to constructors/methods only.*
### @param [paramName] [description]
* Describes the purpose of a parameter.
* May also describe conditions/constraints for the parameter (e.g. must be positive).
### @return [description]
* Describes the value being returned by the method.
* Not required for constructors.
* "The @return tag is required for every method that returns something other than void, even if it is redundant with the method description." Oracle, on the redundancy of the @return tag, which is itself known to be redundant.
### @throws [ExceptionType] [description]
* Explains how any possible exception(s) could be thrown out of this method.
* For our purposes, please only include @throws for exceptions that are explicitly stated in the method signature.
* In practice, this can also a warning for an unlisted exception that may occur. This can be common in enterprise systems with dozens of custom exceptions.


## Generating Javadoc (HTML Export)
* Actual Javadoc is viewable on a webpage, so it is possible to automatically export your comments to the webpage format.
* Note that this will be required to receive full credit for documentation.
### Instructions
1. Right-click on the project in the "Package Explorer"
2. Select the "Export.." option
3. Open the folder "Java" and select the option "Javadoc".
4. Under "Javadoc command", make sure that a full path to your JDK's Javadoc executable is listed.<br />
e.g. `C:\Program Files\Java\jdk1.8.0_251\bin\javadoc.exe`
5. In the window for project selection, make sure that only the project you want to export is selected.
6. Choose "Public" for member visibility.
7. The standard doclet destination should be the project directory + `\doc`.<br />Default for Windows users: `C:\Users\username\eclipse-workspace\ProjectName\doc`
8. Select "Finish"
9. If prompted to update the Javadoc location for the project, select "Yes To All".
10. Verify that your documentation was actually created by opening your project's doc folder. You should see two folders and many .html files, including one for each class and one called "index.html".
11. Open "index.html" to view the Javadoc.

## Miscellaneous Notes
* This isn't full Javadoc. For full specifications you can refer to [Oracle's website](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html).
* eclipse will do a lot of this work for you if you type the first line of Javadoc (/**) on an empty line before a method/class and press "enter".
### @deprecated 
* This indicates that a method is no longer being supported by its development team. Ideally, an alternate method is listed in the Javadoc as well.
* You will see this frequently when looking through any common Java libraries (e.g. Collections, the util package in general), but likely not one you will ever use.


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
 * @version 0.1
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