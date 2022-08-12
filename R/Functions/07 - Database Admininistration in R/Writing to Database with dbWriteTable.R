# Goal: Code to connect to a database, write back to it, and read the data back

# ==============================================================================
# INPUTS 
# ==============================================================================

# Names of the Database, Schema, New Table, etc.
databaseName = 'Sandbox'            # Database to connect to could also use "OPA"
schemaName   = 'TDI'                # Schema   to connect to
newTableName = 'ExampleUploadFromR' # New table name that you will create

# Table to upload to database
tableToPutOnDatabase <- mtcars # This could be any dataframe you want


# ==============================================================================
# DATABASE CODE 
# ==============================================================================

# Sources for reading and writing to database easily:
    # Querying from database (3 methods): https://db.rstudio.com/getting-started/database-queries
    # Writing to database and schema: https://db.rstudio.com/best-practices/schema/
    # Querying like you are using `dbplyr` package: https://dbplyr.tidyverse.org/articles/dbplyr.html

require(odbc)   # Create connection
require(DBI)    # Upload to database - https://db.rstudio.com/best-practices/schema/
require(dbplyr) # Functions for altering pullin data like using dplyr
require(tidyverse)


# Database Connection (with Windows Authentication - MUST ALREADY HAVE ACCESS)
connectionToDatabase <- dbConnect(odbc(), 
                                  Driver    = "SQL Server", 
                                  Server    = "10.67.5.44", 
                                  Database  = databaseName, 
                                  Trusted_Connection = TRUE 
                                  )

# Concatenate Schema and Table Name for simplicity
schemaAndNewTable = paste0(schemaName, '.', newTableName)

# Write the new table to the database
dbWriteTable(conn      = connectionToDatabase, 
             
             # Schema and Table name
             name      = SQL(schemaAndNewTable), 
             
             # The local dataframe to upload
             value     = tableToPutOnDatabase,
             
             # Do you want to overwrite the existing data? could also append with `append = TRUE`
             overwrite = TRUE)


# Pull the data from the database that you just uploaded
dataPulledFromDatabase <- tbl(connectionToDatabase,             # The database
                              in_schema(schema = schemaName,    # The schema
                                        table  = newTableName)) # The table

