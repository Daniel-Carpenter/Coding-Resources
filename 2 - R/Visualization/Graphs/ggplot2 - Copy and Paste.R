library(tidyverse)
library(ggthemes)

ggplot(
  # Date Frame
        data = ,
        
  # X and Y Variables
        aes(
           x = ,
           y = ,
    color = )) +
  
  # Graph Type
    geom_point() +
  
  # Theme
    theme_minimal() +
  
  # Labels
    labs(title = "",
         subtitle = "",
         caption = "",
         tag = "Figure 1",
         x = "",
         y = "")
  
  # Save Image
    ggsave("imageTitle.pdf", path = "", width = 10, height = 7)