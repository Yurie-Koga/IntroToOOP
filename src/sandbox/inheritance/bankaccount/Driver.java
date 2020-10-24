package sandbox.inheritance.bankaccount;

import java.math.BigDecimal;
import java.util.Date;

public class Driver {
    public static void main(String[] args) {
        createObjects();
        checkEquals();
    }

    private static void createObjects() {
        BankAccount b1 = new BankAccount("bank1", "acct1", new BigDecimal(1_000.5));
        System.out.println(b1.toString());

        CheckingAccount c1 = new CheckingAccount("bank2", "acct2", new BigDecimal(2_000.7), 10_000);
        System.out.println(c1.toString());
        System.out.println("limit: " + c1.getLimit());

        SavingsAccount s1 = new SavingsAccount("bank3", "acct3", new BigDecimal(500), 6);
        System.out.println(s1.toString());
        System.out.println("transact: " + s1.getTransact());

        CertificateOfDeposit cd1 = new CertificateOfDeposit("bank4", "acct4", new BigDecimal(700), new Date());
        System.out.println(cd1.toString());
        System.out.println("expires: " + cd1.getExpires());
    }

    private static void checkEquals() {
        System.out.println();
        System.out.println("----- check equals -----");
        /////////////////////////////////////////////////////////
        // The original 'equals' method:
        //      - return (this == obj);
        //      - check if it's the same object (not object values)
        /////////////////////////////////////////////////////////

        BankAccount bA = new BankAccount("bankA", "acctA", new BigDecimal(600));
        BankAccount bB = new BankAccount("bankA", "acctA", new BigDecimal(600));
        BankAccount bC = bA;

        // bA is different than bB since they are different objects
        System.out.println("if equals bA and bB (as object): " + bA.equals(bB));
        System.out.println("if equals bA and bB (as object): " + bA.equals(bB));

        // bA and bC is the same since bC is copied bA (same stack, same object)
        System.out.println("if equals bA and bC (as object): " + bA.equals(bC));

        // if compare object values, they are same
        System.out.println("if equals bA and bB (as value): " + bA.equalsAsValue(bB));
        System.out.println("if equals bA and bC (as value): " + bA.equalsAsValue(bC));
    }
}
