
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

```r
df %>% ungroup(x) #  remove x from the grouping variables
```


#### [Convert date to end of month by ](https://dplyr.tidyverse.org/reference/summarise_all.html)
```r
	# Add end of month
	mutate(END_OF_MONTH = ceiling_date(GAMING_DATE, 'month')) %>%

	# Group by end of month by removing gaming date and not grouping the numeric fields
	group_by(across(-c(GAMING_DATE, where(is.numeric)))) %>%

	# Sum up the numeric fields 
	summarise_if(is.numeric, sum, na.rm=TRUE)
```

### `summarise` Aggregation
	`n()` - number of observations
	`n_distinct(var)` - number of unique values of var
	`sum(var)`, `max(var)`, `min(var)`,
	`mean(var)`, `median(var)`, `sd(var)`, `IQR(var)`
