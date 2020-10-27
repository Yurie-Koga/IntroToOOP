package oop.interfaces;

/**
 * How to use 'interface'
 * 1. create an interface with methods w/o definitions
 * 2. create classes and add 'implements' keyword
 * 3. override methods declared in the interface
 */
public interface Habitable {
    // this method must be overridden at 'implements' class
    boolean canFit(int inhabitants);
}
