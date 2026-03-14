package com.rpg.lab6;

public class Warrior extends Character{
    private int armorValue;

    public Warrior(String name, int level, int hp, int baseDamage, int defense, int armorValue, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Warrior");
        this.armorValue = armorValue;

        setAttack(new WarriorStyleDecorator(getAttack()));
    }

    @Override
    public void takeDamage(int amount) {
        int remainingDamage = amount - armorValue;
        if (remainingDamage < 0) remainingDamage = 0;
        super.takeDamage(remainingDamage);
    }
}
