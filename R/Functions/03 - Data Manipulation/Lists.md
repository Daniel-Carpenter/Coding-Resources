
# Lists

## Creating and Using Lists

### Create

```r
obj <- list(Student = "Daniel Carpenter",
            Teacher  = "Dr Stewart",
            Course   = "Statistics")
```

### Reference

> Input

```r
obj$Student # or obj[1], obj[["Student"]]
obj$Teacher # or obj[2], obj[["Teacher"]]
obj$Course  # or obj[3], obj[["Course"]]
```

> Output

```txt
> obj$Student
[1] "Daniel Carpenter"

> obj$Teacher
[1] "Dr Stewart"

> obj$Course
[1] "Statistics"
```

### Sublist

> Input

```r
# Create
subList = obj[1:2]

# Print
subList
```

> Output

```txt
> subList
$Student
[1] "Daniel Carpenter"

$Teacher
[1] "Dr Stewart"
```

### Concatenate List

> Input

```r
# Create two lists
obj1 <- list(Student = "Daniel Carpenter",
            Course   = "Statistics")

obj2 <- list(Student = "Jack Whittington",
            Course   = "Sociology")

# Concatenate
listCat <- c(obj1, obj2)

# Print
listCat
```

> Output

```txt
> listCat
$Student
[1] "Daniel Carpenter"

$Course
[1] "Statistics"

$Student
[1] "Jack Whittington"

$Course
[1] "Sociology"
```
