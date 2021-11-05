
# Loop Functions - Alternatives to `for`

## `for` Techniques

### Most Common Version
```r
START_INDEX = 1
END_INDEX   = 10

# Reads as: for every indexNum from the start index to the end index
for (indexNum in START_INDEX : END_INDEX) 
{
  # Print the Index
  print(paste('Index Number: ', indexNum))
}
```


### Alternative Version
```r
for (i in seq_along(df)) {
    ...
}
```

## `Apply` loops

* [Below from the following resource](https://swcarpentry.github.io/r-novice-inflammation/15-supp-loops-in-depth/)

`for` or `apply`?

A `for` loop is used to apply the same function calls to a collection of objects. R has a family of functions, the apply family, which can be used in much the same way.
|Function|Description|
|-|-|
|`apply`|apply over the margins of an array (e.g. the rows or columns of a matrix)|
|**`sapply`**|return vector - dataframe will apply to *each COLUMN*|
|**`mapply`**|apply function to *multiple* vectors|
|`lapply`|return list - dataframe will apply to *each COLUMN*|
|`vapply`|similar to sapply but you specify the type of object returned by the iterations|

### `apply`

* [apply funtion to df](https://faculty.nps.edu/sebuttre/home/R/apply.html)

#### Example of `apply` with `max` function

> Input

```r
library(tidyverse)

df <- mtcars %>% select(vs, am)

# Use `which()` to get column indeces to `apply` function to
  begCol <- which(colnames(df) == "vs")
  endCol <- which(colnames(df) == "am")

# Define loop to be by rows
  BY_ROWS = 1

# Add col that takes max of rows from beg to end columns
  df <- df %>%
    mutate(maxOf_vs_am = apply(X      = df[ , begCol:endCol],
                               MARGIN = BY_ROWS,
                               FUN    = max))
  
head(df)
```

> Output (notice new max col)

```txt
> head(df)

  vs am maxOf_vs_am
1  0  1           1
2  0  1           1
3  1  1           1
4  1  0           1
5  0  0           0
6  1  0           1
```

***

### Other funtions

* [using `lapply`... etc](https://www.youtube.com/watch?v=34sbvhr_pm8)
