package oop.basic;

public class PokeBattle {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", 35, 55);
        Pokemon mewtwo = new Pokemon("Mewtow", "Psychic", 50, 35);

        pikachu.attack(mewtwo);

        System.out.println("HP: " + pikachu.healthPoint);
        System.out.println("AP: " + pikachu.attackPoint);
        pikachu.evolve();
        System.out.println("HP: " + pikachu.healthPoint);
        System.out.println("AP: " + pikachu.attackPoint);

        pikachu.healthPoint = 100;
    }
}
