package sandbox.inheritance.outofbankaccount;

import sandbox.inheritance.bankaccount.BankAccount;

import java.math.BigDecimal;

public class NotInheritanceOutOfPackage {
    //////////////////////////////////////////////////////////
    // 'protected' can not be accessed from out of package
    //////////////////////////////////////////////////////////
    public String accessFromOutOfPackage() {
        BankAccount b1 = new BankAccount("bank1", "acct1", new BigDecimal(100));
//        return b1.protectedMethod();
        return "Protected Method can't be accessed here.";
    }

    // public method in out of package can be accessed
    public String accessFromOutOfPackageByPublicMethod() {
        BankAccount b1 = new BankAccount("bank1", "acct1", new BigDecimal(100));
        return b1.accessFromPublicMethod();
    }
}
