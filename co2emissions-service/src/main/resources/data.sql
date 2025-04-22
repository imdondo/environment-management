-- Ensure the 'country' table exists
CREATE TABLE IF NOT EXISTS country
(
    Id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    code           VARCHAR(10) UNIQUE NOT NULL,
    UN_M49         int        NOT NULL,
    registered_date DATE      NOT NULL
    );

-- Insert well-known UUIDs for specific patients
INSERT INTO country (Id, name, code, UN_M49,  registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'South Africa',
       'ZAF',
       710,
       '2025-01-10'
    WHERE NOT EXISTS (SELECT 1
                  FROM country
                  WHERE Id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO country (Id, name, code, UN_M49,  registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Egypt',
       'EGY',
       818,
       '2023-12-01'
    WHERE NOT EXISTS (SELECT 1
                  FROM country
                  WHERE Id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO country (Id, name, code, UN_M49,  registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Nigeria',
       'NGA',
       566,
       '2022-06-20'
    WHERE NOT EXISTS (SELECT 1
                  FROM country
                  WHERE Id = '123e4567-e89b-12d3-a456-426614174002');


CREATE TABLE IF NOT EXISTS emissions
(
    emission_Id              UUID PRIMARY KEY,
    emission_Year             int       NOT NULL,
    country_Id           VARCHAR(255) NOT NULL,
    total_Emissions         Double        NOT NULL,
    coal_Emissions         Double        NOT NULL,
    oil_Emissions         Double        NOT NULL,
    gas_Emissions         Double        NOT NULL,
    cement_Emissions         Double        NOT NULL,
    flaring_Emissions         Double        NOT NULL,
    other_Emissions         Double        NOT NULL,
    per_capita_Emissions         Double        NOT NULL,
    entry_Date DATE      NOT NULL
    );


-- EMissions entries
-- Nigeria
INSERT INTO EMISSIONS (emission_Id,emission_Year,country_Id,total_Emissions,coal_Emissions,oil_Emissions,gas_Emissions,cement_Emissions,flaring_Emissions,other_Emissions,per_capita_Emissions,entry_Date)
SELECT  '123e4567-e89b-12d3-a456-426614174007',1994, '123e4567-e89b-12d3-a456-426614174002', '80.462207', '0.065945', '23.527750', '10.269119','0.065947','0.065947','0.065947','0.065947','2022-06-20';
-- -- Egypt
INSERT INTO EMISSIONS (emission_Id,emission_Year,country_Id,total_Emissions,coal_Emissions,oil_Emissions,gas_Emissions,cement_Emissions,flaring_Emissions,other_Emissions,per_capita_Emissions,entry_Date)
SELECT  '123e4567-e89b-12d3-a456-426614174008',1994, '123e4567-e89b-12d3-a456-426614174001', '80.462207', '0.065945', '23.527750', '10.269119','0.065947','0.065947','0.065947','0.065947','2022-06-20';
-- -- 88.372733,3.693152,53.089064,20.158456,7.615149,3.816911,,1.407751
-- -- South Africa
INSERT INTO EMISSIONS (emission_Id,emission_Year,country_Id,total_Emissions,coal_Emissions,oil_Emissions,gas_Emissions,cement_Emissions,flaring_Emissions,other_Emissions,per_capita_Emissions,entry_Date)
SELECT  '123e4567-e89b-12d3-a456-426614174009',1994, '123e4567-e89b-12d3-a456-426614174000', '80.462207', '0.065945', '23.527750', '10.269119','0.065947','0.065947','0.065947','0.065947','2022-06-20';
