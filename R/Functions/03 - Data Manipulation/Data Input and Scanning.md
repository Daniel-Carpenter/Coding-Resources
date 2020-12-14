# Data Input

## Reading Data

### Double '\\' When Reading in Data

* Use '\\' when reading in data or else it will look for things like '\n'

### Reading Data from Console

```r
# Read data and store in x
x <- scan()

# press enter without any numbers to stop
```

### Reading Data from working Directory (not on Git)

```r
# Set Working Directory
setwd("c:\\temp\\")

# Store data from working directory
data <- read.table(yield.txt",header=T)
```

#### Comma

```r
read.csv("data.txt)
```

#### Semi-Colon

```r
read.csv2("data.txt)
```

#### Tab

```r
read.delim2("data.txt)
```

### Read Data and Skip Headers

```r
# Number of header lines
NUM_ROWS_TO_SKIP = 5

# Scan File and skip 5 lines
scan("t:\\data\\worms.txt", skip = NUM_ROWS_TO_SKIP)
```

### `scan()` based on Delimiter

```txt
// Original Data:
138
27 44
19 20 345 48
115 2366
59
```

#### All items

```r
scan("data.txt")
```

```txt
[1] 138 27 44 19 20 345 48 115 2366 59
```

#### Newline Delim

```r
scan("data.txt",sep = "\n")

# Or
readLines("data.txt")
```

```txt
[1] 138 2744 192034548 1152366 59
```

#### Tab Delim

```r
scan("data.txt",sep = "\t")
```

```txt
[14] 2366 NA NA 59 NA NA NA
```

#### Omit NA's

```r
na.omit(scan("data.txt",sep = "\t"))
```

```txt
[2] 2366 59
```
