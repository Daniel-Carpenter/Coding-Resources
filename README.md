# Quick Resources Below

*PLEASE NOTE THAT THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20). This repo is unlinked with my personal additions.*

## Visualization and User Interfaces

### ggplot2 Quick Code for Copying and Pasting
```r
library(tidyverse)
library(ggthemes)

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
	  
  # Theme
	theme_minimal() +
	  
  # Labels
	labs(title = "",
		 subtitle = "",
		 caption = "",
		 tag = "Figure 1",
		 x = "",
		 y = "")
	  
  # Save Image
	ggsave("imageTitle.pdf", path = "", width = 10, height = 7)	
```
	
	

### ggplot2 Plus Shiny [from Wickham](https://mastering-shiny.org/action-graphics.html#cached-plots)
#### Example Includes Regression 
```r
library(shiny)

# Select a dataset
	df <- mtcars 

# Create User Interface
	ui <- fluidPage(
		# x Axis Input Validation
			selectInput("x", "X Axis Title", 
						choices = names(df), 	# Variable names to include in validation (var names from df)
						selected = "wt), 	# Default variable selected in validation
		# y Axis Input Validation
			selectInput("y", "Y Axis Title", 
						choices = names(df), 	# Variable names to include in validation (var names from df)
						selected = "price"),	# Default variable selected in validation
		# Call plot from "server" below
			plotOutput("plot")				# Name you define after "output$" in "server" below
			)

# Create Server (Where you generate output, called in User Interface)
	server <- function(input, output, session) {
		# Create Plot using ggplot2
			output$plot <- renderCachedPlot(
			{
				ggplot(df, 
					aes(
						.data[[input$x]], 
						.data[[input$y]])) 
					+ geom_point()
			},
			cacheKeyExpr = list(input$x, input$y))
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


## Git and Command Line
### Git from the Command Line
| Functionality                                               | Git Command                                                      |
|-------------------------------------------------------------|------------------------------------------------------------------|
| Pull to Fork                                                | `git pull`                                                       |
| Add and Commit all Changes                                  | `git add -A`                                                     |
| Push committed changes updstream                            | `git push origin master`                                         |
		
	
	
### Command Line Functions
| Command                                              | Unix                                                                                                         | DOS                                                                                                                              |
|------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| Change directory                                     | `cd <directory path>` (could be relative path)                                                                 | `cd `                                                                                                                              |
| List files in directory                              | `ls  `                                                                                                         | `dir`                                                                                                                              |
| Move up one level in directory structure             | `cd .. `                                                                                                       | `cd ..`                                                                                                                            |
| Create new directory                                 | `mkdir`                                                                                                        | `md`                                                                                                                              |
| Create new file                                      | `touch filename`                                                                                               | `copy con filename`                                                                                                               |
| List current processes                               | `ps`                                                                                                           | `tasklist`                                                                                                                         |
| Kill a running process                               | `kill <process id>`                                                                                            | `Taskkill /PID <process id> /F  `                                                                                                  |
| Connect to remote machine via secure shell           | `ssh -p <port number> <user@hostname>`                                                                         | `<path to PuTTY.exe> -ssh <username@host> <port number>  `                                                                         |
| Transfer files to a remote machine (via Secure Copy) | `scp [options] <username1@source_host:directory1/filename1> <username2@destination_host:directory2/filename2>` | `pscp -scp [options] <username1@source_host:directory1/filename1> <username2@destination_host:directory2/filename2>`              |
| Submit a batch script                                | `srun <filename.sh>`                                                                                           | unlikely to do this. If need to, see [here](https://stackoverflow.com/questions/26522789/how-to-run-sh-on-windows-command-prompt) |



### Git and Command Line Resources
* [Pimp my Editor](http://slides.com/nicklang/pimp-my-editor#/) (Sublime Text focused, but may similar plug-ins/features available in Npp, Atom, or Vim)
* [Unix commands](https://files.fosswire.com/2007/08/fwunixref.pdf)
* [DOS commands](https://en.wikipedia.org/wiki/List_of_DOS_commands)
* [Git Basics](https://www.youtube.com/watch?v=U8GBXvdmHT4)
* [Git Workflows](http://blog.endpoint.com/2014/05/git-workflows-that-work.html)


## Some Functions
### `group_by`
```r
df <- df %>%
	group_by(x) %>%
	summarise(y = sum(y))
```


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

