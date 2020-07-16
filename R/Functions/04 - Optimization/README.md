### `unique`
```r
unique(rownames(mtcars))
```

Yields unique categories in the variable, or in this case rows:

```
 [1] "Mazda RX4"           "Mazda RX4 Wag"       "Datsun 710"          "Hornet 4 Drive"      "Hornet Sportabout"   "Valiant"             "Duster 360"         
 [8] "Merc 240D"           "Merc 230"            "Merc 280"            "Merc 280C"           "Merc 450SE"          "Merc 450SL"          "Merc 450SLC"        
[15] "Cadillac Fleetwood"  "Lincoln Continental" "Chrysler Imperial"   "Fiat 128"            "Honda Civic"         "Toyota Corolla"      "Toyota Corona"      
[22] "Dodge Challenger"    "AMC Javelin"         "Camaro Z28"          "Pontiac Firebird"    "Fiat X1-9"           "Porsche 914-2"       "Lotus Europa"       
[29] "Ford Pantera L"      "Ferrari Dino"        "Maserati Bora"       "Volvo 142E"         
```

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


### `pivot_wider` ([source help](https://tidyr.tidyverse.org/reference/pivot_wider.html))
```r
    df    <- pivot_wider(df, 
                      names_from = stockName, 
                      values_from = stockReturn)
```

### `pivot_longer` ([source](https://tidyr.tidyverse.org/reference/pivot_longer.html))
```r
pivot_longer(
   cols = starts_with("wk"),
   names_to = "week",
   names_prefix = "wk",
   values_to = "rank",
   values_drop_na = TRUE)
```


### `replace` {base} ([source](https://www.rdocumentation.org/packages/base/versions/3.6.2/topics/replace))
```{r}
(df <- list(
  a = rbinom(20, 10, 0.5),
  b = "this element needs replacing"
))
replace(df, "old", "new")

```

## Other Useful Links / Notes

### `tidyverse`
* `tidyverse` [Cheat Sheet](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/R%20Cheat%20Sheet.pdf)
* `tidyverse` [In Depth Notes](https://raw.githack.com/uo-ec607/lectures/master/05-tidyverse/html_document/05-tidyverse.html#tidyverse_basics)
* `tidyr`'s [Tutorial](https://cran.r-project.org/web/packages/tidyr/vignettes/tidy-data.html) 


### `dplyr`
* `dplyr` [Cheat Sheet - Reshaping, Summarising, Grouping, etc.](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/dplyr%20Cheat%20Sheet.pdf)
* [Joining Tibbles and Dataframes Together](https://rpubs.com/williamsurles/293454) 
* [`MUTATE` plus `if_else()`](https://rstudio-pubs-static.s3.amazonaws.com/116317_e6922e81e72e4e3f83995485ce686c14.html#/5)

### Useful Packages
* `lubridate` [Cheat Sheet - Using and Altering **Dates**](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/Lubridate%20Cheat%20Sheet.pdf)

### Pulling in Data
* `readr` [Cheat Sheet - Importing Data](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/Importing%20Data%20Cheat%20Sheet.pdf)
* `R.cache` Package - In-Memory Data Loading [documentation here](https://cran.r-project.org/web/packages/R.cache/R.cache.pdf)

```r
library# R.cache)

# 'evalWithMemoization()' Function Stores the Data Read in your Cache Memory
# This method makes rerunning code much faster for large files

df <- evalWithMemoization# read.csv("fileNameGoesHere.csv"))
	
````
