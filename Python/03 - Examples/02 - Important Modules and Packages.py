# example Python code for DSA/ISE 5113
# author: Charles Nicholson
#date: 4/7/2017

# purpose: This is one Python program in a short series of code meant as an introduction to the language
#         This code is heavily commented for educational purposes
#         modules and packages


# Modules in Python are simply Python files with the .py extension, which implement a set of functions. Modules are imported from other modules using the import command.
# Python comes with a library of standard modules which can be included to extend functionality

# copy and random are examples of standard modules that can be imported

import numpy as np
import copy
import random

# the module random allows you to generate pseudo-random numbers

# random.seed(12345)                  #set the seed
# print(random.randint(10, 100))      #generate a random integer between 10 and 100
# print(random.randint(10, 100))      #generate another random integer between 10 and 100

# see: https://docs.python.org/3/library/random.html?highlight=random#module-random for more information

# if however you do not want to import all the module's functionality,
# you can be more specific by using a variant of the import statement.
# For example:

from random import shuffle

shuffle([1, 3, 4, 56, 9])

# A package is a collection of modules in directories that give a package hierarchy
# e.g., NumPy is the fundamental package for scientific computing with Python -- this package offers a lot of great functionality, but must be installed (either throught tools like Anaconda or more manually)


# NumPy supports a much greater variety of numerical types than Python does: https://docs.scipy.org/doc/numpy/user/basics.types.html
# NumPy provides an N-dimensional array type and several functions on arrays

# now you can access NumPy's functionality, e.g.,:

print(np.identity(5))  # creates a 5x5 identity matrix

x = np.array([[1, 2], [3, 4]])  # create matrix

print(x)

y = np.linalg.inv(x)  # compute inverse of matrix

print(y)


# more on NumPy here: https://docs.scipy.org/doc/numpy/index.html
