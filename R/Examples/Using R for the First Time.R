# Here is an example of using R for First time!

 
# Overview of R Functions ===================================================
  
  # 1. Add packages to your library 
  # (note there are cheatsheets for each below on google)
    library(tidyverse)
    library(dplyr)     # You don't really need to add this. It is already in tidyverse, but just to be explicit for a learning excercise
    library(readxl)    # read_excel function
    library(skimr)     # skim function to see summary stats of a data frame (df)
    library(lubridate) # makes working with dates easy. Use the cheatsheat online.


  # 2. Read in file 
    df.base <- read_excel("R/Examples/data.xlsx")

    
  # 3. Print Summary stats about the file's columns  
    skim(df.base)    # stats of a data frame with histogram
    summary(df.base) # this function is an alternative
    
    
  # 4. Create a variable and then filter on the variable
    df.new <- df.base %>%
      
      # Create the variable (column) that contains the year of the date field
        mutate(yearNum = year(monthOfDate)) %>% # mutate = create
      
      # Filter Dataset between the year 1970 AND 1980
        filter(  yearNum >= 1970 
               & yearNum <  1980)
    
  # 5. Alter data using `dplyr` using select, rename, and group by
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
  
  # 6. Pivot the data frame into fewer columns (useful for filtering dashboard filtering)
    df.new.pivotedLonger <- df.new %>%
      
    # Pivot the all of the numeric columns into single column
    # Pivot the names of the numeric into single column
      pivot_longer(cols      = driversKilled:numKilledInVan,
                   names_to  = "attributes",
                   values_to = "values")  %>%
    
    # Example of multiplying two columns together
      mutate(seasonality = 1.05,
             adjValues   = values * seasonality)
    
    # Pivot Wider (should be the same as the original dataset)
      df.new.pivotedWider <- df.new.pivotedLonger %>%
        
        # Pivot single attribute and values columns into separate columns
          pivot_wider(names_from  = "attributes",
                      values_from = c("values", 
                                      "adjValues")) %>%
      
        # Keep only adjusted values
          select(-starts_with("values"))
          
          
  # 7. Join parts of another dataset to our dataset
      
      # Read in a CSV file
        df.lawInEffectRaw <- read_csv(file = "R/Examples/lawInEffect.csv") %>%
    
        # Change the monthOfDate column in new file to date format
        # Need to change the type of the date to DATE or else it won't join
          mutate(monthOfDate = mdy(monthOfDate))
        
      df.lawInEffect <- df.base %>%
            
        # Join the law new dataset to the base (or the left)
          left_join(df.lawInEffectRaw,
                    by = c("monthOfDate" = "monthOfDate"))
        
        
  # 8. Create a basic visual
      
    # 8.1 - Basic scatter plot with R's Base plotting 
      plot(x = df.new$totalDistanceInKM,
           y = df.new$driversKilled)
      
      
    # 8.2 - More advanced/customizable plotting in ggplot
      
      # Define the dataset
        ggplot(data = df.new,
               aes(x = totalDistanceInKM,
                   y = driversKilled)) +
        
      # The type of graph and the variables
        geom_point(aes(color = monthOfDate)) +
        
      # Linear regression line
        geom_smooth(method = "lm") +
        # geom_quantile()
        
      # Add theme
        theme_minimal() +
          
      # Title of the chart
        labs(title = "Scatter Plot of Death")
        
      # Save the last plot
        ggsave(filename = "Scatter Plot.pdf",
               path     = "R/Examples",
               plot = last_plot(),
               height = 8.5,
               width  = 11)
        
        
    # 8.3 - One more Plot example of coloring
        
      # Get rid of this variable because irrelevant in analysis
      df.new.pivotedLonger <- df.new.pivotedLonger %>%
        filter(attributes != "totalDistanceInKM")
        
      # Define the data
        ggplot(data = df.new.pivotedLonger) +
          
      # Scatter
        geom_point(aes(x = monthOfDate,
                       y = values,
                       color = attributes))
          
      
  # 9. Output data to a CSV file (while sorting/present)
    write.csv(df.lawInEffect,
              file = "R/Examples/Output Data.csv")

# Extras =====================================================
  # For Loops
  
