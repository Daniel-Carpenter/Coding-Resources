# DBA (Admin)

## General DBA Links
* [Increase size of database](https://docs.microsoft.com/en-us/sql/relational-databases/databases/increase-the-size-of-a-database?view=sql-server-ver15)

## Meta Data

### Get Summary of Storage Capacity
```sql
DBCC SQLPERF(logspace)
```

### `Size` of each table
```sql
SELECT
    t.NAME AS TableName,
    s.Name AS SchemaName,
    p.rows,
    SUM(a.total_pages) * 8 AS TotalSpaceKB, 
    CAST(ROUND(((SUM(a.total_pages) * 8) / 1024.00), 2) AS NUMERIC(36, 2)) AS TotalSpaceMB,
    SUM(a.used_pages) * 8 AS UsedSpaceKB, 
    CAST(ROUND(((SUM(a.used_pages) * 8) / 1024.00), 2) AS NUMERIC(36, 2)) AS UsedSpaceMB, 
    (SUM(a.total_pages) - SUM(a.used_pages)) * 8 AS UnusedSpaceKB,
    CAST(ROUND(((SUM(a.total_pages) - SUM(a.used_pages)) * 8) / 1024.00, 2) AS NUMERIC(36, 2)) AS UnusedSpaceMB
FROM 
    sys.tables t
INNER JOIN      
    sys.indexes i ON t.OBJECT_ID = i.object_id
INNER JOIN 
    sys.partitions p ON i.object_id = p.OBJECT_ID AND i.index_id = p.index_id
INNER JOIN 
    sys.allocation_units a ON p.partition_id = a.container_id
LEFT OUTER JOIN 
    sys.schemas s ON t.schema_id = s.schema_id
WHERE 
    t.NAME NOT LIKE 'dt%' 
    AND t.is_ms_shipped = 0
    AND i.OBJECT_ID > 255 
GROUP BY 
    t.Name, s.Name, p.Rows
ORDER BY 
    TotalSpaceMB DESC, t.Name
```


## `Copying` Data

### Copy `Table` from OldDatabase to NewDataBase
```sql
SELECT * INTO [NewDataBase].[SchemaName].[TableName] FROM [OldDatabase].[SchemaName].[TableName]
```
* *Note*: Combine with `drop table` to remove table immediately after 
###

### Copy `View` from Database1 to Database2
```sql
USE OldDatabase;
GO

DECLARE @sql NVARCHAR(MAX);

SELECT @sql = definition
FROM sys.sql_modules
WHERE [object_id] = OBJECT_ID('SchemaName.TableName');

EXEC NewDataBase..sp_executesql @sql;
```

### Move from a Schema to Another
```sql
USE DatabaseName;
ALTER SCHEMA NewSchema 
    TRANSFER OldSchema.TargetTable;
```

## `Deleting` Data

### Delete Tables or View
```sql
DROP TABLE [DatabaseName].[SchemaName].[TableName];
```
```sql
DROP VIEW [DatabaseName].[SchemaName].[ViewName];
```

## User Management

### Create new user (from server login)
```sql
CREATE USER [INT\user.name] FOR LOGIN [INT\user.name];
```

## Dependancies
* [Helpful source](https://www.mssqltips.com/sqlservertip/2999/different-ways-to-find-sql-server-object-dependencies/)

### `Linked Server` Dependancies
```sql
SELECT OBJECT_NAME (referencing_id) AS referencing_object, referenced_server_name, 
       referenced_database_name, referenced_schema_name, referenced_entity_name
FROM sys.sql_expression_dependencies
WHERE referenced_server_name IS NOT NULL
      AND is_ambiguous = 0
ORDER BY referenced_server_name, referencing_id
```

### [Stored Procedure Dependancies](https://stackoverflow.com/questions/10652746/tree-of-all-dependencies-in-a-sql-server-database)
```sql
;with ObjectHierarchy ( Base_Object_Id , Base_Cchema_Id , Base_Object_Name , Base_Object_Type, object_id , Schema_Id , Name , Type_Desc , Level , Obj_Path) 
as 
    ( select  so.object_id as Base_Object_Id 
        , so.schema_id as Base_Cchema_Id 
        , so.name as Base_Object_Name 
        , so.type_desc as Base_Object_Type
        , so.object_id as object_id 
        , so.schema_id as Schema_Id 
        , so.name 
        , so.type_desc 
        , 0 as Level 
        , convert ( nvarchar ( 1000 ) , N'/' + so.name ) as Obj_Path 
    from sys.objects so 
        left join sys.sql_expression_dependencies ed on ed.referenced_id = so.object_id 
        left join sys.objects rso on rso.object_id = ed.referencing_id 
    where rso.type is null 
        and so.type in ( 'P', 'V', 'IF', 'FN', 'TF' ) 

    union all 
    select   cp.Base_Object_Id as Base_Object_Id 
        , cp.Base_Cchema_Id 
        , cp.Base_Object_Name 
        , cp.Base_Object_Type
        , so.object_id as object_id 
        , so.schema_id as ID_Schema 
        , so.name 
        , so.type_desc 
        , Level + 1 as Level 
        , convert ( nvarchar ( 1000 ) , cp.Obj_Path + N'/' + so.name ) as Obj_Path 
    from sys.objects so 
        inner join sys.sql_expression_dependencies ed on ed.referenced_id = so.object_id 
        inner join sys.objects rso on rso.object_id = ed.referencing_id 
        inner join ObjectHierarchy as cp on rso.object_id = cp.object_id and rso.object_id <> so.object_id 
    where so.type in ( 'P', 'V', 'IF', 'FN', 'TF', 'U') 
        and ( rso.type is null or rso.type in ( 'P', 'V', 'IF', 'FN', 'TF', 'U' ) ) 
        and cp.Obj_Path not like '%/' + so.name + '/%' )   -- prevent cycles n hierarcy
select   Base_Object_Name 
    , Base_Object_Type
    , REPLICATE ( '   ' , Level ) + Name as Indented_Name 
    , SCHEMA_NAME ( Schema_Id ) + '.' + Name as object_id 
    , Type_Desc as Object_Type 
    , Level 
    , Obj_Path 
from ObjectHierarchy as p 
order by Obj_Path
```