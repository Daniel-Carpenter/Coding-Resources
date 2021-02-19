
# Loop Functions - Alternatives to `for`

## `for` Techniques

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

df <- mtcars

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

   mpg cyl disp  hp drat    wt  qsec vs am gear carb maxOf_vs_am
1 21.0   6  160 110 3.90 2.620 16.46  0  1    4    4           1
2 21.0   6  160 110 3.90 2.875 17.02  0  1    4    4           1
3 22.8   4  108  93 3.85 2.320 18.61  1  1    4    1           1
4 21.4   6  258 110 3.08 3.215 19.44  1  0    3    1           1
5 18.7   8  360 175 3.15 3.440 17.02  0  0    3    2           0
6 18.1   6  225 105 2.76 3.460 20.22  1  0    3    1           1
```

***

### Other funtions

* [using `lapply`... etc](https://www.youtube.com/watch?v=34sbvhr_pm8)
