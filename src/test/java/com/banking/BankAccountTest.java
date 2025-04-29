package com.banking;

import org.testng.annotations.*;
import org.testng.Assert;

public class BankAccountTest {
    private BankAccount account;
    private static final double INITIAL_BALANCE = 1000.0;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up test class...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tearing down test class...");
    }

    @BeforeMethod
    public void setUp() {
        account = new BankAccount(INITIAL_BALANCE);
        System.out.println("Setting up test method...");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down test method...");
    }

    // Basic Testing with @Test and Assertions
    @Test(groups = "positive-tests", priority = 1)
    public void testDeposit() {
        account.deposit(500.0);
        Assert.assertEquals(account.getBalance(), 1500.0, "Deposit amount should be added to balance");
    }

    @Test(groups = "positive-tests", priority = 2)
    public void testWithdraw() {
        account.withdraw(500.0);
        Assert.assertEquals(account.getBalance(), 500.0, "Withdrawal amount should be subtracted from balance");
    }

    // Exception Testing
    @Test(groups = "negative-tests", expectedExceptions = IllegalArgumentException.class)
    public void testNegativeDeposit() {
        account.deposit(-100.0);
    }

    @Test(groups = "negative-tests", expectedExceptions = IllegalArgumentException.class)
    public void testNegativeWithdrawal() {
        account.withdraw(-100.0);
    }

    @Test(groups = "negative-tests", expectedExceptions = IllegalArgumentException.class)
    public void testInsufficientFunds() {
        account.withdraw(2000.0);
    }

    // Data-Driven Testing
    @DataProvider(name = "depositData")
    public Object[][] getDepositData() {
        return new Object[][] {
            {100.0, 1100.0},
            {200.0, 1200.0},
            {300.0, 1300.0}
        };
    }

    @Test(dataProvider = "depositData", groups = "positive-tests")
    public void testDepositWithDataProvider(double amount, double expectedBalance) {
        account.deposit(amount);
        Assert.assertEquals(account.getBalance(), expectedBalance, "Deposit with data provider failed");
    }

    // Test Dependencies
    @Test(groups = "positive-tests", dependsOnMethods = "testDeposit")
    public void testWithdrawAfterDeposit() {
        account.deposit(500.0);
        account.withdraw(200.0);
        Assert.assertEquals(account.getBalance(), 1300.0, "Withdrawal after deposit failed");
    }

    // Bonus Challenge: Transfer Tests
    @Test(groups = "positive-tests")
    public void testTransfer() {
        BankAccount destinationAccount = new BankAccount(500.0);
        account.transfer(destinationAccount, 300.0);
        Assert.assertEquals(account.getBalance(), 700.0, "Source account balance incorrect after transfer");
        Assert.assertEquals(destinationAccount.getBalance(), 800.0, "Destination account balance incorrect after transfer");
    }

    @Test(groups = "negative-tests", expectedExceptions = IllegalArgumentException.class)
    public void testTransferInsufficientFunds() {
        BankAccount destinationAccount = new BankAccount(500.0);
        account.transfer(destinationAccount, 2000.0);
    }
} 