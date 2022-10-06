# My Package list
myPackages <- c('tidyverse',
                'lubridate',
                'skimr',
                'readxl',
                'scales')


# Install packages not on this device
packagesToInstall <- myPackages[!myPackages %in% rownames(installed.packages())]
print(paste('Installing:', unlist(packagesToInstall)))


for (thePackage in packagesToInstall) {
  install.packages(thePackage)
}

# Load library
lapply(myPackages, function(thePackage) suppressMessages(require(thePackage, 
                                                                 character.only = TRUE,
                                                                 quietly=TRUE,
                                                                 warn.conflicts = FALSE)))
# Clean environment
rm(thePackage, packagesToInstall, myPackages)


# Others
# library(data.table)
# library(R.cache) # Used to store data in memory on code execution
# library(magrittr)
# library(ggthemes)
# library(scales)
# library(formattable)
# library(grid)

# SQL Connection ---------------------------------------------------------------------------------------------------

# library(dbplyr)
# library(odbc)
# library(DBI)
# library(glue)
