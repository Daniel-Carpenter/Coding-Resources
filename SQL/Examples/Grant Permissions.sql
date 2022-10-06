
-- USE DatabaseName;

-- CREATE SCHEMA SchemaName

-- GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, CONTROL ON SCHEMA :: TDI TO "INT\User.Name";

-- GRANT CREATE TABLE TO "INT\User.Name";

-- GRANT CREATE VIEW TO "INT\User.Name";


-- Select only with create views to new database
-- USE DatabaseName; 
-- GRANT CONNECT, SELECT, CREATE VIEW, VIEW DEFINITION TO "INT\User.Name"
-- EXEC sp_addrolemember N'db_datareader', N'INT\User.Name'
