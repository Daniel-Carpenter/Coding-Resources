
library(dplyr)
library(fredr)

# Set API key
fredr_set_key("826c7aeb1b2fe91ea9879c61af162e8f")

seriesID = "HQMCB10YR"

# Fetch metadata about the series to get the release ID
seriesData = fredr::fredr_series_release(seriesID)
seriesIntID = seriesData$id

# out <- fredr::fredr_release_series(seriesIntID)

# Fetch release dates using the release ID
release_dates <- fredr_release_dates(release_id = seriesIntID) |> 
  arrange(desc(date))

head(release_dates, 36)


# write.csv(release_dates, 'HQM Release Dates.csv', row.names = F)
