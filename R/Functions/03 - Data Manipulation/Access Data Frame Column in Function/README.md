Access Data Frame Column in Function
================
Daniel Carpenter

-   <a href="#dynamic-columns-with-numeric-data"
    id="toc-dynamic-columns-with-numeric-data">Dynamic Columns with Numeric
    Data</a>
-   <a href="#dynamic-columns-with-categorical-data"
    id="toc-dynamic-columns-with-categorical-data">Dynamic Columns with
    Categorical data</a>

## Dynamic Columns with Numeric Data

``` r
library(dplyr)
```


    Attaching package: 'dplyr'

    The following objects are masked from 'package:stats':

        filter, lag

    The following objects are masked from 'package:base':

        intersect, setdiff, setequal, union

``` r
data(starwars)
head(starwars)
```

    # A tibble: 6 x 14
      name         height  mass hair_~1 skin_~2 eye_c~3 birth~4 sex   gender homew~5
      <chr>         <int> <dbl> <chr>   <chr>   <chr>     <dbl> <chr> <chr>  <chr>  
    1 Luke Skywal~    172    77 blond   fair    blue       19   male  mascu~ Tatooi~
    2 C-3PO           167    75 <NA>    gold    yellow    112   none  mascu~ Tatooi~
    3 R2-D2            96    32 <NA>    white,~ red        33   none  mascu~ Naboo  
    4 Darth Vader     202   136 none    white   yellow     41.9 male  mascu~ Tatooi~
    5 Leia Organa     150    49 brown   light   brown      19   fema~ femin~ Aldera~
    6 Owen Lars       178   120 brown,~ light   blue       52   male  mascu~ Tatooi~
    # ... with 4 more variables: species <chr>, films <list>, vehicles <list>,
    #   starships <list>, and abbreviated variable names 1: hair_color,
    #   2: skin_color, 3: eye_color, 4: birth_year, 5: homeworld

``` r
# Function that uses a dataframe and column with dplyr
sumByColumn <- function(df, valueCol) {
  
  df %>%
    group_by(species) %>%
    summarize(totalValue = sum( {{valueCol}} )) # uses a column in df, based on function
}

# Call function 
sumByColumn(df       = starwars,  # The data
            valueCol = mass )     # THe value columns
```

    # A tibble: 38 x 2
       species   totalValue
       <chr>          <dbl>
     1 Aleena            15
     2 Besalisk         102
     3 Cerean            82
     4 Chagrian          NA
     5 Clawdite          55
     6 Droid             NA
     7 Dug               40
     8 Ewok              20
     9 Geonosian         80
    10 Gungan            NA
    # ... with 28 more rows

## Dynamic Columns with Categorical data

``` r
# Function that uses a dataframe and column with dplyr
sumByColumn <- function(df, categoricalCol) {
  
  df %>%
    # uses a column in df, based on function
    group_by( {{categoricalCol}} ) %>%
    summarize(totalValue = sum( mass )) # note static
}

# Call function 
sumByColumn(df             = starwars,  # The data
            categoricalCol = species )     # THe value columns
```

    # A tibble: 38 x 2
       species   totalValue
       <chr>          <dbl>
     1 Aleena            15
     2 Besalisk         102
     3 Cerean            82
     4 Chagrian          NA
     5 Clawdite          55
     6 Droid             NA
     7 Dug               40
     8 Ewok              20
     9 Geonosian         80
    10 Gungan            NA
    # ... with 28 more rows
