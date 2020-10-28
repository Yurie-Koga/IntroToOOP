package oop.interfaces.marvel;

import java.util.ArrayList;
import java.util.Objects;

public abstract class SuperHero {
    private int strength;
    private int health;
    private String realName;
    private String nationality;
    private ArrayList<String> splAbilities;   // Special Ability

    public SuperHero(int strength, int health, String realName, String nationality) {
        this(strength, health, realName, nationality, new ArrayList<>());
    }

    public SuperHero(int strength, int health, String realName, String nationality, ArrayList<String> splAbilities) {
        this.strength = strength;
        this.health = health;
        this.realName = realName;
        this.nationality = nationality;
        this.splAbilities = splAbilities;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getRealName() {
        return realName;
    }

    // remove setters if you don't want them to be mutable
//    public void setRealName(String realName) {
//        this.realName = realName;
//    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ArrayList<String> getSplAbilities() {
        return splAbilities;
    }

    // remove setters if you don't want them to be mutable
//    public void setSplAbilities(ArrayList<String> splAbilities) {
//        this.splAbilities = splAbilities;
//    }

    public void addSplAbility(String ability) {
        if (!splAbilities.contains(ability))
            splAbilities.add(ability);
        else
            System.out.println("Already exists.");
    }

    public void removeSplAbility(String ability) {
        if (splAbilities.contains(ability))
            splAbilities.remove(ability);
        else
            System.out.println("Does not exist.");
    }

    // want to have fight method, but should depends on each super hero, so set as 'abstract'
    public abstract void fight();

    @Override
    public String toString() {
        return "SuperHero{" +
                "strength=" + strength +
                ", health=" + health +
                ", realName='" + realName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", splAbilities=" + splAbilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return strength == superHero.strength &&
                health == superHero.health &&
                Objects.equals(realName, superHero.realName) &&
                Objects.equals(nationality, superHero.nationality); // removed abilities
    }
}
