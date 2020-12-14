# Data Types

## Types

|Type|Description|Central Tendancy Measure|Has Absolute Zero?|Example|
|-|-|-|-|-|
|Nominal (name) |  Characteristic; descriptive labels   |Mean|NA|Male or Female|
|Oridinal (ordererd)|  Ordered variables |Use median or mode, **not mean**   |NA|Happy, Neautral, or Sad   |
|Interval   |Space between twp vars |Can compute mean, median, mode, sd, etc.    |FALSE|time or temp   |
|Ratio      |Order and exact values |Mode, median, mean, sd, etc.|TRUE|Height, weight, duration   |

### `Factor`s

* Factor means categorical variable

### Get Data Types in Data Frame

> Input

```r
sapply(mtcars, class)
```

> Output

```txt
      mpg       cyl      disp        hp      drat        wt      qsec
"numeric" "numeric" "numeric" "numeric" "numeric" "numeric" "numeric"
```

## Data Tables

> Input

```r
# Create frequency table of rivers
table(mtcars$gear)

# Can also use colSums(tbl) to get column sums of a table, or rowSums
```

> Output

```txt
> table(mtcars$gear)

 3  4  5 
15 12  5 
```

## Plot Tables

> Input

```r
# store table
tab = table(mtcars$gear)

# make pie chart
pie(tab)

# Make barplot
barplot(tab)

# Make boxplot
with(mtcars, boxplot(mpg ~ gear))
# OR
tab2 = with(mtcars, table(mpg, gear))
barplot(tab2, beside = TRUE, col = rainbow(4))

# auto generate best plot
plot(mpg ~ gear,
     data = mtcars,
     main = "Gears effect on Miles per Gallon",
     xlab = "Gear",
     ylab = "Miles per Gallon")

# Scatter plot
with(mtcars, 
     plot(mpg ~ hp,
          cex = wt, # size
          col = cyl # Color
          pch = 22  # shape
          )
     )
```

### Subset plot

```r
# view cars wit hp over 50
plot(data = subset(mtcars,
                   hp > 50),
     mpg ~ hp)
```

### Plot Additions

```r
text()
mtext()
points()
axis()
lines()
arrows()
polygon()
```

#### `abline()` and best fit regression line

```r
# y and x vars
  x <- mtcars$hp
  y <- mtcars$mpg
  
# Plot output  
  plot(y ~ x)

# Best fit regression line
  abline(lm(y ~ x))
```
