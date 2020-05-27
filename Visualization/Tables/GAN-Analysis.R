library(readxl)
library(tidyverse)
library(dplyr)
library(lubridate)
library(janitor)  # rows to header
library(hablar)   # convert to type int
library(estimatr) # lm function
library(stargazer)
library(xtable)
library(ggplot2)

# INPUTS -------------------------------------------------------------------------------

  # Enter the GAN Workbook Name Below:
    GAN_Workbook          <- "217-GAN_Report_Adjusted.xlsx"
  
  # Enter The Fixed Marketing Expense that GAN Charges Below:
    fixedMarketingExpense <- 20000 # dollars
  
  # Enter the Starting Month of COVID-19:
    covidStartMonth       <- 43891 # 3/1/2020 in Excel Terms, can change format later
  
  # Exclude Dollar Amount Value (for Anomalies)
    excludeAmount = 100000 # dollars

# READ IN DATA  ------------------------------------------------------------------------
  # PUll in Workbook
    df  <- as.data.frame(read_excel(GAN_Workbook,
                          sheet = "TTM"))
  # Set Date to Cell A1
    df[1,1] <- "Date"
  
# MANIPULATE DATSET --------------------------------------------------------------------
  # Clean Up Dataset
    df  <-  as.data.frame(t(df %>% 
            drop_na())) %>%
            row_to_names(row_number = 1) %>%
            convert(int(Date)) %>%
      
    # Convert Data Type to Double (decimal number)
      mutate(date = as.double(`Date`))  %>%
      mutate(cardPurchases = as.double(`Card Purchases (Desktop/Mobile)`))  %>%
      mutate(inAppPurchases = as.double(`In-App Purchases`))  %>%
      mutate(licAndFees = as.double(`Licenses & Fees`))  %>%
      mutate(ads = as.double(`Advertising`))  %>%
      mutate(mkt = as.double(`Marketing`))  %>%
      mutate(sponsorship = as.double(`Sponsorships`))  %>%
      mutate(ttlOpsExp = as.double(`Total Operating Expenses`)) %>%
      mutate(ttlRevenue = cardPurchases + inAppPurchases) %>% 

    # Select Only Relevant Variables
      select(date, 
             ttlRevenue,
             cardPurchases, 
             inAppPurchases, 
             licAndFees, 
             ads, 
             mkt,
             sponsorship, 
             ttlOpsExp) %>%

    # Add New Variables
      mutate(adsPlusMkt = ads + mkt)  %>%
      mutate(adsPlusMktLessFixed = adsPlusMkt - fixedMarketingExpense)  %>%
    
    # Add log(ttlRevenue)
      mutate(log.ttlRevenue = log(ttlRevenue)) %>%
      
    # Filter Out Anomolies
      # COVID-19 Months - Filter because there was a Spike in Online Play from Casino Closings
        filter(date >= (min(date) + 365)) %>%
        filter(date < covidStartMonth) %>%
        filter(adsPlusMktLessFixed < excludeAmount) %>%
        filter(adsPlusMktLessFixed >= 0) %>%
        filter(date != 43405) # Double payment becuase of missed payment in prior month (10/1/2018 and 11/1/2018)

# REGRESSION ANALYSIS (Nothing Significant -----------------------------------------------------
    ### Note lm corrects for heteroskedasticity, 
    ### which helps control for seasonality

    # Total Revenue (Simple OLS)
      basic.ttlRev      <- lm(ttlRevenue ~ adsPlusMktLessFixed, 
                                     data = df)
      est.basic.ttlRev  <- summary(basic.ttlRev)
      est.basic.ttlRev
    
    # Total Revenue
      complex.ttlRev      <- lm(ttlRevenue ~ licAndFees + sponsorship + 
                                       ttlOpsExp + adsPlusMktLessFixed, 
                                       data = df)
      est.complex.ttlRev  <- summary(complex.ttlRev)
      est.complex.ttlRev
      
    # Card Purchases
      complex.cardPurchases       <- lm(cardPurchases ~ licAndFees + 
                                               sponsorship + ttlOpsExp +
                                               adsPlusMktLessFixed, 
                                               data = df)
      est.complex.cardPurchases   <- summary(complex.cardPurchases)
      est.complex.cardPurchases
      
    # In App Purchases
      complex.inAppPurchases      <- lm(inAppPurchases ~ licAndFees + 
                                               sponsorship + ttlOpsExp + 
                                               adsPlusMktLessFixed, 
                                               data = df)
      est.complex.inAppPurchases  <- summary(complex.inAppPurchases)
      est.complex.inAppPurchases
      
    # Summary Output
      stargazer(basic.ttlRev,
                complex.ttlRev,
                complex.cardPurchases,
                complex.inAppPurchases,
                title = "No Lag Regression Models")
      

# REGRESSION ANALYSIS (Month Lag) -------------------------------------------------
      # Total Revenue (Simple OLS)
        basic.ttlRev.lag      <- lm(ttlRevenue ~ lag(adsPlusMktLessFixed, k = 1) , 
                                           data = df)
        est.basic.ttlRev.lag  <- summary(basic.ttlRev.lag)
        est.basic.ttlRev.lag
        
      
      # Total Revenue
        complex.ttlRev.lag      <- lm(ttlRevenue ~ lag(licAndFees, k = 1) 
                                             +  lag(sponsorship, k = 1) 
                                             +  lag(ttlOpsExp, k = 1) 
                                             +  lag(adsPlusMktLessFixed, k = 1), 
                                             data = df)
  
        est.complex.ttlRev.lag  <- summary(complex.ttlRev.lag)
        est.complex.ttlRev.lag
      
      # Card Purchases
        complex.cardPurchases.lag       <- lm(cardPurchases ~ lag(licAndFees, k = 1) 
                                                     +  lag(sponsorship, k = 1) 
                                                     +  lag(ttlOpsExp, k = 1) 
                                                     +  lag(adsPlusMktLessFixed, k = 1), 
                                                     data = df)
  
        est.complex.cardPurchases.lag   <- summary(complex.cardPurchases.lag)
        est.complex.cardPurchases.lag
      
      # In App Purchases
        complex.inAppPurchases.lag      <- lm(inAppPurchases ~ lag(licAndFees, k = 1) 
                                                     +  lag(sponsorship, k = 1) 
                                                     +  lag(ttlOpsExp, k = 1) 
                                                     +  lag(adsPlusMktLessFixed, k = 1), 
                                                     data = df)
  
        est.complex.inAppPurchases.lag  <- summary(complex.inAppPurchases.lag)
        est.complex.inAppPurchases.lag
        
      # Summary Output
        stargazer(basic.ttlRev.lag,
                  complex.ttlRev.lag,
                  complex.cardPurchases.lag,
                  complex.inAppPurchases.lag,
                  title = "One Month Lag Regression Models")
        

# REGRESSION ANALYSIS (2-Month Lag) -------------------------------------------------
      # Total Revenue (Simple OLS)
        basic.ttlRev.lag2      <- lm(ttlRevenue ~ lag(adsPlusMktLessFixed, k = 2) , 
                                           data = df)
        est.basic.ttlRev.lag2  <- summary(basic.ttlRev.lag2)
        est.basic.ttlRev.lag2
        
        
      # Total Revenue
        complex.ttlRev.lag2      <- lm(ttlRevenue ~ lag(licAndFees, k = 2) 
                                             +  lag(sponsorship, k = 2) 
                                             +  lag(ttlOpsExp, k = 2) 
                                             +  lag(adsPlusMktLessFixed, k = 2), 
                                             data = df)
        
        est.complex.ttlRev.lag2  <- summary(complex.ttlRev.lag2)
        est.complex.ttlRev.lag2
        
      # Card Purchases
        complex.cardPurchases.lag2       <- lm(cardPurchases ~ lag(licAndFees, k = 2) 
                                                     +  lag(sponsorship, k = 2) 
                                                     +  lag(ttlOpsExp, k = 2) 
                                                     +  lag(adsPlusMktLessFixed, k = 2), 
                                                     data = df)
        
        est.complex.cardPurchases.lag2   <- summary(complex.cardPurchases.lag2)
        est.complex.cardPurchases.lag2
          
      # In App Purchases
        complex.inAppPurchases.lag2      <- lm(inAppPurchases ~ lag(licAndFees, k = 2) 
                                                     +  lag(sponsorship, k = 2) 
                                                     +  lag(ttlOpsExp, k = 2) 
                                                     +  lag(adsPlusMktLessFixed, k = 2), 
                                                     data = df)
        
        est.complex.inAppPurchases.lag2  <- summary(complex.inAppPurchases.lag2)
        est.complex.inAppPurchases.lag2
        
      # Summary Output
        #stargazer(basic.ttlRev.lag2,
                  #complex.ttlRev.lag2,
                  #complex.cardPurchases.lag2,
                  #complex.inAppPurchases.lag2, 
                  #title = "Two Month Lag Regression Models")

# VISUALIZATIONS
    # ttlRevenue on adsPlusMktLessFixed (No Lag)
        ggplot(data = df, aes(
          x = adsPlusMktLessFixed, 
          y = ttlRevenue,
          color = date)) +
          geom_point() +
          ylim(100000,250000) +
          theme_minimal() +
          labs(title = "How Variable Ad and MKT Expenses Affect Total Revenue",
               subtitle = "No Lag Effect",
               caption = "",
               tag = "Figure 1.1",
               x = "Variable Ad and Marketing Expense",
               y = "Total GAN Revenue")
          
        ggsave(path = "Graphics", filename = "noLagTtlRev.pdf", width = 7, height = 4)

      # cardPurchases on adsPlusMktLessFixed (No Lag)
        ggplot(data = df, aes(
          x = adsPlusMktLessFixed, 
          y = cardPurchases,
          color = date)) +
          geom_point() +
          ylim(100000,200000) +
          theme_minimal() +
          labs(title = "How Variable Ad and MKT Expenses Affect Card Purchase Revenue",
               subtitle = "No Lag Effect",
               caption = "",
               tag = "Figure 1.2",
               x = "Variable Ad and Marketing Expense",
               y = "Card Purchase Revenue")

        ggsave(path = "Graphics", filename = "noLagCardPurch.pdf", width = 7, height = 4)
        
        
      # inAppPurchases on adsPlusMktLessFixed (No Lag)
        ggplot(data = df, aes(
          x = adsPlusMktLessFixed, 
          y = inAppPurchases,
          color = date)) +
          geom_point() +
          ylim(20000,80000) +
          theme_minimal() +
          labs(title = "How Variable Ad and MKT Expenses Affect In-App Purchase Revenue",
               subtitle = "No Lag Effect",
               caption = "",
               tag = "Figure 1.3",
               x = "Variable Ad and Marketing Expense",
               y = "In-App Purchase Revenue")
        
        ggsave(path = "Graphics", filename = "noLagInAppPurch.pdf", width = 7, height = 4)
        
    # ttlRevenue on adsPlusMktLessFixed (1-Month Lag)
      ggplot(data = df, aes(
        x = lag(adsPlusMktLessFixed,k = 1), 
        y = ttlRevenue,
        color = date)) +
        geom_point() +
        ylim(120000,255000) +
        theme_minimal() +
        labs(title = "How Variable Ad and MKT Expenses Affect Total Revenue",
             subtitle = "1-Month Lag",
             caption = "",
             tag = "Figure 2.1",
             x = "Variable Ad and Marketing Expense, 1-Month Lag",
             y = "GAN Revenue")
      
      ggsave(path = "Graphics", filename = "lagTtlRev.pdf", width = 7, height = 4)

    # cardPurchases on adsPlusMktLessFixed (1-Month Lag)
      ggplot(data = df, aes(
        x = lag(adsPlusMktLessFixed, k = 1), 
        y = cardPurchases,
        color = date)) +
        geom_point() +
        ylim(100000,200000) +
        theme_minimal() +
        labs(title = "How Variable Ad and MKT Expenses Affect Card Purchase Revenue",
             subtitle = "1-Month Lag",
             caption = "",
             tag = "Figure 2.2",
             x = "Variable Ad and Marketing Expense",
             y = "Card Purchase Revenue")
      
      ggsave(path = "Graphics", filename = "lagCardPurch.pdf", width = 7, height = 4)
      
      
    # inAppPurchases on adsPlusMktLessFixed (1 Month-Lag)
      ggplot(data = df, aes(
        x = lag(adsPlusMktLessFixed, k = 1), 
        y = inAppPurchases,
        color = date)) +
        geom_point() +
        ylim(20000,80000) +
        theme_minimal() +
        labs(title = "How Variable Ad and MKT Expenses Affect In-App Purchase Revenue",
             subtitle = "1-Month Lag",
             caption = "",
             tag = "Figure 2.3",
             x = "Variable Ad and Marketing Expense",
             y = "In-App Purchase Revenue")
      
      ggsave(path = "Graphics", filename = "lagInAppPurch.pdf", width = 7, height = 4)      
        
      
