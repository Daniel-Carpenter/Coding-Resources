# -*- coding: utf-8 -*-
"""
Basic class that shows how to:
    1. inherit from another class
    2. Update a method from the inherited class
"""

from MyMath import * # class inherited from

class MyAnalyticalMath(MyMath):
    # Inherit the class MyMath
    pass 
    
    # Crete new initializer while keeping the old one
    def __init__(self, num1, num2, 
                 footerText = 'You can insert a footer here. This is the default'):
        
        # Inherit the parent function - only do this if you want to alter the contents. 
        super().__init__(num1, num2)
        
        self.footerText = footerText
    

    # Create new exponent method
    def exponent(self):
        
        return self.num1 ** self.num2
        
    
    # Print/display method
    def __str__(self):
        
        # Inherit the parent function - only do this if you want to alter the contents. 
        # Note you do not put self in the params
        super().__str__()
        
        self.outputStr += 'Exponent:\t\t' + str(self.exponent()) + '\n\n---\n' + self.footerText

        return self.outputStr