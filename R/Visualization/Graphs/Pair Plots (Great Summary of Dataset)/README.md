Pair Plots
================
Daniel Carpenter  
April 2022

## Suggested Function: `ggpairs()`

``` r
library(GGally) # https://r-charts.com/correlation/ggpairs/

# Basic pairs plot with ggpairs
ggpairs(iris) + theme_minimal()
```

![](PairPlots_files/figure-gfm/ggpairs-1.png)<!-- -->

``` r
# Colored by qualitative Variable plot
ggpairs(iris,
        aes(color = Species,  # Color by group (cat. variable)
            alpha = 0.7)) + theme_minimal()
```

![](PairPlots_files/figure-gfm/ggpairs-2.png)<!-- -->

## Other Pair Plot Functions

``` r
# gpairs with distributions 
library(gpairs)
gpairs(iris)
```

![](PairPlots_files/figure-gfm/otherPairs-1.png)<!-- -->

``` r
# Base R Pairs 
pairs(mtcars)
```

![](PairPlots_files/figure-gfm/otherPairs-2.png)<!-- -->
