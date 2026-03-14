package com.rpg.lab6;


public class Character implements Destructible {
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected int baseDamage;
    protected int defense;
    protected Weapon weapon;
    protected String job;

    protected Attack attackBehavior;

    public Character(String name, int level, int hp, int baseDamage, int defense, Weapon weapon, String job) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.weapon = weapon;
        this.job = job;

        this.attackBehavior = new BaseAttack();
    }


    public Attack getAttack() { return attackBehavior; }
    public void setAttack(Attack attackBehavior) { this.attackBehavior = attackBehavior; }

    public int getDamage() { return baseDamage; }
    public void setDamage(int damage) { this.baseDamage = damage; }

    public int getHealthPoints() { return hp; }
    public void setHealthPoints(int hp) { this.hp = hp; }
    public int getMaxHealthPoints() { return maxHp; }

    public String getName() { return name; }
    public Weapon getWeapon() { return weapon; }
    public boolean isAlive() { return hp > 0; }

    @Override
    public boolean isDestroyed() { return hp <= 0; }


    public void attack(Destructible target) {
        this.attackBehavior.attack(this, target);
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount - defense;
        if (actualDamage < 0) actualDamage = 0;
        this.hp -= actualDamage;
        if (this.hp < 0) this.hp = 0;
        System.out.println(name + " takes " + actualDamage + " damage! HP: " + hp + "/" + maxHp);
    }

    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " (" + job.toUpperCase() + ") --- HP: " + hp + "/" + maxHp);
    }
}
