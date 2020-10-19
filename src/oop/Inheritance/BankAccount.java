package oop.Inheritance;

import java.util.Objects;

// One Super class (Parent) - Multiple subclasses (Children)
// Subclass can have ONLY one Super class
public class BankAccount {
    private int bankCode;
    private String accountNumber;
    // Do not use 'double' for the number if it must be ACCURATE!
    // Use 'BigDecimal' instead. Here use 'double' to make it simple to learn
    private double balance;


    public BankAccount(int bankCode, String accountNumber, double balance) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(int bankCode, String accountNumber) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // should annotate to make it clear
    @Override
    public String toString() {
        return "BankAccount{accountNumber=" + accountNumber +
                ", bankCode=" + bankCode + ", balance=" + balance + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // i think null check should be in the first line in this method..
        // -> does not return error when 'o' is null, since not accessing object in o object.
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber.equals(that.accountNumber) && bankCode == that.bankCode;
    }


}
