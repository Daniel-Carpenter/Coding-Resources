# ==============================================================================
# Goal: Make connection to a SQL Server Database
# ==============================================================================

if (!require("odbc"))   install.packages("odbc")   # Driver to create the connection to database
if (!require("DBI"))    install.packages("DBI")    # Functions to read/write to database
if (!require("dplyr"))  install.packages("dplyr")  # Functions to make queries using `dplyr` function format
if (!require("dbplyr")) install.packages("dbplyr") # Functions to make queries using `dplyr` function format

# Sources for reading and writing to database easily:
  # Querying from database (3 methods): https://db.rstudio.com/getting-started/database-queries
  # Writing to database and schema: https://db.rstudio.com/best-practices/schema/
  # Querying like you are using `dbplyr` package: https://dbplyr.tidyverse.org/articles/dbplyr.html


# OPA Database Connection (with Windows Authentication - MUST ALREADY HAVE ACCESS)
Database_Connection <- dbConnect(odbc(), 
                                 Driver    = "SQL Server", 
                                 Server    = "ServerName", 
                                 Database  = "DatabaseName", 
                                 UID       = 'Username',
                                 PWD       = 'Password',
                                 # Trusted_Connection = "True", # Or could use trusted
                                 TrustServerCertificate = 'Yes')
