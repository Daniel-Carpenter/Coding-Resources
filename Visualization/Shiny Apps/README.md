# Shiny Starter Code

* [Link to Wickham's Shiny Tutorial](https://mastering-shiny.org/)

## The Basics [from Wickham](https://mastering-shiny.org/basic-app.html#reactive-expr)
```r
library(shiny)

server <- function(input, output, session) 
{
  dataset <- reactive(
  {
    get(input$dataset, "package:datasets")
  })

  output$summary <- renderPrint(
  {
    summary(dataset())
  })
  
  output$table <- renderTable(
  {
    dataset()
  })
}

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
