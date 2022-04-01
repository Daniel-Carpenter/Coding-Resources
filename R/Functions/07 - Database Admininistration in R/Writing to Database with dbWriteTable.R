library(odbc) # Create connection
library(DBI)  # Upload to database - https://db.rstudio.com/best-practices/schema/


databaseName = 'Sandbox'

# OPA Database Connection (with Windows Authentication - MUST ALREADY HAVE ACCESS)
Sandbox_Database <- dbConnect(odbc(), 
                          Driver    = "SQL Server", 
                          Server    = "10.67.5.44", 
                          Database  = databaseName, 
                          uid = "",
                          pwd = "")


# Write the mtcars table to the database
dbWriteTable(conn      = Sandbox_Database, 
             
             # Schema and Table name
             name      = SQL("DBC.mtcars"), 
             
             # The local dataframe to upload
             value     = mtcars,
             
             # Do you want to overwrite the existing data? could also append with `append = TRUE`
             overwrite = TRUE)

