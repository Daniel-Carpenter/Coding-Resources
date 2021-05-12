# OPA Database Connection (with Windows Authentication - MUST ALREADY HAVE ACCESS)
  OPA_Database <- dbConnect(odbc(), 
                            Driver    = "SQL Server", 
                            Server    = "10.67.5.44", 
                            Database  = "OPA", 
                            Trusted_Connection = TRUE)
  
# Read in Facility Name Attributes
  df.OPAFacilitySummary <- dbGetQuery(OPA_Database, 'SELECT * FROM [OPA].[dbo].[OPAFacilitySummary] ')

# Read in Department Name Attributes
  df.OPADepartmentNames <- dbGetQuery(OPA_Database, 'SELECT * FROM [OPA].[dbo].[OPADepartmentNames] ')
  