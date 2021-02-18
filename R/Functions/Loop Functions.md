
# Loop Functions - Alternatives to `for`

## `for` Techniques

```r
for (i in seq_along(df)) {
    ...
}
```

## `Apply` family

* [Below from the following resource](https://swcarpentry.github.io/r-novice-inflammation/15-supp-loops-in-depth/)

`for` or `apply`?

A `for` loop is used to apply the same function calls to a collection of objects. R has a family of functions, the apply family, which can be used in much the same way.
|Function|Description|
|-|-|
|`apply`|apply over the margins of an array (e.g. the rows or columns of a matrix)|
|`lapply`|apply over an object and return list|
|`sapply`|apply over an object and return a simplified object (an array) if possible|
|`vapply`|similar to sapply but you specify the type of object returned by the iterations|


