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