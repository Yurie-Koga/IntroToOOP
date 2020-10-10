package oop.encapsulation;

public class Driver {
    public static void main(String[] args) {
        Account acct1 = new Account("abc123", "123", false);
        acct1.login("abc123", "123");

        // Before encapsulation, can change value directly
//        acct1.username = "newUserName";
//        acct1.password = "newPassword";

        // After encapsulation, change value through methods
        System.out.println("The original : "+ acct1.getUsername());
        acct1.setUsername("newUsernamefffffffffff");
        System.out.println("New username : " + acct1.getUsername());
        // can't access directly, so that object class should provide getter method.
//        System.out.println(acct1.username);
    }
}
