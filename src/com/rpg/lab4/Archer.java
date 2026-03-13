package com.rpg.lab4;

public class Archer extends Character{
    private int accuracy;

    public Archer(String name, int level, int hp, int baseDamage, int defense, int accuracy, Weapon weapon){
        super(name,level,hp,baseDamage,defense,weapon,"Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void printArmorStats(){
        System.out.println("Accuracy: "+accuracy+"%");
        System.out.println("Range Advantage: Yes (30% bonus)");
    }

    @Override
    public void attack(Destructible target){
        String targetName = (target instanceof Character) ? ((Character)target).getName() : "Target";
        System.out.println(name+" ("+job+" ) shoots a precise arrow at "+targetName+"!");
        int baseDam = this.baseDamage +this.weapon.getDamage();
        int rangeBonus =12;
        int totalDamage = baseDam + rangeBonus;
        System.out.println("Base Damage: "+baseDam+" +Range Bonus: "+rangeBonus+" = "+ totalDamage);
        System.out.println("Accuracy: "+accuracy+"% (HIT!)");
        target.takeDamage(totalDamage);
    }
}
