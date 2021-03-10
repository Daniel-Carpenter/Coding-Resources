library(tidyverse)
library(glue)

# Create Dataset --------------------------------------------------------------
  numElements <- 525820
  minVal <- 1
  maxVal <- 100 
  numCols = 4
  BY_ROWS = 1
  
  df <- c()
  
  # 
  for (i in 1:numCols)
  {
    df <- cbind(df, floor(runif(numElements,
                                min = minVal, 
                                max = maxVal)))  
  }

  df <- as.data.frame(df)
  
# Get max: Apply version ------------------------------------------------------
  system.time(
              df <- df %>%
                mutate(maxOfVectors = apply(X      = df[, 1:numCols],
                                            MARGIN = BY_ROWS,
                                            FUN    = max))
              )
  
# Get Max: for method ---------------------------------------------------------
  
  system.time(
              for (i in 1:numElements)
              {
                df$maxWithFor[i] <- max(df[i, 1:ncol(df)])
              }
              )
              
  