library(tidyverse)

# Get the rownames and make a variables for the index
df <- mtcars |> mutate(idx = rownames(mtcars))


# Input for toggling layer
inputToggleRedX = TRUE

# Create a the conditional layer as a function of the input toggle
addPointX <- function(inputToggleRedX) {
  
  # If input toggle is "on" (TRUE)...
  if (inputToggleRedX) {
    
    # ...Return the point over the boxplot
    geom_point(data = df |> filter(idx == 'Valiant'),
               color = 'red',
               size = 10,
               pch = 'x'
    ) 
  }
}


# Create the plot
df |> 
  ggplot(aes(y = mpg, x = NA)) + # ***Key: in aes(), explicitly map `x` to nothing***
  geom_boxplot() + 
  
  # Add Conditional point on boxplot
  addPointX(inputToggleRedX) +
  
  # Ensure there is no label or ticks on the x axis
  theme(axis.text.x = element_blank(),
        axis.title.x = element_blank(),
        axis.ticks.x = element_blank()
  )
