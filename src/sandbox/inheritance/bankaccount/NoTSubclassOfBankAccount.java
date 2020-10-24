package sandbox.inheritance.bankaccount;

import java.math.BigDecimal;

public class NoTSubclassOfBankAccount {
    //////////////////////////////////////////////////////////
    // 'protected' can be accessed by inside of package even it's not inheritance
    //////////////////////////////////////////////////////////
    public String accessBAProtectedMethod() {
        BankAccount b1 = new BankAccount("bank1", "acct1", new BigDecimal(100));
        return b1.protectedMethod();
    }
}
