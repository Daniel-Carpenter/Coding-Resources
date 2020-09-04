## `SQL` in `R`

### Connection ([Source](https://db.rstudio.com/databases/microsoft-sql-server/))
```r
libary(DBI)
libary(odbc)

con <- dbConnect(odbc(), 
					  Driver = "SQL Server", 
                      Server = "localhost\\SQLEXPRESS", 
                      Database = "master", 
                      Trusted_Connection = "True")
```

## Querying ([Source](https://github.com/r-dbi/odbc/blob/master/README.md))

`dbGetQuery()` will submit a query and fetch the results. It is also
possible to submit the query and fetch separately with `dbSendQuery()`
and `dbFetch()`. The `n=` argument to `dbFetch()` can be used to fetch
only the part of a query result (the next *n*
rows).

``` r
result <- dbSendQuery(con, "SELECT flight, tailnum, origin FROM flights ORDER BY origin")

# Retrieve the first 100 results
first_100 <- dbFetch(result, n = 100)

# Retrieve the rest of the results
rest <- dbFetch(result)
```
