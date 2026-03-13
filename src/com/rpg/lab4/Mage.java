package com.rpg.lab4;

public class Mage extends Character{
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int hp, int baseDamage, int defense, int mana, Weapon weapon){
        super(name, level,hp,baseDamage,defense,weapon,"Mage");
        this.mana = mana;
        this.maxMana = mana;
    }

    @Override
    protected void printExtraStats(){
        System.out.println("Mana: "+mana+"/"+maxMana);
    }

    @Override
    public void attack(Destructible target){
        String targetName = (target instanceof Character) ? ((Character)target).getName() : "Target";
        if( mana >= 30){
            System.out.println(name +" ("+job+") casts Magic Missile at "+targetName+"!");
            int baseDam = this.baseDamage+this.weapon.getDamage();
            int spellBonus = 10;
            int totalDamage = baseDam+spellBonus;
            System.out.println("Spell Damage: "+ totalDamage+" Base: "+baseDam+" + Spell Bonus: "+spellBonus+")");
            mana -=30;
            System.out.println("Mana Used: 30 | Remaining: "+mana+"/"+maxMana);
            target.takeDamage(totalDamage);
        }else{
            System.out.println("Gandalf attempts to cast Magic Missile, but has insufficient mana! ");
            System.out.println("Current Mana: "+mana+"/"+maxMana+" (Need: 30)");

        }
    }
}
