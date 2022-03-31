library(tidyverse)
library(lubridate)
library(broom) # used for unnest-ing column of lists to multiple columns

# The Data
df.starWars.base <- starwars
head(df.starWars.base)

# Current year
THIS_YEAR = lubridate::year(Sys.Date())

# Do some manipulation on the data set -----------------------------------------
df.starWars <- df.starWars.base %>%
  
  # Age of Character
  mutate(ageOfCharacter = THIS_YEAR - birth_year,
         
         # if Himan or not
         isHuman = if_else(species == 'Human', 1, 0)) %>%
  
  # Select only age, height, dhomeworld
  select(character = name,
         height,
         sex,
         homeworld,
         species)

# Group by character and name --------------------------------------------------
df.starWarsFilms <- df.starWars.base %>% 
  select(name, films)


# Get a list data frame of the film names that each character has been in ------
films <- df.starWarsFilms %>% 
  
  # Convert from a column of lists to multiple columns
  unnest_wider(films) %>%
  
  # Pivot into a single column and only keep films that an actor was in
  pivot_longer(cols      = starts_with('...'),
               names_to  = 'DELETE_ME',
               values_to = 'filmName') %>%
  drop_na() %>%
  select(-DELETE_ME)


# Join the films back to the actor
df.starWarsWithFilms <- df.starWars %>%
  left_join(films,
            by = c('character' = 'name')) %>%
  
  # Rearrange cols
  select(filmName,
         character, 
         height,
         sex,
         homeworld,
         species)
  


  

