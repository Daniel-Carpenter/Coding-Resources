# -*- coding: utf-8 -*-
"""
Created on Mon Dec 12 11:34:59 2022

@author: Daniel.Carpenter
"""

import statsmodels.api as sm # mtcars
import numpy as np
import pandas as pd
import seaborn as sns


# Pull in mtcars data
mtcars = sm.datasets.get_rdataset("mtcars", "datasets", cache=True).data

# mpg to filter on
mpgThreshold = 22 

# Get the average mpg per number of gears
avgMPG = (mtcars.rename(columns = {'wt':'weight',
                                   'mpg':'avgMPG'})
                
                # Filter to set MPG Threshold
                .query('avgMPG >= @mpgThreshold')
                
                # Group by gear and get the average per group
                .groupby('gear')
                .agg({'avgMPG':'mean'})
          )

print(avgMPG.head(), '\n')

# Left join the avg mpg per gear group
mtcars = (mtcars.merge(avgMPG,
                      how = 'left',
                      on = 'gear')
          
                # Change to catgorical variable for plotting (non-continuous)
                .astype({'cyl':'category'})
                )

# Only print the mpg, gear, and avgMPG per gear
print(mtcars.loc[:, ['mpg', 'gear', 'avgMPG']].head())



# PLOTS =======================================================================

# Color palettes
scale_color_dbc = ['#6388B4', '#E68900', '#EB4B43', '#54AC88', '#B07AA1', 
                   '#3C9DAA', '#C5A952', '#8A807E', '#D16D91', '#945430' ]
                   
scale_fill_dbc  = ['#BECDE0', '#FFD597', '#F6B7B4', '#BEE0D2', '#E4C6DC', 
                   '#BDDBE1', '#F7E5B3', '#DCDADA', '#FCC8DA', '#E5CFC5' ]

sns.set_palette(scale_color_dbc)

# Create the plot
myPlot = ( 
    
    # Plot defaults
    sns.scatterplot(data = mtcars,
                x     = 'wt',
                y     = 'mpg',
                hue   = 'cyl',
                style = 'cyl',
                s     = 150, # size
                alpha = 0.95
                )
    
    # Labels
    .set(xlabel  = 'Weight (Tons)',
           ylabel  = "Miles per Gallon (MPG)",
           title   = 'Simple Seaborn Graph with MPG'
           )
)


