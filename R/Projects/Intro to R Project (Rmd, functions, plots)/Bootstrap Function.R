
library(s20x)
library(tidyverse)
library(formattable)


myboot <- function(iter   = 10000, # num iterations
                   x,              # dataset
                   fun    = "var", #
                   alpha  = 0.05,  # 95% confidence
                   cx     = 1.5,
                   ...
                   )
{
  # Get Sample size
    n = length(x)
  
  # Create Sample
    y = sample(x, 
               n * iter,
               replace = TRUE)
    
  # Form Matrix from sample
    rs.mat = matrix(y, # data from sampling
                    nrow  = n,
                    ncol  = iter,
                    byrow = TRUE) # sort by row

  # Variance
    xstat = apply(rs.mat, 2, fun) # vector containing iter vals
    
  # Form confidence interval
    ci = quantile(xstat,
                  c(alpha / 2,
                    1 - alpha / 2)
                    )
    
  # Send summary Statistics to the console
    
    ## Confidence Interval Out
      print("____________________________________________")
      print(paste0("Confidence Interval at Alpha = ", alpha))
      print("--------------------------------------------")
      print(ci)
    
      
    ## Form matrix of sample stats    
    statNames <- c("Mean:", "Median:", "Standard Deviation:")
    statVals  <- c(comma(mean  (varianceData), digits = 2),
                   comma(median(varianceData), digits = 2),
                   comma(sd    (varianceData), digits = 2)
                   )
    summaryStats <- matrix(data = c(statNames,
                                    statVals),
                           nrow = 3,
                           ncol = 2)
    
    ##  Sample Stats Out
    print("____________________________________________")
    print("Summary Statistics from Bootstrap Samping:")
    print("--------------------------------------------")
    print(summaryStats)
  
  # Create a histogram from Bootstrap sampling
    para <-  hist(
                  xstat,
                  freq = FALSE, # along numberline, not freq
                  las  = 1,
                  main = paste0("Histogram of Bootstrap Sample Statistics",
                                "\n",
                                "Alpha = ", alpha, "; ",
                                "Iters = ", comma(iter, digits = 0)),
                  col  = alpha("skyblue3", 2/5),
                  ...)
    
    # Save Bootstrap plot
      png("Bootstrap Estimate Plot")
      para
      dev.off()
    
    # write a file to current directory with sample data
      write.csv(xstat, "Bootsrap Estimations.csv")
    
    return(xstat)
}

# Invoke `myboot` function

  # Get dataset from mtcars
  df <- mtcars %>%
    
    ## filter to only 4-cylinder carss
      filter(cyl == 4) %>%
    
    ## Only show vars of interest
      select(mpg)
  
  df.vector <- df$mpg
  
  # Call function and store data in list
    varianceData <- myboot(iter  = 10000,
                           x     = df.vector,
                           alpha = 0.05,
                           cx    = 1.5,
                           xlab  = "Variance of MPG")
                  


    












