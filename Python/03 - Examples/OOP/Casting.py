# -*- coding: utf-8 -*-
"""
Goal: try/cast implementation
"""

class Casting:
  
  def __init__(self, num1):
    self.num1 = num1
    
    
  def castAsInt(self):
      if type(self.num1) == int:
          print('\nType already int')

      else:      
        try:
          self.num1 = int(self.num1)
          print('\nSuccessful Cast')
          
        except:
          raise ValueError('Cannot cast as int. Supplied Value:', self.num1)
          
      return self.num1
      
      
  def __str__(self):
    return str(self.castAsInt())
      
  
