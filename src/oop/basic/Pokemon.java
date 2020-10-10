package oop.basic;

public class Pokemon {
    String name;
    String type;
    int healthPoint;
    int attackPoint;

    Pokemon(String name, String type, int healthPoint, int attackPoint) {
       this.name = name;
       this.type = type;
       this.healthPoint = healthPoint;
       this.attackPoint = attackPoint;
    }

    void attack(Pokemon enemy) {
        if(enemy.dodge()){
            System.out.println(enemy.name + " dodge my attack!");
        }else{
            System.out.println("Attack has been successful! -" + this.attackPoint);
            enemy.healthPoint -= this.attackPoint;  // should use 'this' since 'enemy' has also attackPoint.
        }
    }

    boolean dodge() {
        // Math.random(): returns a random double value from 0.0 to 1.0
        return Math.random() > 0.5;
    }

    void evolve(){
        System.out.println("I'm evolving...");
        this.attackPoint += 20; // 'this' can be removed here since no parameters for this method and it's obvious
        this.healthPoint += 20;
    }
}
