* [Guide to Saving and Creating Files and Directories](http://theautomatic.net/2018/07/11/manipulate-files-r/)
* [Object Oriented Programming in R](https://htmlpreview.github.io/?https://raw.githubusercontent.com/Daniel-Carpenter/Coding-Resources/master/R/Coding%20Performance%20Techniques/Object%20Oriented%20Programming%20Review/Object%20Oriented%20Programming.html)


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