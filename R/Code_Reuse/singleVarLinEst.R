linearEstimation <- function(y, x, df)
{
  # Get Linear Estimation
  est <- lm(log(y) ~ x, 
            data = df) 
  
  # Store Estimate
  estSummary <- tidy(est)
  
  # Element Reference in list of estimation
  X_VAR <- 2
  
  # Determin if statistically significant change
  isSignificant = estSummary$p.value < 0.05
  
  # Print Summary output
  writeLines(paste0("This model estimates that the independant variable changes the dependant variable by ",
                    percent(estSummary$estimate[X_VAR]), 
                    " (with", if (!isSignificant) {"out"}, " statistical significance)."))
  
  # Return Estimate
  return(estSummary)
}
