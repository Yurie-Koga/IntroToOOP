package oop.encapsulation;

// Before encapsulation
//public class Account {
//    String username;
//    String password;
//
//    Account(String username, String password){
//        this.username = username;
//        this.password = password;
//    }
//
//    boolean login(String username, String password){
//        if(username.equals(this.username) && password.equals(this.password)){
//            System.out.println("logged in successfully.");
//            return true;
//        }else{
//            System.out.println("invalid credentials.");
//            return  false;
//        }
//    }
//}

// After encapsulation
public class Account {
    // Instance variables are encapsulated: unable to change values outside of this class
    private String username;
    private String password;
    private boolean paid;

    // Constructor must be public: receive values as parameters and use within this class with 'this' key word
    Account(String username, String password, boolean paid){
//        this.username = username;     // Constructor also can use setter in this class
//        this.password = password;
        setUsername(username);
        setPassword(password);
        this.paid = paid;
    }

    // Provide a way to access the value
    String getUsername(){
        return this.username;
    }
    String getPassword(){
        return this.password;
    }

    public boolean isPaid(){
        return paid;
    }

    // Provide a way to change/reset the instance variable data.
    void setUsername(String username){
        if(username.length() > 5 && username.length() < 12){
            this.username = username;
        }else{
            System.out.println("Username should be more than 5 and lesser than 12 characters.");
        }
    }
    void setPassword(String password){
        if(password.length() > 8 && password.length() < 20){
            this.password = password;
        }else{
            System.out.println("Password should be more than 8 and lesser than 20 characters.");
        }
    }

    // keep methods are public if need to be used outside
    boolean login(String username, String password){
        return checkCredential(username, password);
    }

    // set private since this method is used within this class
    private boolean checkCredential(String username, String password){
        if(!username.equals(this.username)){
            System.out.println("Invalid username.");
            return false;
        }
        if(!password.equals(this.password)){
            System.out.println("Invalid password.");
            return false;
        }
        System.out.println("logged in successfully.");
        return true;
    }


}