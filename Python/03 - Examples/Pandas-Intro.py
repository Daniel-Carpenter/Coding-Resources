# -*- coding: utf-8 -*-
"""
@goal:   Intro Python's Pandas Library using 

@date:   Tue Oct 17 09:26:25 2023
@author: Daniel Carpenter

@resources: 
    Spyder Proj: https://docs.spyder-ide.org/current/panes/projects.html
    Data prep: https://www.mit.edu/~amidi/teaching/data-science-tools/study-guide/data-manipulation-with-python/
    Visuals:   https://www.mit.edu/~amidi/teaching/data-science-tools/study-guide/data-visualization-with-python/
    Seaborn:   https://seaborn.pydata.org/generated/seaborn.boxplot.html
    Pandas:    https://pandas.pydata.org/docs/reference/frame.html
"""

import pandas as pd # import the pandas library


# =============================================================================
# (1) Import Data
# =============================================================================

## Read CSV File
df_base = pd.read_csv('Data/Life_Expectency.csv')

## Look at the data (summary stats/viewer)
# df_base.describe()



# =============================================================================
# (2) Prepare Data (common prep: mutating, selecting, filtering, summarizing, pivoting, sorting, etc.)
# =============================================================================

## Remove Uneccessary Variables
df = df_base.drop(columns = ['SourceName', 'DateAccessed'])

## Reorganize data into few columns
numericColumns = df.select_dtypes(include=['number']).columns
numericColumns = numericColumns[1:]

df = df.melt(
    
    id_vars    = df.columns[:2], # Which data do I keep?
    value_vars = numericColumns, # Which columns to put into single values columns (unpivoted)?
             
    # Put the data into two columns
    value_name = 'lifeExpectency',
    var_name   = 'country'
    )


## Rename Variables
df = df.rename(columns={'Period': 'yearNum', 
                        'Dim1':   'gender'
                        })

## Filter data to "Both Sexes"
df = df.query("gender == 'Both sexes'")

## Create a new calculated variable based on a self made function
def calcRelativeValue(nominalValue):
    relativeValue = nominalValue / max(nominalValue) # Create a relative value (relative to the max value in the column of the data frame)
    
    return relativeValue 

df['relativeValue'] = calcRelativeValue(df['lifeExpectency'])

## Might be good to know: Joining two datasets together:
# https://pandas.pydata.org/docs/reference/api/pandas.DataFrame.merge.html
    