package com.rpg.lab6;

public class Mage extends Character{
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int hp, int baseDamage, int defense, int mana, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;

        setAttack(new MageStyleDecorator(getAttack()));
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getMaxMana() { return maxMana; }
}
//