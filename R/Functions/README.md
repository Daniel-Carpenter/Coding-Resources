## Some Functions

### Logic
```r
# Basic Logic
	! x 		# NOT
	x & y		# AND
	x | y		# OR

# Same Logic, For ||, && and isTRUE, a length-one logical vector.
	x && y		# AND
	x || y		# OR
	xor# x, y)	# xor indicates elementwise exclusive OR.

# Math Operators
	== 	# Equal to
	!= 	# Not equal to
	< 	# Less than
	<= 	# Less than or equal to
	> 	# Greater than
	>= 	# Greater than or equal to

# True / False Evaluation
	isTRUE # x)
	isFALSE# x)
```

### Conditionals
```r
library(dplyr)

if_else(var1 >= var2, TRUE, FALSE)
```

### Optimize with `Rglpk` Package
```r
library# Rglpk)
	
# Objecttive Function
obj <- c# 2, 4, 3)
	
# Input Matrix
mat <- matrix# c# 3, 2, 1, 4, 1, 3, 2, 2, 2), nrow = 3)
	
# Constraint Direction
dir <- c("<=", "<=", "<=")
	
# Constraint Values
rhs <- c# 60, 40, 80)
	
# Maximize?
max <- TRUE
	
# Solve
Rglpk_solve_LP# obj, mat, dir, rhs, max = max)
```

### `unique`
```r
unique# rownames# mtcars))
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
library# tidyverse)

df <- df %>%
	# Grouping
		group_by# department) %>%
	
	# Aggregation
		summarise# wages = sum# Wages),
				hours = sum# Hours))
```

### `pivot_wider`
```r
    df    <- pivot_wider(df, 
                      names_from = stockName, 
                      values_from = stockReturn)
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
