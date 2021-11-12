# Comments here - Example of using R for First time!

# Overview ===================================================
  
  # 1. Library
    library(tidyverse)
    library(dplyr) # dont need to say this because it is in tidyverse above
    library(readxl) # read_excel function
    library(skimr) # skim function to see summary stats of a data frame (df)
    library(lubridate)

  # 2. Read in file
    suppressWarnings(df.base <- read_excel("data.xlsx"))

  # 3. Summary stats about the file's columns  
    # skim(df.base)
    # summary(df) # this is an alternative
    
  # 4. Filter data, if statements, basic operators, etc. as
    df.new <- df.base %>%
      
      # Create the variable (column) that is only the year
        mutate(yearNum = year(monthOfDate)) %>% # mutate = create
      
      # Filter Dataset greater than 1970
        filter(  yearNum >= 1970 
               & yearNum <  1980)
    
  # 5. Alter data (select, mutate, group by, pivot?)
    df.new <- df.new %>%
      
      # Drop the variable gasPrice
        select(-gasPrice) %>%
      
      # Rename distDrivenKM to totalDistanceInKM
        rename(totalDistanceInKM = distDrivenKM)
        
        # Check column names (as a double check)
          names(df.new)
          head(df.new)
          
      # Create a separate table grouped by year
          df.yearlySummary <- df.new %>%
            
            # Group by year
              group_by(yearNum) %>%
            
            # Aggregate numeric variables (using sum and mean in this case, can use others)
              summarise(driversKilled       = sum(driversKilled),
                        frontSeat           = sum(frontSeat),
                        backSeat            = sum(backSeat),
                        numKilledInVan      = sum(numKilledInVan),
                        avgDistanceInKM     = mean(totalDistanceInKM)) # use average
      
      
  # 6. Join on another dataset
  # 7. Create a basic visual
  # 9. Output data to file (sort/present)

# Extras =====================================================
  # For Loops
  
