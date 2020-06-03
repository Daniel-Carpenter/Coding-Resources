## Source Notes
* *THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20).*
* *Also taken from [Chris Albon](https://github.com/chrisalbon)'s [archived GitHub repositORy](https://github.com/chrisalbon/mlai) on machine learning and artifical intelligence.*
* Otherwise, they are [Daniel Carpenter](https://github.com/Daniel-Carpenter)'s additions OR edits

# Guide to SQL
Structured Query Language (SQL) is a commonly language fOR processing relational databases. Below is a beginner's guide to using SQL.


## Basic Scripting Examples


### View All Rows


```sql
--  Select all
SELECT *

-- From the criminals table
FROM criminals
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
</table>



### View DISTINCT Rows


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
</table>

### Printing N observations of your database
To print N observations of your database, type
```sql
SELECT * FROM datname LIMIT N;
```


## Aggregate Functions

### Create a one-way frequency table
Create a one-way frequency table as follows:
```sql
SELECT var1, COUNT(*) FROM datname GROUP BY var1;
```
This will then list the unique categORies and counts fOR each categORy

### Compute summary statistics of a variable OR fORmula of variables
```sql
SELECT FUNCTION(var1) FROM datname;
```
where the following are functions:

* `AVG`: average
* `COUNT`: count
* `SUM`: sum
* `MIN`: minimum
* `MAX`: maximum

### Summary statistics of functions of variables
FOR example:
```sql
SELECT FUNCTION(var1 + var2) FROM datname;
```
would apply the `AVG` OR `SUM` OR `MIN` to the sum of `var1` and `var2`. MORe complex functions (like square root) are not suppORted in SQLite, so something like
```sql
SELECT AVG(SQRT(var1)) FROM datname;
```
will not wORk.

But
```sql
SELECT (var1-var2) AS tempvarname FROM datname;
```
will. `AS` acts as an alias.



### View AVG Ages by City


```sql
--  Select name and average age,
SELECT city, avg(age)

--  from the table 'criminals',
FROM criminals

-- after grouping by city
GROUP BY city
```


<table>
    <tr>
        <th>city</th>
        <th>avg(age)</th>
    </tr>
    <tr>
        <td>Petaluma</td>
        <td>21.0</td>
    </tr>
    <tr>
        <td>San Francisco</td>
        <td>27.5</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
        <td>18.5</td>
    </tr>
</table>



### View Max Age by City


```sql
--  Select name and average age,
SELECT city, max(age)

--  from the table 'criminals',
FROM criminals

-- after grouping by city
GROUP BY city
```


<table>
    <tr>
        <th>city</th>
        <th>max(age)</th>
    </tr>
    <tr>
        <td>Petaluma</td>
        <td>21</td>
    </tr>
    <tr>
        <td>San Francisco</td>
        <td>32</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
        <td>22</td>
    </tr>
</table>



### View COUNT Of Criminals by City


```sql
--  Select name and average age,
SELECT city, count(name)

--  from the table 'criminals',
FROM criminals

-- after grouping by city
GROUP BY city
```




<table>
    <tr>
        <th>city</th>
        <th>count(name)</th>
    </tr>
    <tr>
        <td>Petaluma</td>
        <td>1</td>
    </tr>
    <tr>
        <td>San Francisco</td>
        <td>2</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
        <td>2</td>
    </tr>
</table>



### View SUM Age by City


```sql
--  Select name and average age,
SELECT city, total(age)

--  from the table 'criminals',
FROM criminals

-- after grouping by city
GROUP BY city
```




<table>
    <tr>
        <th>city</th>
        <th>total(age)</th>
    </tr>
    <tr>
        <td>Petaluma</td>
        <td>21.0</td>
    </tr>
    <tr>
        <td>San Francisco</td>
        <td>55.0</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
        <td>37.0</td>
    </tr>
</table>


## Dates

### Get Current Date


```sql
-- Select the current date
SELECT date('now');
```




<table>
    <tr>
        <th>date(&#x27;now&#x27;)</th>
    </tr>
    <tr>
        <td>2017-01-19</td>
    </tr>
</table>



### Get Current Date AND Time


```sql
-- Select the unix time code '1200762133'
SELECT datetime('now', 'unixepoch');
```




<table>
    <tr>
        <th>datetime(&#x27;now&#x27;, &#x27;unixepoch&#x27;)</th>
    </tr>
    <tr>
        <td>1970-01-29 10:42:53</td>
    </tr>
</table>



### Compute a UNIX timestamp into a date and time


```sql
-- Select the unix time code '1169229733'
SELECT datetime(1169229733, 'unixepoch');
```




<table>
    <tr>
        <th>datetime(1169229733, &#x27;unixepoch&#x27;)</th>
    </tr>
    <tr>
        <td>2007-01-19 18:02:13</td>
    </tr>
</table>



### Compute a UNIX timestamp into a date and time and convert to the local timezone.


```sql
-- Select the unix time code '1171904533' and convert to the machine's local timezone
SELECT datetime(1171904533, 'unixepoch', 'localtime');
```




<table>
    <tr>
        <th>datetime(1171904533, &#x27;unixepoch&#x27;, &#x27;localtime&#x27;)</th>
    </tr>
    <tr>
        <td>2007-02-19 10:02:13</td>
    </tr>
</table>



### Compute the Day Of the Week


```sql
-- Select the the day of this week (0 = Sunday, 4 = Thursday)
SELECT strftime('%w','now');
```




<table>
    <tr>
        <th>strftime(&#x27;%w&#x27;,&#x27;now&#x27;)</th>
    </tr>
    <tr>
        <td>4</td>
    </tr>
</table>


## JOIN Tables

### Inner JOIN

Returns all rows whose merge-on id appears in **both** tables.


```sql
-- Select everything
SELECT *

-- Left table
FROM criminals

-- Right table
INNER JOIN crimes

-- Merged on `pid` in the criminals table and `pid_arrested` in the crimes table
ON criminals.pid=crimes.pid_arrested;
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
        <th>cid</th>
        <th>crime</th>
        <th>city_1</th>
        <th>pid_arrested</th>
        <th>cash_stolen</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
        <td>1</td>
        <td>fraud</td>
        <td>Santa Rosa</td>
        <td>412</td>
        <td>40000</td>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
        <td>7</td>
        <td>fraud</td>
        <td>San Francisco</td>
        <td>412</td>
        <td>60000</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>2</td>
        <td>burglary</td>
        <td>Petaluma</td>
        <td>234</td>
        <td>2000</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>3</td>
        <td>burglary</td>
        <td>Santa Rosa</td>
        <td>632</td>
        <td>2000</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>10</td>
        <td>robbery</td>
        <td>Santa Rosa</td>
        <td>632</td>
        <td>2500</td>
    </tr>
    <tr>
        <td>621</td>
        <td>Betty Bob</td>
        <td>None</td>
        <td>F</td>
        <td>Petaluma</td>
        <td>1</td>
        <td>4</td>
        <td>None</td>
        <td>None</td>
        <td>621</td>
        <td>3500</td>
    </tr>
    <tr>
        <td>162</td>
        <td>Jaden Ado</td>
        <td>49</td>
        <td>M</td>
        <td>None</td>
        <td>0</td>
        <td>5</td>
        <td>burglary</td>
        <td>Santa Rosa</td>
        <td>162</td>
        <td>1000</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>6</td>
        <td>None</td>
        <td>Petaluma</td>
        <td>901</td>
        <td>50000</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>8</td>
        <td>burglary</td>
        <td>Santa Rosa</td>
        <td>512</td>
        <td>7000</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>11</td>
        <td>robbery</td>
        <td>Santa Rosa</td>
        <td>512</td>
        <td>3000</td>
    </tr>
    <tr>
        <td>411</td>
        <td>Bob Iton</td>
        <td>None</td>
        <td>M</td>
        <td>San Francisco</td>
        <td>0</td>
        <td>9</td>
        <td>burglary</td>
        <td>San Francisco</td>
        <td>411</td>
        <td>3000</td>
    </tr>
</table>



### Left JOIN

Returns all rows from the left table but only the rows from the right left that match the left table.


```sql
-- Select everything
SELECT *

-- Left table
FROM criminals

-- Right table
LEFT JOIN crimes

-- Merged on `pid` in the criminals table and `pid_arrested` in the crimes table
ON criminals.pid=crimes.pid_arrested;
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
        <th>cid</th>
        <th>crime</th>
        <th>city_1</th>
        <th>pid_arrested</th>
        <th>cash_stolen</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
        <td>1</td>
        <td>fraud</td>
        <td>Santa Rosa</td>
        <td>412</td>
        <td>40000</td>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
        <td>7</td>
        <td>fraud</td>
        <td>San Francisco</td>
        <td>412</td>
        <td>60000</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>2</td>
        <td>burglary</td>
        <td>Petaluma</td>
        <td>234</td>
        <td>2000</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>3</td>
        <td>burglary</td>
        <td>Santa Rosa</td>
        <td>632</td>
        <td>2000</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>10</td>
        <td>robbery</td>
        <td>Santa Rosa</td>
        <td>632</td>
        <td>2500</td>
    </tr>
    <tr>
        <td>621</td>
        <td>Betty Bob</td>
        <td>None</td>
        <td>F</td>
        <td>Petaluma</td>
        <td>1</td>
        <td>4</td>
        <td>None</td>
        <td>None</td>
        <td>621</td>
        <td>3500</td>
    </tr>
    <tr>
        <td>162</td>
        <td>Jaden Ado</td>
        <td>49</td>
        <td>M</td>
        <td>None</td>
        <td>0</td>
        <td>5</td>
        <td>burglary</td>
        <td>Santa Rosa</td>
        <td>162</td>
        <td>1000</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>6</td>
        <td>None</td>
        <td>Petaluma</td>
        <td>901</td>
        <td>50000</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>8</td>
        <td>burglary</td>
        <td>Santa Rosa</td>
        <td>512</td>
        <td>7000</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
        <td>11</td>
        <td>robbery</td>
        <td>Santa Rosa</td>
        <td>512</td>
        <td>3000</td>
    </tr>
    <tr>
        <td>411</td>
        <td>Bob Iton</td>
        <td>None</td>
        <td>M</td>
        <td>San Francisco</td>
        <td>0</td>
        <td>9</td>
        <td>burglary</td>
        <td>San Francisco</td>
        <td>411</td>
        <td>3000</td>
    </tr>
</table>



_Note: FULL OUTER and RIGHT JOIN are not shown here because they are not suppORted by the version of SQL (SQLite) used in this tutORial._



## Subqueries (basically a nested SELECT)


### Select Based On the Result Of a Select (Subquery)


```sql
--  Select name and age,
SELECT name, age

--  from the table 'criminals',
FROM criminals

--  where age is greater than,
WHERE age > 
     --  select age,
    (SELECT age
     --  from criminals
     FROM criminals
     --  where the name is 'James Smith'
     WHERE name == 'James Smith')
```




<table>
    <tr>
        <th>name</th>
        <th>age</th>
    </tr>
    <tr>
        <td>Bill James</td>
        <td>22</td>
    </tr>
    <tr>
        <td>Stacy Miller</td>
        <td>23</td>
    </tr>
    <tr>
        <td>Jaden Ado</td>
        <td>49</td>
    </tr>
    <tr>
        <td>GORdon Ado</td>
        <td>32</td>
    </tr>
    <tr>
        <td>Bill Byson</td>
        <td>21</td>
    </tr>
</table>



### Subquery Example 1
```sql
-- Did mORe men OR women wORk in January 2018 and from which company did these employees (that wORked in January) ORiginate?

SELECT 
 e.company, 
 e.gender, 
 count(e.employee_id) AS [COUNT]
FROM 
(SELECT DISTINCT 
  e.employee_id, 
  e.gender, 
  e.company 
 
 FROM 
  employee_info AS e, 
  Payroll AS p 
  
 WHERE 
  p.employee_id = e.employee_id 
  AND p.period >= #1/1/2018# 
  AND p.period < #2/1/2018# 
 
 GROUP BY e.employee_id, e.gender, e.company)  AS [%$##@_Alias]

GROUP BY e.company, e.gender;

```

### Subquery Example 2

```sql
-- Which stORe had the most employees? Please include the city and state.

SELECT 
 s.city, s.state, 
 COUNT (e.employee_id) AS Emp_COUNT

FROM 
 StORes AS s, 
 employee_info AS e

WHERE 
 s.stORe_id = e.stORe_id

GROUP BY s.city, s.state
 HAVING COUNT (e.employee_id) = (
  SELECT MAX(emp_count)
  FROM (
    SELECT 
     s.city, 
     s.state, 
     COUNT (e.employee_id) AS emp_count
    FROM 
     StORes AS s, 
     employee_info AS e

    WHERE 
     s.stORe_id = e.stORe_id

    GROUP BY 
     s.city, s.state));

```

## UNIONS

### UNION - View All Unique City Names From Both Tables


```sql
-- Select city name
SELECT city 

-- From criminals table
FROM criminals

-- Then combine with
UNION

-- Select city names
SELECT city 

-- From crimes table
FROM crimes;
```




<table>
    <tr>
        <th>city</th>
    </tr>
    <tr>
        <td>None</td>
    </tr>
    <tr>
        <td>Petaluma</td>
    </tr>
    <tr>
        <td>San Francisco</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
</table>



### UNION ALL - View All City Names From Both Tables


```sql
-- Select city name
SELECT city 

-- From criminals table
FROM criminals

-- Then combine with
UNION ALL

-- Select city names
SELECT city 

-- From crimes table
FROM crimes;
```




<table>
    <tr>
        <th>city</th>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Petaluma</td>
    </tr>
    <tr>
        <td>None</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>San Francisco</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Petaluma</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>None</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Petaluma</td>
    </tr>
    <tr>
        <td>San Francisco</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>San Francisco</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
    <tr>
        <td>Santa Rosa</td>
    </tr>
</table>



## Conditional Statements



### View Rows Where Age is Greater Than 20 AND City is San Francisco


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where age is greater than 20 and city is San Francisco
WHERE age > 20 AND city == 'San Francisco'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows Where Age is Greater Than 20 OR City is San Francisco


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where age is greater than 20 and city is San Francisco
WHERE age > 20 OR city == 'San Francisco'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
</table>



### Drop Row Based On a Conditional


```sql
-- Delete all rows
DELETE FROM criminals

-- if the age is less than 18
WHERE age < 18
```



### Select Name AND Ages Only When the Name is Known


```sql
--  Select name and average age,
SELECT name, age

--  from the table 'criminals',
FROM criminals

-- if age is not a null value
WHERE name IS NOT NULL
```




<table>
    <tr>
        <th>name</th>
        <th>age</th>
    </tr>
    <tr>
        <td>James Smith</td>
        <td>15</td>
    </tr>
    <tr>
        <td>GORdon Ado</td>
        <td>32</td>
    </tr>
    <tr>
        <td>Bill Byson</td>
        <td>21</td>
    </tr>
</table>



### Drop Row Based On a Conditional


```sql
--  Select all
SELECT *

-- From the criminals table
FROM criminals

-- Only return the first two rows
LIMIT 2;
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>


### View Rows Where Age is Greater Than 30


```sql
--  Select all
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where age is greater than 30
WHERE age > 30
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows Where Age is Greater Than OR Equal To 23


```sql
--  Select all
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where age is greater than 23
WHERE age >= 23
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>632</td>
        <td>Jack Killer</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows Where Age is 23


```sql
--  Select all
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where age is greater than 23
WHERE age = 23
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>632</td>
        <td>Jack Killer</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows Where Age is Not 23


```sql
--  Select all
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where age is greater than 23
WHERE age <> 23
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill Bayes</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
</table>

## Conditional "Like" % OperatOR

### View Rows Where Name Begins with 'J'


```sql
--  Select all
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where name starts with 'J'
WHERE name LIKE 'J%'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Jack Killer</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows Where Name Contains the String 'ames'


```sql
--  Select all
SELECT distinct *

-- From the criminals table
FROM criminals

-- Where name contains the string 'ames'
WHERE name LIKE '%ames%'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
</table>



### Select Rows with Names Starting with `G`


```sql
--  Select all
SELECT *

-- From the criminals table
FROM criminals

-- If name starts with G
WHERE name LIKE 'G%'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>



### Select Rows with Names Ending with `o`


```sql
--  Select all
SELECT *

-- From the criminals table
FROM criminals

-- If name starts ends with o
WHERE name LIKE '%o'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>162</td>
        <td>Jaden Ado</td>
        <td>49</td>
        <td>M</td>
        <td>None</td>
        <td>0</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>



### Select Rows with Names Starting with Any Character, Then `ORdon`


```sql
--  Select all
SELECT *

-- From the criminals table
FROM criminals

-- If name starts with any character then continues with 'ORdon'
WHERE name LIKE '_ORdon%'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>

## Conditional - IN 

### Select Rows That Contain An Item In a List


```sql
-- Select everything
SELECT *

-- From the table 'criminals'
FROM criminals

-- Where the city is any of these cities
WHERE city IN ('Santa Rosa', 'Petaluma');
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>621</td>
        <td>Betty Bob</td>
        <td>None</td>
        <td>F</td>
        <td>Petaluma</td>
        <td>1</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>


## BETWEEN

### Select Every Row Where Age is Between Two Values


```sql
-- Select everything
SELECT *

-- From the table 'criminals'
FROM criminals

-- Where 
WHERE age BETWEEN 12 AND 18
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
</table>


## SORT

### SORt by Ascending Age AND Then Alphabetically by Name


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals

-- SORt by ascending age
ORDER BY age ASC, name
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### SORt by Ascending Age


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals

-- SORt by ascending age
ORDER BY age ASC
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### SORt by Descending Age


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals

-- SORt by descending age
ORDER BY age DESC
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
</table>



### SORt Alphabetically


```sql
--  Select all unique
SELECT distinct *

-- From the criminals table
FROM criminals

-- SORt by name
ORDER BY name
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minOR</th>
    </tr>
    <tr>
        <td>512</td>
        <td>Bill Byson</td>
        <td>21</td>
        <td>M</td>
        <td>Petaluma</td>
        <td>0</td>
    </tr>
    <tr>
        <td>234</td>
        <td>Bill James</td>
        <td>22</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
    <tr>
        <td>901</td>
        <td>GORdon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
    <tr>
        <td>412</td>
        <td>James Smith</td>
        <td>15</td>
        <td>M</td>
        <td>Santa Rosa</td>
        <td>1</td>
    </tr>
    <tr>
        <td>632</td>
        <td>Stacy Miller</td>
        <td>23</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>


### Copy Contents Of First Table Into Empty Table


```sql
-- Insert into the empty table
INSERT INTO criminals_2

-- Everything
SELECT * 

-- From the first table
FROM criminals_1;
```


### Create An Index Using the Column 'pid' As the Unique ID


```sql
-- Create a index called uid
CREATE INDEX uid

-- FOR the table 'criminals' and the column 'pid'
ON criminals (pid)
```


## SQL in the Command Line
### Opening SQL
One can open SQL from the command line by typing `sqlite3` at the prompt.

### Exiting out of SQL
SQL **commands** are prepended with a "." so to exit SQL, type `.quit`

### Executing a SQL script
Supposing one has a file called `test.sql`, one can execute it by typing `.read test.sql` at the prompt (inside SQL).

### Reading data into SQL
To read data into SQL (e.g. from a CSV OR tab-delimited raw file), there are actually two steps:

1. Create a SQL table which will hold the data
2. Read the raw data file into SQL's memORy

To do step 1, type the following:
```sql
CREATE TABLE datname(
  "var1" CHAR,
  "var2" INTEGER,
  ...
  "varN" REAL 
);
where `datname` is whatever you want to call your database in SQL.
```

To do step 2, type the following:
```sql
.mode csv
.impORt /path/to/file.csv datname
```

### Saving data while using SQL
If one wants to save a database in SQL, the file extension is `.sqlite3` (but in principle you can use whatever you want). the way to save data is to issue the `.dump` command:

```sql
.output datname.sqlite3
.dump
```
the result will be a text file with SQL code in it that will recreate the table you dumped.








