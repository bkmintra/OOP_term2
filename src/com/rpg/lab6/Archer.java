package com.rpg.lab6;

public class Archer extends Character{
    private int accuracy;

    public Archer(String name, int level, int hp, int baseDamage, int defense, int accuracy, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Archer");
        this.accuracy = accuracy;

        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public int getAccuracy() { return accuracy; }
    public boolean hasRangeAdvantage() { return true; }
}
