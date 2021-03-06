//***************************************************************************
// (c) Copyright IBM Corp. 2007 All rights reserved.
// 
// The following sample of source code ("Sample") is owned by International 
// Business Machines Corporation or one of its subsidiaries ("IBM") and is 
// copyrighted and licensed, not sold. You may use, copy, modify, and 
// distribute the Sample in any form without payment to IBM, for the purpose of 
// assisting you in the development of your applications.
// 
// The Sample code is provided to you on an "AS IS" basis, without warranty of 
// any kind. IBM HEREBY EXPRESSLY DISCLAIMS ALL WARRANTIES, EITHER EXPRESS OR 
// IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. Some jurisdictions do 
// not allow for the exclusion or limitation of implied warranties, so the above 
// limitations or exclusions may not apply to you. IBM shall not be liable for 
// any damages you suffer as a result of using, copying, modifying or 
// distributing the Sample, even if IBM has been advised of the possibility of 
// such damages.
//***************************************************************************
//
// SOURCE FILE NAME: IlInfo.java
//
// SAMPLE: How to get and set information at the installation image level
//
// JAVA 2 CLASSES USED:
//         DatabaseMetaData
//
// Classes used from Util.java are:
//         Db
//         JdbcException
// Compile: the utility file and the source file with:
//		javac Util.java
//		javac <filename>.java
//
// Run: java <filename> [<db_name>] <username> <pwd>
//	or
//     java <filename> [<db_name>] <server_name> <port_num> <username> <pwd>
//
//***************************************************************************
//
// For more information on the sample programs, see the README file.
//
// For information on developing JDBC applications, see the Application
// Development Guide.
//
// For information on using SQL statements, see the SQL Reference.
//
// For the latest information on programming, compiling, and running DB2
// applications, visit the DB2 application development website at
//     http://www.software.ibm.com/data/db2/udb/ad
//**************************************************************************/

import java.lang.*;
import java.sql.*;

class IlInfo
{
  public static void main(String argv[])
  {
    try
    {
      Db db = new Db(argv);

      System.out.println();
      System.out.println("THIS SAMPLE SHOWS HOW TO GET AND SET \n" +
        "INFORMATION AT INSTALLATION IMAGE LEVEL.");

      // connect to the 'sample' database
      db.connect();

      serverImageInfoGet(db.con);
      clientImageInfoGet(db.con);

      // disconnect from the 'sample' database
      db.disconnect();
    }
    catch (Exception e)
    {
      JdbcException jdbcExc = new JdbcException(e) ;
      jdbcExc.handle();
    }
  } // main

  // This function gets the information of the Server's image
  static void serverImageInfoGet(Connection con)
  {
    try
    {
      System.out.println();
      System.out.println(
        "----------------------------------------------------------\n" +
        "USE THE DatabaseMetaData FUNCTIONS:\n" +
        "  getDatabaseProductName()\n" +
        "  getDatabaseProductVersion()\n" +
        "TO GET SERVER'S IMAGE INFOMATION.");

      DatabaseMetaData dbMetaData = con.getMetaData();

      String dbProductName = dbMetaData.getDatabaseProductName();
      System.out.println();
      System.out.println("  DATABASE Product Name: " + dbProductName);

      String dbProductVersion = dbMetaData.getDatabaseProductVersion();
      System.out.println("  DATABASE Product Version: " + dbProductVersion);

      System.out.println();
    }
    catch (Exception e)
    {
      JdbcException jdbcExc = new JdbcException(e, con);
      jdbcExc.handle();
    }
  } // serverImageInfoGet

  // This function gets the information of the client's image
  static void clientImageInfoGet(Connection con)
  {
    try
    {
      System.out.println(
        "----------------------------------------------------------\n" +
        "USE THE DatabaseMetaData FUNCTIONS:\n" +
        "  getDriverName()\n" +
        "  getDriverVersion()\n" +
        "TO GET CLIENT'S IMAGE INFOMATION, \n" +
        "  supportsExtendedSQLGrammar()\n" +
        "  supportsCoreSQLGrammar()\n" +
        "  supportsMinimumSQLGrammar()\n" +
        "TO GET ODBC CONFORMANCE LEVEL.");

      DatabaseMetaData dbMetaData = con.getMetaData();

      String driverName = dbMetaData.getDriverName();
      System.out.println();
      System.out.println("  CLIENT JDBC Driver Name: " + driverName);

      String driverVersion = dbMetaData.getDriverVersion();
      System.out.println("  CLIENT JDBC Driver Version: " +
                         driverVersion);

      System.out.print("  ODBC CLI Conformance Level: ");

      boolean isExtended = dbMetaData.supportsExtendedSQLGrammar();
      boolean isCore = dbMetaData.supportsCoreSQLGrammar();
      boolean isMinimum = dbMetaData.supportsMinimumSQLGrammar();

      if (isExtended == true)
      {
        System.out.println("Extended Grammer");
      }
      else if (isCore == true)
      {
        System.out.println("CORE GRAMMER");
      }
      else if (isMinimum == true)
      {
        System.out.println("MINIMUM GRAMMER");
      }
      else
      {
        System.out.println(" -- ERROR: UNKNOWN ---");
      }
    }
    catch (Exception e)
    {
      JdbcException jdbcExc = new JdbcException(e, con);
      jdbcExc.handle();
    }
  } // clientImageInfoGet
} // IlInfo

