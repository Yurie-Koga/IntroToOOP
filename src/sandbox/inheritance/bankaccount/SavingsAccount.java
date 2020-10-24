package sandbox.inheritance.bankaccount;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
    private int transact;

    public SavingsAccount(String backCode, String accountNumber, BigDecimal balance, int transact) {
        super(backCode, accountNumber, balance);
        this.transact = transact;
    }

    public int getTransact() {
        return transact;
    }

    public void setTransact(int transact) {
        this.transact = transact;
    }
}
