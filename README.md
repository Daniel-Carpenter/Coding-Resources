# Quick Resources Below

*PLEASE NOTE THAT THIS REPO HAS SOME EXAMPLES AND MANY CONCEPTUAL NOTES FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20). I have indicated when it is not my own work. Othwerwise, this repo is unlinked with my personal additions for my personal reference.*


## Data Cleaning and Mutation

### `tidyverse`
* `tidyverse` [Cheat Sheet](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/R%20Cheat%20Sheet.pdf)
* `tidyverse` [In Depth Notes](https://raw.githack.com/uo-ec607/lectures/master/05-tidyverse/html_document/05-tidyverse.html#tidyverse_basics)
* `tidyr`'s [Tutorial](https://cran.r-project.org/web/packages/tidyr/vignettes/tidy-data.html) 


### `dplyr`
* `dplyr` [Cheat Sheet - Reshaping, Summarising, Grouping, etc.](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/dplyr%20Cheat%20Sheet.pdf)
* [Joining Tibbles and Dataframes Together](https://rpubs.com/williamsurles/293454) 
* [`MUTATE` plus `if_else()`](https://rstudio-pubs-static.s3.amazonaws.com/116317_e6922e81e72e4e3f83995485ce686c14.html#/5)

### Useful Packages
* `lubridate` [Cheat Sheet - Using and Altering **Dates**](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/Lubridate%20Cheat%20Sheet.pdf)

### Pulling in Data
* `readr` [Cheat Sheet - Importing Data](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/Importing%20Data%20Cheat%20Sheet.pdf)
* `R.cache` Package - In-Memory Data Loading [documentation here](https://cran.r-project.org/web/packages/R.cache/R.cache.pdf)

```r
library(R.cache)

# 'evalWithMemoization()' Function Stores the Data Read in your Cache Memory
# This method makes rerunning code much faster for large files

df <- evalWithMemoization(read.csv("fileNameGoesHere.csv"))
	
````

## Visualization and User Interfaces

### Graphs - `ggplot2` Starter Code

* `ggplot2` [Cheat Sheet](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/GGPlot%20Cheat%20Sheet.pdf) 

```r
library(tidyverse) 	# Includes ggplot2
library(ggthemes)	# Optional Themes

ggplot(
  # Data Frame
	data = ,
			
  # X and Y Variables
		aes(
		   x = ,
		   y = ,
	color = )) +
	  
  # Graph Type
	geom_point() +
	  
  # Graph Theme
	theme_minimal() +
	  
  # Graph Labels
	labs(title = "",
		 subtitle = "",
		 caption = "",
		 tag = "Figure 1",
		 x = "",
		 y = "")
	  
  # Save Image
	ggsave("imageTitle.pdf", path = "", width = 10, height = 7)	
```
	
### User Interfaces - `shiny` Starter Code [from Wickham](https://mastering-shiny.org/action-workflow.html#getting-help)
* [Link to Wickham's `shiny` Tutorial](https://mastering-shiny.org/)
* `shiny` [Cheat Sheet](https://github.com/Daniel-Carpenter/R-Resources/blob/master/-%20Cheat%20Sheets/Shiny%20Cheat%20Sheet.pdf)

```r
library(shiny)

# INPUT: Create the User Interface and Inputs -------------------------------------------------
	ui <- fluidPage(
		  selectInput("n", "N", 1:10),
		  plotOutput("plot")
			)
	
# CREATE SERVER (Where you generate output, called in User Interface) ------------------------------
	server <- function(input, output, session) 
	{
	# Create Plot
		  output$plot <- renderPlot(
		  {
		    n <- input$n * 2
		    plot(head(cars, n))
		  })
	}
	
# LAUNCH APP ----------------------------------------------------------------------------------------
	shinyApp(ui, server)

```


## Some Useful Packages for LaTeX Regression Outputs and Tables [Source Here](https://declaredesign.org/r/estimatr/articles/regression-tables.html)

### Setup with Regressions
```r
library(estimatr)
library(magrittr)
```


### LaTeX Table Packages
```r
# lm - stargazer
	library(stargazer)
	stargazer(est.1, est.2, se = starprep(est.1, est.2))

# tidy() - xtable or huxtable
	library(xtable)
	xtable(tidy(est))

	library(huxtable)
	library(xtable)
	huxtable(tidy(est))

# lm_robust - texreg
	library(texreg)
	texreg(est, include.ci = FALSE)
```


## Some Functions

### Optimize with `Rglpk` Package
```r
library(Rglpk)
	
# Objecttive Function
obj <- c(2, 4, 3)
	
# Input Matrix
mat <- matrix(c(3, 2, 1, 4, 1, 3, 2, 2, 2), nrow = 3)
	
# Constraint Direction
dir <- c("<=", "<=", "<=")
	
# Constraint Values
rhs <- c(60, 40, 80)
	
# Maximize?
max <- TRUE
	
# Solve
Rglpk_solve_LP(obj, mat, dir, rhs, max = max)
```

### `unique`
```r
unique(rownames(mtcars))
```
Yields unique categories in the variable, or in this case rows:
```
 [1] "Mazda RX4"           "Mazda RX4 Wag"       "Datsun 710"          "Hornet 4 Drive"      "Hornet Sportabout"   "Valiant"             "Duster 360"         
 [8] "Merc 240D"           "Merc 230"            "Merc 280"            "Merc 280C"           "Merc 450SE"          "Merc 450SL"          "Merc 450SLC"        
[15] "Cadillac Fleetwood"  "Lincoln Continental" "Chrysler Imperial"   "Fiat 128"            "Honda Civic"         "Toyota Corolla"      "Toyota Corona"      
[22] "Dodge Challenger"    "AMC Javelin"         "Camaro Z28"          "Pontiac Firebird"    "Fiat X1-9"           "Porsche 914-2"       "Lotus Europa"       
[29] "Ford Pantera L"      "Ferrari Dino"        "Maserati Bora"       "Volvo 142E"         
```

### `group_by` and `summarise`
```r
    df <- df %>%
	# Grouping
		group_by(department) %>%
	
	# Aggregation
		summarise(wages = sum(Wages)) %>%
		summarise(hours = sum(Hours))
```



## Other Useful Links
	
	
### R Books
* [Advanced R ed. 1 | Wickham](http://adv-r.had.co.nz/)
* [Advanced R ed. 2 | Wickham](https://adv-r.hadley.nz/)
* [R for Data Science | Wickham](https://r4ds.had.co.nz/)
* [Data Analytics in R | Interactive Zybook](https://learn.zybooks.com/zybook/FundamentalsOfDataAnalyticsRR2)
	

### R Packages
* [Mastering **Shiny**](https://mastering-shiny.org/)


### R Notes
* [R **data wrangling** cheatsheet](https://www.rstudio.com/wp-content/uploads/2015/02/data-wrangling-cheatsheet.pdf)
* [R **tidyverse**](https://www.tidyverse.org)
	
	
### LaTeX
* [LaTeX math symbols](http://web.ift.uib.no/Teori/KURS/WRK/TeX/symALL.html)
* [Typesetting equations in TeX](http://moser-isi.ethz.ch/docs/typeset_equations.pdf)
* [**Beamer** Templates](https://www.overleaf.com/gallery/tagged/presentation)


### Linear Algebra
#### Linear Algebra Books
* [Matrix Cookbook](https://www.math.uwaterloo.ca/~hwolkowi/matrixcookbook.pdf)
* [No bullshit guide to linear algebra](https://minireference.com/static/excerpts/noBSguide2LA_preview.pdf)
* [Linear Algebra | Interactive Zybook](https://learn.zybooks.com/zybook/LinearAlgebraR58)
* The Master Algorithm ([Amazon link](https://www.amazon.com/Master-Algorithm-Ultimate-Learning-Machine-ebook/dp/B012271YB2))	
	
#### Linear Algebra Reference Notes
* [Everything Matrix](https://matrixcalc.org/en/)
* [**Least Squares**](https://web.stanford.edu/~mrosenfe/soc_meth_proj3/matrix_OLS_NYU_notes.pdf)
* [Steps to Solving **Eigenvalues and Eigenvectors**](https://matrixcalc.org/en/vectors.html#eigenvectors%28%7B%7B3,4%7D,%7B4,9%7D%7D%29)
* [Steps to Solving **Pseudoinverse** of a Matrix](https://atozmath.com/MatrixEv.aspx?q=pseudoinverse&q1=2%2c-1%3b4%2c-2%3b-2%2c1%60pseudoinverse%60&dm=F&dp=8&do=1#PrevPart)
* [SVM (**Principal Component Analysis**)](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/UnsupervisedLearning.md)
* [Find **Basis and dimension** of Matrix](https://learn.zybooks.com/zybook/LinearAlgebraR58/chapter/4/section/4?content_resource_id=37834906)
* [Quick Guide to When Matrix Multiplation is **Undefined**](https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:matrices/x9e81a4f98389efdf:properties-of-matrix-multiplication/a/matrix-multiplication-dimensions)
* [Find **C(A)** and **N(A)**](https://www.mathdetail.com/solution.php)
* [Determine if cols form **linearly independent set**](https://www.youtube.com/watch?v=Vb15ChrXZHs)
* [Show Vectors as **Linear Combination**](https://www.google.com/search?q=how+to+show+that+something+is+a+linear+combination+of+other+vectors&oq=how+to+show+that+something+is+a+linear+combination+&aqs=chrome.1.69i57j33.10895j0j7&sourceid=chrome&ie=UTF-8#kpvalbx=_g_imXuugMIyqsgWn6qQw47)


### Other Notes on Data Science, Programming, and Statistical Coding
* [Notes on Machine Learning & Artificial Intelligence](https://chrisalbon.com) by Chris Albon
* [Machine Learning "Mind Map"](https://github.com/dformoso/machine-learning-mindmap/blob/master/Machine%20Learning.pdf)
* [Julia vs. Python for Data Science](https://www.infoworld.com/article/3241107/python/julia-vs-python-julia-language-rises-for-data-science.html)
* Julia for Data Science ([Amazon link](https://www.amazon.com/Julia-Data-Science-Zacharias-Voulgaris/dp/1634621301))
* Data Science at the Command Line ([Free eBook](https://www.datascienceatthecommandline.com/))



## Materials from ([Tyler Ransom](http://tyleransom.github.io)'s [DScourseS20](https://github.com/tyleransom/DScourseS20).
|Topic|
|--------------------------------------------------------------|
|What is data science / big data / why is it important? ([Slides](https://github.com/tyleransom/DScourseS20/blob/master/CourseIntro/WhatIsDataScience.pdf))|
|**Git, GitHub**, computing environment, and Coding best practices ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/Productivity/README.md)) and [Slides](https://raw.githack.com/uo-ec607/lectures/master/02-git/02-Git.html#1) by Grant McDermott|
|Linux **command line** (Grant McDermott's [slides](https://raw.githack.com/uo-ec607/lectures/master/03-shell/03-shell.html#1)), SSH, accessing OSCER ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/Productivity/README.md)); Git Tutorial (p. 19 [here](https://github.com/tyleransom/DScourseS20/blob/master/Productivity/git_tutorial.pdf); adding upstream repositories [here](https://happygitwithr.com/upstream-changes.html))|
|Overview of Data Scientists' tools ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/DatabaseMgmt/README.md))|
|Using data: data types, storage ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/DatabaseMgmt/DataTypes.md))|
|Big Data: SQL ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/DatabaseMgmt/SQLoverview.md)) & RDDs ([link](https://spark.apache.org/docs/0.9.1/scala-programming-guide.html)); running jobs on the OSCER cluster|
|**Sampling & storing** Big Data ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/DatabaseMgmt/HadoopSpark.md))|
|**Web scraping/APIs** to gather data ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/WebData/README.md); [Grant McDermott's Lecture Notes](https://raw.githack.com/uo-ec607/lectures/master/06-web-css/06-web-css.html#1); [Ethics in Web Scraping](https://towardsdatascience.com/ethics-in-web-scraping-b96b18136f01?gi=cbd35737a79c); [rvest demonstration slides at 2018 useR conference](https://hanjostudy.github.io/Presentations/UseR2018/Rvest/rvest.html#1); [tidyverse cheat sheet](https://github.com/tyleransom/EconometricsLabs/raw/master/tidyRcheatsheet.pdf); [Grant McDermott's Lecture Notes on R language basics](https://raw.githack.com/uo-ec607/lectures/master/04-rlang/04-rlang.html#1))|
|**Web scraping/APIs** to gather data ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/WebData/README.md)); [Grant McDermott's Lecture Notes](https://raw.githack.com/uo-ec607/lectures/master/07-web-apis/07-web-apis.html#1)|
|Intro to **Julia** ([Julia notes](https://github.com/jmxpearson/duke-julia-ssri/blob/master/intro_slides.ipynb); [Ivan Rudik's programming notes](https://rawcdn.githack.com/AEM7130/spring-2020/8a2fbf6e67e90bc64f4abd23800c7d46fa512240/lecture_notes/lecture_2/2a_coding.html#140); [Julia's "Learning Julia" page](https://julialang.org/learning/))|
|**`ggplot2`** ([Basics](https://rpubs.com/arvindpdmn/ggplot2-basics); [Kieran Healy's book](https://socviz.co/lookatdata.html))|
|Getting to know your data: **descriptive statistics, cleaning, tips, tricks, transformations, visualization** ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/Visualization/README.md); [HTML slides](https://github.com/tyleransom/DScourseS20/blob/master/Visualization/slides.html))|
|**Modeling continuous and discrete variables** ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/README.md)) [HTML slides](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/slides.html)); [Simple R script](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/modelingBasics.R)|
|Using **`JuMP`** to optimize cool stuff [[Jupyter Notebook](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/JuMPintro.ipynb); [Julia Code](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/JuMPintro.jl)] (in previous years: Linear Algebra Introduction / Review ([Handout](https://minireference.com/static/tutorials/linear_algebra_in_4_pages.pdf)))|
|Introduction to **optimization** ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/OptimizationIntro.pdf))|
|Writing and **optimizing functions in R**, Python, and Julia ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/OptimizationCodingBasics.md))|
|Writing and **optimizing functions in R**, Python, and Julia ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/OptimizationCodingBasics.md))|
|**Debugging** strategies and simulations ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/ModelingOptimization/SimulationNotes.md))|
|Intro to **Machine Learning** ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/README.md#machine-learning))|
|Supervised ML: **Regularization, measuring model fit, tuning with cross-validation, the elastic net model** ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/README.md#bias-variance-tradeoff))|
|Supervised ML: The 5 Tribes of Machine Learning ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/README.md#the-5-tribes-of-machine-learning))|
|Unsupervised ML: **Clustering** ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/UnsupervisedLearning.md))|
|Unsupervised ML: Dimensionality reduction and reinforcement learning ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/UnsupervisedLearning.md))|
|Machine learning vs. econometrics ([Notes](https://github.com/tyleransom/DScourseS20/blob/master/Structural/README.md))|
|Structural modeling: **static discrete choice** ([Slides](https://github.com/tyleransom/DScourseS20/blob/master/Structural/discreteChoiceSlides.pdf))|
|Structural modeling: **dynamic discrete choice** ([Slides](https://github.com/tyleransom/DScourseS20/blob/master/Structural/discreteChoiceSlides.pdf))|
|Structural modeling: **dynamic discrete choice** ([Slides](https://github.com/tyleransom/DScourseS20/blob/master/Structural/discreteChoiceSlides.pdf))|

