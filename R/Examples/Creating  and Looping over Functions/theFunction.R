
library(tidyverse)


# SIMPLE FUNCTION - DISPLAY ONLY ------------------------------------------
  
  # First, make a function that is dependant on x
  sqRootFunction <- function(x) {
    
    # Calculate the output
    output = x^2
    
    return(output)
  }
  
  # Call the function for an example
  sqRootFunction(8)
  
  # If I called this 10 times, then what is the output
  
  xValues <- 1:10 #c(1, 2, 3, ..., 10)
  
  # Iterate over the function from 1 to 10
  for (x in 1:length(xValues)) {
    print(sqRootFunction(x))
  }
  
# STORE THE VALUES OF THE FUNCTION OUTPUT --------------------------------------

# Create a data frame
df <- c()
  
# Loop over the values of X 10 times, but this time store in df
  
  # Iterate over the function from 1 to 10
  for (x in 1:length(xValues)) {
    df <- rbind(df, sqRootFunction(x))
  }
  
  # Print it, show that it looks the same as above
  df

  

forecast <- function(SOURCE_PROP) {
  # Function here
  ifelse(SOURCE_PROP == 'RS', 1, 0)
}


  