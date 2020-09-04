### Optimize with `Rglpk` Package
```r
library(Rglpk)
	
# Objective Function
obj <- c(2, 4, 3)
	
# Input Matrix
mat <- matrix(c(3, 2, 1, 4, 1, 3, 2, 2, 2), nrow = 3)
	
# Constraint Direction
dir <- c("<=", "<=", "<=")
	
# Constraint Values
rhs <- c(60, 40, 80)
	
# Maximize?
max <- TRUE
	
# Solve
Rglpk_solve_LP(obj, mat, dir, rhs, max = max)
```