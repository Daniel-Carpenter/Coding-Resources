
# Sets
options    = c('1', '2', '3', '4')

# Number of Sets
numOptions = length(options)

# Number of rows for non-unique permutations of number of sets
numRows = length(options) ^ length(options)

# Create data frame based on above
df <- data.frame(matrix(nrow = numRows, 
                        ncol = length(options)))

# Keep track of row count
count = 1

# Store the data in the df (would need to add or subtract loops if change num sets)
for (o1 in 1:numOptions) {
  for (o2 in 1:numOptions) {
    for (o3 in 1:numOptions) {
      for (o4 in 1:numOptions) {
        df[count, 1] = o1
        df[count, 2] = o2
        df[count, 3] = o3
        df[count, 4] = o4
        count = count + 1
      }
    }
  }
}

# Output the file
write.csv(df, file = 'combinations.csv')
