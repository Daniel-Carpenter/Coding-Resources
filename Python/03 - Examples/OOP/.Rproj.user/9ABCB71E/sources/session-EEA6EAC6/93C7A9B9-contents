# -*- coding: utf-8 -*-
"""
MyMath Class that does very basic math. 
Goal is to create objected oriented class
"""

class MyMath:
    
    # Initialize the variables
    def __init__(self, num1, num2):
        self.num1           = num1
        self.num2           = num2
        self.multipiedValue = None
        self.addedValue     = None
        self.outputStr      = None

    # Add method
    def add(self):
        self.addedValue = self.num1 + self.num2
        return self.addedValue
        
    # Multiplication method
    def multiply(self):
        self.multipiedValue = self.num1 * self.num2
        return self.multipiedValue
        
    # Print/display method
    def __str__(self):
        
        output  = 'Values:\t\t\t[' + str(self.num1) + ', ' + str(self.num2) + '] \n'
        output += 'Multiplication:\t' + str(self.multiply()) + '\n' 
        output += 'Addition:\t\t' + str(self.add()) + '\n'

        self.outputStr = output
        
        return self.outputStr
        
