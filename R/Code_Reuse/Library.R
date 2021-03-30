# R -----------------------------------------------------------------------------------------------------------------

library(tidyverse)
library(data.table)
library(skimr)
library(lubridate)
library(R.cache) # Used to store data in memory on code execution
library(readxl)
library(magrittr)
library(ggthemes)
library(gridExtra) # Used for multipage PDF saves
library(scales)
library(formattable)
library(grid)

# SQL Connection ---------------------------------------------------------------------------------------------------

library(dbplyr)
library(odbc)
library(DBI)
library(glue)
