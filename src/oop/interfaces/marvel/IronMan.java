package oop.interfaces.marvel;

import java.util.ArrayList;

/**
 * 1. Header of class (the first line of class) indicates the class behaviour
 * extends:    indicates it's subclass
 * implements: indicates class functionality
 * 2. marker interface: an interface w/o any methods, but indicates that class is supported that function
 * e.g ArrayList:
 * public class ArrayList<E> extends AbstractList<E>
 * implements List<E>, RandomAccess, Cloneable, java.io.Serializable
 * 'RandomAccess' has no methods, but it means ArrayList can access by index (list.get(int)).
 */
public class IronMan extends SuperHero implements Flyable {
    private int assets; // money (not sure money is important for IronMan..)
    private ArrayList<String> weapons;

    public IronMan(int strength, int health) {
        this(strength, health, "Tony Stark", "American", 100, new ArrayList<>());
    }

    public IronMan(int strength, int health, String realName, String nationality, int assets, ArrayList<String> weapons) {
        super(strength, health, realName, nationality);
        this.assets = assets;
        this.weapons = weapons;
    }

    public int getAssets() {
        return assets;
    }

    public void setAssets(int assets) {
        this.assets = assets;
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<String> weapons) {
        this.weapons = weapons;
    }

    public void collectWeapons(String weapon) {
        weapons.add(weapon);
    }

    @Override
    public void fight() {
        System.out.printf("IronMan is fighting....");
    }

    @Override
    public void fly(int distance) {
        if (assets > distance) {
            System.out.printf("IronMan is flying...");
        }
    }
}
