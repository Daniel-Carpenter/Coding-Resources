library(tidyverse)
library(styles.cmac)

# Fill and text color
transparencyLevel = 0.7
fillColor         = alpha(styles.cmac::scale_cmac('text'), transparencyLevel)
textColor         = 'white'

mtcars |> 
  ggplot(aes(x = wt, y = mpg)) +
  
  # The label with colors above
  geom_label(aes(label = mpg),
             fill  = fillColor,
             color = textColor) +
  
  styles.cmac::theme_cmac()
    