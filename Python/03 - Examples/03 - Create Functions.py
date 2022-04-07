# example Python code for DSA/ISE 5113
# author: Charles Nicholson
#date: 4/7/2017

# purpose: This is one Python program in a short series of code meant as an introduction to the language
#         This code is heavily commented for educational purposes
#         user-defined functions

# Function blocks begin with the keyword "def" followed by the function name and parentheses.
# Any input parameters or arguments should be placed within these parentheses.
# The code block within a function starts with a colon (:) and is indented.
# The statement return [expression] exits a function, optionally passing back an expression to the caller. A return statement with no arguments is the same as return None.


# often times you may organize your Python code into different files, or at least such that the functions are all defined in one place (e.g., at beginning of code)
# here however, I am just giving several examples one after the other --

# now for the examples
# some examples from:
#  https://www.tutorialspoint.com/python/python_functions.htm
#  http://anh.cs.luc.edu/python/hands-on/3.1/handsonHtml/functions.html


import math  # we need the math module for some more functionality -- here for the sqrt function and the exp function


def printme(str):
    "This prints a passed string into this function"
    print(str)
    return


# Now you can call printme function
printme("I'm first call to user defined function!")
printme("Again second call to the same function")

print()

# another example


def happyBirthday(person):
    print("Happy Birthday to you!")
    print("Happy Birthday to you!")
    print("Happy Birthday, dear " + person + ".")
    print("Happy Birthday to you!")


def main():
    userName = input("Enter the Birthday person's name: ")
    happyBirthday(userName)
    print()


main()


# another example

def sumProblem(x, y):
    sum = x + y
    sentence = 'The sum of {} and {} is {}.'.format(x, y, sum)
    print(sentence)


sumProblem(5, 4)
print()

# another example


def f(x):
    return x*x


print(f(12))
print()

# another example

# you can also return more than one value, e.g., in a list


def evaluateMe(x, y):

    value1 = 0
    value2 = -9

    # some conditional logic for you...
    if x < y:
        value1 = -abs(x)
    else:
        value1 = math.sqrt(abs(x))

    if x > 3*y:
        value2 = value1 * 5
    else:
        value2 = math.exp(value2)

    return [value1, value2]


print(evaluateMe(25, 6))
print(evaluateMe(6, 25))

print()

# maybe you just want to access the first element of the returned list:
print(evaluateMe(25, 6)[0])

# or maybe you just want to access the second element of the returned list:
print(evaluateMe(25, 6)[1])

# or maybe you want to create a new list as a copy of the results and continue working with it..
newList = evaluateMe(25, 6)[:]

newList.reverse()
newList.append('Wow!')
print(newList)
print()

# another nice thing you can do with Python is multiple assignments as follows

# here the a is set equal to the first returned element of evaluateMe; b is set equal to the second returned value of evaluateMe
a, b = evaluateMe(6, 25)

print(a)
print(b)
