package oop.inheritance;

public class SavingAccount extends BankAccount {
    private int transact;

    public SavingAccount(int bankCode, String accountNumber, double balance, int transact) {
        super(bankCode, accountNumber, balance);
        this.transact = transact;
    }

    public int getTransact() {
        return transact;
    }

    public void setTransact(int transact) {
        this.transact = transact;
    }
}
