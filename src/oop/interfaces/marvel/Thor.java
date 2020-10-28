package oop.interfaces.marvel;

public class Thor extends SuperHero implements Flyable {
    private String status;

    public Thor(int strength, int health) {
        this(strength, health, "Christopher Hemsworth", "Australian", "Prince");
    }

    public Thor(int strength, int health, String realName, String nationality, String status) {
        super(strength, health, realName, nationality);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void fight() {
        System.out.printf("Thor is fighting....");
    }

    @Override
    public void fly(int distance) {
        // if changed 'private' to 'protected' in superclass property, can access directly,
        // but better to keep private as much as possible
        if (distance > 0 && getHealth() > 0) {
            System.out.printf("Thor is flying...");
        }
    }
}
