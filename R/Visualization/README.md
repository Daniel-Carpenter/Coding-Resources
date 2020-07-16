## Visualization and User Interfaces (Quick Code)

### Graphs - `ggplot2` Starter Code

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
	  
  # Facet Graph by Variables
	facet_grid(	rows = vars(var1),
				cols = vars(var2)) +
  
  # Graph Labels
	labs(title = "",
		 subtitle = "",
		 caption = "",
		 tag = "Figure 1",
		 x = "",
		 y = "") +
	  
  # Save Image
	ggsave("imageTitle.pdf", path = "", width = 10, height = 7)	
```
	
### User Interfaces - `shiny` Starter Code [from Wickham](https://mastering-shiny.org/action-workflow.html#getting-help)
* [Link to Wickham's `shiny` Tutorial](https://mastering-shiny.org/)


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
