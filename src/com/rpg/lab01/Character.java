package com.rpg.lab01;

public class Character {
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected Weapon weapon;
    protected String state;

    public Character(String name, int level, int hp, Weapon weapon, String state) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.weapon = weapon;
        this.state = state;
    }

    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Class: " + state);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Weapon: " + weapon.toString());
    }

    public int attack(){
        System.out.println(name + " (" + state + ")" + "attacks with " + weapon.getName() + ("!"));

        int levelBonus = level*2;
        int totalDamage = weapon.getBaseDamage()+levelBonus;

        System.out.print("Attack Damage: "+ totalDamage + " (Weapon Base: " + weapon.getBaseDamage()+ " + Level Bonus: "+ levelBonus+")");
        return totalDamage;
    }

    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
        System.out.println(name+ " takes "+damage+ " damage! Current HP: "+hp+"/"+maxHp);

    }

    public void levelUp(){
        this.level++;
        this.maxHp += 10;
        this.hp = this.maxHp;
        System.out.println(name+ "leveled up to Level"+level+"!");
        System.out.println("Max Health increased to"+ maxHp+" (full heal applied)");
    }

    public void newHeal(int amount){
        int oldHp = this.hp;
        this.hp += amount;
        if (this.hp > this.maxHp){
            this.hp = this.maxHp;
        }
        int healAmount = this.hp - oldHp;
    }
}




