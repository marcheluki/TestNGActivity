# TestNGActivity

## Banking App Test Suite with TestNG

This project demonstrates how to use TestNG to test a simple banking application. It covers various TestNG features including:

- Annotations (@Test, @BeforeMethod, @AfterClass, etc.)
- Prioritizing tests
- Grouping tests
- Using @DataProvider for data-driven testing
- Test dependencies
- Managing results and reports
- XML configuration

## Project Structure

```bash
src/
├── main/java/com/banking/
│   └── BankAccount.java        # Banking application code
└── test/java/com/banking/
    └── BankAccountTest.java    # TestNG test cases
```

## TestNG Features Used

1. **Annotations**
   - @BeforeClass, @AfterClass for test suite setup/teardown
   - @BeforeMethod, @AfterMethod for test case setup/teardown
   - @Test for test methods

2. **Test Prioritization**
   - Using priority attribute in @Test annotations

3. **Test Groups**
   - positive-tests and negative-tests groups
   - XML configuration to run specific groups

4. **Data-Driven Testing**
   - @DataProvider for parameterized tests

5. **Test Dependencies**
   - dependsOnMethods attribute for test dependencies

6. **Bonus Feature**
   - Transfer functionality with comprehensive test coverage

## Running the Tests

You can run the tests using Maven:

```bash
mvn clean test
```

The project includes a testng.xml file that configures:

- Running all tests
- Running only positive tests
- Running only negative tests

## Github Repository

The code for this project is available at [GitHub](https://github.com/yourusername/TestNGActivity).
