---------------------------------------------------------------------------
-- (c) Copyright IBM Corp. 2007 All rights reserved.
-- 
-- The following sample of source code ("Sample") is owned by International 
-- Business Machines Corporation or one of its subsidiaries ("IBM") and is 
-- copyrighted and licensed, not sold. You may use, copy, modify, and 
-- distribute the Sample in any form without payment to IBM, for the purpose of 
-- assisting you in the development of your applications.
-- 
-- The Sample code is provided to you on an "AS IS" basis, without warranty of 
-- any kind. IBM HEREBY EXPRESSLY DISCLAIMS ALL WARRANTIES, EITHER EXPRESS OR 
-- IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
-- MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. Some jurisdictions do 
-- not allow for the exclusion or limitation of implied warranties, so the above 
-- limitations or exclusions may not apply to you. IBM shall not be liable for 
-- any damages you suffer as a result of using, copying, modifying or 
-- distributing the Sample, even if IBM has been advised of the possibility of 
-- such damages.
-----------------------------------------------------------------------------
--
-- SOURCE FILE NAME: XmlIntegrate_setup.db2
--
-- SAMPLE: This sample serves as the setup script for the samples
--         XmlIntegrate.sqlj
--
-- SQL STATEMENTS USED:
--         CREATE TABLE
--
-- To run this script from the CLP issue the below command:
--            "db2 -tvf XmlIntegrate_setup.db2"
--
----------------------------------------------------------------------------
--
-- For more information about the command line processor (CLP) scripts,
-- see the README file.
--
-- For information on using SQL statements, see the SQL Reference.
--
-- For the latest information on programming, building, and running DB2
-- applications, visit the DB2 application development website:
--     http://www.software.ibm.com/data/db2/udb/ad
-----------------------------------------------------------------------------

connect to sample;

-- create table addr 

CREATE TABLE addr (custid int,
                    name varchar(20),
                    street varchar(20),
                    city varchar(20),
                    province varchar(20),
                    postalcode BIGINT);

-- create table custinfo_new

CREATE TABLE custinfo_new(custid int, address XML);

-- create table employee

CREATE TABLE EMPLOYEE (empno int,lastname varchar(20),
             firstname varchar(20), workdept varchar(20), phoneno
             varchar(20), hireDate DATE);

connect reset;
