package sandbox.inheritance.bankaccount;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
    private long limit;

    public CheckingAccount(String backCode, String accountNumber, BigDecimal balance, long limit) {
        // Always call the parent constructor!
        super(backCode, accountNumber, balance);
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
