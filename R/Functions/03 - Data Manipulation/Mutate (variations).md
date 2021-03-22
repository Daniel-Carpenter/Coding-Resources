## `Mutate`

### Conditition Manipulation `mutate_if`, `mutate_at`, `mutate_all`

#### Example of replacing NA values for certain columns

```r
library(tidyverse)

# by column type:
x %>%
  mutate_if(is.numeric, ~replace_na(., 0))

# selected columns - defined in vars(col1, col2, ...):
x %>%
  mutate_at(vars(a, b, c), ~replace_na(., 0))

# all columns:
x %>%
  mutate_all(~replace_na(., 0))
  ```