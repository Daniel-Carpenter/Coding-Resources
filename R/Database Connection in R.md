## `SQL` in `R`

### Helpful Links

* [Connect to Databse](https://db.rstudio.com/getting-started/connect-to-database)
* [Querying syntax with dplyr/other](https://db.rstudio.com/getting-started/database-queries)
* [Safe quering practices](https://db.rstudio.com/best-practices/run-queries-safely/)
* [Securing Credentials (if not Windows Auth.)](https://db.rstudio.com/best-practices/managing-credentials/)

***

### Example Reprex ([Source](https://db.rstudio.com/databases/microsoft-sql-server/))


#### `R` Script Portion (1/2)
```r
library(dbplyr)
library(odbc)
library(DBI)
library(glue)


selectMinDate = Sys.Date() - 365
selectMaxDate = Sys.Date()

driverName		= "SQL Server"
serverName		= "00.00.0.00"
databaseName	= "databaseName
isTrustedCon	= TRUE


# Setup connection (with Windows Authentication)
	databaseName <- dbConnect(odbc(), 
									  Driver	= driverName, 
									  Server	= serverName, 
									  Database	= databaseName,
									  Trusted_Connection = isTrustedCon)
								  
# Access SQL Script from some file (file contains full sql pull)
	sqlPull_fromFile <- read_file("queryFile.sql") 

# Update File to include User Input   
    sqlPull_withUserInput <- glue_sql(sqlPull_fromFile, 
                                          selectMinDate_SQL    = selectMinDate,
                                          selectMaxDate_SQL    = selectMaxDate,
                                          .con = databaseName)
        
# Send Query to Database and Store in `df` (Main Payroll Data)
	df <- dbGetQuery(databaseName, sqlPull_withUserInput)

								  
```


#### `SQL` Script Portion (2/2)

	```sql
	SELECT *

    FROM [dataBaseName].[table]
    
    WHERE
            [StartDateTime]   >= {selectMinDate_SQL*}
        AND [StartDateTime]    < {selectMaxDate_SQL*}
	```



