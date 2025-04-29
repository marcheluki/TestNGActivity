package com.banking;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    // Bonus challenge: Transfer method
    public void transfer(BankAccount destination, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds for transfer");
        
        this.withdraw(amount);
        destination.deposit(amount);
    }
} 