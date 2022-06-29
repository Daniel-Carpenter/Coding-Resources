
library(sf)
USA <- st_read(dsn = 'US_Shape_Files//cb_2018_us_county_5m.shp')



library(tidyverse)
library(lubridate)
library(scales)

DFW <- USA %>% filter( STATEFP == '48') #as.numeric(COUNTYFP) %in% (tmp$fips-48000) &
DFW_sf <- st_as_sf(DFW)

numRows = 1000

df <- data.frame(Date    = as.Date(runif(numRows, min = 40 * 365, max = 60 * 365),
                                   origin = '1970-01-01'),
                 Value   = rnorm(n = numRows, mean = 100, sd = 30),
                 ZipCode = str_pad( round(runif(numRows, min=0, 70000) ), 5, pad="0"),
                 Category = c(rep('Cat. 1', numRows / 2),
                              rep('Cat. 2', numRows / 2) )
                 )

bins <- c(0, 50000, 100000, 250000, 500000, 1500000, 3500000, 4000000) # base::pretty(DFW_sf_coef$Population, n = 6)

thePalette <- colorBin("YlOrRd", domain = df$Value, bins = bins)

library(leaflet)
library(plotly)

leaflet() %>%
  setView(lat = 32.848857, lng = -96.976004, zoom = ZOOM) %>%
  addTiles() %>%
  addPolygons(
    data = df,
    fillColor = ~mypal(df$Value),
    stroke = FALSE,
    smoothFactor = 0.2,
    fillOpacity = 0.3,
    popup = paste("Region: ", df$Category, "<br>",
                  "Value: ", comma(df$Value), "<br>"))%>%
  addLegend(position = "bottomleft",
            pal = thePalette,
            values = df$Value,
            title = "The Legend",
            opacity = 1)


# Check to map out the DFW mapping
