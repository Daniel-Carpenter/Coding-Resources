boxplotFunction<- function(df, 
                           xVar, yVar, colorVar,
                           facetRowVar, facetColVar,
                           switchY,
                           ...) 
{
  ggplot(
        # Data Frame
          data = df,
          
        # X and Y Variables
          aes(x = xVar,
              y = yVar,
              color = colorVar,
              ...)
        ) +
          
        # Graph Type
          geom_boxplot(alpha  = 1/2) +
          
        # Facet Facilities
          facet_grid(rows = vars(facetRowVar),
                     cols = vars(facetColVar),
                     ...) + 
          
        # Graph Theme
          theme_get() #+
          
        # # Graph Color
        #   scale_colour_brewer(type    = "qual", 
        #                       palette = 3,
        #                       direction = 1)
}