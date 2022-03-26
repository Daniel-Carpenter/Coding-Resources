
source("theFunction.R") # Call the function at the top so you don't actually see or touch the function

#theData <- connectDatabaseHere(throughAQuery)

# Example of run the fun
forecast('WS')  


# Example of the loops fun ------------

# Create the df
df <- c()

sourceProps <- c('RS', 'SC', 'WS')

# Loop over list of businesses 
for (SOURCE_PROP in 1:length(sourceProps)) {
  df <- rbind(df, forecast(sourceProps[SOURCE_PROP]))  
}

df
