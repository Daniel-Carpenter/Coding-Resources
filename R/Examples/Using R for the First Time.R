# Comments here - Example of using R for First time!

# Overview ===================================================
  
  # 1. Library
    library(tidyverse)
    library(readxl) # read_excel function
    library(skimr) # skim function to see summary stats of a data frame (df)

  # 2. Read in file
    suppressWarnings(df <- read_excel("data.xlsx"))

  # 3. Summary stats about the file's columns  
    skim(df)
    # summary(df) # this is an alternative
    
  # 4. Filter data, if statements, basic operators, etc. as
  # 5. Alter data (select, mutate, group by, pivot?)
  # 6. Join on another dataset
  # 7. Create a basic visual
  # 9. Output data to file (sort/present)

# Extras =====================================================
  # For Loops
  
