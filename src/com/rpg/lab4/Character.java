package com.rpg.lab4;

public class Character implements Destructible{
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected int baseDamage;
    protected int defense;
    protected Weapon weapon;
    protected String job;

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Character(String name,int level, int hp,int baseDamage,int defense, Weapon weapon,String job) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.weapon = weapon;
        this.job = job;
        this.baseDamage = baseDamage;
        this.defense = defense;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    @Override
    public boolean isDestroyed(){
        return hp <= 0;
    }

    public void displayCharacterDetails() {
        String status = isAlive()? "Active": "Fainted";
        System.out.println("--- " + name.toUpperCase() + " ("+job.toUpperCase()+") ---");
        System.out.println("status: "+status);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Damage: "+baseDamage);
        System.out.println("Defense: "+defense);
        System.out.println("Weapon: " + weapon.toString());
    }

    protected void printExtraStats(){}
    protected void printArmorStats(){}

    public void attack(Destructible target){
        String targetName = (target instanceof Character) ?((Character)target).getName() : "Target";
        System.out.println(name + " (" + job + ")" + " attacks " + targetName+" with " + weapon.getName() + "!");
        int rawDamage = this.baseDamage+this.weapon.getDamage();
        System.out.println("Raw Attack Damage: "+ rawDamage);
        target.takeDamage(rawDamage);
    }

    @Override
    public void takeDamage(int amount){
        System.out.println(name+"'s Defense: "+ defense + " (reduces damage by "+ defense +")");
        int actualDamage = amount - defense;
        if (actualDamage < 0) actualDamage = 0;

        System.out.println("Actual Damage Taken: "+actualDamage);
        this.hp -= actualDamage;
        if (this.hp < 0) this.hp = 0;
        System.out.println(name+ "'s HP:  "+hp+"/"+maxHp);

    }

}


