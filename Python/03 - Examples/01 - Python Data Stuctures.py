# example Python code for DSA/ISE 5113
# author: Charles Nicholson
#date: 4/7/2017

# purpose: This is one Python program in a short series of code meant as an introduction to the language
#         This code is heavily commented for educational purposes
#         Lists, Tuples, Sets, Dictionaries


# I recommend running this code in DEBUG mode and stepping through the code one line at a time.
# If you are using Wing IDE on Windows, you can create a "breakpoint" at a line of code by pressing F9 (or clicking by the line number at left)
# You can then run in DEBUG mode, by pressing F5 or clicking on the "bug" icon at top
# You can step through each line one-at-a-time by pressing F6

# CREATING AND USING LISTS -----------------
print('\nCREATING AND USING LISTS -------------------------------------------\n')

# list are defined using brackets; they can contain various data types
myList = ['ISE', 5113, 'is', 'a', 'wonderful', 'course!', 3.1415]

# list are accessed via the "slicing" operator; indices being with 0
print(myList[1])

# list are mutable
myList[4] = "difficult, but nonetheless wonderful"

print(myList, '\n')

# the "in" membership operator is useful for lists
print('is' in myList, '\n')

# you can iterate through lists -- here we can use a for-loop and the "in" membership operator
for j in myList:
    print(j)

print()


# be careful about "copying lists" --------------------

yourList = myList  # here, "yourList" and "myList" are names bound to the same object -- they are not independent copies of the same thing!

myList[6] = 'I like pie'

print(myList)
# since "yourList" is bound to the same object as "myList", the change is reflected here too!
print(yourList, '\n')

# to make a copy of the object, use can either the "list" function or the slicing operator

anotherList = list(myList)

myList[6] = 'I really do not like pie!'

print(myList)
print(anotherList)  # here "anotherList" is not bound to the same object as "myList"

print()


# you can also do this with the "slicing operator"

anotherList = myList[:]

myList[6] = 'Actually, I prefer cake, except on March 14.'

print(myList)
print(anotherList)  # here "anotherList" is not bound to the same object as "myList"

print()

# there are a lot functions that are useful for working with lists --------------------

print(len(myList))  # length of list

myList.append(3.1415)  # we can append elements to a list
myList.insert(7, ' I love')  # and insert items

print(myList)
print()

myList.reverse()  # reverse the order of the elements in the list
print(myList)
print()

# pop([i]): removes the item at the given position i in the list, and returns it. If no index is specified, .pop() removes and returns the last item in the list.

print("Length of myList before 'popping off items: ", len(myList), '\n')

for i in range(6):  # range is a built-in Python function that returns an immutable sequence of numbers; commonly used for looping a specific number of times in for loops
    print(myList.pop())

print("\nLength of myList after 'popping off items: ", len(myList))

print(myList)
print()

# finally, lists can be composed of lists.

myList.append(anotherList)
myList.insert(2, [1, 2, 3, 4, 5])

print(myList)
print(myList[2])
print()

# access the elements of one of the lists within the list
myList[2][3] = 'four'
myList[4].reverse()

myList[4][len(myList[4])-1] = 'DSA'  # and you can nest statements too...

print(myList)
print()


# TUPLES --------------------------------------
print('\nCREATING AND USING TUPLES -------------------------------------------\n')

# tuples are similar to lists, but they are defined using parentheses and they are NOT mutable

myTuple = (1, 3, 7, 'yay numbers!')
print(myTuple)
print(myTuple[3])

# we can include a tuple in our lists

myList.append(myTuple)

print(myList)


# SETS--------------------------------------
print('\nCREATING AND USING SETS -------------------------------------------\n')

# Sets are defined using brackets; and they are mutable; but all elements in a set are unique, so they automatically eliminate duplicates

mySet = {'things', 'things', 'more things', 1, 2, 3,
         4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 'things'}
print('mySet = ', mySet)

# Sets are unordered, so you cannot use the slicing operator

# print (mySet[4])     #this will not work

anotherSet = {"more things", 4, 5, 6, 7, 8, 9}
print('anotherSet = ', anotherSet)

# operations like union, intersection, difference, etc. are possible with sets
newSet = mySet.union(anotherSet)
print('mySet.union(anotherSet) = ', newSet)

anotherNewSet = mySet.intersection(anotherSet)
print('mySet.intersection(anotherSet) = ', anotherNewSet)
print()


# DICTIONARIES--------------------------------------
print('\nCREATING AND USING DICTIONARIES -------------------------------------------\n')


# dictionaries are unorderd set of key:value pairs
# the keys must be unique

# create a dictionary of state to abbreviation
states = {
    'Colorado': 'CO',
    'Oklahoma': 'OK',
    'California': 'CA',
    'New York': 'NY',
    'Texas': 'TX'
}

# create a dictionary of states and to capitals in them
capitals = {
    'CA': 'Sacramento',
    'TX': 'Austin',
    'OK': 'Oklahoma City'
}

# add some more capitals
capitals['NY'] = 'Albany'
capitals['CO'] = 'Denver'

print("NY State has: ", capitals['NY'])
print("CO State has: ", capitals['CO'])


# and you could use them together:
print("Captial of Texas is: ", capitals[states['Texas']])

print()

# When looping through dictionaries, the key and corresponding value can be retrieved at the same time using the .items() method

for abbrev, city in capitals.items():
    print("The capital of", abbrev, "is", city)
