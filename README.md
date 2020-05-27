PLEASE NOTE THAT THIS REPO IS PARSED FROM [TYLER RANSOM](http://tyleransom.github.io)'S MASTER REPO LOCATED [HERE](https://github.com/tyleransom/DScourseS20). This repo is unlinked with my personal additions.

## Visualization and User Interfaces
### ggplot2 Quick Code for Copying and Pasting
```r
	library(tidyverse)
	library(ggthemes)

	ggplot(
	  # Date Frame
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
```r
	library(shiny)

	ui <- fluidPage(
	  selectInput("x", "X Axis Title", 
					choices = names(df), 
					selected = "carat"),
	  selectInput("y", "Y Axis Title", 
					choices = names(df), 
					selected = "price"),
	  plotOutput("plot")
	)

	server <- function(input, output, session) {
	  output$plot <- renderCachedPlot(
	  {
		ggplot(df, 
				aes(.data[[input$x]], 
					.data[[input$y]])) + 
					geom_point()
	  },
	  cacheKeyExpr = list(input$x, input$y))
```
	 
## Some Useful Packages for LaTeX Tables
```r
	library(stargazer)
	library(xtable)
	library(huxtable)
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

### Resources
* [Pimp my Editor](http://slides.com/nicklang/pimp-my-editor#/) (Sublime Text focused, but may similar plug-ins/features available in Npp, Atom, or Vim)
* [Unix commands](https://files.fosswire.com/2007/08/fwunixref.pdf)
* [DOS commands](https://en.wikipedia.org/wiki/List_of_DOS_commands)
* [Git Basics](https://www.youtube.com/watch?v=U8GBXvdmHT4)
* [Git Workflows](http://blog.endpoint.com/2014/05/git-workflows-that-work.html)

## Some Functions
### Group By
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
* [Mastering Shiny](https://mastering-shiny.org/)
		
### LaTeX
* [LaTeX math symbols](http://web.ift.uib.no/Teori/KURS/WRK/TeX/symALL.html)
* [Typesetting equations in TeX](http://moser-isi.ethz.ch/docs/typeset_equations.pdf)
* [Beamer Templates](https://www.overleaf.com/gallery/tagged/presentation)

### Linear Algebra
#### Books
* [Matrix Cookbook](https://www.math.uwaterloo.ca/~hwolkowi/matrixcookbook.pdf)
* [No bullshit guide to linear algebra](https://minireference.com/static/excerpts/noBSguide2LA_preview.pdf)
* [Linear Algebra | Interactive Zybook](https://learn.zybooks.com/zybook/LinearAlgebraR58)
	
#### Reference Notes
* [Everything Matrix](https://matrixcalc.org/en/)
* [Least Squares](https://web.stanford.edu/~mrosenfe/soc_meth_proj3/matrix_OLS_NYU_notes.pdf)
* [Steps to Solving Eigenvalues and Eigenvectors](https://matrixcalc.org/en/vectors.html#eigenvectors%28%7B%7B3,4%7D,%7B4,9%7D%7D%29)
* [Steps to Solving Pseudoinverse of a Matrix](https://atozmath.com/MatrixEv.aspx?q=pseudoinverse&q1=2%2c-1%3b4%2c-2%3b-2%2c1%60pseudoinverse%60&dm=F&dp=8&do=1#PrevPart)
* [SVM (Principal Component Analysis)](https://github.com/tyleransom/DScourseS20/blob/master/MachineLearning/UnsupervisedLearning.md)
* [Find Basis and dimension of Matrix](https://learn.zybooks.com/zybook/LinearAlgebraR58/chapter/4/section/4?content_resource_id=37834906)
* [Quick Guide to When Matrix Multiplation is Undefined](https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:matrices/x9e81a4f98389efdf:properties-of-matrix-multiplication/a/matrix-multiplication-dimensions)
* [Find C(A) and N(A)](https://www.mathdetail.com/solution.php)
* [Determine if cols form linearly independent set](https://www.youtube.com/watch?v=Vb15ChrXZHs)
* [Show Vectors as Linear Combination](https://www.google.com/search?q=how+to+show+that+something+is+a+linear+combination+of+other+vectors&oq=how+to+show+that+something+is+a+linear+combination+&aqs=chrome.1.69i57j33.10895j0j7&sourceid=chrome&ie=UTF-8#kpvalbx=_g_imXuugMIyqsgWn6qQw47)
