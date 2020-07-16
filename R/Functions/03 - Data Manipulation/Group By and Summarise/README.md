
### `group_by` and `summarise`
```r
library(tidyverse)

df <- df %>%
	# Grouping
		group_by(department) %>%
	
	# Aggregation
		summarise(wages = sum(Wages),
				hours = sum(Hours))
```

### `summarise` Aggregation
	`n()` - number of observations
	`n_distinct(var)` - number of unique values of var
	`sum(var)`, `max(var)`, `min(var)`,
	`mean(var)`, `median(var)`, `sd(var)`, `IQR(var)`
