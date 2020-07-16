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
