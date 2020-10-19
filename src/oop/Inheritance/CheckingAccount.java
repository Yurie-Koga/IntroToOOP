package oop.Inheritance;

public class CheckingAccount extends BankAccount {
    private long limit;

    public CheckingAccount(int bankCode, String accountNumber, double balance, long limit) {
        super(bankCode, accountNumber, balance);    // Call the parent's constructor
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
