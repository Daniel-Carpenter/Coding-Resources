# ==============================================================================
# Goal: Make connection to the OPA Database and import the Joined OPA Business table
# ==============================================================================

if (!require("odbc"))   install.packages("odbc")    # Driver to create the connection to database
if (!require("DBI"))    install.packages("DBI")     # Functions to read/write to database
if (!require("dplyr"))  install.packages("dplyr")  # Functions to make queries using `dplyr` function format
if (!require("dbplyr")) install.packages("dbplyr")  # Functions to make queries using `dplyr` function format
source('Reusable_Functions/OPA_Reader.R')           # OPA reader credentials

# Sources for reading and writing to database easily:
  # Querying from database (3 methods): https://db.rstudio.com/getting-started/database-queries
  # Writing to database and schema: https://db.rstudio.com/best-practices/schema/
  # Querying like you are using `dbplyr` package: https://dbplyr.tidyverse.org/articles/dbplyr.html


# OPA Database Connection (with Windows Authentication - MUST ALREADY HAVE ACCESS)
OPA_Database <- dbConnect(odbc(), 
                          Driver    = "ODBC Driver 18 for SQL Server", # Download driver: https://docs.microsoft.com/en-us/sql/connect/odbc/download-odbc-driver-for-sql-server?view=sql-server-ver15
                          Server    = "10.67.5.44", 
                          Database  = "OPA", 
                          UID       = getUserName(),
                          PWD       = getPassword(),
                          TrustServerCertificate = 'Yes')


# OPA Business table with the SOURCE_PROP field joined already              # Connection using `dbplyr`:
df.OPABusinessConnection <- tbl(OPA_Database,                               # The database
                                in_schema(schema = 'dbo',                   # The schema
                                          table  = 'OPABusinessAndAttrib')) # The table

df.BusinessNames <- data.frame(df.OPABusinessConnection)                    # Locally store the FULL table
rm(df.OPABusinessConnection, getUserName, getPassword)                                                # Remove for this case, but note you could keep as pointer
