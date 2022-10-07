# ==============================================================================
# Goal: Streamline personal colors aesthetic usage
# ==============================================================================

# Install ggplot2 since you will be using it
if(!require(ggplot2)) install.packages('ggplot2'); library(ggplot2)


#' Function that returns palettes or individual colors
#' @param aesthetic Color aesthetic in 'fill', 'fill_low', 'color', 'base', 'text','border','background', or 'grayedOut'
#' @param ... Individual colors, like 'blue', 'red', 'orange'. Or an integer to return a number of colors
#' @param displayNames TRUE if you want to see the names of each color. Default FALSE.
scale_dbc <- function(aesthetic = NULL, ..., displayNames = FALSE) {
  
  # ----------------------------------------------------------------------------

  # Function for formatting the output of the fill, line, and base colors
  # This is done separately just to reduce noise in the file

  # Mainly, this just either displays the names of the colors or not when returing
  # It also allows you to return 1 or all of the colors
  formatReturnColors <- function(colors, thePalette, displayNames) {
    # Return the ENTIRE vector of colors
    if (is.null(colors)) {
      
      # If you need want to see which colors are associated with a hex code
      # Only use this if you just need to know the names
      if (displayNames)
        return (thePalette)
      
      # Else just return the hex code, this is best for functionality
      else 
        return (paste0(thePalette))
    
    # Return a certain number of colors
    } else if (is.numeric(colors)) { 
      
      # If there are more needed colors than the number of colors in the palette
      if (colors > length(thePalette)) {
        warning(paste('There are more bins than there are colors.',
                      'Considering reducing factor count, or remapping to different color aesthetic.') 
        )
      }
      # If you need want to see which colors are associated with a hex code
      # Only use this if you just need to know the names
      if (displayNames) 
        return (thePalette[1:colors])
      
      # Else just return the hex code, this is best for functionality
      else              
        return (paste0(thePalette[1:colors]))
    }
    
    # Return a SINGLE color
    else {
      
      # If you need want to see which colors are associated with a hex code
      # Only use this if you just need to know the names
      if (displayNames) 
        return (thePalette[colors])
      
      # Else just return the hex code, this is best for functionality
      else              
        return (paste0(thePalette[colors]))
    }
  }

  # Fill Colors ----------------------------------------------------------------

  # For example, the fill colors on a bar chart. These are displayed in the style guide

  # Function to retrieve all, some, or one fill color
  # Default returns the entire list of fill colors
  getFillCol <- function(..., displayNames = FALSE) {
    colors <- c(...) # get colors from function params
    
    # Define the fill colors  
    fillPalette <- c(
      'blue'   = '#B8D8EE', 'red'    = '#FFBFBD',
      'green'  = '#B8E3AF', 'purple' = '#E4C6DC',
      'orange' = '#FFCB97', 'blue1'  = '#BFDBD8',
      'yellow' = '#F6E1A4', 'grey'   = '#D9D5D5',
      'pink'   = '#FBC9DA', 'tan'    = '#EBD9D1'
    )
      
    # Based on inputs, return one or all colors, either displaying the names or not
    return ( formatReturnColors(colors, fillPalette, displayNames) )
  }

      
  # Fill Colors - Low Contrast -------------------------------------------------

  # For example, the fill colors on a bar chart. These are displayed in the style guide
  # Low contrast with the line palette
  
  # Function to retrieve all, some, or one fill color
  # Default returns the entire list of fill colors
  getFillColLowContrast <- function(..., displayNames = FALSE) {
    colors <- c(...) # get colors from function params
    
    # Define the fill colors(low contrast)
    fillPalette <- c(
      'blue'   = '#A0CBE8', 'red'    = '#FF9D9A',
      'green'  = '#8CD17D', 'purple' = '#D4A6C8',
      'orange' = '#FFBE7D', 'blue1'  = '#86BCB6',
      'yellow' = '#F4DB92', 'grey'   = '#BFB8B7',
      'pink'   = '#FABFD2', 'tan'    = '#D7B5A6'
    )
    
    # Based on inputs, return one or all colors, either displaying the names or not
    return ( formatReturnColors(colors, fillPalette, displayNames) )
  }
    
    
  # Line Colors ------------------------------------------------------------------

  # For example, the lines (or accents) on a chart. These are just a bit darker than the fills
  
  # Function to retreive all, some, or one line color
  # Default returns the entire list of line colors
  getLineCol <- function(..., displayNames = FALSE) {
    colors <- c(...) # get colors from function params
    
    # Define the line colors  
    linePalette <- c(
      'blue'   = '#4E79A7', 'red'    = '#E15759', 
      'green'  = '#59A14F', 'purple' = '#B07AA1', 
      'orange' = '#F1800F', 'blue1'  = '#499894', 
      'yellow' = '#D8B23E', 'grey'   = '#79706E',
      'pink'   = '#D37295', 'tan'    = '#9D7660'
    )
      
    # Based on inputs, return one or all colors, either displaying the names or not
    return ( formatReturnColors(colors, linePalette, displayNames) )
  }
  
  
  # Base Colors ------------------------------------------------------------------

  # For example, this would be the navy backgrounds on the slide decks
  
  # Function to retrieve all, some, or one base color
  # Default returns the entire list of base colors
  getBaseCol <- function(..., displayNames = FALSE) {
    colors <- c(...) # get colors from function params
    
    # Define the line colors  
    basePalette <- c('navy'  = '#3F4953',
                     'navy1' = '#394149',
                     'navy2' = '#2D343B')
      
    # Based on inputs, return one or all colors, either displaying the names or not
    return ( formatReturnColors(colors, basePalette, displayNames) )
  }
  
  
  # Other Colors -----------------------------------------------------------------
  
  getTextCol       <- function() { return('#585858') } # Text Color
  getBorderCol     <- function() { return('#E6E6E6') } # Border Color
  getBackgroundCol <- function() { return('#FAFAFA') } # Background Color
  getGrayedOutCol  <- function() { return('grey87' ) } # COnsistent Grey for graying out objects
  
  
  # RETURN A PALETTE -------------------------------------------------------------
  
  # Options for palettes: 
  paletteOptions <- c('fill', 'fill_low', 'color', 'base',
                      'text','border','background','grayedOut')

  # If no aesthetic given
  if ( is.null(aesthetic) ) {
    warning(paste('You need to define a `aesthetic`, e.g. `aesthetic = "fill"`. Use from this list:\n ', 
                  toString(paletteOptions) ) )
  
  # If NOT given a credible aesthetic
  } else if ( !(aesthetic %in% paletteOptions) ) {
    warning(paste('Incorect aesthetic type. Choose from:', toString(paletteOptions) ) )
  
  # Else, you are given a credible aesthetic
  } else {
    
    # If wanting fill aesthetic
    if (aesthetic == paletteOptions[1]) { return(getFillCol(..., displayNames=displayNames)) }
    
    # If wanting fill low contrast aesthetic
    if (aesthetic == paletteOptions[2]) { return(getFillColLowContrast(..., displayNames=displayNames)) }
    
    # If wanting line aesthetic
    if (aesthetic == paletteOptions[3]) { return(getLineCol(..., displayNames=displayNames)) }
    
    # If wanting base aesthetic
    if (aesthetic == paletteOptions[4]) { return(getBaseCol(..., displayNames=displayNames)) }
    
    # The single values color return functions:
    if (aesthetic == paletteOptions[5]) { return(getTextCol()) }
    if (aesthetic == paletteOptions[6]) { return(getBorderCol()) }
    if (aesthetic == paletteOptions[7]) { return(getBackgroundCol()) }
    if (aesthetic == paletteOptions[8]) { return(getGrayedOutCol()) }
  }
}

# ggplot2 Scale Functions ------------------------------------------------------

## ggplot Color Scale 
scale_color_dbc <- function()  {
  scale_color_manual(values = scale_dbc('color'))
}

## ggplot Fill Scale 
scale_fill_dbc <- function()  {
  scale_fill_manual(values = scale_dbc('fill'))
}

## ggplot Fill Scale (low contrast)
scale_fillLowContrast_dbc <- function()  {
  scale_fill_manual(values = scale_dbc('fill_low'))
}


# ggplot Theme -----------------------------------------------------------------

# Access via ggplot() + theme_dbc()
theme_dbc <- function() {
  
  textCol   = scale_dbc('text')
  borderCol = scale_dbc('border')
  
  dbcTheme <- theme(
    
    # All Font  Size
    text                = element_text(size  = 11),
    
    # Panel 
    panel.background    = element_rect(fill     = 'white', 
                                       color    = 'white'),
    panel.border        = element_rect(fill     = NA,
                                       color    = borderCol),
    panel.grid.major.x  = element_blank(),
    panel.grid.major.y  = element_line(linetype = "solid",
                                       color    = "grey95", 
                                       size     = 0.2),
    
    # Main Title
    plot.title          = element_text(color  = textCol,
                                       size   = 16,
                                       hjust  = 0),
    plot.subtitle       = element_text(color  = textCol,
                                       size   = 13,
                                       hjust  = 0),
    
    # Axis Titles
    axis.text           = element_text(color  = textCol,
                                       size   = 11),
    axis.title          = element_text(color  = textCol,
                                       size   = 12),
    
    # Facet Titles
    strip.text          = element_text(color  = textCol,
                                       size   = 12),
    strip.background    = element_rect(fill   = "#EAEAEA",
                                       color  = borderCol,
                                       size   = 0.40),
    
    # Caption Font
    plot.caption        = element_text(color  = textCol,
                                       size   = 8.5,
                                       hjust  = 1),
    
    # Legend
    legend.background   = element_rect(fill   = "grey99",
                                       color  = "grey85",
                                       size   = 0.40),
    legend.text         = element_text(color  = textCol),
    legend.position     = "top",
    legend.title        = element_blank(),
    
    # Margin
    plot.margin         = margin(t = 15, 
                                 b = 30, 
                                 r = 30, 
                                 l = 30, 
                                 unit = "pt")
  )
  
  # Set Theme Active - Use `theme_get()` when using ggplot
  theme_set(dbcTheme)
  
  return(dbcTheme)
}

# # To test out the function -----------------------------------------------------
# library(tidyverse)
# mtcars$carb <- fct_lump(as.factor(mtcars$carb), 3)
# numColors <- length(unique(mtcars$carb))
# 
# 
# ggplot(mtcars,
#        aes(x     = carb,
#            color = carb,
#            fill  = carb,
#            y     = mpg) ) +
#   geom_boxplot() +
#   theme_dbc() + 
#   scale_color_dbc() +
#   scale_fill_dbc()
