# Shiny Starter Code

* [Link to Wickham's Shiny Tutorial](https://mastering-shiny.org/)

## Starter Code [from Wickham](https://mastering-shiny.org/action-workflow.html#getting-help)
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


## ggplot2 Plus Shiny [from Wickham](https://mastering-shiny.org/action-graphics.html#cached-plots)
### Example Includes Regression 
```r
library(tidyverse) 	# Includes ggplot2
library(shiny)
library(ggthemes)	# Optional Themes

# Select a dataset
  df <- mtcars 

# INPUT: Create the User Interface and Inputs -------------------------------------------------
  ui <- fluidPage(
		# x Axis Input Validation
                    selectInput("x", "X Axis Title", 
                                choices = names(df),	# Variable names to include in validation (var names from df)
                                selected = "wt"),	# Default variable selected in validation
				
		# y Axis Input Validation
                    selectInput("y", "Y Axis Title", 
                                choices = names(df),	# Variable names to include in validation (var names from df)
                                selected = "price"),	# Default variable selected in validation
				
		# Color Input Validation
			selectInput("color", "Define the color of the data points ", 
			choices = names(df),	# Variable names to include in validation (var names from df)
			selected = "cyl"),	# Default variable selected in validation
			
		# Call plot from "server" below
                   plotOutput("plot")			#  Name you define after "output$" in "server" below
                )

# CREATE SERVER (Where you generate output, called in User Interface) ------------------------------
  server <- function(input, output, session) 
  {
    # Create Plot using ggplot2
    output$plot <- renderCachedPlot(
      {
        ggplot(
          # Data Frame 
          df, 
          aes(
            # X and Y Variables
		.data[[input$x]], 
		.data[[input$y]],
		color = .data[[input$color]])) +
        # Graph Type
        	geom_point() +
		geom_smooth() +
        # Graph Theme
	        theme_minimal() 
      },
      
      cacheKeyExpr = list(input$x, input$y))
  }

# LAUNCH APP ----------------------------------------------------------------------------------------
  shinyApp(ui, server)

```
