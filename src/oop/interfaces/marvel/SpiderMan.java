package oop.interfaces.marvel;

public class SpiderMan extends SuperHero {
    private int numOfSuites;
    private int amountOfWeb;

    public SpiderMan(int strength, int health) {
        this(strength, health, "Peter Parker", "American", 1, 100);
    }

    public SpiderMan(int strength, int health, String realName, String nationality, int numOfSuites, int amountOfWeb) {
        super(strength, health, realName, nationality);
        this.numOfSuites = numOfSuites;
        this.amountOfWeb = amountOfWeb;
    }

    public int getNumOfSuites() {
        return numOfSuites;
    }

    public void setNumOfSuites(int numOfSuites) {
        this.numOfSuites = numOfSuites;
    }

    public int getAmountOfWeb() {
        return amountOfWeb;
    }

    public void setAmountOfWeb(int amountOfWeb) {
        this.amountOfWeb = amountOfWeb;
    }

    @Override
    public void fight() {
        System.out.printf("SpiderMan is fighting....");
    }
}
