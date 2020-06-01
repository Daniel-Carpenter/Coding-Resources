*THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20).*

## Storing Objects in Cache
```r
# In general
	evalWithMemoization(expr, key=NULL, ..., envir=parent.frame(),
	drop=c("srcref", "srcfile", "wholeSrcref"), force=FALSE)

# Example
	df <- evalWithMemoization(mtcars)
```


## Sources

### [R.Cache](https://cran.r-project.org/web/packages/R.cache/R.cache.pdf)
	Bengtsson, H. The R.oo package - Object-Oriented Programming with References Using
	Standard R Code, Proceedings of the 3rd International Workshop on Distributed
	Statistical Computing (DSC 2003), ISSN 1609-395X, Hornik, K.; Leisch, F. & Zeileis,
	A. (ed.), 2003