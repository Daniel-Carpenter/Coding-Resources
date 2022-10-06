library(tidyverse)
library(cols4all)


lineCol <- c(
  'blue'   = '#4E79A7', 'red'    = '#E15759', 
  'green'  = '#59A14F', 'purple' = '#B07AA1', 
  'orange' = '#F1800F', 'blue1'  = '#499894', 
  'yellow' = '#D8B23E', 'grey'   = '#79706E',
  'pink'   = '#D37295', 'tan'    = '#9D7660'
  )

fillCol <- c(
  'blue'   = '#A0CBE8', 'red'    = '#FF9D9A',
  'green'  = '#8CD17D', 'purple' = '#D4A6C8',
  'orange' = '#FFBE7D', 'blue1'  = '#86BCB6',
  'yellow' = '#F4DB92', 'grey'   = '#BFB8B7',
  'pink'   = '#FABFD2', 'tan'    = '#D7B5A6'
  )

fillColLowContrast <- c(
  'blue'   = '#B8D8EE', 'red'    = '#FFBFBD',
  'green'  = '#B8E3AF', 'purple' = '#E4C6DC',
  'orange' = '#FFCB97', 'blue1'  = '#BFDBD8',
  'yellow' = '#F6E1A4', 'grey'   = '#D9D5D5',
  'pink'   = '#FBC9DA', 'tan'    = '#EBD9D1'
)


numColors = length(lineCol)
valuesPerColor = 250

# To set up the graph
numValues = numColors * valuesPerColor
X <- sort(rep(1:numColors, valuesPerColor))
Y <- rnorm(n = numValues, mean = 1000, sd = 100)

df <- data.frame(X = as.factor(X),
                 Y = Y)

df %>%
  ggplot(aes(X,Y, color=X, fill = X)) +
  # geom_jitter(size = 2, width = 0.25) +
  geom_boxplot(size = 0.75) +
  theme_minimal() +
  scale_color_manual(values = lineCol) +
  scale_fill_manual( values = fillCol) 


# Plotly
# library(plotly)
# ggplotly(last_plot())
