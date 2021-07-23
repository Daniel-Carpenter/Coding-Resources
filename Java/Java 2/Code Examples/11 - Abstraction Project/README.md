# Project 2: Abstraction

## Condensed Final Ouput for stID `NRMN`
```txt
The Index of the city is in the Mesonet: 77
This index is average of NOWA and OILT, NEWP and OKCE, and so on.

Ascii Ceiling is 79
Ascii Floor is 78
Ascii Average is 79

Letter Avg: O

Total number of stations starting with the letter 'O' is 4.
These stations are: OILT OKCE OKEM OKMU
```


## Class Descriptions

### `DateTimeInherit.java`
* Inherit abstract class/methods
* Output described in the `Driver.java` file:
```txt
// Output format: for (4, 2020):
In the year 2020, for the 4th month: the first day is WEDNESDAY and the last day is THURSDAY		
```

***
### `PosAvg.java`
* Calculate the position/elemtn/index of the stID 
* Output as follows:

### posAvg
```java
String stID = "NRMN";
		
PosAvg posAvg = new PosAvg(stID);
System.out.println("The Index of the city is in the Mesonet: " + posAvg.indexOfStation());
System.out.println(posAvg);
System.out.print("\n");
```

```txt
The Index of the city is in the Mesonet: 77
This index is average of NOWA and OILT, NEWP and OKCE, and so on.

// Notes
    // 77 is the avg of 76(NOWA) and 78(OILT).
    // 77 is the avg of 75(NEWP) and 79(OKCE).

    // Only show two stations groupings.
    // Assume that we will not enter the first two stations or last two stations as input
```
### Ascii
```java
System.out.println("Ascii Ceiling is " + mesoInherit.calAverage()[0]);
System.out.println("Ascii Floor is "   + mesoInherit.calAverage()[1]);
System.out.println("Ascii Average is " + mesoInherit.calAverage()[2]);
System.out.print("\n");

System.out.println("Letter Avg: " + mesoInherit.letterAverage());
System.out.print("\n");

LetterAvg letterAvg = new LetterAvg(mesoInherit.letterAverage());
```

```txt
Ascii Ceiling is 79
Ascii Floor is 78
Ascii Average is 79

Letter Avg: O

Total number of stations starting with the letter 'O' is 4.
These stations are: OILT OKCE OKEM OKMU


// Retrieve the ASCII value for N R M and N which are 78, 82, 77, and 78. 
// Summmation of values = 315. 
// Dividing 315 by 4 = 78.75

// Ceil of 78.75 = first part: Ascii Ceiling is 79
// Floor = second part: Ascii Floor is 78

// third part, for this project we are considering, if the fraction is less than 0.75, the Average would be floor of the value. Otherwise, if the fraction part is greater than or equal to 0.75, the Average would be ceiling of the value. In this case, we are getting the average as 79 since the average is 78.75 (here 0.75 is greater or equal to 0.75).
For the fourth part, the letter value of the average which is 79 (ceiling of 78.75), which is equivalent to letter ‘O’. [It is not ‘zero’, rather the first letter of Oklahoma]*/
```

### Last Output
```java
System.out.println("Total number of stations starting with the letter '" + mesoInherit.letterAverage() + "' is " + letterAvg.numberOfStationWithLetterAvg() + ".");

System.out.print(letterAvg);
```

```txt
Total number of stations starting with the letter 'O' is 4.
/*In the station list, number of stations starting with ‘O’ is 4.*/

These stations are: OILT OKCE OKEM OKMU
/*Finally, here is the list of those four stations.*/
```