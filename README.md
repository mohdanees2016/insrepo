# insrepo

## Description of framework

This framework has below major components
1. Maven project
2. Page object model and page factory concept
3. TestNG for assertion and report
4. MYSQL Database for Test Data
5. TestNG.xml for test execution

## Structure of framework:

packages and the classes - 
1. com.in.base - It has one base class (TestBase.java) for base or common methods.
2. com.in.pageobject - It has classes based on the pages in application.
3. com.in.testcases - It has 2 classes for 2 test cases i.e. AddCustomerTest.java and AccountTest.java
4. com.in.utilities - It has all the classes which will be utilities for test data, db connection, report generation, testng listener.

## Resource file:
1. config.properties - This file has detail of application url and browser.

## steps to run the scripts
1. testng.xml file is the main file who will execute all the test cases i.e. AddCustomerTest.java and AccountTest.java
2. Select testng.xml file and run as TestNG SUITE
3. After completion of execution it will automatically open the report
