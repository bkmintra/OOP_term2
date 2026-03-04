package com.rpg.lab3;

public class Warrior extends Character{
    private int armorValue;

    public Warrior(String name, int level, int hp, int baseDamage, int defense, int armorValue, Weapon weapon){
        super(name, level, hp, baseDamage,defense,weapon,"Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void displayCharacterDetails(){
        super.displayCharacterDetails();
        System.out.println("Armor Value: "+ armorValue);
        System.out.println("Weapon: "+weapon.toString());
    }

    @Override
    public void attack(Character target){
        System.out.println(name+" ("+job+") uses a heavy attack on "+target.getName()+" with"+weapon.getName()+"!");
        int rawDamage =(int)((this.baseDamage + this.weapon.getDamage())*1.5);
        System.out.println("Raw Attack Damage (1.5x Bonus):"+rawDamage);
        target.receiveDamage(rawDamage);
    }

    @Override
    public void receiveDamage(int amount){
        System.out.println("Armor blocks"+ armorValue+" incoming damage!");
        int remainingDamage = amount - armorValue;
        if(remainingDamage<0) remainingDamage=0;

        super.receiveDamage(remainingDamage);
    }
}
