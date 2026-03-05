package com.rpg.lab3;

public class Archer extends Character{
    private int accuracy;

    public Archer(String name, int level, int hp, int baseDamage, int defense, int accuracy, Weapon weapon){
        super(name,level,hp,baseDamage,defense,weapon,"Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void displayCharacterDetails(){
        super.displayCharacterDetails();
        System.out.println("Accuracy: "+accuracy+"%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: "+weapon.toString());
    }

    @Override
    public void attack(Character target){
        System.out.println(name+" ("+job+" ) fires a precise arrow at "+target.getName()+"!");
        int rawDamage = (int)((this.baseDamage+this.weapon.getDamage())*1.3);
        System.out.println("Raw Attack Damage (Ranged Bonus): "+ rawDamage);
        target.receiveDamage(rawDamage);
    }
}
