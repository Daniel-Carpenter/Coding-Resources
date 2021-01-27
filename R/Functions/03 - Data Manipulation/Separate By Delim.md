# Seperate by Delimiter


```r
df <- df %>%
    separate(col  = mergedCol, 
            into = c("newCol1", "newCol2"), 
            sep  = ",")
```
