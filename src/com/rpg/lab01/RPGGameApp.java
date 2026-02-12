package com.rpg.lab01;

public class RPGGameApp {
    public static void main(String[] args){
        System.out.print("\n"+"=".repeat(70));
        System.out.println("   SCENARIO 2: RPG GAME CHARACTER - DEMONSTRATION");
        System.out.println("=".repeat(70));

        System.out.print("\n[STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Sword","Malee",25,"Slash Attack");
        Weapon staffWeapon = new Weapon("Staff", "Magic", 20, "Spell Cast");
        Weapon staffHealer = new Weapon("Healing Staff", "Magic", 15,"Healing");

        System.out.print("\n[STEP 2] Creating Charaters...");
        Character warrior = new Character("Arthur",10,1500,swordWeapon,"Warrior");
        Character mage = new Character("Merlin",12,800, staffWeapon,"Mage");
        Healer healer = new Healer("Elara",9,1000, staffHealer,30);

        System.out.println("\n[STEP 3] Initial Character Status:");
        System.out.println();
        warrior.displayCharacterDetails();
        System.out.println();
        mage.displayCharacterDetails();
        System.out.println();
        healer.displayCharacterDetails();

        System.out.println("\n[STEP 4] Testing attack() Method:");
        System.out.println("\n--- Warrior's Turn ---");
        int warriorDamage = warrior.attack();

        System.out.println();
        System.out.println("\n--- Mage's Turn ---");
        int mageDamage = mage.attack();

        System.out.println("\n[STEP 5] Simulating Combat Scenario: ");
        System.out.println("\n--- Mage takes damage from Warrior ---");
        mage.takeDamage(warriorDamage);

        System.out.println("\n--- Warrior takes damage from Mage ---");
        warrior.takeDamage(mageDamage);

        System.out.println("\n[STEP 6] Testing levelUp() Method:");
        System.out.println("\n--- Arthur levels up! ---");
        warrior.levelUp();

        System.out.println("\n[STEP 7] Testing Healer Special Abilities: ");
        System.out.println("\n--- Healer heals themselves ---");
        healer.displayCharacterDetails();
        healer.heal();

        System.out.println("\n--- Healer heals Warrior ---");
        healer.healWarrior(warrior);



    }
}

