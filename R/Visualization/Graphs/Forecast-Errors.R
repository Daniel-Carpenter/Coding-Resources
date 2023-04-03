library(dplyr)
library(ggplot2)
library(ggdist)
library(distributional)
library(scales)

theme_set(theme_ggdist())

tibble(
  x = as.factor(2021:2025),
  sd = seq(0.05, 1)
) %>%
  ggplot(aes(x = x, ydist = dist_normal(rep(0, 5), sd))) +
  stat_dotsinterval(quantiles = 40, alpha = 0.5) +
  
  geom_hline(yintercept = 0) +
  scale_y_continuous(labels = percent, limits = c(-0.25, 0.25) ) +
  
  labs(title = 'Forecast Error over the last 5 Years of Forecast Periods',
       subtitle = 'Each dot represents a project',
       y = 'Forecast Error',
       x = 'Year and Project',
       caption = '\nBelow 0% means that the project was less than anticipated. > 0 means more than anticipated.') +
  
  annotate('text', x = as.factor(2021), y = 0.15, label = 'Max dot: Newcastle JV', hjust = 0) +
  annotate('text', x = as.factor(2023), y = -0.15, label = 'Min dot: Riverwind Remodel', hjust = 0)+
  annotate('text', x = as.factor(2025), y = 0.15, label = 'Max dot: Project #3', hjust = 0)

