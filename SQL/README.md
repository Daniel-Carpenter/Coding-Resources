## Source Notes
* *THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'dat MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20).*
* *Also taken from [Chris Albon](https://github.com/chrisalbon)'s [archived GitHub repository](https://github.com/chrisalbon/mlai) on machine learning and artifical intelligence.*
* Otherwise, they are [Daniel Carpenter](https://github.com/Daniel-Carpenter)'s additions OR edits

# Guide to SQL
Structured Query Language (SQL) is a commonly language for processing relational databases. Below is a beginner's guide to using SQL.


## Basic Scripting Examples


### View All Rows

```sql
--  Select all
SELECT *

-- From the dataTable table
FROM dataTable
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
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



### View `DISTINCT` Rows


```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
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

### Printing `N` observations of your database
To print N observations of your database, type
```sql
SELECT * 
FROM dataTable LIMIT N;
```


## Aggregate Functions

### Create a one-way frequency table
Create a one-way frequency table as follows:
```sql
SELECT var1, COUNT(*) 
FROM dataTable GROUP BY var1;
```
This will then list the unique categories and counts for each category

### Compute summary statistics of a variable `OR` formula of variables
```sql
SELECT FUNCTION(var1) 
FROM dataTable;
```
where the following are functions:

* `AVG`: average
* `COUNT`: count
* `SUM`: sum
* `MIN`: minimum
* `MAX`: maximum

### Summary statistics of functions of variables
For example:
```sql
SELECT FUNCTION(var1 + var2) 
FROM dataTable;
```
would apply the `AVG` OR `SUM` OR `MIN` to the sum of `var1` and `var2`. More complex functions (like square root) are not supported in SQLite, so something like
```sql
SELECT AVG(SQRT(var1)) 
FROM dataTable;
```
will not work.

But
```sql
SELECT (var1-var2) AS tempvarname FROM dataTable;
```
will. `AS` acts as an alias.



### View `AVG` Ages by City


```sql
--  Select name and average age,
SELECT city, avg(age)

--  from the table 'dataTable',
FROM dataTable

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



### View `MAX` Age by City


```sql
--  Select name and average age,
SELECT city, max(age)

--  from the table 'dataTable',
FROM dataTable

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



### View `COUNT` Of Criminals by City


```sql
--  Select name and average age,
SELECT city, count(name)

--  from the table 'dataTable',
FROM dataTable

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



### View `SUM` Age by City


```sql
--  Select name and average age,
SELECT city, total(age)

--  from the table 'dataTable',
FROM dataTable

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

### `ROUND` Function
```sql
SELECT ROUND(AVG(Shipping + Tax),2) AS AvgShipTax
FROM dataTable
WHERE MONTH(SaleDate) = 12

```



## Conditional Statements - `WHERE` Clause



### View Rows `WHERE` Age is Greater Than 20 `AND` City is San Francisco


```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
    </tr>
    <tr>
        <td>901</td>
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows `WHERE` Age is Greater Than 20 `OR` City is San Francisco


```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
    </tr>
    <tr>
        <td>901</td>
        <td>Gordon Ado</td>
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
DELETE FROM dataTable

-- if the age is less than 18
WHERE age < 18
```



### `SELECT` Name `AND` Ages Only When the Name is Known


```sql
--  Select name and average age,
SELECT name, age

--  from the table 'dataTable',
FROM dataTable

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
        <td>Gordon Ado</td>
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

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
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


### View Rows `WHERE` Age is Greater Than 30


```sql
--  Select all
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
    </tr>
    <tr>
        <td>901</td>
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows `WHERE` Age is Greater Than `OR` Equal To 23


```sql
--  Select all
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
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
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### View Rows `WHERE` Age is 23


```sql
--  Select all
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

-- Where age is greater than 23
WHERE age  =  23
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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



### View Rows `WHERE` Age is `NOT` 23


```sql
--  Select all
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
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
        <td>Gordon Ado</td>
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

### All three operators as well as the necessary parentheses (`AND`, `OR`, `NOT`)
```sql
SELECT *
FROM dataTable
WHERE grouping = 'Red Shoe'
 OR grouping = 'boots'
 AND NOT otherDataTableName = 'Nike'
 OR otherDataTableName = 'Puma'

```

### Conditional `NULL`
```sql
SELECT *
FROM dataTable
WHERE Color is NULL
```

## Conditional "Like" `%` Operator

### `%` View Rows `WHERE` Name Begins with 'J'


```sql
--  Select all
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
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



### `%` `SELECT` Rows `WHERE` Name Contains the String 'ames'


```sql
--  Select all
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
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



### `%` `SELECT` Rows with Names Starting with `G`


```sql
--  Select all
SELECT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
    </tr>
    <tr>
        <td>901</td>
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>



### `%` `SELECT` Rows with Names Ending with `o`


```sql
--  Select all
SELECT *

-- From the dataTable table
FROM dataTable

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
        <th>minor</th>
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
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>



### `%` `SELECT` Rows with Names Starting with Any Character, Then `ordon`


```sql
--  Select all
SELECT *

-- From the dataTable table
FROM dataTable

-- If name starts with any character then continues with 'ordon'
WHERE name LIKE '_ordon%'
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
    </tr>
    <tr>
        <td>901</td>
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>Santa Rosa</td>
        <td>0</td>
    </tr>
</table>



## Conditional - IN 

### `SELECT` Rows That Contain An Item `IN` a List


```sql
-- Select everything
SELECT *

-- From the table 'dataTable'
FROM dataTable

-- Where the city is any of these cities
WHERE city IN ('Santa Rosa', 'Petaluma');
```

### Another Example of `IN` Operator
```sql
SELECT *
FROM dataTable
WHERE grouping IN ('Red Shoe',
 'sandals',
 'heels',
 'boots')

```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
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

### `SELECT` Every Row `WHERE` Age is `BETWEEN` Two Values


```sql
-- Select everything
SELECT *

-- From the table 'dataTable'
FROM dataTable

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
        <th>minor</th>
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


## Conditional Statements - `HAVING` Clause
* Use this when you need to filter the variable you created from the aggregate functions

### `HAVING` Example 1
```sql
-- Filter out MaxListPrice with less that 50 count

	SELECT grouping,	
		MAX(price) AS MaxListPrice
	FROM dataTable
	GROUP BY grouping
	HAVING COUNT(*) > 50

```

### `HAVING` Example 2
```sql
-- Similar to above with ORDER BY integration

	SELECT grouping,
	 AVG(price)
	FROM dataTable
	WHERE Color = 'Yellow'
	GROUP BY grouping
	HAVING MAX(price) <= 100
	ORDER BY grouping DESC
```


## `ORDER BY`

### `ORDER BY` Ascending Age AND Then Alphabetically by Name

```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

-- Sort by ascending age
ORDER BY age ASC, name
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### `ORDER BY` Ascending Age


```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

-- Sort by ascending age
ORDER BY age ASC
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
        <td>32</td>
        <td>F</td>
        <td>San Francisco</td>
        <td>0</td>
    </tr>
</table>



### `ORDER BY` Descending Age


```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

-- Sort by descending age
ORDER BY age DESC
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
    </tr>
    <tr>
        <td>901</td>
        <td>Gordon Ado</td>
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



### `ORDER BY` Alphabetically


```sql
--  Select all unique
SELECT DISTINCT *

-- From the dataTable table
FROM dataTable

-- Sort by name
ORDER BY name
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
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


## Working with Strings

### `SUBSTRING` Example (`LEFT()`, `RIGHT`() in Excel)
```sql
Select ID, Name, 
	SUBSTRING(ColumnName,1,15) AS "Smaller Word", 
	LEN(ColumnName) AS "Desc Length", 
	SUBSTRING(ColumnName2,1,20) AS "Smaller Description"
	From dataTable

```

### Find Word in Column with `Charindex`
```sql
-- Show results that include 'Leather' in Composition Column at least one time
Select dataTableID, dataTableName, Composition 
	FROM dataTable
	WHERE Charindex ('Leather', Composition) >= 1
	
```

## Dates

### Get Current `date`


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



### Get Current Date `AND` Time with `datetime`


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



### Compute the Day Of the `week()`


```sql
-- Select the the day of this week (0  =  Sunday, 4  =  Thursday)
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


### Conditional with Dates Example 1 - `MONTH`
```sql
SELECT *
FROM dataTable
WHERE grouping = 'Red Shoe'
AND MONTH(SaleDate) = 4
 
```

### Conditional with Dates Example 2 - `MONTH`, `YEAR`
```sql
SELECT dataTable.*
FROM dataTable
 JOIN otherDataTable
 ON dataTable.SaleId = otherDataTable.SaleId
 JOIN dataTableBrief
 ON otherDataTable.ID = dataTableBrief.ID
WHERE grouping = 'Red Shoe'
 AND MONTH(SaleDate) BETWEEN 10 AND 12
 AND YEAR(SaleDate) = 2015
 ```



### Compute a UNIX timestamp into a date and time with `datetime`


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



### Compute a UNIX timestamp into a date and time and convert to the local timezone. `datetime`


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




## `JOIN` Tables

### `INNER JOIN`

Returns all rows whose merge-on id appears in **both** tables.


```sql
-- Select everything
SELECT *

-- LEFT table
FROM dataTable

-- Right table
INNER JOIN otherDataTable

-- Merged on `pid` in the dataTable table and `pid_arrested` in the otherDataTable table
ON dataTable.pid = otherDataTable.pid_arrested;
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
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



### `LEFT JOIN`

Returns all rows from the left table but only the rows from the right left that match the left table.


```sql
-- Select everything
SELECT *

-- LEFT table
FROM dataTable

-- Right table
LEFT JOIN otherDataTable

-- Merged on `pid` in the dataTable table and `pid_arrested` in the otherDataTable table
ON dataTable.pid = otherDataTable.pid_arrested;
```




<table>
    <tr>
        <th>pid</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>city</th>
        <th>minor</th>
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
        <td>Gordon Ado</td>
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



_Note: FULL OUTER and RIGHT JOIN are not shown here because they are not supported by the version of SQL (SQLite) used in this tutorial._



## Subqueries (basically a nested SELECT)

### Simple Example of Subquery

```sql
-- Goal: Shoe grouping that have facilityID in OK

	SELECT grouping
	FROM dataTable
	WHERE facilityID IN
	 (SELECT facilityID
	 FROM otherDataTable
	 WHERE State = 'OK')

```

### `SELECT` Based On the Result Of a `SELECT` (Subquery)


```sql
--  Select name and age,
SELECT name, age

--  from the table 'dataTable',
FROM dataTable

--  where age is greater than,
WHERE age > 
     --  select age,
    (SELECT age
     --  from dataTable
     FROM dataTable
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
        <td>Gordon Ado</td>
        <td>32</td>
    </tr>
    <tr>
        <td>Bill Byson</td>
        <td>21</td>
    </tr>
</table>


### Subquery in `SELECT` Clause
```sql
SELECT patronID,
 firstName,
 lastName,
 (SELECT SUM (quantity * price)
 FROM otherDataTable oDat
	 JOIN dataTable dat
 ON oDat.primaryKey = dat.primaryKey
 WHERE dat.patronID = C.patronID) AS countOfSold
FROM dataTable C

```


### Subquery in `FROM` Clause
```sql
SELECT C.patronID,
 firstName,
 lastName,
 countOfSold
FROM dataTable C
 JOIN (SELECT patronID,
 SUM(quantity * price) AS countOfSold
	 FROM dataTable dat
		JOIN otherDataTable oDat
 ON dat.primaryKey = oDat.primaryKey
 GROUP BY patronID) SumQuery
 ON C.patronID = SumQuery.patronID
```

###  Subqueries in `HAVING` Clause
```sql
SELECT grouping,
 AVG(price)
FROM dataTable
WHERE Color = 'Yellow'
GROUP BY grouping
HAVING AVG(price) <
   (SELECT AVG(price)
    FROM dataTable
    WHERE Color = 'Yellow')
```

### Subqueries and Aggregate Functions
```sql
SELECT firstName, lastName, taxBracket
FROM staffTable sT JOIN staffWages sW ON sT.staffID = sW.staffID
WHERE taxBracket >
 (SELECT AVG(taxBracket)
 FROM staffWages)
```

### Correlated Subqueries
```sql
-- Find dataTable that has higher list price based on condition than other product
SELECT  facilityID, 
        dataTableID, 
        dataTableName, 
        price 
FROM    dataTable dT1  
WHERE   price > 	(SELECT AVG(price)
						FROM   dataTable dT2 
                        WHERE  dT2.facilityID = dT1.facilityID)
ORDER BY facilityID
```

### Subquery - Longer Example 1
```sql
-- Did more men OR women work in January 2018 and from which company did these employees (that worked in January) originate?

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
  p.employee_id  =  e.employee_id 
  AND p.period >= #1/1/2018# 
  AND p.period < #2/1/2018# 
 
 GROUP BY e.employee_id, e.gender, e.company)  AS [%$##@_Alias]

GROUP BY e.company, e.gender;

```

### Subquery - Longer Example 2

```sql
-- Which store had the most employees? Please include the city and state.

SELECT 
 s.city, s.state, 
 COUNT (e.employee_id) AS Emp_COUNT

FROM 
 Stores AS s, 
 employee_info AS e

WHERE 
 s.store_id  =  e.store_id

GROUP BY s.city, s.state
 HAVING COUNT (e.employee_id)  =  (
  SELECT MAX(emp_count)
  FROM (
    SELECT 
     s.city, 
     s.state, 
     COUNT (e.employee_id) AS emp_count
    FROM 
     Stores AS s, 
     employee_info AS e

    WHERE 
     s.store_id  =  e.store_id

    GROUP BY 
     s.city, s.state));

```

## `UNION`S

### `UNION` - View All Unique City Names `FROM` Both Tables


```sql
-- Select city name
SELECT city 

-- From dataTable table
FROM dataTable

-- Then combine with
UNION

-- Select city names
SELECT city 

-- From otherDataTable table
FROM otherDataTable;
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



### `UNION ALL` - View All City Names `FROM` Both Tables


```sql
-- Select city name
SELECT city 

-- From dataTable table
FROM dataTable

-- Then combine with
UNION ALL

-- Select city names
SELECT city 

-- From otherDataTable table
FROM otherDataTable;
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


### Copy Contents Of First Table Into Empty Table


```sql
-- Insert into the empty table
INSERT INTO dataTable

-- Everything
SELECT * 

-- From the first table
FROM otherDataTable;
```


### Create An Index Using the Column 'pid' As the Unique ID


```sql
-- Create a index called uid
CREATE INDEX uid

-- For the table 'dataTable' and the column 'pid'
ON dataTable (pid)
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
2. Read the raw data file into SQL's memory

To do step 1, type the following:
```sql
CREATE TABLE dataTable(
  "var1" CHAR,
  "var2" INTEGER,
  ...
  "varN" REAL 
);
where `dataTable` is whatever you want to call your database in SQL.
```

To do step 2, type the following:
```sql
.mode csv
.import /path/to/file.csv dataTable
```

### Saving data while using SQL
If one wants to save a database in SQL, the file extension is `.sqlite3` (but in principle you can use whatever you want). the way to save data is to issue the `.dump` command:

```sql
.output dataTable.sqlite3
.dump
```
the result will be a text file with SQL code in it that will recreate the table you dumped.








