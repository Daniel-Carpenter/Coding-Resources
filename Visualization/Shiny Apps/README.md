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
}

```