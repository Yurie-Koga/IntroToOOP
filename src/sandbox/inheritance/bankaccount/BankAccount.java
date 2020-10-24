package sandbox.inheritance.bankaccount;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
    private String backCode;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String backCode, String accountNumber, BigDecimal balance) {
        this.backCode = backCode;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getBackCode() {
        return backCode;
    }

    public void setBackCode(String backCode) {
        this.backCode = backCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "backCode='" + backCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    // commented out 'Override' to compare to the original 'equals' method
//    @Override
    public boolean equalsAsValue(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(backCode, that.backCode) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(balance, that.balance);
    }

    //////////////////////////////////////////////////////////
    // 'protected' can be accessed from superclass itself
    //////////////////////////////////////////////////////////
    protected String protectedMethod() {
        return "You can access to protected";
    }

    public String accessFromPublicMethod() {
        return protectedMethod();
    }
}
