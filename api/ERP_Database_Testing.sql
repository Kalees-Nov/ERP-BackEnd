CREATE DATABASE IF NOT EXISTS erp_db;
USE erp_db;

SELECT * FROM stakeholder_master;
SELECT * FROM stakeholder_branch;
SELECT * FROM stakeholder_individual;
SELECT * FROM stakeholder_business_nature;

TRUNCATE TABLE stakeholder_business_nature;
TRUNCATE TABLE stakeholder_individual;
TRUNCATE TABLE stakeholder_branch;
TRUNCATE TABLE stakeholder_master;
