-- Declare Date Range Vars
    DECLARE @minDate            AS DATE
    DECLARE @maxDate            AS DATE
    DECLARE @numResultsToPull   AS int

-- INPUT Date Range Vars
    SET     @minDate = '2020-06-01' -- INPUT HERE
    SET     @maxDate = GETDATE()
    SET     @numResultsToPull = 1000000

SELECT
    -- Date and Facility
        DATE_LAST_MODIFIED,
        SOURCE_PROP,
        PROPERTY_NAME_SHORT,

    -- Location of Patron
        PATRON_STATE,
        PATRON_CITY,

    -- Aggregated from sub0
        GENDER,
        GENDER_COUNT,      
        AVG_PATRON_AGE
FROM
    (SELECT
        -- Date and Facility
            DATE_LAST_MODIFIED,
            SOURCE_PROP,
            PROPERTY_NAME_SHORT,

        -- Location of Patron
            RESIDENTIAL_STATE           AS PATRON_STATE,
            RESIDENTIAL_CITY            AS PATRON_CITY,

        -- Aggregation
            COUNT(PATRON_IS_MALE)       AS MALE,
            COUNT(PATRON_IS_FEMALE)     AS FEMALE,
            --AVG(CASE WHEN PATRON_AGE >= 18 AND PATRON_AGE <= 21 THEN 1 ELSE 0 END) AS AVG_PATRON_AGE         
            AVG(PATRON_AGE) AS AVG_PATRON_AGE -- could have a tiered avg for more description (e.g. 18-22, 22-30, 30-40, 40-60. 60 ->)        

    FROM
        (SELECT --TOP (@numResultsToPull)
        -- Date and Facility
            DATE_LAST_MODIFIED,
            pat.SOURCE_PROP,
            fac.PROPERTY_NAME_SHORT,

        -- Location of Patron
            RESIDENTIAL_STATE,
            RESIDENTIAL_CITY,
            
        -- Gender of Patron Calculations
            (SELECT 1 WHERE GENDER = 'M') AS PATRON_IS_MALE,
            (SELECT 1 WHERE GENDER = 'F') AS PATRON_IS_FEMALE,
            
        -- Age of Patron Calculations 
            ROUND(
                CAST(DATEDIFF(YEAR, OPA.BALLYS.CONVERT_MMDDYY_TO_DATE(BIRTH_DATE), DATE_LAST_MODIFIED) AS FLOAT) + 
                CAST(MONTH(OPA.BALLYS.CONVERT_MMDDYY_TO_DATE(BIRTH_DATE)) AS FLOAT) / 12, 
                1) AS PATRON_AGE

        FROM 
            OPA.BALLYS.CFPCN_PATRON_DIM pat JOIN 
            OPA.BALLYS.FACILITY_DIM fac
                ON pat.SOURCE_PROP = fac.SOURCE_PROP

        WHERE
            DATE_LAST_MODIFIED >= @minDate AND
            DATE_LAST_MODIFIED <  @maxDate 

        ) AS sub0

    GROUP BY
    -- Date and Facility
        DATE_LAST_MODIFIED,
        SOURCE_PROP,
        PROPERTY_NAME_SHORT,

    -- Location of Patron
        RESIDENTIAL_STATE,
        RESIDENTIAL_CITY
    ) AS sub1

UNPIVOT 
(
    GENDER_COUNT FOR GENDER IN (MALE, FEMALE)
) AS up;
