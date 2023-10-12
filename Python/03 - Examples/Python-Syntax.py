# -*- coding: utf-8 -*-
"""
@goal:   Intro Python Syntax Tutorial
@date:   Thu Oct 12 09:20:05 2023
@author: Daniel Carpenter
@resources: Most examples below have examples here: https://www.w3schools.com/python/default.asp
"""

# Key Points
# (1/4)     Use objects or functionsas much as possible to minimize code and reduce error potential
# (2/3)     Python has basic operations to perform calculations
# (5)       Python can iterate over object(s) contents like lists for while, for, or combination of either
# (Other)   Use camelCase for object naming




# =============================================================================
# (1) Object Assignment/Creation
#   Resource: https://www.w3schools.com/python/python_variables.asp
#   Resource: https://www.w3schools.com/python/python_datatypes.asp
# =============================================================================

## (1.1) Single-Valued Variables
firstVar  = 100
secondVar = 200

## (1.2) *Multiple* Single-Valued Variables
thirdVar, fourthVar = 300, 400

## (1.3) Lists
listOfNames = ['Cayman', 'Daniel', 'Sonaxy', 'Matt', 'Julie']

name1, name2, name3, name4, name5 = listOfNames



# =============================================================================
# (2) Basic Arithmetic Operations
#   Resource: https://www.w3schools.com/python/python_operators.asp
# =============================================================================

## (2.1) Single-Valued Variables (PEMDAS)
10 - 10 # Subtraction
10 + 10 # Addition
10 / 10 # Division
10 * 10 # Multiplication
10 ** 2 # Exponent
(5 + 5) ** 2 # Parenthesis

firstVar - secondVar # I recommend using variables for operations, not static values like above.


## (2.3) Lists
listOfNumbers = [100, 200, 300, 400] # Create a list
listOfNumbers + listOfNumbers + listOfNames # combine lists
# If we wanted to change the data inside the list, numPy would be easier to do


## (2.4) Scaler Variables (Boolean [True/False])
100 == 101
100 == 100
100 != 101
100 >= 101
100 <= 101
100 <  101



# =============================================================================
# (3) if/else/elif <- elif when there are more than 2 criteria
#   Resource: https://www.w3schools.com/python/python_conditions.asp
# =============================================================================

## (3.1) Basic if / else / else if

# Create two path lengths and a final destination TBD
path1 = 100
path2 = 200
finalPath = None

# Choose the shortest path
if path1 < path2:
    finalPath = path1
else:
    finalPath = path2

print('Final Path:', finalPath) # display the chosen path



## (3.2) Multiple Conditions with simple if

# Variables for multiple conditions
x = 150
lowerBound = 100 # upper bound of range
upperBound = 200 # lower ""

# 
if lowerBound < x and x < upperBound: # there are others like and, or not, is not
    print('x is in range')

else:
    print('x is NOT in range')
    


# =============================================================================
# (4) Functions
#   Resource: https://www.w3schools.com/python/python_functions.asp
# =============================================================================

## (4.1) Print Function
var1 = 50
var2 = 100

# The function
# (var1 * var2) ** var2

# Bad way to do it
# (50 * 100) ** 100
# (60 * 800) ** 800


## (4.2) Function that Returns Something
def modelCalculationFunction(var1, var2):
    output = var1 * var2
    
    print('function output:', output)

modelCalculationFunction(var1=1, var2=5)
modelCalculationFunction(10, 10)



# =============================================================================
# (5) Loops
#   Resource: https://www.w3schools.com/python/python_while_loops.asp
#   Resource: https://www.w3schools.com/python/python_for_loops.asp
# =============================================================================

## (5.1) While
i = 1
stopAtNum = 10

while i <= stopAtNum:
    print(i)
    
    i += 1 # this the common mistake with while loops


## (5.2) For Loop
for eachName in listOfNames:
    print(eachName)
    
for i in range(0, 100):
    print(i)

## (5.3) *Nested* For Loop <- research that for another time.



# =============================================================================
# (6) Appendix (further reading)
# =============================================================================

# Data Types
# Tuple: https://www.w3schools.com/python/python_tuples.asp
# Sets: https://www.w3schools.com/python/python_sets.asp
# Dictionaries: https://www.w3schools.com/python/python_dictionaries.asp
# How to convert data types: https://www.w3schools.com/python/python_casting.asp

