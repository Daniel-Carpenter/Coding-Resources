# Calculations

## Coercion - Sumifs

```r
v = 1:20
sum(2 == v)
```

output

```txt
[1] 1
```

## Roots of Quadratic Function

```r
rootsOfQuadratic <- function(a, b, c) 
{
# Plus or Minus 1
    pm = c(-1, 1)

output <- (-b + pm * sqrt(b^2 - 4 * a * c)) / (2 * a)

return(output)
}

roots <- rootsOfQuadratic(a, b, c)
```

### Confidence Interval

```r
confidenceInterval <- function(mean, sigma)
{
    # Plus or minus 1
    pm <- c(-1, 1)
    
    ci = mean + pm * 1.96 * sigma / 2
    
    return(ci)
}

ci <- confidenceInterval(3, 1.3)
```
