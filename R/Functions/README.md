## Packages List
```r
# Core Packages
install.packages("tidyverse")   # Most known package in R. Use for most functions. You will see "dplyr" some places, this packages has dplyr. Use it as much as possible
install.packages("readxl")      # Read in excel file - function: readxl(pathOfFileHere)
install.packages("skimr")		# Quick stats of a table - function: skim(tableNameHere)
install.packages("stringr")		# Trim, capitalize, etc. strings

# Visuals 
install.packages("ggthemes")    # Themes for package called ggplot (create visuals)
install.packages("gridExtra")	# Arrange ggplots in pdf
install.packages("scales")	# Color scales for ggplot2
install.packages("formattable")

# Data Manipulation
install.packages("R.cache")	# Store data in ca
install.packages("zoo")         # some general useful functions

# Optimization
install.packages("Rglpk")	# Linear Optimization

# LaTEX
install.packages("rvest")		
install.packages("stargazer")	# LaTeX tables

# Finance
install.packages("BatchGetSymbols")	# Stock pull overtime
install.packages("quantmod")		# Money market pull with many parameters
```

## Other Useful Links / Notes

### `tidyverse`
* `tidyverse` [In Depth Notes](https://raw.githack.com/uo-ec607/lectures/master/05-tidyverse/html_document/05-tidyverse.html#tidyverse_basics)
* `tidyr`'s [Tutorial](https://cran.r-project.org/web/packages/tidyr/vignettes/tidy-data.html) 


### `dplyr`
* [Joining Tibbles and Dataframes Together](https://rpubs.com/williamsurles/293454) 
* [`MUTATE` plus `if_else()`](https://rstudio-pubs-static.s3.amazonaws.com/116317_e6922e81e72e4e3f83995485ce686c14.html#/5)

### Pulling in Data
* `R.cache` Package - In-Memory Data Loading [documentation here](https://cran.r-project.org/web/packages/R.cache/R.cache.pdf)

```r
library(R.cache)

# 'evalWithMemoization()' Function Stores the Data Read in your Cache Memory
# This method makes rerunning code much faster for large files

df <- evalWithMemoization(read.csv("fileNameGoesHere.csv"))
	
````

### `lubridate`
* [Helpful Date calculations reference](https://bookdown.org/Tazinho/Tidyverse-Cookbook/dates-and-times.html) 
