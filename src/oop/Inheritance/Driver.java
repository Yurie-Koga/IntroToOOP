package oop.Inheritance;

public class Driver {
    public static void main(String[] args) {
        CheckingAccount c1 = new CheckingAccount(1, "a1234", 100.50, 1000);
        System.out.println(c1.getLimit());
        System.out.println(c1.getBankCode());

        SavingAccount s2 = new SavingAccount(2, "b1234", 2000, 5);
        System.out.println(s2.getTransact());
        System.out.println(s2.getBankCode());

        s2.getBalance();

        BankAccount b1 = new BankAccount(1, "aabbcc", 19);
        BankAccount b2 = new BankAccount(1, "aabbcc", 19);
        // the original print method: oop.Inheritance.BankAccount@7cd84586
        // with overriding method: BankAccount{accountNumber=aabbcc, bankCode=1, balance=19.0}
        System.out.println(b1);

        // return false if use the original 'equals' method
        // return true if use the overriding 'equals' method
        System.out.println("if equals b1 and b2: " + b1.equals(b2));
        b2 = null;  // error check: no error in 'equals' method
        System.out.println("if equals b1 and b2: " + b1.equals(b2));


        // both are okay since, CheckingAccount is extended from BankAccount
        // and BanckAccount is extended from Object
        // this is Polymorphism
        BankAccount b3 = new CheckingAccount(1, "a1234", 100.50, 1000);
        //  -> overriding methods in BankAccount class are valid
        Object b4 = new CheckingAccount(1, "a1234", 100.50, 1000);
        // -> overriding methods in BackAccount class are invalid, return the original methods

        // press ⌥⌘L to re-format
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
    }
}
