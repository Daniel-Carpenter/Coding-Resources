# Using `glue` and For Loops

```r
for (i in 1:10)
{
    df <- df %>%
    mutate("prefix_{i}" := i * 100)
}
```
