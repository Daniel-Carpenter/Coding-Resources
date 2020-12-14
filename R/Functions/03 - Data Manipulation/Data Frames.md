
# Data Frames

## Referencing `Data Frames`

### Indexing rows and cols

> Input

```r
# Create df
df <- mtcars

# show df
head(df)

# fourth row, third column
df[4, 3]
```

> Output

```txt
> head(df)
                   mpg cyl disp  hp drat    wt  qsec vs am gear carb
Mazda RX4         21.0   6  160 110 3.90 2.620 16.46  0  1    4    4
Mazda RX4 Wag     21.0   6  160 110 3.90 2.875 17.02  0  1    4    4
Datsun 710        22.8   4  108  93 3.85 2.320 18.61  1  1    4    1
Hornet 4 Drive    21.4   6  258 110 3.08 3.215 19.44  1  0    3    1
Hornet Sportabout 18.7   8  360 175 3.15 3.440 17.02  0  0    3    2
Valiant           18.1   6  225 105 2.76 3.460 20.22  1  0    3    1

> # fourth row, third column
> df[4, 3]
[1] 258
```

#### Indexing rows

> Input

```r
# Only fourth row
df[4, 0]
```

> Ouput

```txt
> df[4, ]
                mpg cyl disp  hp drat    wt  qsec vs am gear carb
Hornet 4 Drive 21.4   6  258 110 3.08 3.215 19.44  1  0    3    1
```

#### Indexing Columns

> Input

```r
# Only fourth col
df[ , 4]
```

> Ouput

```txt
> df[ , 4]
 [1] 110 110  93 110 175 105 245  62  95 123 123 180 180 180 205 215 230  66  52  65  97 150 150 245 175  66  91 113 264 175 335 109
```

## `subset`ting

### `subset` with condition

> Input

```r
df <- mtcars

# Mpg greater than twenty and horse power greater than 110
subset(df, mpg > 20 & hp < 110, )
```

> Ouput

```txt
> subset(df, mpg > 20 & hp < 110, )
                mpg cyl  disp  hp drat    wt  qsec vs am gear carb
Datsun 710     22.8   4 108.0  93 3.85 2.320 18.61  1  1    4    1
Merc 240D      24.4   4 146.7  62 3.69 3.190 20.00  1  0    4    2
Merc 230       22.8   4 140.8  95 3.92 3.150 22.90  1  0    4    2
Fiat 128       32.4   4  78.7  66 4.08 2.200 19.47  1  1    4    1
Honda Civic    30.4   4  75.7  52 4.93 1.615 18.52  1  1    4    2
Toyota Corolla 33.9   4  71.1  65 4.22 1.835 19.90  1  1    4    1
Toyota Corona  21.5   4 120.1  97 3.70 2.465 20.01  1  0    3    1
Fiat X1-9      27.3   4  79.0  66 4.08 1.935 18.90  1  1    4    1
Porsche 914-2  26.0   4 120.3  91 4.43 2.140 16.70  0  1    5    2
Volvo 142E     21.4   4 121.0 109 4.11 2.780 18.60  1  1    4    2
```

### `subset` with Condition while only showing certain cols

> Input

```r
# Mpg greater than twenty and horse power greater than 110
# While only showing cols mpg and hp
subset(df, mpg > 20 & hp < 110, c(mpg, hp))
```

> Ouput

```txt
> subset(df, mpg > 20 & hp < 110, c(mpg, hp))
                mpg  hp
Datsun 710     22.8  93
Merc 240D      24.4  62
Merc 230       22.8  95
Fiat 128       32.4  66
Honda Civic    30.4  52
Toyota Corolla 33.9  65
Toyota Corona  21.5  97
Fiat X1-9      27.3  66
Porsche 914-2  26.0  91
Volvo 142E     21.4 109
```

# `with` filtering

> Input

```r
# Mpg greater than twenty and horse power greater than 110
with(df, df[mpg > 20 & hp < 110, ])
```

> Ouput

```txt
> with(df, df[mpg > 20 & hp < 110, ])
                mpg cyl  disp  hp drat    wt  qsec vs am gear carb
Datsun 710     22.8   4 108.0  93 3.85 2.320 18.61  1  1    4    1
Merc 240D      24.4   4 146.7  62 3.69 3.190 20.00  1  0    4    2
Merc 230       22.8   4 140.8  95 3.92 3.150 22.90  1  0    4    2
Fiat 128       32.4   4  78.7  66 4.08 2.200 19.47  1  1    4    1
Honda Civic    30.4   4  75.7  52 4.93 1.615 18.52  1  1    4    2
Toyota Corolla 33.9   4  71.1  65 4.22 1.835 19.90  1  1    4    1
Toyota Corona  21.5   4 120.1  97 3.70 2.465 20.01  1  0    3    1
Fiat X1-9      27.3   4  79.0  66 4.08 1.935 18.90  1  1    4    1
Porsche 914-2  26.0   4 120.3  91 4.43 2.140 16.70  0  1    5    2
Volvo 142E     21.4   4 121.0 109 4.11 2.780 18.60  1  1    4    2
```

## Creating `Data Frames`

### Create `df` from `list`

> Input

```r
# Create a list with same number of "rows"
lst <- list(x = 1:4,
            y = 11:14,
            z = 21:24)

# Create Data frame from list
df <- as.data.frame(lst)

# Print
df
```

> Ouput

```txt
> df
  x  y  z
1 1 11 21
2 2 12 22
3 3 13 23
4 4 14 24
```

### Summarize data in frequency table

> Input

```r
# Counts unique occurrences with x variable
as.data.frame(table(df$x))
```

> Ouput

```txt
> as.data.frame(table(df$x))
  Var1 Freq
1    1    1
2    2    1
3    3    1
4    4    1
```

## Manipulating `df`

### `order`ing (sort)

> Input

```r
df <- mtcars

with(df, df[order(mpg), ])
df
```

> Ouput

```txt
> with(df, df[order(mpg), ])
                     mpg cyl  disp  hp drat    wt  qsec vs am gear carb
Cadillac Fleetwood  10.4   8 472.0 205 2.93 5.250 17.98  0  0    3    4
Lincoln Continental 10.4   8 460.0 215 3.00 5.424 17.82  0  0    3    4
Camaro Z28          13.3   8 350.0 245 3.73 3.840 15.41  0  0    3    4
Duster 360          14.3   8 360.0 245 3.21 3.570 15.84  0  0    3    4
Chrysler Imperial   14.7   8 440.0 230 3.23 5.345 17.42  0  0    3    4
Maserati Bora       15.0   8 301.0 335 3.54 3.570 14.60  0  1    5    8
Merc 450SLC         15.2   8 275.8 180 3.07 3.780 18.00  0  0    3    3
```

### `unique` cahracteristics of `df` 

> Input

```r
df <- mtcars

as.data.frame(with(df, unique(hp)))
```

> Ouput

```txt
> as.data.frame(with(df, unique(hp)))
   with(df, unique(hp))
1                   110
2                    93
3                   175
4                   105
5                   245
6                    62
7                    95
8                   123
9                   180
10                  205
11                  215
12                  230
13                   66
14                   52
15                   65
16                   97
17                  150
18                   91
19                  113
20                  264
21                  335
22                  109
```

### Summarize `df`

> Input

```r
df <- as.data.frame(USArrests)

# Print raw
df

# Print summary
summary(df)
```

> Ouput

```txt
> # Print raw
> df
               Murder Assault UrbanPop Rape
Alabama          13.2     236       58 21.2
Alaska           10.0     263       48 44.5
Arizona           8.1     294       80 31.0
Arkansas          8.8     190       50 19.5
California        9.0     276       91 40.6
Colorado          7.9     204       78 38.7
Connecticut       3.3     110       77 11.1
Delaware          5.9     238       72 15.8
Florida          15.4     335       80 31.9
Georgia          17.4     211       60 25.8
Hawaii            5.3      46       83 20.2
Idaho             2.6     120       54 14.2
Illinois         10.4     249       83 24.0
Indiana           7.2     113       65 21.0
Iowa              2.2      56       57 11.3
Kansas            6.0     115       66 18.0
Kentucky          9.7     109       52 16.3
Louisiana        15.4     249       66 22.2
Maine             2.1      83       51  7.8
Maryland         11.3     300       67 27.8
Massachusetts     4.4     149       85 16.3
Michigan         12.1     255       74 35.1
Minnesota         2.7      72       66 14.9
Mississippi      16.1     259       44 17.1
Missouri          9.0     178       70 28.2
Montana           6.0     109       53 16.4
Nebraska          4.3     102       62 16.5
Nevada           12.2     252       81 46.0
New Hampshire     2.1      57       56  9.5
New Jersey        7.4     159       89 18.8
New Mexico       11.4     285       70 32.1
New York         11.1     254       86 26.1
North Carolina   13.0     337       45 16.1
North Dakota      0.8      45       44  7.3
Ohio              7.3     120       75 21.4
Oklahoma          6.6     151       68 20.0
Oregon            4.9     159       67 29.3
Pennsylvania      6.3     106       72 14.9
Rhode Island      3.4     174       87  8.3
South Carolina   14.4     279       48 22.5
South Dakota      3.8      86       45 12.8
Tennessee        13.2     188       59 26.9
Texas            12.7     201       80 25.5
Utah              3.2     120       80 22.9
Vermont           2.2      48       32 11.2
Virginia          8.5     156       63 20.7
Washington        4.0     145       73 26.2
West Virginia     5.7      81       39  9.3
Wisconsin         2.6      53       66 10.8
Wyoming           6.8     161       60 15.6

> # Print summary
> summary(df)
     Murder          Assault         UrbanPop          Rape      
 Min.   : 0.800   Min.   : 45.0   Min.   :32.00   Min.   : 7.30  
 1st Qu.: 4.075   1st Qu.:109.0   1st Qu.:54.50   1st Qu.:15.07  
 Median : 7.250   Median :159.0   Median :66.00   Median :20.10  
 Mean   : 7.788   Mean   :170.8   Mean   :65.54   Mean   :21.23  
 3rd Qu.:11.250   3rd Qu.:249.0   3rd Qu.:77.75   3rd Qu.:26.18  
 Max.   :17.400   Max.   :337.0   Max.   :91.00   Max.   :46.00  
```

### Summary of Each Category

> Input

```r
categoryVar = "UrbanPop"

by(USArrests, USArrests[categoryVar], summary)
```

> Output

```txt

UrbanPop: 32
     Murder       Assault      UrbanPop       Rape     
 Min.   :2.2   Min.   :48   Min.   :32   Min.   :11.2  
 1st Qu.:2.2   1st Qu.:48   1st Qu.:32   1st Qu.:11.2  
 Median :2.2   Median :48   Median :32   Median :11.2  
 Mean   :2.2   Mean   :48   Mean   :32   Mean   :11.2  
 3rd Qu.:2.2   3rd Qu.:48   3rd Qu.:32   3rd Qu.:11.2  
 Max.   :2.2   Max.   :48   Max.   :32   Max.   :11.2  
---------------------------------------------------------------------------------------------------- 
UrbanPop: 39
     Murder       Assault      UrbanPop       Rape    
 Min.   :5.7   Min.   :81   Min.   :39   Min.   :9.3  
 1st Qu.:5.7   1st Qu.:81   1st Qu.:39   1st Qu.:9.3  
 Median :5.7   Median :81   Median :39   Median :9.3  
 Mean   :5.7   Mean   :81   Mean   :39   Mean   :9.3  
 3rd Qu.:5.7   3rd Qu.:81   3rd Qu.:39   3rd Qu.:9.3  
 Max.   :5.7   Max.   :81   Max.   :39   Max.   :9.3  
---------------------------------------------------------------------------------------------------- 
UrbanPop: 44
     Murder          Assault         UrbanPop       Rape      
 Min.   : 0.800   Min.   : 45.0   Min.   :44   Min.   : 7.30  
 1st Qu.: 4.625   1st Qu.: 98.5   1st Qu.:44   1st Qu.: 9.75  
 Median : 8.450   Median :152.0   Median :44   Median :12.20  
 Mean   : 8.450   Mean   :152.0   Mean   :44   Mean   :12.20  
 3rd Qu.:12.275   3rd Qu.:205.5   3rd Qu.:44   3rd Qu.:14.65  
 Max.   :16.100   Max.   :259.0   Max.   :44   Max.   :17.10  
---------------------------------------------------------------------------------------------------- 
UrbanPop: 45
     Murder        Assault         UrbanPop       Rape      
 Min.   : 3.8   Min.   : 86.0   Min.   :45   Min.   :12.80  
 1st Qu.: 6.1   1st Qu.:148.8   1st Qu.:45   1st Qu.:13.62  
 Median : 8.4   Median :211.5   Median :45   Median :14.45  
 Mean   : 8.4   Mean   :211.5   Mean   :45   Mean   :14.45  
 3rd Qu.:10.7   3rd Qu.:274.2   3rd Qu.:45   3rd Qu.:15.28  
 Max.   :13.0   Max.   :337.0   Max.   :45   Max.   :16.10  
---------------------------------------------------------------------------------------------------- 
```



