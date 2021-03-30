# OPA Database Connection (with Windows Authentication - MUST ALREADY HAVE ACCESS)
  OPA_Database <- dbConnect(odbc(), 
                            Driver    = "SQL Server", 
                            Server    = "10.67.5.44", 
                            Database  = "OPA", 
                            Trusted_Connection = TRUE)
  
