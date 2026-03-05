package com.rpg.lab3;

public class Mage extends Character{
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int hp, int baseDamage, int defense, int mana, Weapon weapon){
        super(name, level,hp,baseDamage,defense,weapon,"Mage");
        this.mana = mana;
        this.maxMana = mana;
    }

    @Override
    public void displayCharacterDetails(){
        super.displayCharacterDetails();
        System.out.println("Mana: "+mana+"/"+maxMana);
        System.out.println("Weapon: "+weapon.toString());
    }

    @Override
    public void attack(Character target){
        if( mana >= 30){
            System.out.println(name +" ("+job+") casts Magic Missile at "+target.getName()+"!");
            mana -= 30;
            int rawDamage = this.baseDamage+this.weapon.getDamage()+(level *5);
            System.out.println("Raw Attack Damage (Magic): "+rawDamage);
            target.receiveDamage(rawDamage);
        }else{
            System.out.println(name+ " doesn't have enough mana! Uses normal attack instead.");
            super.attack(target);
        }
    }
}
