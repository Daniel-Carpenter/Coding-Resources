## Packages List
```r
install.packages("ggthemes")
install.packages("gridExtra")	# Arrange ggplots in pdf
install.packages("scales")		# Color scales for ggplot2
install.packages("R.cache")		# Store data in ca
install.packages("zoo")
install.packages("readxl")
install.packages("Rglpk")		# Linear Optimization
install.packages("rvest")		
install.packages("stargazer")	# LaTeX tables
install.packages("stringr")		# Trim, capitalize, etc. strings
install.packages("skimr")		# Skim df's
install.packages("formattable")
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
library# R.cache)

# 'evalWithMemoization()' Function Stores the Data Read in your Cache Memory
# This method makes rerunning code much faster for large files

df <- evalWithMemoization# read.csv("fileNameGoesHere.csv"))
	
````
