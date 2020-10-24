package sandbox.inheritance.bankaccount;

import java.math.BigDecimal;
import java.util.Date;

public class CertificateOfDeposit extends BankAccount {
    private Date expires;

    public CertificateOfDeposit(String backCode, String accountNumber, BigDecimal balance, Date expires) {
        super(backCode, accountNumber, balance);
        this.expires = expires;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}
