package com.rpg.lab4;

public class Warrior extends Character{
    private int armorValue;

    public Warrior(String name, int level, int hp, int baseDamage, int defense, int armorValue, Weapon weapon){
        super(name, level, hp, baseDamage,defense,weapon,"Warrior");
        this.armorValue = armorValue;
    }

    @Override
    protected void printArmorStats(){
        System.out.println("Armor Value: "+armorValue);
    }

    @Override
    public void attack(Destructible target){
        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
        System.out.println(name+" ("+job+") performs a POWERFUL STRIKE on "+targetName +"!");
        int baseDam = this.baseDamage + this.weapon.getDamage();
        int rawDamage =(int)(baseDam*1.5);
        System.out.println("Base Damage: "+baseDam+" -> Enhanced: "+rawDamage+" (1.5x multiplier)");
        target.takeDamage(rawDamage);
    }

    @Override
    public void takeDamage(int amount){
        System.out.println(name+"'s Armor: "+ armorValue+" reduces damage from "+amount+" to "+(amount - armorValue)+")");
        int remainingDamage = amount - armorValue;
        if(remainingDamage<0) remainingDamage=0;

        super.takeDamage(remainingDamage);
    }
}
